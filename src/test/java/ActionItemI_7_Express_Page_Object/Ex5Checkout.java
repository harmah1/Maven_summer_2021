package ActionItemI_7_Express_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Method_With_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ex5Checkout extends Reusable_Annotations_Class_Html_Report {

    ExtentTest logger;
    public Ex5Checkout(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations_Class_Html_Report.logger;
    }//end of constructor class

    //setup all the web element xpath locators you need for this page
    @FindBy(xpath = "//*[@name='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//*[@name='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//*[@name='email']")
    WebElement email;

    @FindBy(xpath = "//*[@name='confirmEmail']")
    WebElement confirmEmail;

    @FindBy(xpath = "//*[@name='phone']")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//*[@name='bluecoreCloseButton']")
    WebElement closePopUp;

    @FindBy(xpath = "//*[@name='shipping.firstName']")
    WebElement shippingFirstName;

    @FindBy(xpath = "//*[@name='shipping.lastName']")
    WebElement shippingLastName;

    @FindBy(xpath = "//*[@name='shipping.line1']")
    WebElement shippingAddress;

    @FindBy(xpath = "//*[@name='shipping.postalCode']")
    WebElement shippingPostalCode;

    @FindBy(xpath = "//*[@name='shipping.city']")
    WebElement shippingCity;

    @FindBy(xpath = "//*[@name='shipping.state']")
    WebElement shippingState;

    @FindBy(xpath = "//*[text()='Continue']")
    WebElement shippingContinue;

    @FindBy(xpath = "//*[text()='Continue']")
    WebElement shippingContinueButton;

    @FindBy(xpath = "//*[@class='_1Q4iDku_IopeC7OgnKsdoD']")
    WebElement deliveryText;

    //method to sendFirstName
    public void sendFirstName(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,firstName,userValue,"sendFirstName",logger);
    }//end of sendFirstName

    //method to sendLastName
    public void sendLastName(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,lastName,userValue,"sendLastName",logger);
    }//end of sendLastName

    //method to sendEmail
    public void sendEmail(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,email,userValue,"sendEmail",logger);
    }//end of sendEmail

    //method to sendConfirmEmail
    public void sendConfirmEmail(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,confirmEmail,userValue,"sendConfirmEmail",logger);
    }//end of sendConfirmEmail

    //method to sendPhoneNumber
    public void sendPhoneNumber(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,phoneNumber,userValue,"sendPhoneNumber",logger);
    }//end of sendPhoneNumber

    //method to clickContinueButton
    public void clickContinueButton(){
        Reusable_Method_With_Logger.clickMethod(driver,continueButton,"clickContinueButton",logger);
    }//end of clickContinueButton

    //method to clickXPopUp
    public void clickXpopup(){
        Reusable_Method_With_Logger.clickIfPopupExist(driver,closePopUp,"clickXPopUp",logger);
    }//end of clickXPopup

    //method to sendShippingFn
    public void sendShippingFn(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,shippingFirstName,userValue,"sendShippingFn",logger);
    }//end of sendShippingFn

    //method to sendShippingLn
    public void sendShippingLn(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,shippingLastName,userValue,"sendShippingLn",logger);
    }//end of sendShippingLn

    //method to sendShippingAddress
    public void sendShippingAddress(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,shippingAddress,userValue,"sendShippingAddress",logger);
    }//end of sendShippingAddress

    //method to sendPostalCode
    public void sendPostalCode(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,shippingPostalCode,userValue,"sendPostalCode",logger);
    }//end of sendPostalCode

    //method to sendShippingCity
    public void sendShippingCity(String userValue){
        Reusable_Method_With_Logger.sendKeysMethod(driver,shippingCity,userValue,"sendShippingCity",logger);
    }//end of sendShippingCity

    //method to selectShippingState
    public void selectShippingState(String choice){
        Reusable_Method_With_Logger.selectMethod(driver,shippingState,choice,"sendShippingState",logger);
    }//end of sendShippingState

    //method to clickShippingContinue
    public void clickShippingContinue(){
        Reusable_Method_With_Logger.clickMethod(driver,shippingContinue,"clickShippingContinue",logger);
    }//end of clickShippingContinue

    //method to clickShippingContinueButton
    public void clickShippingContinueButton(){
        Reusable_Method_With_Logger.clickMethod(driver,shippingContinueButton,"clickShippingContinueButton",logger);
    }//end of clickShippingContinueButton

    //capture delivery text
    public String getDeliveryText(){
        String actualText = Reusable_Method_With_Logger.getText(driver,deliveryText,"getDeliveryText",logger);
        return actualText;
    }//end of deliver text

}//end of class

