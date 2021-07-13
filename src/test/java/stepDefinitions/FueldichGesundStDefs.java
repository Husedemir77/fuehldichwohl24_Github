package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.FuehldichgesundPage;
import utilities.Driver;
import static pages.FuehldichgesundPage.*;

import java.util.List;
import java.util.Random;

public class FueldichGesundStDefs extends Driver {

    WebDriver driver = new Driver().getDriver();
    FuehldichgesundPage fdgPage = new FuehldichgesundPage();

    By buttonWarenkorb = By.xpath("//i[@class='groovy-69018-handbag']");
    By fuhlDichGesundMenu = By.xpath("(//span[@class='gm-menu-item__txt'])[2]");
    By menuText = By.xpath("//h1[@class='qodef-m-title entry-title']");


    @Given("Navigate to as {string}")
    public void navigateToAs(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        WebElement cokiesButton = driver.findElement(cookies);
        cokiesButton.click();
    }


    @Then("Hover on fühldichgesund menu")
    public void hoverOnFühldichgesundMenu() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fuhlDichGesundMenu)).perform();
        clickTo(fuhlDichGesundMenu);

    }

    @And("check the menu link")
    public void checkTheMenuLink() {

        Assert.assertEquals(getText(menuText), "fühldichgesund");

    }

    @And("Hover fühldichgesundMenus und check")
    public void hoverFühldichgesundMenusUndCheck() throws InterruptedException {

        WebElement fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fuhlDichGesundMenu).perform();

        List<WebElement> menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(0)).click().perform();
        WebElement menu1 = driver.findElement(fdgPage.menu1);
        Assert.assertEquals(menu1.getText(), "Herz-Kreislauf, Blut & Blutgefäße");
        // Wait wait = new WebDriverWait(driver, 10);
        driver.navigate().back();


        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(1)).click().perform();
        menu1 = driver.findElement(fdgPage.menu1);
        Assert.assertEquals(menu1.getText(), "Entzündungen & Infektionen");

        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(2)).click().perform();
        menu1 = driver.findElement(fdgPage.menu1);
        Assert.assertEquals(menu1.getText(), "Gelenke & Knochen");

        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(3)).click().perform();
        menu1 = driver.findElement(fdgPage.menu1);
        Assert.assertEquals(menu1.getText(), "Immunsystem & Allergien");

        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(4)).click().perform();
        menu1 = driver.findElement(fdgPage.menu1);
        Assert.assertEquals(menu1.getText(), "Magen, Darm, Harnwege & Blase");

        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(5)).click().perform();
        menu1 = driver.findElement(fdgPage.menu1);
        Assert.assertEquals(menu1.getText(), "Zellen, Haut & Gewebe");


    }


    @And("go to subMenus und Product check")
    public void goToSubMenusUndProductCheck() {
        WebElement fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fuhlDichGesundMenu).perform();
        List<WebElement> menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(0)).click().perform();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        int productZahl = products.size();
        WebElement zahlSteht = driver.findElement(By.xpath("//p[@class='woocommerce-result-count']"));
        String text = zahlSteht.getText();
        text = text.replaceAll("[A-z]", "");
        text = text.trim();
        int nummer = Integer.parseInt(text);
        Assert.assertEquals(productZahl, nummer);
        takeScreenshot("subMenus");
        driver.navigate().back();


        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(1)).click().perform();

        products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        productZahl = products.size();
        zahlSteht = driver.findElement(By.xpath("//p[@class='woocommerce-result-count']"));
        text = zahlSteht.getText();
        text = text.replaceAll("[A-z]", "");
        text = text.trim();
        nummer = Integer.parseInt(text);
        Assert.assertEquals(productZahl, nummer);
        driver.navigate().back();


        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(2)).click().perform();

        products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        productZahl = products.size();
        zahlSteht = driver.findElement(By.xpath("//p[@class='woocommerce-result-count']"));
        text = zahlSteht.getText();
        text = text.replaceAll("[A-z]", "");
        text = text.trim();
        nummer = Integer.parseInt(text);
        Assert.assertEquals(productZahl, nummer);
        driver.navigate().back();


        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(3)).click().perform();

        products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        productZahl = products.size();
        zahlSteht = driver.findElement(By.xpath("//p[@class='woocommerce-result-count']"));
        text = zahlSteht.getText();
        text = text.replaceAll("[A-z]", "");
        text = text.trim();
        nummer = Integer.parseInt(text);
        Assert.assertEquals(productZahl, nummer);
        driver.navigate().back();


        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(4)).click().perform();

        products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        productZahl = products.size();
        zahlSteht = driver.findElement(By.xpath("//p[@class='woocommerce-result-count']"));
        text = zahlSteht.getText();
        text = text.replaceAll("[A-z]", "");
        text = text.trim();
        nummer = Integer.parseInt(text);
        Assert.assertEquals(productZahl, nummer);
        driver.navigate().back();


        fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        actions.moveToElement(fuhlDichGesundMenu).perform();
        menus = driver.findElements(fdgPage.fühldichgesundMenus);
        actions.moveToElement(menus.get(5)).click().perform();

        products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        productZahl = products.size();
        zahlSteht = driver.findElement(By.xpath("//p[@class='woocommerce-result-count']"));
        text = zahlSteht.getText();
        text = text.replaceAll("[A-z]", "");
        text = text.trim();
        nummer = Integer.parseInt(text);
        Assert.assertEquals(productZahl, nummer);
        driver.navigate().back();

    }

    @Then("Driver close")
    public void driverQuit() {
        quitDriver();
    }

    @And("Random go to submenus und random add a Product in den Warenkorb")
    public void randomGoToSubmenusUndRandomAddAProductInDenWarenkorb() throws InterruptedException {
        WebElement fuhlDichGesundMenu = driver.findElement(By.xpath("(//span[@class='gm-menu-item__txt'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fuhlDichGesundMenu).perform();
        List<WebElement> menus = driver.findElements(fdgPage.fühldichgesundMenus);
        Random random = new Random();
        int randomSubMenus = random.nextInt(6);
        actions.moveToElement(menus.get(randomSubMenus)).click().perform();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        int productZahl = products.size();
        int randomProduct = random.nextInt(productZahl);
        actions.moveToElement(products.get(randomProduct)).click().perform();
        Thread.sleep(2000);

        WebElement html = driver.findElement(By.cssSelector("html"));
        String htmlText = html.getText();
        System.out.println(htmlText);

        if (htmlText.contains("Wirkstoffdosierung")) {
            WebElement buttonInhalt = driver.findElement(By.cssSelector("#select2-pa_wirkstoffdosierung-container"));
            buttonInhalt.click();
            WebElement Inhalt = driver.findElement(By.xpath("(//ul[@class='select2-results__options']/li)[2]"));
            Inhalt.click();
        }

        if (htmlText.contains("Inhalt")) {
            WebElement buttonInhalt = driver.findElement(By.cssSelector("#select2-pa_inhalt-container"));
            buttonInhalt.click();
            WebElement inhalt = driver.findElement(By.xpath("(//ul[@class='select2-results__options']/li)[2]"));
            inhalt.click();
        }

        WebElement buttonWarenkorb = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
        buttonWarenkorb.click();

    }


    @Then("check in den Warenkorb a product")
    public void checkInDenWarenkorbAProduct() {
        WebElement nameProduct = driver.findElement(By.xpath("//div[@class='summary entry-summary']//h1"));
        String name = nameProduct.getText();
        System.out.println(name);

        WebElement buttonWarenkorb = driver.findElement(By.xpath("//i[@class='groovy-69018-handbag']"));
        buttonWarenkorb.click();
        WebElement zurWarenkorb = driver.findElement(By.xpath("//a[contains(text(), 'Warenkorb anzeigen')]"));
        zurWarenkorb.click();
        WebElement productInWarenkorb = driver.findElement(By.xpath("//td[@class='product-name']//a"));
        String textInWarenkorb = productInWarenkorb.getText();
        Assert.assertTrue(textInWarenkorb.contains(name));


    }

    @Then("change the quantity in der Warenkorb")
    public void changeTheQuantityInDerWarenkorb() throws InterruptedException {

        WebElement buttonWarenkorb1 = driver.findElement(By.xpath("//i[@class='groovy-69018-handbag']"));
        buttonWarenkorb1.click();
        clickTo(buttonWarenkorb);
        WebElement zurWarenkorb = driver.findElement(By.xpath("//a[contains(text(), 'Warenkorb anzeigen')]"));
        zurWarenkorb.click();
        WebElement stück = driver.findElement(By.xpath("//div[@class='qodef-quantity-buttons quantity']//input"));
        stück.clear();
        stück.sendKeys("4");
        WebElement buttonUpdate = driver.findElement(By.xpath("//button[@name='update_cart']"));
        buttonUpdate.click();
        Thread.sleep(7000);


    }

    @And("check pries and zwischensumme")
    public void checkPriesAndZwischensumme() {
        WebElement firstPries = driver.findElement(By.xpath("//td[@class='product-price']//span//bdi"));
        String firstPriesText = firstPries.getText();
        System.out.println(firstPriesText);
        double first = nurPrice(firstPriesText);
        System.out.println(first);

        WebElement zwischenSumme = driver.findElement(By.xpath("(//td[@data-title='Zwischensumme']//span//bdi)[2]"));
        String zwischenSummeText = zwischenSumme.getText();
        System.out.println(zwischenSummeText);
        double totalPrice = nurPrice(zwischenSummeText);
        System.out.println(totalPrice);
        Assert.assertEquals(totalPrice, (first * 4));


    }


    @Then("remove the product")
    public void removeTheProduct() {
        WebElement buttonRemove = driver.findElement(By.xpath("//a[@class='remove']"));
        buttonRemove.click();

    }

    @And("check the not")
    public void checkTheNot() {
        WebElement textLeer = driver.findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"));
        String text = textLeer.getText();
        Assert.assertEquals(text, "Dein Warenkorb ist gegenwärtig leer.");
    }

    @And("go to Warenkorb")
    public void goToWarenkorb() {
        WebElement nameProduct = driver.findElement(By.xpath("//div[@class='summary entry-summary']//h1"));
        String name = nameProduct.getText();
        System.out.println(name);

        WebElement buttonWarenkorb = driver.findElement(By.xpath("//i[@class='groovy-69018-handbag']"));
        buttonWarenkorb.click();
        WebElement zurWarenkorb = driver.findElement(By.xpath("//a[contains(text(), 'Warenkorb anzeigen')]"));
        zurWarenkorb.click();
    }
}
