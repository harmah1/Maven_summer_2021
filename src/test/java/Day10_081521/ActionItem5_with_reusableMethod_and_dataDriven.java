package Day10_081521;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ActionItem5_with_reusableMethod_and_dataDriven {
    public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException {

        //step 1: locate the file path where you saved it
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/express_dataDriven.xls"));
//create a writable file that mimics the readable in order to write back your result
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/express_dataDriven_results.xls"),readableFile);
//Step 2: accessing the Excel sheet from the workbook
        WritableSheet writableSheet = writableFile.getSheet(0);
//Step 3: row count will return all the rows which is not empty
        int rowCount = writableSheet.getRows();

//set the driver
        WebDriver driver = Reusable_Methods.setDriver();

//call the for loop to iterate through your test data from excel
        for(int i = 1; i < rowCount; i++) {

            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String postalCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();

            //navigate to express.com
            driver.navigate().to("http://express.com/");

            //sleep statement
            Thread.sleep(2500);

            //close pop up
            Reusable_Methods.clickMethod(driver, "//*[@id='closeModal']", "closePopUp");

            Thread.sleep(2500);

            //hover to the Men tab
            Reusable_Methods.mouseHover(driver, "//a[text()='Men']", "Mens tab");
            Thread.sleep(2500);

            //click on polo link
            Reusable_Methods.clickMethod(driver,"//a[text()='Polos']", "Sizes");
            Thread.sleep(2500);

            //click on first polo
            Reusable_Methods.clickMethod(driver,"//*[@class='cdS1D9eKI7bXTMHp5xeAA']","First Polo");
            Thread.sleep(2500);

            //click on size
            Reusable_Methods.clickMethod(driver,"//*[@class='_29GwyLL9tJIABAZ0llJMdA']","Sizes");
            Thread.sleep(2500);

            //click Add to Bag
            Reusable_Methods.clickMethod(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _1UL8jbSKi_lJk1h-uAQ0e _3pJe12e9WWrXBNv6H-DyNU _3AXg-5OJtmBBP6EuBMBV40']","Add to Bag");
            Thread.sleep(2500);

            //click on view bag
            Reusable_Methods.clickMethod(driver,"//*[text()='View Bag']", "View Bag button");
            Thread.sleep(2500);

            //select quantity from dropdown menu
            Reusable_Methods.selectMethod(driver,"//*[@id='qdd-0-quantity']",quantity,"Quantity");
            Thread.sleep(2500);

            //click on checkout
            Reusable_Methods.clickMethod(driver,"//*[@id='continue-to-checkout']","checkout button");
            Thread.sleep(2500);

            //click checkout as guest
            Reusable_Methods.clickMethod(driver,"//*[@class='_1UFak _2YpK4 _1f9t- _2UzsqcoIQ8eUCvNG8QMTC7']","checkout as guest");
            Thread.sleep(2500);

            //enter first name
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='firstname']", firstName, "First name field");

            //enter last name
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='lastname']", lastName, "Last name field");

            //enter email
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='email']", email, "Email field");

            //confirm email
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='confirmEmail']", email, "Confirm email field");

            //enter phone number
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='phone']", phoneNumber, "Phone number field");

            //click on continue
            Reusable_Methods.clickMethod(driver,"//*[text()='Continue']", "Continue button");
            Thread.sleep(2500);

            //close pop up
            Reusable_Methods.clickMethod(driver,"//*[@class='close_button-20856-button close_button-20856-button-d2 bluecoreCloseButton']", "Pop up button");

            //enter address
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='shipping.line1']",address,"enter address field");

            //enter postal code
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='shipping.postalCode']",postalCode,"enter postal code field");

            //enter city
            Reusable_Methods.sendKeysMethod(driver,"//*[@name='shipping.city']",city,"enter city field");

            //select NY from dropdown
            Reusable_Methods.selectMethod(driver, "//select[@name='shipping.state']", state, "State");

            // click on continue
            Reusable_Methods.clickMethod(driver,"//*[text()='Continue']", "Continue button");
            Thread.sleep(2500);

            // click on continue
            Reusable_Methods.clickMethod(driver,"//*[text()='Continue']", "Continue button");
            Thread.sleep(2500);

            //capture the delivery option and write to excel
            String deliveryText = Reusable_Methods.getText(driver,"//*[@class='_1Q4iDku_IopeC7OgnKsdoD']", "Deliver options text");
            System.out.println(deliveryText);
            Label label = new Label(10,i, deliveryText);
            writableSheet.addCell(label);

            //delete cookies
            driver.manage().deleteAllCookies();

        }//end of for loop

        //write back to excel
        writableFile.write();
        //close the file
        writableFile.close();

        //outside of loop quit the driver
        driver.quit();

    }//end of main method
}//end of action item
