module playwright.test {
    requires playwright.flow;
    requires org.testng;
    requires playwright.util;
    exports test.playwright.test to org.testng;
    exports test.playwright.test.elements to org.testng;
    exports test.playwright.test.base to org.testng;
}