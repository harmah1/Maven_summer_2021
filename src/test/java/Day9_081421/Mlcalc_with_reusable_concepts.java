package Day9_081421;

import Reusable_Classes.Reusable_Methods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Mlcalc_with_reusable_concepts {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = Reusable_Methods.setDriver();

//navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2500);
//clear and enter a purchase price
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='ma']","400000","Purchase Price");
//clear and enter down payment
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='dp']","25","Down Payment");


    }//end of main method
}//end of java class
