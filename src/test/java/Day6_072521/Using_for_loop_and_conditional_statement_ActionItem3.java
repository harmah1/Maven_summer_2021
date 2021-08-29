package Day6_072521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Using_for_loop_and_conditional_statement_ActionItem3 {
    public static void main(String[] args) throws InterruptedException {

        String[] zipcode = new String[3];
        zipcode[0] = "10314";
        zipcode[1] = "11209";
        zipcode[2] = "11223";

            //set up webDriver manager to handle dynamic browser versions
            WebDriverManager.chromedriver().setup();
            //Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("incognito");
            WebDriver driver = new ChromeDriver(options);

            for (int i=0; i<zipcode.length; i++) {

            //navigate to weight watchers website
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
            //few seconds to wait
            Thread.sleep(3000);

            //click on Studio link
            driver.findElements(By.xpath("//*[@class='buttonText-3DCCO']")).get(1).click();
            Thread.sleep(3000);

            //enter zipcode in the search field
            WebElement searchField = driver.findElement(By.xpath("//*[@id='location-search']"));
            searchField.clear();
            searchField.sendKeys(zipcode[i] );

            //hitting submit on search field
            driver.findElement(By.xpath("//*[@id='location-search-cta']"));
            searchField.submit();
            Thread.sleep(3000);

             List<WebElement> links= driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));

             if (i==0)
            links.get(0).click();
            else if (i==1)
            links.get(1).click();
            else if (i==2)
            links.get(2).click();

        Thread.sleep(2000);

        String address_part1=driver.findElement(By.xpath("(//div[@class='address-2PZwW'])/div[1]")).getText();
        String address_part2=driver.findElement(By.xpath("(//div[@class='address-2PZwW'])/div[2]")).getText();

        System.out.println("The address when i="+ i +" and zipcode=" + zipcode[i]+ " is "+ address_part1 +" " + address_part2);

        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript( "scroll (0,1000)");

        String result= driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
        System.out.println("The hours are\n"+result+ "\n");

        }//end of for loop
        //quit the driver
        driver.quit();

        }//end of main statement
        }//end of Action Item
