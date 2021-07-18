package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebElement;


import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

import utilities.ParentClass;

import java.util.List;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.sleep;


public class FD_HomePagePages extends ParentClass {


    String url = "https://fuehldichwohl24.de/";


    public By mainMenu_deskM = (By.xpath("(//ul[@class='gm-navbar-nav'])[1]/li/a"));
    public By mainMenu_mobM = (By.xpath("(//ul[@class='gm-navbar-nav'])[2]/li/a"));
    public By search1 = By.xpath("//div[@class='gm-search gm-dropdown gm-opened-before']");
    public By searchInputDeskM = By.xpath("(//div[@class='gm-form-group']/input)[1]");
    public By searchInputMobM = By.xpath("(//input[@class='gm-search__input'])[2]");
    public By searchSubmitDeskM = By.xpath("(//button[@class='gm-search-btn'])[1]");
    public By searchSubmitMobM = By.xpath("(//button[@class='gm-search-btn'])[2]");
    public By warenkorbDeskM = By.xpath("(//a[@class='gm-minicart-link'])[2]");
    public By warenkorbMobMout = By.xpath("(//a[@class='gm-minicart-link'])[1]");
    public By warenkorbMobMin = By.xpath("(//a[@class='gm-minicart-link'])[3]");
    public By cookiesAblehnen = By.xpath("//button[@aria-label='Ablehnen']");

    public By stoffDosierung = By.xpath("//span[@id='select2-pa_wirkstoffdosierung-container']");
    public By fDG_mainpageBottom = By.xpath("(//figure[@class='wpb_wrapper vc_figure'])[23]");
    public By fDF_mainpageBottom = By.xpath("(//figure[@class='wpb_wrapper vc_figure'])[24]");
    public By fDE_mainpageBottom = By.xpath("(//figure[@class='wpb_wrapper vc_figure'])[25]");

    public By switcher2 = By.xpath("(//span[@role='button'])[2]");
    public By switcher3 = By.xpath("(//span[@role='button'])[3]");
    public By switcher1 = By.xpath("(//span[@role='button'])[1]");
    public By uberUns = By.xpath("//rs-module[@id='rev_slider_8_4']");
    public By headTextIn = By.className("qodef-m-title entry-title");
    // WebElement headTextINwe=driver.findElement(By.className("qodef-m-title entry-title"));
    public By productTitelIn = By.className("qodef-woo-product-title product_title entry-title");
    public By mainPageLayer = By.id("rs_slidelink_23104");


    public List<WebElement> mainTabList = driver.findElements(By.xpath("(//ul[@class='gm-navbar-nav'])[1]/li/a"));
    public List<WebElement> mehrSehenList = driver.findElements(By.xpath("//div[@class='wpb_wrapper']/a"));
    public List<WebElement> subMenuList = driver.findElements(By.xpath("//nav[@id='gm-main-menu']//img"));
    public List<WebElement> mainPageProdcts = driver.findElements(By.xpath("//div[@class='qodef-grid-inner clear']/div"));


    Actions buiilder = new Actions(driver);

    public void checkTheButtons() {

        List<WebElement> mainTabList = driver.findElements(By.xpath("(//ul[@class='gm-navbar-nav'])[1]/li/a"));


        for (WebElement element : mainTabList) {

            buiilder.moveToElement(element).perform();
            waiting(500);
            //  if (i>0&& i<4) {
            //    wait.until(ExpectedConditions.visibilityOfAllElements(subMenuList));
            // }

        }


        waiting(500);


    }


    public void searchFunction() {
        WebElement searchh = driver.findElement(By.xpath("(//div[@class='gm-search gm-dropdown'])[1]"));
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='qodef-e-inner']"));
        //   waitUntilVisible(searchh);
        // driver.findElement(searchInputDeskM).click();
        driver.findElement(searchInputDeskM).sendKeys("curcumin");
        driver.findElement(searchSubmitDeskM).click();
        waiting(1000);

        String searchedText = driver.getTitle().substring(17, driver.getTitle().length() - 21);
        System.out.println("SearchedText " + searchedText);
        Assert.assertEquals(searchedText, "curcumin");
        waiting(1000);
        driver.navigate().back();

        waiting(1000);


    }


    public void scroolling(String valUes) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(valUes); //scroll(0, 10000);

        waiting(2000);


    }

    public void checkLinkTexts(By linkk, String text) {


        hoverOver(linkk);
        // System.out.println(getText(linkk));
        //  scrollTo(linkk); // anasayfada olan bir elementin linki
        clickTo(linkk);


        // driver.findElement(linkk).click();
        waiting(500);

        String prodctTitel = driver.getTitle();

        System.out.println(prodctTitel);
        Assert.assertTrue(prodctTitel.contains(text));


        waiting(300);


        driver.navigate().back();

        waiting(500);


    }

    public void quitDriver() {
        driver.quit();
    }


    public void navigateToPage() {
        driver.manage().window().maximize();
        driver.get("https://fuehldichwohl24.de");

        //driver.manage().deleteAllCookies();
        clickTo(By.xpath("//button[@aria-label='Ablehnen']"));

    /*   driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.MILLISECONDS);
        try {
            driver.get("https://fuehldichwohl24.de");
        } catch (TimeoutException ignored) {
            // expected, ok
        }*/


    }


    public void checkProductsInfo() {
        waiting(2000);

        WebElement eeaas = driver.findElement(By.xpath("(//div[@class='wpb_wrapper']/h1)[1]"));

        List<WebElement> prdctsss = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/a"));

        buiilder.moveToElement(eeaas);

        waiting(2000);

        int size = prdctsss.size();



        for (int i=15; i<size; i++)
        {
            List<WebElement> listingWebElementListInLoop = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/a"));
            waiting(1000);
            int rand = (int)(Math.random() * 20);
            List<WebElement> mainPageProdctsPrice = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/div/div[1]"));
            List<WebElement> mainPageProdctsHeader = driver.findElements(By.xpath("//*[contains(@class,'qodef-e qodef-grid-item qodef-item--full pro')]//h6"));

            buiilder.moveToElement(listingWebElementListInLoop.get(rand));
            String priceOut = mainPageProdctsPrice.get(rand).getText();
            String header = mainPageProdctsHeader.get(rand).getText();

            waiting(500);
            listingWebElementListInLoop.get(rand).click();

            By titelTextIn = By.xpath("//div[@class='summary entry-summary']/h1");
            By productPricesIn = By.xpath("(//span[@class='woocommerce-Price-amount amount']/bdi)[1]");

            System.out.println(header + " ____" + getText(titelTextIn));
            Assert.assertEquals(header, getText(titelTextIn));

            if (priceOut.equalsIgnoreCase(getText(productPricesIn)))
            {
                System.out.println(" Prices match - " + priceOut + " --- " + getText(productPricesIn));
            }
            else
                System.out.println("Prices do not match - "+ priceOut + " --- " + getText(productPricesIn));



          waiting(500);
            driver.navigate().back();
         waiting(1000);
        }

    }


public void getPageTitle()
{

    System.out.println(" Page title is " + driver.getTitle());
    String pageTT=driver.getTitle();

    if (pageTT.contains("FühlDichWohl24")){
        System.out.println(" you are probably on the homepage ");
    }
    else System.out.println(" You may not be on the homepage. check the url.");

}




        }












