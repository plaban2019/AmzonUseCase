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

import java.util.List;

public class AmazonCartPageObject extends ExtentReport {
    public static RemoteWebDriver driver;
    @FindBy(how = How.XPATH, using = "//input[@class='nav-input' and @value='Go']")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement searchIcon;

    @FindBy(how = How.XPATH, using = "//input[@id = 'nav-search-keywords']")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private WebElement searchField;

    @FindBy(how = How.XPATH, using = "//input[@class = 'a-button-input']")
    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "")
    private List<WebElement> addToCarts;


    public AmazonCartPageObject(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void searchField(String searchText) throws Exception {
        Boolean value = true;
        Assert.assertEquals(searchField.getText(),"");
        if (true){
            searchField.sendKeys(searchText);
            test.log(LogStatus.PASS, "seaeched for product:" +searchText);
        }else {
            test.log(LogStatus.FAIL, "not able to search");
            test.log(LogStatus.FAIL, test.addScreenCapture(getFailScreenshot(driver, "failedSearch")));
        }

    }
    public void  clickOnSearchIcon() throws Exception {
        Assert.assertEquals(searchIcon.isDisplayed(), true);
        if (true){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchIcon);
            Thread.sleep(2000);
            test.log(LogStatus.PASS, "Search Icon is clicked");
        }else {
            test.log(LogStatus.FAIL, "Search Icon is not clickable");
            test.log(LogStatus.FAIL, test.addScreencast(getFailScreenshot(driver, "failSearchIcon")));
        }
    }


    public void scrollToAddToCartButton(){
        WebElement addToCart = addToCarts.get(0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",addToCart);

    }
    public void clickOnAddToCart() throws Exception {
        WebElement addToCart = addToCarts.get(0);
        if (addToCart.isDisplayed()){
            Assert.assertEquals(addToCart.isEnabled(), true);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
            test.log(LogStatus.PASS, "addToCart Button is clicked");
        }else {
            test.log(LogStatus.FAIL, "addToCart Button is not clickable");
            test.log(LogStatus.FAIL, test.addScreencast(getFailScreenshot(driver, "failAddToCart")));
        }
    }

}
