package Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FetchOs {
        public static  RemoteWebDriver driver;

        public static RemoteWebDriver startTest(String platform) {
            if(platform.equalsIgnoreCase("Android")) {
                AndroidDriver driver = androidDriver();
                return driver;
            } else if(platform.equalsIgnoreCase("iOS")) {
                IOSDriver driver = iosDriver();
                return driver;
            }else {
                WebDriver driver =  mobileWebDriver();
                return (RemoteWebDriver) driver;
            }
        }
        public static AndroidDriver<?> androidDriver() {
            try {
                String apkpath="./miltongreen-nonproguarded-userjourney.apk";
                File app=new File(apkpath);
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 6");
                cap.setCapability("app", app.getAbsolutePath());
                cap.setCapability("noReset",true);
                cap.setCapability("fullReset",false);
                cap.setCapability("appPackage", "io.hansel.sampleapp.userjourney.miltongreen");
                cap.setCapability("appWaitActivity","com.company.miltongreen.activity.LaunchActivity");
                cap.setCapability("autoLaunch", true);
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (AndroidDriver<?>) driver;
        }
        public static IOSDriver<?> iosDriver() {
            try {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0.1");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
                cap.setCapability(MobileCapabilityType.UDID, "");
                cap.setCapability("bundleId", "");
                cap.setCapability("autoLaunch", false);
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
                driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Returning the instance of the driver to the parent method
            return (IOSDriver<?>) driver;
        }
        public static WebDriver mobileWebDriver(){
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                //capabilities.setCapability("chromedriverExecutable", "chromedriver");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 6");
                //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.get("https://www.amazon.in");
            }catch (Exception e) {
                e.printStackTrace();
            }

            return  driver;
        }

}
