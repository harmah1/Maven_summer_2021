package Day4_071821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Search {

    public static void main(String[] args) throws InterruptedException {

        //set the property and path to your chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define the chrome driver basically what driver I am going to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to google search page
        driver.navigate().to("https://www.google.com");

        //maximize the browser
        driver.manage().window().maximize();

        //put few seconds wait
        Thread.sleep(3000);

        //identify the search field and enter a keyword 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //hit submit on the search icon
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //every time you interact with a new page you should put sleep statement
        Thread.sleep(2000);

        //capture the search result and only print out the number
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

        //System.out.println("My full result is " + result);

        //extract out the number from the search result and print it using split
        String[] arrayResult = result.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //quit my browser
        driver.quit();


    }//end of main
}//end of java class
