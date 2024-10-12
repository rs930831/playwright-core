package test.playwright.flow.pageflows;

import test.playwright.page.pages.GooglePage;

public class GooglePageFlow extends GooglePage {
    

    public void googleSearch(String key) {
        navigateToGoogle();
        searchKeyInGoogleSearch(key);
    }
}
