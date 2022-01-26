package TestCase;
import PageObject.AmazonCheckOutPageObject;
import Utility.ConfigFileReader;
import Utility.ExtentReport;
import Utility.FetchOs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonCheckOutTestCase extends ExtentReport {
    ConfigFileReader configFileReader;
    @Parameters({"platform"})
    @BeforeClass
    public void beforeTestCaseOne(@Optional("Web") String platform){
        driver = FetchOs.startTest(platform);

    }
    @Test(groups = {"mobileSite"}, description = "CheckOut on Amazon.in for Mobile Site", priority = 4)
    public void SignInCheck() throws Exception {
        AmazonCheckOutPageObject amazonCheckOut = new AmazonCheckOutPageObject(driver);
        amazonCheckOut.goToCartPage();
        amazonCheckOut.validateCartPage();
        amazonCheckOut.proceedToCheckOut();


    }
    @Test(groups = {"Android"}, description = "CheckOut on Amazon.in for Android", priority = 5)
    public void SignInCheckForAndroid() throws Exception {
        System.out.println("Test for Android app");

    }
}
