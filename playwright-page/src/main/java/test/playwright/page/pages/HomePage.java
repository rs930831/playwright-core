package test.playwright.page.pages;

import test.playwright.page.internal.BasePage;
import test.playwright.util.playwright.PlaywrightUtil;

public class HomePage extends BasePage {

    private PlaywrightUtil playwrightUtil;
    public HomePage() {
        super();
        playwrightUtil = PlaywrightUtil.getPlaywrightUtil();
    }

    private final String dynamicXpathForMenuCards = "//div[@class='card-body']/*[text()='@@menuName']";
    public static HomePage getInstance() {
        return new HomePage();
    }

    public void navigateToHome() {
        playwrightUtil.navigateTo("https://demoqa.com/");
    }

    public void clickOnAlertFrameWindows() {
        playwrightUtil.clickOnElement("//div[@class='category-cards']//h5[contains(text(), 'Alerts, Frame & Windows')]/parent::div");
    }


    public static void main(String[] args) throws InterruptedException {
        HomePage hp = HomePage.getInstance();
        Thread.sleep(5000);
    }

    public void navigateToElements() {
        String currentXpath = dynamicXpathForMenuCards.replace("@@menuName", "Elements");
        playwrightUtil.clickOnElement(currentXpath);
    }


}
