package ActionItemI_7_Express_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Method_With_Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ex3PoloShirt extends Reusable_Annotations_Class_Html_Report {

    public Ex3PoloShirt(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class_Html_Report.logger;
    }//end of constructor class
    @FindBy(xpath = "//button[text()='Add to Bag']")
    WebElement addToBagButton;

    @FindBy(xpath = "//*[text()='View Bag']")
    WebElement viewBag;

    public void chooseSize(String size){
        Reusable_Method_With_Logger.selectSize(driver,size,"size",logger);
    }

    public void addToBag(){
        Reusable_Method_With_Logger.clickMethod(driver,addToBagButton,"add to bag button",logger);
    }

    public void viewTheBag(){
        Reusable_Method_With_Logger.clickMethod(driver,viewBag,"view bag button",logger);
    }
}//end of class

