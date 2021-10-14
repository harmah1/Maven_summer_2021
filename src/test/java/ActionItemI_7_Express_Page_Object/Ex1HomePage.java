package ActionItemI_7_Express_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Method_With_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ex1HomePage extends Reusable_Annotations_Class_Html_Report {

    ExtentTest logger;
    public Ex1HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class_Html_Report.logger;
    }//end of constructor class

    //set up all the web element xpath locators you need for this page
    @FindBy(xpath = "//*[@id='closeModal']")
    WebElement closePopUp;

    @FindBy(xpath = "//a[text()='Men']")
    WebElement mensTab;

    @FindBy(xpath = "//a[text()='Polos']")
    WebElement clickOnPolos;


    //method to closepopup
    public void closePopUp(){
        Reusable_Method_With_Logger.clickIfPopupExist(driver,closePopUp,"closePopUp", logger);
    }//end of closepopup

    //method to mouseHover
    public void hoverOverMensTab(){
        Reusable_Method_With_Logger.mouseHover(driver,mensTab,"hoverOverMensTab",logger);
    }//end of mouseHover

    //method to clickPolos
    public void clickPolos(){
        Reusable_Method_With_Logger.clickMethod(driver,clickOnPolos,"clickPolos",logger);
    }//end of clickPolos

}//end class


