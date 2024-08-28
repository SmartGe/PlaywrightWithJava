package browser;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class browserSetup {

    public Playwright playwright;
    public Browser browser;
    public Page page;


    @BeforeMethod
    public void LaunchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        page = browser.newPage();
        page.navigate("https://dev.bettercases.ai/");
    }

    @AfterMethod
    public void closeBrowser(){
        browser.close();
    }

}
