package Day13_082821;

import Google_Page_Object.BaseClass;
import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import org.testng.annotations.Test;

public class GoogleSearch_PageObject extends Reusable_Annotations_Class_Html_Report {

    @Test
    public void SearchSomethingOnGoogleHome() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2500);
        BaseClass.homePage().searchAKeyword("Cars");
        BaseClass.homePage().googleSearchSubmit();
    }//end of test 1

    @Test(dependsOnMethods = "SearchSomethingOnGoogleHome")
    public void GetSearchNumber() throws InterruptedException {
        Thread.sleep(2500);
        BaseClass.searchResultPage().getSearchNumber();
    }//end of test 2
}
