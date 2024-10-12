package test.playwright.test.base;

import org.testng.annotations.*;
import test.playwright.util.playwrightfactory.PlaywrightFactory;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Executing Before Suite");
        PlaywrightFactory.launchBrowser("chromium");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Executing Before Method");
        PlaywrightFactory.createNewMainContext();
        PlaywrightFactory.createNewMainPageFromMainContext();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Executing After Method");
        PlaywrightFactory.closeMainPage();
        PlaywrightFactory.closeMainContext();
    }


    @AfterSuite
    public void afterSuite() {
        System.out.println("Executing After Suite");
        PlaywrightFactory.closePlaywright();
    }

}
