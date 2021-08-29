package Day5_072421;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath_contains_And_Text {


    public static void main(String[] args) throws InterruptedException {
        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigating to metlife page
        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(3000);
        //click on solutions
        /*
        when a property value has long value or white space before or after the value then
        contains command is needed in xpath statement
         */
        driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();


    }//end of main


}//end of java class
