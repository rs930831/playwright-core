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

    public class TextBoxSection extends BasePage {
        private String fullNameXpath = "//input[@id='userName']";
        private String emailXpath = "//input[@id='userEmail']";

        private String currentAddressTxtAreaXpath = "//textarea[@id='currentAddress']";
        private String permanentAddressTxtAreaXpath = "//textarea[@id='permanentAddress']";
        private String submitXpath = "//button[@id='submit']";

        public void fillFullName(final String fullName) {
            playwrightUtil.fill(fullNameXpath, fullName);
        }

        public void fillEmail(final String email) {
            playwrightUtil.fill(emailXpath, email);
        }

        public void fillCurrentAddress(final String currentAddress) {
            playwrightUtil.fill(currentAddressTxtAreaXpath, currentAddress);
        }

        public void fillPermanentAddress(final String permanentAddress) {
            playwrightUtil.fill(permanentAddressTxtAreaXpath, permanentAddress);
        }

        public void clickOnSubmit() {
            playwrightUtil.clickOnElement(submitXpath);
        }


    }


    public class CheckBoxSection extends BasePage {

        private final String homeCheckBoxXpath = "//label[@for='tree-node-home']";
        private final String desktopCheckBoxXpath = "//label[@for='tree-node-desktop']";
        private final String expandPlusIconXpath = "//button[@title='Expand all']";
        private final String collapseIconXpath = "//button[@title='Collapse all']";

        public void checkHome() {
            playwrightUtil.check(homeCheckBoxXpath);
        }

        public void expandCheckBox() {
            playwrightUtil.clickOnElement(expandPlusIconXpath);
        }

        public void uncheckDesktop() {
            playwrightUtil.uncheck(desktopCheckBoxXpath);
        }


    }

}
