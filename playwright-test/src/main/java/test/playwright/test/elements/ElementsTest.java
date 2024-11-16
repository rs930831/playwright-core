package test.playwright.test.elements;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.playwright.flow.pageflows.ElementsPageFlow;
import test.playwright.flow.pageflows.GooglePageFlow;
import test.playwright.flow.pageflows.HomePageFlow;
import test.playwright.test.base.BaseTest;

public class ElementsTest extends BaseTest {

    HomePageFlow homePageFlow;
    ElementsPageFlow elementsPageFlow;

    @BeforeClass
    public void beforeClass() {
        homePageFlow = new HomePageFlow();
        elementsPageFlow = new ElementsPageFlow();
    }

    private void navigateToElements() {
        homePageFlow.navigateToHome();
        homePageFlow.navigateToElements();
    }

    @Test
    public void elementsPageTextBoxTest(ITestContext context) throws InterruptedException {
        navigateToElements();
        elementsPageFlow.navigateToMenu("Text Box");
        elementsPageFlow.completeTextBoxFormSubmission(
                "Andy America",
                "andy.america@example.com",
                "Andys Current Address",
                "Andys Permanent Address");
        Thread.sleep(5000);
    }

    @Test
    public void elementsPageCheckBoxTest(ITestContext context) throws InterruptedException {
        navigateToElements();
        elementsPageFlow.navigateToMenu("Check Box");
        elementsPageFlow.checkHome();
        elementsPageFlow.expandCheckBox();
        elementsPageFlow.uncheckDesktop();
        Thread.sleep(5000);
    }





//    @Test(priority = 2)
//    public void test2(ITestContext context) throws InterruptedException {
//        googlePageFlow.googleSearch("Test2");
//        Thread.sleep(4000);
//    }
//
//    @Test(priority = 3)
//    public void test3(ITestContext context) throws InterruptedException {
//        googlePageFlow.googleSearch("Test3");
//        Thread.sleep(4000);
//    }
//
//    @Test(priority = 4)
//    public void test4(ITestContext context) throws InterruptedException {
//        googlePageFlow.googleSearch("Test4");
//        Thread.sleep(4000);
//    }
//
//    @Test(priority = 5)
//    public void test5(ITestContext context) throws InterruptedException {
//        googlePageFlow.googleSearch("Test5");
//        Thread.sleep(4000);
//    }

}
