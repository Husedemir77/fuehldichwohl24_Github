package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import org.testng.Assert;
import pages.BlogPagePOM;
import utilities.Driver;
import utilities.ParentClass;

public class BlogPageStepdefs {

    BlogPagePOM blogPagePOM = new BlogPagePOM();
    boolean check;

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        blogPagePOM.navigateToHomePage(url);
    }

    @And("Click on the Blog link")
    public void clickOnTheBlogLink() {
        blogPagePOM.navigateToBlogPage();
    }

    @Then("Blog page title should be {string}")
    public void blogPageTitleShouldBe(String expectedPageTitle) {
        Assert.assertEquals(blogPagePOM.getPageTitle(), expectedPageTitle);
    }

    @Then("User should see an image for an article")
    public void userShouldSeeAnImageForAnArticle() {
        Assert.assertTrue(blogPagePOM.isImageExist());
    }

    @When("User clicks image of any article randomly")
    public void userClicksImageOfAnyArticleRandomly() {
        check = blogPagePOM.clickAnImage();
    }

    @When("User clicks the title of any article randomly")
    public void userClicksTheTitleOfAnyArticleRandomly() {
        check = blogPagePOM.clickTitle();
    }

    @When("User clicks any wieterlesen randomly")
    public void userClicksAnyWieterlesenRandomly() {
        check = blogPagePOM.clickWeiterlesen();
    }

    @Then("User should be able to navigate to related page")
    public void userShouldBeAbleToNavigateToRelatedPage() {
        Assert.assertTrue(check);
    }
}
