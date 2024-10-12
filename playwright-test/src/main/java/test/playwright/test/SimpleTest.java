package test.playwright.test;

import org.testng.annotations.Test;
import test.playwright.flow.pageflows.HomePageFlow;
import test.playwright.test.base.BaseTest;

public class SimpleTest extends BaseTest {

    @Test
    public void test() {
        System.out.println("Testing");
        HomePageFlow hpf = new HomePageFlow(); // Take it to Before or After
        hpf.navigateToHome();
        hpf.clickOnAlertFrameWindows();
    }

}
