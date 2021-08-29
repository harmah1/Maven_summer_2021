package Day7_07_31_21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_example {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
//set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");
//define the webdriver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(3000);

//click on Show advanced options
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

//using select command choose August as a value for start month
//element need to be under select tag in order to use select command
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select smSelect = new Select(startMonth);
//select by visible text
        smSelect.selectByVisibleText("Aug");

//using select command choose 2022 as a value for start year
//WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
//Select sySelect = new Select(startYear);
//select by visible text
//sySelect.selectByVisibleText("2022");

/*
using click concept to click on the drop down for start year. Whenever an element is not under select tag
then the only to select a value is using click command
*/
//first click on the dropdown
        driver.findElement(By.xpath("//*[@name='sy']")).click();
//click on the value from the dropdown
        driver.findElement(By.xpath("//*[text()='2022']")).click();




    }//end of main method
}//end of java class
