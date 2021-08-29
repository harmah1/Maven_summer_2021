package Day8_080121;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class try_catch_exeption {
    public static void main(String[] args) throws InterruptedException, IOException {

        //killing all the chrome instance that have opened
        Runtime.getRuntime().exec("taskkill /im chrome.exe /f");

        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.google.com");

        Thread.sleep(3000);

        //entering a keyword on search field
        try{
            System.out.println("Entering a keyword on search field");
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        } catch (Exception err) {
            System.out.println("Unable to enter a keyword on search field " + err);
        }//end of search field exception

        //submit on google search button
        try{
            System.out.println("Submitting on Google search button");
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        } catch (Exception err) {
            System.out.println("Unable to submit on Google Search button " + err);
        }//end of Google Search button exception

        //capture the result
        Thread.sleep(2500);
        try{
            System.out.println("Capturing search results");
            String results = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            System.out.println("My search result is " + results);
        } catch (Exception err) {
            System.out.println("Unable to capture search results " + err);
        }//end of search results exception



    }//end of main method
}// of java class
