package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class Covid19StepDefs extends Driver {

    @Then("Hover on Covid{int} menu")
    public void hoverOnCovidMenu(int arg0) {
        WebElement buttonCovid = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[5]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonCovid).perform();
        buttonCovid.click();

    }

    @And("check the Covid menu link")
    public void checkTheCovidMenuLink() {
        WebElement textCovid = driver.findElement(By.xpath("//h1[@class='qodef-m-title entry-title']"));
        String text = textCovid.getText();
        Assert.assertEquals(text, "Covid-19");

    }

    @And("Covid{int} menu random add a Product in den Warenkorb")
    public void covidMenuRandomAddAProductInDenWarenkorb(int arg0) throws InterruptedException {
        Random random = new Random();
        Actions actions = new Actions(driver);

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        int productZahl = products.size();
        int randomProduct = random.nextInt(productZahl);
        actions.moveToElement(products.get(randomProduct)).click().perform();
        Thread.sleep(2000);

        WebElement html = driver.findElement(By.cssSelector("html"));
        String htmlText = html.getText();
        System.out.println(htmlText);
        if ( htmlText.contains("Wirkstoffdosierung")){
            WebElement buttonInhalt = driver.findElement(By.cssSelector("#select2-pa_wirkstoffdosierung-container"));
            buttonInhalt.click();
            WebElement Inhalt = driver.findElement(By.xpath("(//ul[@class='select2-results__options']/li)[2]"));
            Inhalt.click();
        }

        if ( htmlText.contains("Inhalt")) {
            WebElement buttonInhalt = driver.findElement(By.cssSelector("#select2-pa_inhalt-container"));
            buttonInhalt.click();
            WebElement inhalt = driver.findElement(By.xpath("(//ul[@class='select2-results__options']/li)[2]"));
            inhalt.click();
        }

        WebElement buttonWarenkorb = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
        buttonWarenkorb.click();



    }
}
