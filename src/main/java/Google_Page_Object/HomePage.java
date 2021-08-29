package Google_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Methods_With_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Reusable_Annotations_Class_Html_Report {
    ExtentTest logger;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class_Html_Report.logger;
    }//end of constructor class

    //set up all the web element xpath locators you need for this page
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;

    //method to type on search field
    public void searchAKeyword(String userValue){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,searchField,userValue,"Search Field",logger);
    }//end of search field method

    //method hitting submit on google search
    public void googleSearchSubmit(){
        Reusable_Methods_With_Logger.submitMethod(driver,googleSearchButton,"Google Search Button",logger);
    }//end of google search button method





}//end of class
