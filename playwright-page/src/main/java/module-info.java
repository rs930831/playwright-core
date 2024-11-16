module playwright.page {
    exports test.playwright.page.pages to playwright.flow; // Only to Flow
//    exports test.playwright.page.internal to playwright.flow; // Only to Flow
    requires playwright.util;
}