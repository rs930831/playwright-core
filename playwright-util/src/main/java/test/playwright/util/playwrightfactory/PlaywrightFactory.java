package test.playwright.util.playwrightfactory;

import com.microsoft.playwright.Playwright;
import test.playwright.util.playwright.PlaywrightUtil;

public class PlaywrightFactory {

    private static boolean playWrightUtilNull() {
        return (PlaywrightUtil.getPlaywrightUtil() == null);
    }

    public static void closePlaywright() {
        if(!playWrightUtilNull()) {
            PlaywrightUtil.killPlaywright();
        }
    }

    public static void launchBrowser(final String browserType) {
        PlaywrightUtil.launchBrowser(browserType);
    }

    public static void createNewMainContext() {
        PlaywrightUtil.createNewMainContext();
    }

    public static void createNewMainPageFromMainContext() {
        PlaywrightUtil.createNewMainPageFromMainContext();
    }

    public static void closeMainPage() {
        PlaywrightUtil.closeMainPage();
    }

    public static void closeMainContext() {
        PlaywrightUtil.closeMainContext();
    }
}
