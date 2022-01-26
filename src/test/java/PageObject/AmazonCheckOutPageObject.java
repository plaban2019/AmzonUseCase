package PageObject;

import Utility.ConfigFileReader;
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

public class AmazonCheckOutPageObject extends ExtentReport {
    public static RemoteWebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    ConfigFileReader configFileReader;

    @FindBy(how = How.XPATH, using = "//span[@id = 'nav-cart-count']")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement cartIcon;

    @FindBy(how = How.XPATH, using = "//*[contains(text() 'Subtotal']")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement subTotalText;

    @FindBy(how = How.XPATH, using = "//div[@class = 'sc-proceed-to-checkout-button-label ']")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement proceedToCheckOut;

    public AmazonCheckOutPageObject(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCartPage() throws Exception {
        Assert.assertEquals(cartIcon.isDisplayed(), true);
        if (true){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartIcon);
            test.log(LogStatus.PASS, "Continue button is clicked");
        }else {
            test.log(LogStatus.FAIL, "continue button is disabled");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedContinue")));
        }
    }
    public void validateCartPage() throws Exception {
        Assert.assertEquals(proceedToCheckOut.isDisplayed(), true);
        if (true){
            test.log(LogStatus.PASS, "Proceed To Buy is present");
        }else {
            test.log(LogStatus.FAIL, "Proceed To Buy is not present");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedProceedToBuy")));
        }
    }

    public void proceedToCheckOut() throws Exception {
        Assert.assertEquals(proceedToCheckOut.isDisplayed(), true);
        if (true){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedToCheckOut);
            test.log(LogStatus.PASS, "Proceed To Checkout is clicked");
        }else {
            test.log(LogStatus.FAIL, "Proceed To Checkout is not clicked");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedProceedToCheckOut")));
        }
    }

}
