package TestCase;
import PageObject.AmazonLoginPageObject;
import Utility.ConfigFileReader;
import Utility.ExtentReport;
import Utility.FetchOs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AmazonLoginTestCase extends ExtentReport {
    ConfigFileReader configFileReader;
    @Parameters({"platform"})
    @BeforeClass
    public void beforeTestCaseOne(@Optional("Web") String platform){
        driver = FetchOs.startTest(platform);

    }
    @Test(groups = {"mobileSite"}, description = "SignIn to Amazon.in from Mobile Site", priority = 0)
    public void SignInCheck() throws Exception {
        configFileReader = new ConfigFileReader();
        System.out.println(driver);
        String text = driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text, "https://www.amazon.in");
        String phoneNumber = configFileReader.getAmazonPhoneNumber();
        String passWord = configFileReader.getAmazonPassword();
        AmazonLoginPageObject amazon = new AmazonLoginPageObject(driver);
        amazon.scrollAmazonPageDown();
        amazon.scrollAmazonPageUp();
        Thread.sleep(2000);
        amazon.signIn();
        Thread.sleep(2000);
        amazon.enterPhoneNumber(phoneNumber);
        Thread.sleep(2000);
        amazon.clickContinueButton();
        amazon.enterPassWord(passWord);
        Thread.sleep(2000);
        amazon.signInToAmazon();


    }
    @Test(groups = {"Android"}, description = "SignIn to Amazon.in from Android", priority = 1)
    public void SignInCheckForAndroid() throws Exception {
        System.out.println("Test for Android app");

    }
}
