package Day12_082221;

import Reusable_Classes.Reusable_Annotations_Class;
import Reusable_Classes.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class yahoo_checkbox_assertions extends Reusable_Annotations_Class {

    @Test
    public void checkboxAssertion() throws IOException, InterruptedException {
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000);
        //click on sign in
        Reusable_Methods.clickMethod(driver,"//*[text()='Sign in']","Sign In Button");
        Thread.sleep(2000);
        //verify the checkbox stay signed in is selected using testNg assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id='persistent']")).isSelected(),"Should be Selected");

        //verify checkbox is selected using boolean command
        boolean checkBoxStatus = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if(checkBoxStatus == true){
            System.out.println("Checkbox is selected as expected");
        } else {
            System.out.println("Checkbox is not selected");
        }//end of condition

        softAssert.assertAll();

    }//end of test

}//end of java class
