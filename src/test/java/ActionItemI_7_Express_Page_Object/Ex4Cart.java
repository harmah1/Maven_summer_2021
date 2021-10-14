package ActionItemI_7_Express_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Method_With_Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ex4Cart extends Reusable_Annotations_Class_Html_Report {

    public Ex4Cart(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class_Html_Report.logger;
    }//end of constructor class

    @FindBy(xpath = "//select[@id='qdd-0-quantity']")
    WebElement selectQuantity;

    @FindBy(xpath = "//button[@id='continue-to-checkout']")
    WebElement clickContinue;

    @FindBy(xpath = "//*[text()='Checkout as Guest']")
    WebElement clickGuest;

    //method to selectQuantityFrmDropDown
    public void selectQuantityFrmDropDown(String choice){
        Reusable_Method_With_Logger.selectMethod(driver,selectQuantity,choice,"selectQuantityFrmDropDown",logger);
    }//end of selectQuantityFrmDropDown

    //method to clickToContinue
    public void clickToContinue(){
        Reusable_Method_With_Logger.clickMethod(driver,clickContinue,"clickToContinue",logger);
    }//end of clickToContinue

    //method to clickGuestCheckout
    public void clickGuestCheckout(){
        Reusable_Method_With_Logger.clickMethod(driver,clickGuest,"clickGuestCheckout",logger);
    }//end of clickGuestCheckout


}//end of class


