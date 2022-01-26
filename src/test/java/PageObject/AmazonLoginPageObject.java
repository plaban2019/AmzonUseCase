package PageObject;

import Utility.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AmazonLoginPageObject extends ExtentReport {
    public static RemoteWebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Sign In')]")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement signInLink;

    @FindBy(how = How.ID, using = "ap_email_login")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "//*[@id = 'continue']")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//input[@name = 'customerName')]")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement nameField;

    @FindBy(how = How.ID, using = "ap_password")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement passWordField;

    @FindBy(how = How.ID, using = "signInSubmit")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement signInButton;

    public AmazonLoginPageObject(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void  scrollAmazonPageDown(){
        try {
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void  scrollAmazonPageUp(){
        try {
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0);");
                Thread.sleep(2000);

                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void signIn() throws Exception {
        if (signInLink.isDisplayed()) {
            softAssert.assertEquals(signInLink.isEnabled(), true);
            test.log(LogStatus.PASS, test.addScreenCapture(getScreenShot(driver, "SignIn", signInLink)));
            signInLink.click();
            test.log(LogStatus.PASS, "Sign In is clicked");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //Assert.assertEquals(signInLink.isSelected(), true);
        }else {
            test.log(LogStatus.FAIL, "Sign In button is not visible");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedSignIn")));
        }
    }
    public void enterPhoneNumber(String phone) throws Exception {
        if(emailField.isDisplayed()) {
            softAssert.assertEquals(emailField.isDisplayed(), true);
            Assert.assertEquals(emailField.isDisplayed(), true);
            test.log(LogStatus.PASS, test.addScreenCapture(getScreenShot(driver, "emailField", emailField)));
            emailField.sendKeys(phone);
            test.log(LogStatus.PASS, "Phone number is entered");
            Thread.sleep(2000);

        }else {
            test.log(LogStatus.FAIL, "Email field is not visible");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedEmailField")));
        }
    }
    public void clickContinueButton() throws Exception {

        if (continueButton.isDisplayed() == true) {
            Thread.sleep(6000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
            test.log(LogStatus.PASS, "Continue button is clicked");
        }else {
            test.log(LogStatus.FAIL, "continue button is disabled");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedContinue")));
        }
    }
    public void enterPassWord(String passWord) throws Exception {
        if (passWordField.isDisplayed()) {
            softAssert.assertEquals(passWordField.isDisplayed(), true);
            //Assert.assertEquals(passWordField.isDisplayed(), true);
            passWordField.sendKeys(passWord);
            test.log(LogStatus.PASS, "Password is entered");
        }else {
            test.log(LogStatus.FAIL, "Password field is disabled");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedPassword")));
        }
    }
    public void signInToAmazon() throws Exception {
        if(signInButton.isDisplayed()){
            Assert.assertTrue(signInButton.isEnabled());
            signInButton.click();
            test.log(LogStatus.PASS, "Successfully Signed In");


        }else {
            test.log(LogStatus.FAIL, "Signed In is not happening");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedSignIn")));
        }

    }


}
