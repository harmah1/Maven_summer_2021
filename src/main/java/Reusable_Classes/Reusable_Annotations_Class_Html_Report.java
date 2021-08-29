package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Reusable_Annotations_Class_Html_Report {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void setTheDriver() throws IOException {
        driver = Reusable_Methods.setDriver();
        //define the path to the report where you going to save your report
        reports = new ExtentReports("src/main/java/Extent_Report/AutomationReport.html",true);
    }//end of before suite

    //before method will take the name of @Test method and store it in the report to track
    @BeforeMethod
    public void getTestName(Method testname){
        logger = reports.startTest(testname.getName());
    }//end of before method

    @AfterMethod
    public void endtest(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void quiteSession(){
        driver.quit();
        reports.flush();
    }//end of after suite

}//end of reusable annotations class
