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

    @Before // this should be in stepDefinitions package
    public void before(Scenario scenario){
        System.out.println(scenario.getName() + " has been started...");
    }

    @After // this should be in stepDefinitions package
    public void after(Scenario scenario){
        System.out.println(scenario.getName() + " : " + scenario.getStatus());

        if (scenario.isFailed()) new ParentClass().takeScreenshot("mesut");

        Driver.quitDriver();
    }


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

    @Given("User clicks image of any article randomly")
    public void userClicksImageOfAnyArticleRandomly() {
        check = blogPagePOM.clickAnImage();
    }

    @Given("User clicks the title of any article randomly")
    public void userClicksTheTitleOfAnyArticleRandomly() {
        check = blogPagePOM.clickTitle();
    }

    @Given("User clicks any wieterlesen randomly")
    public void userClicksAnyWieterlesenRandomly() {
        check = blogPagePOM.clickWeiterlesen();
    }

    @Then("User should be able to navigate to related page")
    public void userShouldBeAbleToNavigateToRelatedPage() {
        Assert.assertTrue(check);
    }
}
