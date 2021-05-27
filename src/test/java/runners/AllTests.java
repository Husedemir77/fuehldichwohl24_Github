package runners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.Driver;

public class AllTests extends Driver {

    @Test
    public void deneme(){
        WebDriver driver = new Driver().getDriver();
        driver.get("https://amazon.com");
        System.out.println("deneme");
    }
}
