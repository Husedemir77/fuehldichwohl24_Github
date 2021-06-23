package runners;

import gherkin.lexer.Th;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class AllTests extends Driver {

    @Test
    public void deneme(){
        WebDriver driver = new Driver().getDriver();
        driver.get("https://amazon.com");
        System.out.println("deneme");
    }

    @Test
    public void hover1() throws InterruptedException {

        WebDriver driver = new Driver().getDriver();
        driver.manage().window().maximize();
        driver.get("https://fuehldichwohl24.de/");

        WebElement cookies = driver.findElement(By.xpath("//button[@class='cf2Lf6']"));
        cookies.click();
        Thread.sleep(3000);

        WebElement fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fuhlDichGesundMenu).perform();

        Thread.sleep(3000);

        WebElement fuhlDichSpanntMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[3]"));
        actions.moveToElement(fuhlDichSpanntMenu).perform();

        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,2500)"); // 2500 piksel asagiya gider

        Thread.sleep(3000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // sayfanin en altina gider

        Thread.sleep(3000);

        driver.quit();

    }
}
