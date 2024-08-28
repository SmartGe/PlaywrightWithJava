package test;

import browser.browserSetup;
import com.microsoft.playwright.Page;
import mainPackage.Methods;
import org.testng.annotations.Test;

public class PlaywrightJavaDemo extends browserSetup {

    Methods methods;

    @Test
        public void loginUsingValidCredentials() {
        methods = new Methods(page);
        methods.clickOnSignInLink();
        methods.enterEmailInInputField("testinguser943@gmail.com");
        methods.clickOnSignInButton();
        methods.enterOtpInTextBox("123456");
        methods.verifyUserIsLoggingSuccessfully("testinguser943@gmail.com");
    }

    @Test
    public void startWritingTestCases() throws InterruptedException {
        methods = new Methods(page);
        loginUsingValidCredentials();
        methods.clickOnStartWritingTestCasesLink();
        methods.generateAITestCasesPageIsOpened();
        methods.enterStoryDataInStoryInputField("Write down test cases for Login Page");
        methods.clickOnGenerateTestCasesNowButton();
        methods.verifyTestCasesIsGenerated();
    }

}

