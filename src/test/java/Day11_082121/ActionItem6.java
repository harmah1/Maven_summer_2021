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

public class ActionItem6 {

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
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Aetna_dataDriven_.xls"));
        //create a writable file that mimics the readable in order to write back your result and not corrupt the readable
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Aetna_dataDriven_Results.xls"),readableFile);
        //Step 2: accessing the excel sheet from the workbook
        writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        rowCount = writableSheet.getRows();
        //set the driver
        driver = Reusable_Methods.setDriver();
    }//end of before suite

    @Test
    public void Aetna() throws InterruptedException, WriteException {
        for(int i = 1; i < 2; i++) {

            //get cell's 2 arguments are column and row
            String zipcode = writableSheet.getCell(0, i).getContents();
            String miles = writableSheet.getCell(1, i).getContents();

            //navigate to express
            driver.navigate().to("https://www.aetna.com/");
            driver.manage().window().fullscreen();
            Thread.sleep(2500);

            //click on Shop for a plan
            Reusable_Methods.clickMethod(driver, "//*[text()='Shop for a plan']", "Shop for a plan");
            Thread.sleep(2500);

            //click on Medicare
            Reusable_Methods.clickMethod(driver, "//*[text()='Medicare']", "Medicare");
            Thread.sleep(2500);

            //click on Find a doctor
            Reusable_Methods.clickMethod(driver, "//*[text()='Find a doctor ']", "Find a doctor ");
            Thread.sleep(2500);

            //click on 2021 Medicare plans you purchase yourself
            Reusable_Methods.clickMethod(driver, "//*[text()='2021 Medicare plans you purchase yourself']", "2021 Medicare plans you purchase yourself");
            Thread.sleep(2500);

            //send keys to enter a zipcode
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='medZip']", zipcode, "enter a zipcode");
            Thread.sleep(2500);

            //click zipcode
            Reusable_Methods.clickMethod(driver, "//*[text()='"+zipcode+"']", "zipcode");
            Thread.sleep(2500);

            //move slider bar
            Reusable_Methods.sliderSendKeysMethod(driver, "//*[@class='rz-pointer rz-pointer-min']", 25, miles, "zipcode");
            Thread.sleep(2500);

            //click on skip plan selection
            Reusable_Methods.clickMethod(driver, "//*[text()='Skip plan selection*']", "Skip plan selection");
            Thread.sleep(2500);

            //click on medial doctors & specialist
            Reusable_Methods.clickMethod(driver, "//*[@class='search-block image-block-purple']","click on medial doctors & specialist");
            Thread.sleep(2000);

            //click on all primary care physicians
            Reusable_Methods.clickMethod(driver, "//*[@class='search-block image-block-purple']", "click on Doctors (primary care)");
            Reusable_Methods.clickMethod(driver, "//*[@class='dummyLinkLabel']", "click on all primary care physicians");
            Thread.sleep(2000);

            //capture the first result and send it back to excel doctorLocation column
            String doctorLocation = Reusable_Methods.getText(driver,"//*[@class='mobileFont14px dataGridPadding']","capture the first result");
            System.out.println(doctorLocation);

            //send the result back to the writable excel sheet
            Label label = new Label(2,i,doctorLocation);
            writableSheet.addCell(label);

        }//end of loop
    }//end of test

    @AfterSuite
    public void writeExcelAndQuitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite
}//end of java class


