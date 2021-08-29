package Day11_082121;

import Reusable_Classes.Reusable_Annotations_Class;
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

public class ActionItem6_aetna_TestNG extends Reusable_Annotations_Class {

    //declare the global variables outside the annotation methods
    WebDriver driver;
    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    //precondition for aetna
    @BeforeSuite
    public void setTheDriverAndWorkbook() throws IOException, BiffException {
        //step 1: locate the file path where you save it
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Aetna_dataDriven.xls"));
        //create a writable file that mimics the readable in order to write back your result and not corrupt the readable
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Aetna_Results.xls"),readableFile);
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
            String zipcode = writableSheet.getCell(0, i).getContents();
            String miles = writableSheet.getCell(1, i).getContents();

            //navigate to aetna
            driver.navigate().to("https://www.aetna.com/");
            Thread.sleep(2500);
            //verify the title is 'Health Insurance Plans/Aetna'
            Reusable_Methods.verifyPageTitle(driver, "Health Insurance Plans/Aetna");

            //click on shop for a plan
            Reusable_Methods.clickMethod(driver, "//*[text()='Shop for a plan']", "shop for a plan");
            Thread.sleep(2500);

            //hoover on medicare
            Reusable_Methods.mouseHover(driver, "//*[text()='Medicare']", "medicare");
            Thread.sleep(2000);

            //click on find a doctor
            Reusable_Methods.clickMethod(driver, "//*[text()='Find a doctor']", "find doctor");

            //click on 2021 medicare plans you purchase yourself
            Reusable_Methods.clickMethod(driver, "//*[@class='primaryPurple BtnWidth mgbutton w400']", "medicare plans purchase ");
            Thread.sleep(2500);

            //enter a zipcode
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='medZip']", zipcode, "zipcode field");
            Thread.sleep(2000);

            //click on zipcode
            Reusable_Methods.clickMethod(driver, "//*[@id='typeahead-26-1488-option-0']", "click zipcode");
            Thread.sleep(1000);

            //on the slider bar select mile
            Reusable_Methods.sliderSendKeysMethod(driver, "//*[@class='rz-pointer rz-pointer-min']", 25, "int","select miles");
            Thread.sleep(1000);

            //click on skip plan selection
            Reusable_Methods.clickMethod(driver, "//*[text()='Skip plan selection*']", "skip plan selection");
            Thread.sleep(2500);

            //click on medical doctors & specialist
            Reusable_Methods.clickMethod(driver, "//*[@class='mobileMarAdj anchorTagGuided']", "medical doctors & specialist");
            Thread.sleep(2000);

            //click on all primary care physicians
            Reusable_Methods.clickMethod(driver, "//*[text()='All Primary Care Physicians']", "all primary care physicians");
            Thread.sleep(2000);

           /* //capture first result and write to excel
            String deliveryText = Reusable_Methods.getText(driver, "//*[@class='_1Q4iDku_IopeC7OgnKsdoD']", "Deliver options text");
            System.out.println(deliveryText);
            Label label = new Label(10, i, deliveryText);
            writableSheet.addCell(label);
            //delete cookies
           */ driver.manage().deleteAllCookies();
        }//end of outer for loop

    }//end of test


    @AfterSuite
    public void writeExcelAndQuitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite


}// end of java class



