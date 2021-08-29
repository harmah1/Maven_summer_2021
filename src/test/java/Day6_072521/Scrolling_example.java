package Day6_072521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_example {
    public static void main(String[] args) throws InterruptedException {

        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator site
        driver.navigate().to("https://www.yahoo.com");
        //few seconds to wait
        Thread.sleep(3000);
        //enter a keyword
        WebElement searchField = driver.findElement(By.xpath("//*[@name='p']"));
        searchField.sendKeys("cars");
        //hitting submit on search field
        searchField.submit();

        Thread.sleep(3000);

        /*
           need to scroll to the bottom of the result page in order to capture
           the search result number
         */
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,5000)");

        //capture the result and print out only number
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        String[] arrayResult = result.split("Next");
        System.out.println("My search result is " + arrayResult[1].trim());
        String newResult = arrayResult[1].trim();
        String[] newArray = newResult.split(" ");
        System.out.println("My search number is " + newArray[0]);

        //scroll back up to the top
        jse.executeScript( "scroll(0, -5000)");
        Thread.sleep( 2000);

        //quit the driver
        driver.quit();

    }//end of main method
}// end of java class
