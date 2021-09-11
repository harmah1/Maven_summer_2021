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

public class ActionItem6_aetna_TestNG {

    //declare the global variables outside the annotation methods
    WebDriver driver;
    //Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    //precondition for aetna
    @BeforeSuite
    public void setTheDriverAndWorkbook() throws IOException, BiffException {
        //step 1: locate the file path where you save it
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Aetna_dataDriven.xls"));
        //create a writable file that mimics the readable in order to write back your result and not corrupt the readable
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Aetna_dataDriven_Results.xls"),readableFile);
        //Step 2: accessing the excel sheet from the workbook
        writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        rowCount = writableSheet.getRows();
        //set the driver
        driver = Reusable_Methods.setDriver();
    }//end of before suite

   @Test(priority = 1)
    public void Aetna() throws InterruptedException, WriteException {

        for (int i = 1; i < rowCount; i++) {
           //for (int currentRow=1; currentRow<rowCount;currentRow++) {
            //get cell's 2 arguments are column and row
            String zipcode = writableSheet.getCell(0, i).getContents();
            String miles = writableSheet.getCell(1, i).getContents();

            //navigate to aetna
            driver.navigate().to("https://www.aetna.com/");
            //driver.manage().window();
            Thread.sleep(2500);
            //verify the title is 'Health Insurance Plans/Aetna'
            //Reusable_Methods.verifyPageTitle(driver, "Health Insurance Plans/Aetna");

            //click on shop for a plan
            Reusable_Methods.clickMethod(driver, "//*[text()='Shop for a plan']", "shop for a plan");
            Thread.sleep(2500);

            //click on medicare
            Reusable_Methods.clickMethod(driver, "//*[text()='Medicare']", "medicare");
            Thread.sleep(2000);

            //click on find a doctor
            Reusable_Methods.clickMethod(driver, "//*[text()='Find a doctor']", "find doctor");

            //click on 2021 medicare plans you purchase yourself
            Reusable_Methods.clickMethod(driver, "//*[text()='2021 Medicare plans you purchase yourself']","Medicare plans you purchase yourself");
            Thread.sleep(2500);

            //enter a zipcode
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='medZip']", zipcode, "enter a zipcode");
            Thread.sleep(2000);

            //click on zipcode
            Reusable_Methods.clickMethod(driver, "//*[text()='"+zipcode+"']", "zipcode");
            Thread.sleep(2500);

            //on the slider bar select mile
            Reusable_Methods.sliderSendKeysMethod(driver, "//*[@class='rz-pointer rz-pointer-min']", 25, "miles","zipcode");
            Thread.sleep(1000);

            //click on skip plan selection
            Reusable_Methods.clickMethod(driver, "//*[text()='Skip plan selection*']", "skip plan selection");
            Thread.sleep(2500);

            //click on medical doctors & specialist
            Reusable_Methods.clickMethod(driver, "//*[@class='search-block image-block-purple']", "click on medical doctors & specialist");
            Thread.sleep(2500);

            //click on all primary care physicians
            Reusable_Methods.clickMethod(driver, "//*[@class='search-block image-block-purple']", "click on doctors (primary care)");
            Thread.sleep(2500);

            Reusable_Methods.clickMethod(driver, "//*[@class='dummyLinkLabel']","click on all primary care physicians");
            Thread.sleep(2500);

           //capture first result and write to excel
            String doctorLocation = Reusable_Methods.getText(driver, "//*[@class='col-xs-12 col-md-4 dataGridContentCol']", "capture result");
            System.out.println(doctorLocation);

            //spit capture
            //String[] result1 = result.split("colum");
            //String[] result2 = result1[1].split("Specialties");

            //print result
            //System.out.println("Doctor information is" + result2[0]);

            //send result back to the writeable excel sheet
            Label label= new Label(2, i, doctorLocation);
            writableSheet.addCell(label);

            //delete all cookies
            //driver.manage().deleteAllCookies();

        }//end of loop

    }//end of test


    @AfterSuite
    public void writeExcelAndQuitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite


}// end of action item6



