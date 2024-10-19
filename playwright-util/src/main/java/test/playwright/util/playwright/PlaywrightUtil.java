package test.playwright.util.playwright;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
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

    /**
     * <p>fill is the easiest way to fill out the form fields.
     * It focuses the element and triggers an input event with the entered text.
     * It works for <input>, <textarea> and [contenteditable] elements.
     *
     * Similar to Selenium sendKeys
     *
     * <a href="https://playwright.dev/java/docs/input">Playwright Java Doc For Input</a>
     * </p>
     * @param xpath xpath string of element
     * @param key xpath string of element
     * @return void
     * @since 1.0
     */
    public void fill(String xpath, String key) {
        page.locator(xpath).fill(key);
    }

//    public void selectOption(final String xpath, final String option) {
//        page.locator(xpath).selectOption(option);
//    }

//    public void selectOptions(final String xpath, final String[] options) {
//        page.locator(xpath).selectOption(options);
//    }
    
    public void selectOption(final String xpath, final String... options) {
        if(options.length == 0) {
            throw new RuntimeException("At Least One Options is Needed");
        }
        if(options.length == 1) {
        }
        List<String> list = (options.length == 1) ? page.selectOption(xpath, options[0]) : page.selectOption(xpath, options);
    }

    public void clear(final String xpath) {
        page.locator(xpath).clear();
    }

    public void check(final String xpath) {
        page.locator(xpath).check();
    }

    public void uncheck(final String xpath) {
        page.locator(xpath).uncheck();
    }
}

