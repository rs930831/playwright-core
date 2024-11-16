module playwright.util {
    requires playwright;
    requires com.opencsv;
    exports test.playwright.util.playwright to playwright.page;
    exports test.playwright.util.common;
    exports test.playwright.util.playwrightfactory to playwright.test;
}