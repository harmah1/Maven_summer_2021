package Appium_Automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo_Test {
    //declare android driver to be used
    AndroidDriver<AndroidElement> driver;

    @BeforeMethod
    public void setApiDemoApp() throws InterruptedException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "11.0.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator222");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\harma\\OneDrive\\Desktop\\DemoApps\\ApiDemos.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(2000);

    }//end of before method

    @Test(priority = 1)
    public void SelectPhotGrid() throws MalformedURLException, InterruptedException {
        AndroidElement element = driver.findElement(By.xpath("//*[@text='API Demos']"));
        try {
            if (element.isDisplayed()) {
                System.out.println("Element API Demos is displayed");
            }
        } catch (Exception e) {
            System.out.println("Fail");
        }

        //click on views
        AndroidElement views = driver.findElement(By.xpath("//*[@text='Views']"));
        try {
            if (views.isDisplayed()) {
                views.click();
                System.out.println("PASS: Successfully clicked on views");
            }
        } catch (Exception e) {
            System.out.println("Fail: Unable to click on views. Exception: " + e);
        }

        Thread.sleep(1000);
        //click on Grid
        AndroidElement grid = driver.findElement(By.xpath("//*[@text='Grid']"));
        try {
            if (grid.isDisplayed()) {
                grid.click();
                System.out.println("PASS: Successfully clicked on Grid");
            }
        } catch (Exception e) {
            System.out.println("Fail: Unable to click on Grid. Exception: " + e);
        }
        Thread.sleep(2500);
        //click on Photo Grid
        AndroidElement photoGrid = driver.findElement(By.xpath("//*[@text='2. Photo Grid']"));
        try {
            if (photoGrid.isDisplayed()) {
                photoGrid.click();
                System.out.println("PASS: Successfully clicked on Photo Grid");
            }
        } catch (Exception e) {
            System.out.println("Fail: Unable to click on Photo Grid. Exception: " + e);
        }
        Thread.sleep(1500);

    }//end of test 1

    @Test(priority = 2)
    public void clickOnTabAndScrollToTab8() throws InterruptedException {
        //click on views
        AndroidElement views = driver.findElement(By.xpath("//*[@text='Views']"));
        views.click();
        //vertical scrolling until the text 'Tabs' is found
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                ".scrollIntoView(new UiSelector().text(\"Tabs\"))");
        //click on Tabs
        AndroidElement tabs = driver.findElement(By.xpath("//*[@text='Tabs']"));
        tabs.click();
        Thread.sleep(1000);
        //click on Scrollable
        AndroidElement scrollable = driver.findElement(By.xpath("//*[@text='5. Scrollable']"));
        scrollable.click();
        //click on TAB 1
        AndroidElement tab1 = driver.findElement(By.xpath("//*[@text='TAB 1']"));
        tab1.click();
        //horizontal scrolling until the text 'TAB 8' is found
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
                ".scrollIntoView(new UiSelector().text(\"TAB 8\"))");
        //click on TAB 8
        AndroidElement tab8 = driver.findElement(By.xpath("//*[@text='TAB 8']"));
        tab8.click();

    }//end of test 2

}//end of java class






