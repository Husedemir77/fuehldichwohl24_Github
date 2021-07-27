package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.ParentClass;

import java.util.List;
import java.util.Random;

public class Covid19Page extends ParentClass {


    By buttonCovid = (By.xpath("(//span[@class='gm-menu-item__txt'])[5]"));

    By textCovid = (By.xpath("//h1[@class='qodef-m-title entry-title']"));
    By wirkstoffdosierungButton = (By.cssSelector("#select2-pa_wirkstoffdosierung-container"));
    By inhalt = (By.xpath("(//ul[@class='select2-resultsoptions']/li)[2]"));
    By buttonInhalt = (By.cssSelector("#select2-pa_inhalt-container"));
    By html = (By.cssSelector("html"));
    By buttonWarenkorb = (By.xpath("//button[@class='single_add_to_cart_button button alt']"));
    By produksList = By.xpath("//div[@class='qodef-woo-product-inner']/parent::*");




    public void  hoverOnCovid(){

        moveToElement(buttonCovid);
        clickTo(buttonCovid);

    }

    public void checkTheCovidMenu(){

        String text = driver.findElement(textCovid).getText();
        Assert.assertEquals(text, "Covid-19");

    }

    public void covidMenuRandomAddAProduct() throws InterruptedException {
        Random random = new Random();
        Actions actions = new Actions(driver);
        List<WebElement> products = driver.findElements(produksList);

        int productZahl = products.size();
        int randomProduct = random.nextInt(productZahl);
        System.out.println(productZahl);
        System.out.println(randomProduct);

        actions.moveToElement(products.get(randomProduct)).click().perform();
        Thread.sleep(2000);

        String htmlText = driver.findElement(html).getText();
        System.out.println(htmlText);

        if (htmlText.contains("Wirkstoffdosierung")) {
            clickTo(wirkstoffdosierungButton);
            clickTo(inhalt);
        }
        if (htmlText.contains("Inhalt")) {
            clickTo(buttonInhalt);
            clickTo(inhalt);
        }
        clickTo(buttonWarenkorb);
    }

}
