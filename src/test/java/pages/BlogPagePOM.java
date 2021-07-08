package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ParentClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Page Object encapsulates the Blog page.
 */
public class BlogPagePOM extends ParentClass {

    private By acceptButton = By.cssSelector("button[data-cf-action='accept']");
    private By blogLink = By.xpath("(//a[@href='https://fuehldichwohl24.de/blog/'])[1]");
    private By blogPageTitle = By.cssSelector("div>h5");
    private By images = By.cssSelector("a[itemprop='url']>img");
    private By titlesOfArticles = By.cssSelector("h4>a");
    private By titleOfArticle2 = By.xpath("//div[@class='qodef-e-text']/h2");
    private By weiterlesens = By.cssSelector("div.qodef-e-read-more>a");

    private List<WebElement> imageElementList;
    private List<WebElement> titleElementList;
    private List<WebElement> weiterlesenElementList;
    private List<String> titleTextList = new ArrayList<>();

    /**
     * This method should be in ParentClass !!!
     * @param num is max number
     * @return a random number between 0 and num
     */
    public int randomNumber(int num){
        return (int)(Math.random()*num);
    }

    /**
     *This method should be in HomePagePOM !!!
     *
     * @param url address
     */
    public void navigateToHomePage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().deleteAllCookies();
        clickTo(acceptButton);
    }

    /**
     * Check if Blog page link is available
     * @return true-false
     */
    public boolean isBlogPageLinkExist(){
        return getElement(blogLink).isDisplayed();
    }

    /**
     *
     */
    public void navigateToBlogPage() {
        if (isBlogPageLinkExist()) clickTo(blogLink);

        imageElementList = getElements(images);
        titleElementList = getElements(titlesOfArticles);
        weiterlesenElementList = getElements(weiterlesens);

        for (WebElement el: titleElementList) {
            titleTextList.add(el.getText());
            //System.out.println(el.getText());
        }
    }

    /**
     *
     * @param expectedPageTitle
     * @return
     */
    public boolean checkPageTitle(String expectedPageTitle) {
        String actualPageTitle = getText(blogPageTitle);
        return actualPageTitle.equals(expectedPageTitle);
    }

    /**
     * Check if all images on the Page are exist.
     * @return false or true
     */
    public boolean isImageExist() {
        List<WebElement> imageList = getElements(images);
        int counter=0;
        for (WebElement img : imageList) {
            if(!img.isDisplayed()) return false;
            counter++;
        }
        System.out.println(counter + " images are displayed...");
        return true;
    }

    /**
     *
     * @return
     */
    public boolean clickAnImage(){

        //int n = randomNumber(imageList.size());
        for (int i = 0; i <imageElementList.size() ; i++) {
            String expectedText = titleTextList.get(i).toLowerCase();
            clickTo(By.xpath("(//a[@itemprop='url']/img)[" + (i+1) + "]"));
            if(!checkPage(expectedText)) return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public boolean clickTitle(){

        for (int i = 0; i <titleElementList.size() ; i++) {
            String expectedText = titleTextList.get(i).toLowerCase();
            try {
                clickTo(By.xpath("(//h4/a)[" + (i+1) + "]"));  // ElementClickInterceptedException icin javaScript kullanilabilir...
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement((By.xpath("(//div[@class='qodef-e-read-more']/a)[" + (i+1) + "]"))));
            }
            if(!checkPage(expectedText)) return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public boolean clickWeiterlesen(){

        //clickTo(weiterlesens);
        //clickTo(By.xpath("(//div[@class='qodef-e-read-more']/a)[1]")); // ElementClickInterceptedException hatasi veriyor

        for (int i = 0; i <weiterlesenElementList.size() ; i++) {
            String expectedText = titleTextList.get(i).toLowerCase();

            try {
                clickTo(By.xpath("(//div[@class='qodef-e-read-more']/a)[" + (i+1) + "]"));  // ElementClickInterceptedException icin javaScript kullanilabilir...
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement((By.xpath("(//div[@class='qodef-e-read-more']/a)[" + (i+1) + "]"))));
            }
            if(!checkPage(expectedText)) return false;
        }
        return true;
    }

    /**
     *
     * @param expectedText
     * @return
     */
    public boolean checkPage(String expectedText){
        String actualText = driver.findElement(titleOfArticle2).getText().toLowerCase();
        System.out.println(expectedText + " : " + actualText);
        // Assert.assertEquals(expectedText, actualText);
        driver.navigate().back();
        return actualText.equals(expectedText);
    }

}
