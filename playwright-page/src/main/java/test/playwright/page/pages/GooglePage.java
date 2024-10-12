package test.playwright.page.pages;

import test.playwright.page.internal.BasePage;
import test.playwright.util.playwright.PlaywrightUtil;

public class GooglePage extends BasePage {


    private PlaywrightUtil playwrightUtil;
    public GooglePage() {
        super();
        playwrightUtil = PlaywrightUtil.getPlaywrightUtil();
    }
    public void searchKeyInGoogleSearch(final String key) {
        playwrightUtil.fill("//textarea[@title='Search']", key);
        playwrightUtil.clickOnElement("(//input[@value='Google Search'])[2]");
    }

    public void navigateToGoogle() {
        playwrightUtil.navigateTo("https://www.google.com");
    }
}
