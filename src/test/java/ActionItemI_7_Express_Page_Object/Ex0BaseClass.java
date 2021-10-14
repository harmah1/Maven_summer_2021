package ActionItemI_7_Express_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Ex0BaseClass extends Reusable_Annotations_Class_Html_Report {

    public Ex0BaseClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }//end of constructor class

    //Create static reference for express homepage
    public static Ex1HomePage ex1HomePage() {
        Ex1HomePage ex1HomePage = new Ex1HomePage(driver);
        return ex1HomePage;
    }//end of express homepage method

    //Create static reference for mens polo
    public static Ex2MensPolo ex2MensPolo() {
        Ex2MensPolo ex2MensPolo = new Ex2MensPolo(driver);
        return ex2MensPolo;
    }//end of mens polo method

    //Create static reference for Polo shirt
    public static Ex3PoloShirt ex3PoloShirt() {
        Ex3PoloShirt ex3PoloShirt = new Ex3PoloShirt(driver);
        return ex3PoloShirt;
    }//end of Polo shirt

    //Create static reference for Cart
    public static Ex4Cart ex4Cart() {
        Ex4Cart ex4Cart = new Ex4Cart(driver);
        return ex4Cart;
    }//end of cart

    //Create static reference for checkOut
    public static Ex5Checkout ex5Checkout(){
        Ex5Checkout ex5Checkout = new Ex5Checkout(driver);
        return ex5Checkout;
    }//end of checkOut


}//end of class



