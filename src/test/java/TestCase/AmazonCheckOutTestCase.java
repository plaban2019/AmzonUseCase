package TestCase;
import PageObject.AmazonCartPageObject;
import PageObject.AmazonCheckOutPageObject;
import Utility.ConfigFileReader;
import Utility.ExtentReport;
import Utility.FetchOs;
import org.testng.annotations.*;

public class AmazonCheckOutTestCase extends ExtentReport {

    @Test(groups = {"mobileSite"}, description = "CheckOut on Amazon.in for Mobile Site", priority = 4)
    public void CheckOut() throws Exception {
        AmazonCheckOutPageObject amazonCheckOut = new AmazonCheckOutPageObject(driver);
        amazonCheckOut.goToCartPage();
        amazonCheckOut.validateCartPage();
        amazonCheckOut.proceedToCheckOut();


    }
    @Test(groups = {"Android"}, description = "CheckOut on Amazon.in for Android", priority = 5)
    public void SignInCheckForAndroid() throws Exception {
        System.out.println("Test for Android app");

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
