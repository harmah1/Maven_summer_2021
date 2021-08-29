package Day9_081421;

import Reusable_Classes.Reusable_Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Actionitem4_with_Reusable_Methods{
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> firstNamelist = new ArrayList<>();
        firstNamelist.add("Anna");
        firstNamelist.add("Rose");
        firstNamelist.add("Jean");
        ArrayList<String> lastNamelist = new ArrayList<>();
        lastNamelist.add("Cruz");
        lastNamelist.add("Dicks");
        lastNamelist.add("Smith");
        ArrayList<String> doblist = new ArrayList<>();
        doblist.add("12251990*");
        doblist.add("11241980*");
        doblist.add("10231970*");
        ArrayList<String> planidlist = new ArrayList<>();
        planidlist.add("50501");
        planidlist.add("40404");
        planidlist.add("30303");
        ArrayList<String> groupnumberlist = new ArrayList<>();
        groupnumberlist.add("10306");
        groupnumberlist.add("10309");
        groupnumberlist.add("10304");

        WebDriverManager.chromedriver().setup();
//set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
//set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");
//define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //iterate through the array list of fistnamelist, lastnamelist, doblist, zipcodelist and planidlist
        for (int i = 0; i < firstNamelist.size(); i++) {

            try {
                //navigate to united health care website
                System.out.println("Navigating to https://www.uhc.com");
                driver.navigate().to("https://www.uhc.com");

            } catch (Exception Error) {
                System.out.println("unable to navigate to https://www.uhc.com " + Error);
                Thread.sleep(2000);

            }//end of navigate to uhc.com exception

            //click on find a doctor link
            try {
                System.out.println("Click on find a doctor link");
                WebElement find_a_doctor = driver.findElement(By.xpath("//a[text()='Find a doctor']"));
                find_a_doctor.click();
                Thread.sleep(5000);
            } catch (Exception err) {
                System.out.println("Unable to click on find a doctor link " + err);
            }//end of find a doctor exception

            try {
                //close popup if it appears
                System.out.println("click on close popup button");
                WebElement popup_exit = driver.findElement(By.xpath("//*[@id='ip-close']"));
                popup_exit.click();
            } catch (Exception Error) {
                //print out the error message if popup does not appear
                System.out.println("unable to click on close popup button " + Error);
                Thread.sleep(2000);
            }//end of close popup if it appears

            //scroll to dropdown menu
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll (0,400)");

            try {
                //click on select your plan to sign in
                System.out.println("click on select your plan to sign in");
                WebElement plans_dropdown_menu = driver.findElement(By.xpath("//*[contains(text(),'Select your plan to sign in')]"));
                plans_dropdown_menu.click();

            } catch (Exception Error) {
                //print out error message if unable to click on select your plan to sign in
                System.out.println("Unable to click on select your plan to sign in " + Error);
                Thread.sleep(2000);
            }//end of click on select your plan to sign in

            try {
                //click on Medicaid plan
                System.out.println("Clicking on Medicaid plan option");
                WebElement medicaid_plan = driver.findElement(By.xpath("//*[text()='Medicaid plan']"));
                medicaid_plan.click();
            } catch (Exception Error) {
                //print out this error message if it is unable to click on Medicaid plan option
                System.out.println("Unable to click on Medicaid plan option " + Error);
                Thread.sleep(2000);
            }//end of click on medicaid plan

            //Switch to new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switches to the second tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            try {
                //click on register now
                System.out.println("click on register now");
                WebElement register_now = driver.findElement(By.xpath("//*[text()='Register Now']"));
                register_now.click();

            } catch (Exception Error) {
                //print out this error message if it is unable to click on register now
                System.out.println("Unable to click on register now " + Error);
                Thread.sleep(2000);
            }// end of register now

            Reusable_Methods.sendKeysMethod(driver,"//*[@id='firstName']", firstNamelist.get(i), "First name field");

            /*
            //send first_name list
            WebElement first_name_field = driver.findElement(By.xpath("//*[@id='firstName']"));
            first_name_field.sendKeys(firstNamelist.get(i));
             */

            Reusable_Methods.sendKeysMethod(driver,"//*[@id='lastName']", lastNamelist.get(i), "Last name field ");

            /*
            //enter last name
            WebElement last_name_field = driver.findElement(By.xpath("//*[@id='lastName']"));
            last_name_field.sendKeys(lastNamelist.get(i));
            */

            //enter month of birth
            WebElement dob_month_box = driver.findElement(By.xpath("//*[@id='dob_month_input']"));
            Select select_month = new Select(dob_month_box);
            select_month.selectByValue(doblist.get(i).substring(0, 2));

            Reusable_Methods.sendKeysMethod(driver,"//*[@id='dob_day']", doblist.get(i).substring(2, 4), "date of birth field ");

            /*
            //enter the day of dob
            WebElement dob_day_box = driver.findElement(By.xpath("//*[@id='dob_day']"));
            dob_day_box.sendKeys(doblist.get(i).substring(2, 4));

             */

            Reusable_Methods.sendKeysMethod(driver,"//*[@id='dob_year']", doblist.get(i).substring(4, 9), "Year of birth field ");
            /*
            //enter the year of birth
            WebElement dob_year_box = driver.findElement(By.xpath("//*[@id='dob_year']"));
            dob_year_box.sendKeys(doblist.get(i).substring(4, 8));
            */


            Reusable_Methods.sendKeysMethod(driver,"//*[@id='memberId']", planidlist.get(i), "id number field ");
            /*
            //enter plan id number
            WebElement planId_field = driver.findElement(By.xpath("//*[@id='memberId']"));
            planId_field.sendKeys(planidlist.get(i));

             */

            Reusable_Methods.sendKeysMethod(driver,"//*[@id='groupNumber']",groupnumberlist.get(i),"group number field");
            /*
            //enter group number
            WebElement groupNumber_field = driver.findElement(By.xpath("//*[@id='groupNumber']"));
            groupNumber_field.sendKeys(groupnumberlist.get(i));
            */
            try {
                //click on continue button
                System.out.println("click continue button");
                WebElement continue_buttom = driver.findElement(By.xpath("//*[@id='submitBtn']"));
                continue_buttom.click();
            } catch (Exception err) {
                //print out the error message if unable to continue
                System.out.println("Unable to continue" + err);
                Thread.sleep(2000);
            }//end of continue exception

//capture error message
            System.out.println(Reusable_Methods.getText(driver,"//*[@id='plainText_error']","err message"));


//close the new tab
            driver.close();

//switch back to default tab
            driver.switchTo().window(tabs.get(0));

        }//end off loop

        driver.quit();

    }//end of main method
}//end of ActionItem

