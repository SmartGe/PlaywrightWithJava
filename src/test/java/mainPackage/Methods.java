package mainPackage;

import com.microsoft.playwright.*;
import org.testng.Assert;

public class Methods {

    protected Page page;

    public Methods(Page page){
      this.page = page;
    }

    public void clickOnSignInLink(){
        Locator signInLinkLocator = page.locator("(//span[text()='Sign in'])[1]");
        signInLinkLocator.click();
    }

    public void enterEmailInInputField(String enterEmailId){
        Locator emailInputFieldLocator = page.locator("//input[@id='email']");
        emailInputFieldLocator.fill(enterEmailId);
    }

    public void clickOnSignInButton(){
        Locator signInButtonLocator = page.locator("//button[text()=' Sign In ']");
        signInButtonLocator.click();
    }

    public void enterOtpInTextBox(String otp){

        for (int i = 0; i < otp.length(); i++) {
            String otpLocator = "//input[@type='text']";
            Locator otpBox = page.locator(otpLocator).nth(i);
            otpBox.fill(String.valueOf(otp.charAt(i)));
        }
    }

    public void verifyUserIsLoggingSuccessfully(String verifyUserEmail){
        String userEmailLocator = page.locator("(//button[@id='menu-button'])[1]").textContent();
        Assert.assertEquals(userEmailLocator, verifyUserEmail, "Not Valid User");
    }

    public void clickOnStartWritingTestCasesLink(){
        Locator startWritingTestCasesLocator = page.locator("(//a[@href='/better-cases/create'])[1]");
        startWritingTestCasesLocator.click();
    }

    public void generateAITestCasesPageIsOpened(){
        Locator generateAITestCasesLocator = page.locator("//h2[text()=' Generate AI TestCases ']");
        generateAITestCasesLocator.isVisible();
    }

    public void enterStoryDataInStoryInputField(String enterStoryDetails){
        Locator storyDetailsInputField = page.locator("//textarea[@id='story_detail']");
        storyDetailsInputField.fill(enterStoryDetails);
    }

    public void clickOnGenerateTestCasesNowButton(){
        Locator generateButtonLocator = page.locator("//button[@id='test_case_generate_btn']");
        generateButtonLocator.click();
    }

    public void verifyTestCasesIsGenerated() throws InterruptedException {
        Thread.sleep(10000);
        Locator generateAITestCasesLocator = page.locator("//span[text()='Result: Test-Cases']");
        generateAITestCasesLocator.isVisible();
    }

}
