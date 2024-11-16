package test.playwright.util.playwright;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.Playwright;

public class PlaywrightApiUtil implements AutoCloseable {

    private static Playwright pw;
    @Override
    public void close() throws Exception {
        if(pw !=null )
            pw.close();
    }

    public static void main(String[] args) {
        pw = Playwright.create();
        APIRequest apiRequest = pw.request();
        apiRequest.newContext(new APIRequest.NewContextOptions());
        
    }
}
