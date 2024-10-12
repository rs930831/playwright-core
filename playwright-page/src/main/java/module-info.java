module playwright.page {
    exports test.playwright.page.pages to playwright.flow;
    exports test.playwright.page.internal to playwright.flow;
    requires playwright.util;
}