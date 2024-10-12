package test.playwright.flow.pageflows;

import test.playwright.page.pages.HomePage;

public class HomePageFlow extends HomePage {

    public void navigateToWindowsAlertFrames() {
        navigateToHome();
        clickOnAlertFrameWindows();
    }


}
