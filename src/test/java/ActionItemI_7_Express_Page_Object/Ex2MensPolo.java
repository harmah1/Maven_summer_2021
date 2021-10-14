package ActionItemI_7_Express_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Method_With_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ex2MensPolo extends Reusable_Annotations_Class_Html_Report {

    ExtentTest logger;
    public Ex2MensPolo(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class_Html_Report.logger;
    }//end of constructor class

    //setup all the webelement xpath locators you need for this page
    @FindBy(xpath = "//*[@class='_2fbIe3xmE78JEQRb26pdpQ']")
    WebElement FirstMensPoloPicture;

    //method to clickFirstPolosPicture
    public void clickFirstPolosPicture(){
        Reusable_Method_With_Logger.clickMethod(driver,FirstMensPoloPicture,"clickFirstPolosPicture",logger);
    }//end of clickFirstPolosPicture


}//end of class

