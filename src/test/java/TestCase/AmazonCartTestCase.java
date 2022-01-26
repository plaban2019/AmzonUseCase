package TestCase;

import PageObject.AmazonCartPageObject;
import PageObject.AmazonLoginPageObject;
import Utility.ConfigFileReader;
import Utility.ExtentReport;
import Utility.FetchOs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonCartTestCase extends ExtentReport {
    ConfigFileReader configFileReader;
    @Parameters({"platform"})
    @BeforeClass
    public void beforeTestCaseOne(@Optional("Web") String platform){
        driver = FetchOs.startTest(platform);

    }
    @Test(groups = {"mobileSite"}, description = "Add To Cart on Amazon.in for Mobile Site", priority = 2)
    public void SignInCheck() throws Exception {
        configFileReader = new ConfigFileReader();
        String searchText = configFileReader.getSearchedText();
        AmazonCartPageObject amazonAddToCart = new AmazonCartPageObject(driver);
        amazonAddToCart.searchField(searchText);
        amazonAddToCart.clickOnSearchIcon();
        amazonAddToCart.scrollToAddToCartButton();
        amazonAddToCart.clickOnAddToCart();


    }
    @Test(groups = {"Android"}, description = "Add To Cart on Amazon.in for Android", priority = 3)
    public void SignInCheckForAndroid() throws Exception {
        System.out.println("Test for Android app");

    }
}
