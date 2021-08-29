package Google_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Methods_With_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Reusable_Annotations_Class_Html_Report {
    ExtentTest logger;
    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class_Html_Report.logger;
    }//end of constructor class

    //set up all the web element xpath locators you need for this page
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResultText;

    //method to capture the search result and print out only the search number
    public void getSearchNumber(){
       String results =  Reusable_Methods_With_Logger.getText(driver,searchResultText,"Search Result",logger);
       String[] arrayResults = results.split(" ");
       System.out.println("My Search number is " + arrayResults[1]);
       logger.log(LogStatus.INFO,"My Search number is " + arrayResults[1]);
    }//end of get search number




}//end of class
