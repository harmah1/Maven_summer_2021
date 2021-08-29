package Day11_082121;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Express_TestNg_Annotations {

    //declare the global variables outside the annotation methods
    WebDriver driver;
    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    //precondition for express
    @BeforeSuite
    public void setTheDriverAndWorkbook() throws IOException, BiffException {
        //step 1: locate the file path where you save it
        readableFile = Workbook.getWorkbook(new File("src/main/resources/express_dataDriven.xls"));
        //create a writable file that mimics the readable in order to write back your result and not corrupt the readable
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ExpressShopping_Results.xls"),readableFile);
        //Step 2: accessing the excel sheet from the workbook
        writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        rowCount = writableSheet.getRows();
        //set the driver
        driver = Reusable_Methods.setDriver();
    }//end of before suite

    @Test
    public void ExpressCheckoutIteration() throws InterruptedException, WriteException {
        for (int i = 1; i < 2; i++) {
            //get cell's 2 arguments are column and row
            String size = writableSheet.getCell(0, i).getContents();
            String qty = writableSheet.getCell(1, i).getContents();
            String fName = writableSheet.getCell(2, i).getContents();
            String lName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phone = writableSheet.getCell(5, i).getContents();
            String addr = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();

            //navigate to express
            driver.navigate().to("https://www.express.com/");
            Thread.sleep(2500);
            //close pop up
            Reusable_Methods.clickMethod(driver, "//*[@id='closeModal']", "Pop up close button");
            //hover over to the Men tab
            Reusable_Methods.mouseHover(driver, "//a[text()='Men']", "Mens tab");
            Thread.sleep(2500);
            //click on polo link
            Reusable_Methods.clickMethod(driver, "//a[text()='Polos']", "Sizes");
            Thread.sleep(2500);
            //click on first polo
            Reusable_Methods.clickMethod(driver, "//*[@class='cdS1D9eKI7bXTMHp5xeAA']", "First Polo");
            Thread.sleep(2000);
            //click on a size
            Reusable_Methods.clickMethod(driver, "//*[text()='" + size + "']", "Sizes");
            //click Add to Bag
            Reusable_Methods.clickMethod(driver, "//button[text()='Add to Bag']", "Add to Bag button");
            Thread.sleep(2500);
            //click View Bag
            Reusable_Methods.clickMethod(driver, "//*[text()='View Bag']", "View Bag button");
            Thread.sleep(1000);
            //select method to choose Qty
            Reusable_Methods.selectMethod(driver, "//select[@id='qdd-0-quantity']", qty, "Quantity");
            //click checkout
            Reusable_Methods.clickMethod(driver, "//button[@id='continue-to-checkout']", "Checkout button");
            Thread.sleep(1000);
            //click checkout as guest
            Reusable_Methods.clickMethod(driver, "//*[text()='Checkout as Guest']", "Checkout as guest");
            Thread.sleep(2500);
            //send keys to first name
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='firstname']", fName, "First name field");
            //send keys to last name
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='lastname']", lName, "Last name field");
            //send keys to email
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='email']", email, "Email field");
            //send keys to confirm email
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='confirmEmail']", email, "Confirm email field");
            //send keys to phone number
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='phone']", phone, "Phone number field");
            //click continue
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue button");
            //close pop up
            Reusable_Methods.clickMethod(driver, "//*[@class='close_button-20856-button close_button-20856-button-d2 bluecoreCloseButton']", "Pop up button");
            //send keys to first name
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.firstName']", fName, "First name field");
            //send keys to last name
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.lastName']", lName, "Last name field");
            //send keys to address
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.line1']", addr, "Street address");
            //send keys to postal code
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.postalCode']", zipCode, "Postal code");
            //send keys to city
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.city']", city, "City");
            //select NY from dropdown
            Reusable_Methods.selectMethod(driver, "//select[@name='shipping.state']", state, "State");
            //click continue
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue button");
            Thread.sleep(2500);
            //click continue
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue button");
            Thread.sleep(2500);
            //capture text from delivery options and write to excel
            String deliveryText = Reusable_Methods.getText(driver, "//*[@class='_1Q4iDku_IopeC7OgnKsdoD']", "Deliver options text");
            System.out.println(deliveryText);
            Label label = new Label(10, i, deliveryText);
            writableSheet.addCell(label);
            //delete cookies
            driver.manage().deleteAllCookies();
        }//end of outer for loop

    }//end of test


    @AfterSuite
    public void writeExcelAndQuitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite


}// end of java class
