package Day5_072421;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findElements_example {
    public static void main(String[] args) throws InterruptedException {
        //set the property and path to your chromedriver
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000);

        //click on second link(News) using find Elements concept
        driver.findElements(By.xpath("//*[contains(@title,'_yb_15qyj')]")).get(1).click();

    }//end of main
}//end of java class
