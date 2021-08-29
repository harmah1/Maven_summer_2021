package Day8_080121;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Actions_USPS {
    public static void main(String[] args) throws InterruptedException {

        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator site
        driver.navigate().to("https://www.usps.com");
        //few seconds to wait
        Thread.sleep(3000);

        //move to send tab using mouse Actions
        Actions mouseMove = new Actions(driver);
        try {
            System.out.println("Hovering to send tab");
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            mouseMove.moveToElement(sendTab).perform();

        }catch (Exception err) {
            System.out.println("unable to hover to send tab" + err);
        }//end of send tab exception

        try {
            //using actions to click on the schedule a pickup
            System.out.println("Clicking on Schedule a Pickup");
            WebElement schedulePickup = driver.findElement(By.xpath("a[text()='Schedule a Pickup']"));
            mouseMove.moveToElement(schedulePickup).click().perform();
        } catch (Exception err) {
            System.out.println("unable to click on schedule a pickup " + err);
        }//end of schedule a pickup exception

    }//end of main method
}//end of java class
