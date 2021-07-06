package pages;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import utilities.Driver;
import utilities.ParentClass;

import java.util.List;

public class BlogPagePOM extends ParentClass {
    private By blogLink = By.linkText("Blog");
    private By images = By.cssSelector("a[itemprop='url']>img");
    private By titlesOfArticles = By.cssSelector("h4>a");
    private By weiterlesens = By.cssSelector("span.qodef-m-text");

    public void navigateToHomePage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }


    public void clickBlogPage() {
        clickTo(blogLink);
    }

    public void checkPageTitle(String pageTitle) {
        System.out.print("Page title is " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), pageTitle);
        System.out.println(" --> OK");
    }

    public void checkViewOfImages() {
        List<WebElement> imageList = getElements(images);
        int counter=0;
        for (WebElement img : imageList) {
            Assert.assertTrue(img.isDisplayed());
            counter++;
        }
        System.out.println(counter + " images are displayed...");
    }


}
