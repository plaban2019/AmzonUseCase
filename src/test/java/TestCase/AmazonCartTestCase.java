package TestCase;

import PageObject.AmazonCartPageObject;
import PageObject.AmazonLoginPageObject;
import Utility.ConfigFileReader;
import Utility.ExtentReport;
import Utility.FetchOs;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AmazonCartTestCase extends ExtentReport {
    ConfigFileReader configFileReader;

    @Test(groups = {"mobileSite"}, description = "Add To Cart on Amazon.in for Mobile Site", priority = 2)
    public void addToCart() throws Exception {
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
