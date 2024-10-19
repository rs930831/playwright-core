package test.playwright.page.pages;

import test.playwright.page.internal.BasePage;
import test.playwright.util.playwright.PlaywrightUtil;

public class ElementsPage extends BasePage {

    private String dynamicPathForElementsMenu = "//li[contains(@class,'btn btn-light')]//span[text()='@@menuName']/parent::*";

    private PlaywrightUtil playwrightUtil;
    public ElementsPage() {
        super();
        playwrightUtil = PlaywrightUtil.getPlaywrightUtil();
    }

    public void navigateToMenu(final String menuName) {
        String currentMenuXpath = dynamicPathForElementsMenu.replace("@@menuName", menuName);
        playwrightUtil.clickOnElement(currentMenuXpath);
    }

    private class TextBoxSection {
        
    }


}
