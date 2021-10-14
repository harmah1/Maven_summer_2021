package ActionItemI_7_Express_Page_Object;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Express_PageObject extends Reusable_Annotations_Class_Html_Report {

    //declare the global variables outside the annotation methods
    //WebDriver driver;
    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;
    String size;
    String quantity;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String postalCode;
    String city;
    String state;

    @BeforeSuite
    public void setTheDriverAndWorkbook() throws BiffException, IOException {
        //step 1: locate the file path where you saved it
        readableFile = Workbook.getWorkbook(new java.io.File("src/main/resources/express_dataDriven.xls"));
        //readableFile = Workbook.getWorkbook(new File( "src/main/resources/express_dataDriven.xls"));
        //create a writeable file that mimics the readable in order to write back your result and not corrupt the readable
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ExpressShopping_Results.xls"),readableFile);
        //writableFile = Workbook.createWorkbook(new File("src/main/resources/express_dataDriven_results.xls"),readableFile);
        //Step 2:accessing the excel sheet from the workbook
        writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        rowCount = writableSheet.getRows();
        //set the driver
        //driver = Reusable_Methods.setDriver();
    }//end of before suite

    @Test
    public void readingFromExcel() throws InterruptedException, WriteException, IOException {
        for (int i = 1; i < rowCount; i++) {
            //get cells 2 arguments are column and row
            size = writableSheet.getCell(0, i).getContents();
            quantity = writableSheet.getCell(1, i).getContents();
            firstName = writableSheet.getCell(2, i).getContents();
            lastName = writableSheet.getCell(3, i).getContents();
            email = writableSheet.getCell(4, i).getContents();
            phoneNumber = writableSheet.getCell(5, i).getContents();
            address = writableSheet.getCell(6, i).getContents();
            postalCode = writableSheet.getCell(7, i).getContents();
            city = writableSheet.getCell(8, i).getContents();
            state = writableSheet.getCell(9, i).getContents();

        /*}//end of test


    @Test(dependsOnMethods = "readingFromExcel")
    public void shopExpress() throws InterruptedException {*/
            driver.navigate().to("https://www.express.com");
            Thread.sleep(2000);
            Ex0BaseClass.ex1HomePage().closePopUp();
            Ex0BaseClass.ex1HomePage().hoverOverMensTab();
            Ex0BaseClass.ex1HomePage().clickPolos();
    /*}//end of test 1

    @Test(dependsOnMethods = "shopExpress")
    public void viewExpress() throws InterruptedException {*/
            Thread.sleep(2000);
            Ex0BaseClass.ex2MensPolo().clickFirstPolosPicture();
    /*}//end of test 2

    @Test(dependsOnMethods = "viewExpress")
    public void choosePoloShirt() throws InterruptedException {*/
            Thread.sleep(2000);
            Ex0BaseClass.ex3PoloShirt().chooseSize(size);
            Ex0BaseClass.ex3PoloShirt().addToBag();
            Ex0BaseClass.ex3PoloShirt().viewTheBag();
    /*}//end of test 3

    @Test(dependsOnMethods = "choosePoloShirt")
    public void addToCart() throws InterruptedException {*/
            Thread.sleep(2000);
            Ex0BaseClass.ex4Cart().selectQuantityFrmDropDown(quantity);
            Ex0BaseClass.ex4Cart().clickToContinue();
            Ex0BaseClass.ex4Cart().clickGuestCheckout();
    /*}//end of test 4

    @Test(dependsOnMethods = "addToCart")
    public void checkOut() throws InterruptedException {*/
            Thread.sleep(2000);
            Ex0BaseClass.ex5Checkout().sendFirstName(firstName);
            Ex0BaseClass.ex5Checkout().sendLastName(lastName);
            Ex0BaseClass.ex5Checkout().sendEmail(email);
            Ex0BaseClass.ex5Checkout().sendConfirmEmail(email);
            Ex0BaseClass.ex5Checkout().sendPhoneNumber(phoneNumber);
            Ex0BaseClass.ex5Checkout().clickContinueButton();
            Ex0BaseClass.ex5Checkout().clickXpopup();
            Ex0BaseClass.ex5Checkout().sendShippingFn(firstName);
            Ex0BaseClass.ex5Checkout().sendShippingLn(lastName);
            Ex0BaseClass.ex5Checkout().sendShippingAddress(address);
            Ex0BaseClass.ex5Checkout().sendPostalCode(postalCode);
            Ex0BaseClass.ex5Checkout().sendShippingCity(city);
            Ex0BaseClass.ex5Checkout().selectShippingState(state);
            Ex0BaseClass.ex5Checkout().clickShippingContinue();
            Ex0BaseClass.ex5Checkout().clickShippingContinueButton();
    /*}//end of test 5

    @Test(dependsOnMethods = "checkOut")
    public void writingToExcel() throws WriteException {*/

            String actualText = Ex0BaseClass.ex5Checkout().getDeliveryText();
            Label label = new Label(10, i, actualText);
            writableSheet.addCell(label);
            //delete cookies
            driver.manage().deleteAllCookies();
        }//end of loop



    }//end of after test
    @AfterSuite
    public void writeExcelAndQuitDrive() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite

}//end of class


