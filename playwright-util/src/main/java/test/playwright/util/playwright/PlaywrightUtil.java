package test.playwright.util.playwright;

import java.util.HashMap;
import java.util.Map;
import com.microsoft.playwright.*;
import test.playwright.util.playwright.BrowserTypeEnum;

public class PlaywrightUtil implements AutoCloseable {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;

    private BrowserType browserType;
    private Map<String, BrowserContext> browserContextMap;
    private Page page;

    private Map<String, Page> pageMap;

    private static PlaywrightUtil playwrightUtil;

    private final static String mainContextKey = "MainContext";
    private final static String mainPageKey = "MainPage";


    public static PlaywrightUtil getPlaywrightUtil() {
        return playwrightUtil;
    }

    //private boolean isThisUtilNull;


    private PlaywrightUtil() {}





    public static PlaywrightUtil initiatePlaywright() {
        playwrightUtil = new PlaywrightUtil();
        playwrightUtil.playwright = Playwright.create();
        BrowserType browserType = playwrightUtil.playwright.chromium();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless=false;
        playwrightUtil.browser = browserType.launch(launchOptions);
        playwrightUtil.browserContext = playwrightUtil.browser.newContext();
        playwrightUtil.browserContextMap = new HashMap<>();
        playwrightUtil.browserContextMap.put(mainContextKey, playwrightUtil.browserContext);
        playwrightUtil.page = playwrightUtil.browserContext.newPage();
        playwrightUtil.pageMap = new HashMap<>();
        playwrightUtil.pageMap.put(mainPageKey, playwrightUtil.page);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return playwrightUtil;
    }

    private static void createPlaywright() {
        System.out.println("[PlaywrightUtil][createPlaywright()] : Creating Playwright");
        System.out.println("[PlaywrightUtil][createPlaywright()] : Checking For Existing Playwright");
        if(PlaywrightUtil.getPlaywrightUtil() != null){
            if(PlaywrightUtil.getPlaywrightUtil().playwright != null) {
                PlaywrightUtil.getPlaywrightUtil().playwright.close();
            }
        }
        playwrightUtil = new PlaywrightUtil();
        playwrightUtil.playwright = Playwright.create();
    }


    public static void launchBrowser(final String browserType) {
        createPlaywright();
        switch (browserType.toUpperCase().trim()) {
            case "CHROMIUM" :
                playwrightUtil.browserType = playwrightUtil.playwright.chromium();
                break;
            default:
                throw new RuntimeException("Borrower Type Not Supported : "+ browserType);
        }
        playwrightUtil.browser = playwrightUtil.browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));

    }

    public static void killPlaywright() {
        playwrightUtil.playwright.close();
    }

    public static void createNewMainContext() {
        playwrightUtil.browserContext = playwrightUtil.browser.newContext();
        playwrightUtil.browserContextMap = new HashMap<>();
        playwrightUtil.browserContextMap.put(mainContextKey, playwrightUtil.browserContext);
    }

    public static void createNewMainPageFromMainContext() {
        playwrightUtil.page = playwrightUtil.browserContext.newPage();
        playwrightUtil.pageMap = new HashMap<>();
        playwrightUtil.pageMap.put(mainPageKey, playwrightUtil.page);
    }

    public static void closeMainPage() {
        playwrightUtil.pageMap.get(mainPageKey).close();
    }

    public static void closeMainContext() {
        playwrightUtil.browserContextMap.get(mainContextKey).close();
    }


    public void close() {
        this.playwright.close();
    }

    public static void main(String[] args) throws InterruptedException {
//        PlaywrightUtil playwrightUtil1 = PlaywrightUtil.initiatePlaywright();
//        playwrightUtil1.close();

        Playwright pw = Playwright.create();
        Browser browser1 = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page1 = browser1.newContext().newPage();
        page1.navigate("https://demoqa.com/");
        Thread.sleep(5000);

    }

    public void navigateTo(final String url) {
        page.navigate(url);
    }

    public void clickOnElement(final String xpath) {
        page.click(xpath);
    }

    public void clickOnElementAndStorePage(final String xpath, final String pageName) {
        Page newPage = browserContext.waitForPage(() -> {
            page.click(xpath);
        });
        pageMap.put(pageName, newPage);
    }

    public void fill(String xpath, String key) {
        page.locator(xpath).fill(key);
    }
}

