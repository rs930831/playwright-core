package test.playwright.test.elements;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.playwright.flow.pageflows.GooglePageFlow;
import test.playwright.flow.pageflows.HomePageFlow;
import test.playwright.test.base.BaseTest;

public class ElementsTest extends BaseTest {

    HomePageFlow homePageFlow;
    GooglePageFlow googlePageFlow;

    @BeforeClass
    public void beforeClass() {
        homePageFlow = new HomePageFlow();
        googlePageFlow = new GooglePageFlow();
    }

    @Test(priority = 1)
    public void testNavigateToElements(ITestContext context) {
        homePageFlow.navigateToHome();
        homePageFlow.clickOnAlertFrameWindows();
    }

    @Test(priority = 2)
    public void test2(ITestContext context) throws InterruptedException {
        googlePageFlow.googleSearch("Test2");
        Thread.sleep(4000);
    }

    @Test(priority = 3)
    public void test3(ITestContext context) throws InterruptedException {
        googlePageFlow.googleSearch("Test3");
        Thread.sleep(4000);
    }

    @Test(priority = 4)
    public void test4(ITestContext context) throws InterruptedException {
        googlePageFlow.googleSearch("Test4");
        Thread.sleep(4000);
    }

    @Test(priority = 5)
    public void test5(ITestContext context) throws InterruptedException {
        googlePageFlow.googleSearch("Test5");
        Thread.sleep(4000);
    }

}
