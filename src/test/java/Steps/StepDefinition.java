package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class StepDefinition {
    private WebDriver driver;

    HomePage homePage;
    LoginPage loginPage;

    String url;

    Scenario scenario;
    HashMap<String , String> data;
     public StepDefinition(BrowserManager browserManager){

         this.driver=browserManager.getDriver();
     }

     @Before(order = 1)
     public void before(Scenario scenario){
         this.scenario=scenario;
     }

     //user open facebook login page
    @Given("user open facebook login page")
    public void userOpenFacebookLoginPage() {
        url = QaProps.getValue("url");
        driver.get(url);
    }
    //user enters login credentials
    @When("user enters login credentials")
    public void userEntersLoginCredentials() {
         loginPage = new LoginPage(driver);
        loginPage.getUsername().sendKeys("kristianastewert210@gmail.com");
        loginPage.getPassword().sendKeys("Mehboob@21");
        loginPage.getLoginButton().click();
    }
    //user is successfully logged in
    @Then("user is successfully logged in")
    public void userIsSuccessfullyLoggedIn() throws InterruptedException {
        homePage = new HomePage(driver);

    }

    //scenario 1
    //user should navigate to homepage
    @Given("user should navigate to homepage")
    public void userShouldNavigateToHomepage() {
        //String user = homePage.getPatternMatches()
           //     .getText();
        //Assert.assertEquals(user, "Mehboob Unissa");
    }
//user should click icons in homepage
    @When("user should click icons in homepage")
    public void userShouldClickIconsInHomepage() throws InterruptedException {
         homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getClickFriend()));
        homePage.getClickFriend().click();
        wait.until(ExpectedConditions.visibilityOf(homePage.getDisplayFriend()));
        homePage.getDisplayFriend().isDisplayed();
        //watch
        homePage.getClickWatch().click();
        homePage.getDisplayWatch().isDisplayed();
        //market
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getClickMarketPlace()));
        homePage.getClickMarketPlace().click();
        homePage.getDisplayMarketPlace().isDisplayed();
        //groups
        wait.until (ExpectedConditions.elementToBeClickable(homePage.getClickGroups()));
        homePage.getClickGroups().click();
        homePage.getDisplayGroups().isDisplayed();
    }

   // user should navigate to respective page
    @Then("user should navigate to respective page")
    public void userShouldNavigateToRespectivePage() throws InterruptedException {
        Assert.assertTrue(homePage.getDisplayFriend().isDisplayed());
        Assert.assertTrue(homePage.getDisplayWatch().isDisplayed());
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(homePage.getDisplayMarketPlace()));
        Assert.assertTrue(homePage.getDisplayMarketPlace().isDisplayed());
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(homePage.getDisplayGroups()));
        Assert.assertTrue(homePage.getDisplayGroups().isDisplayed());
    }

    //scenario 2
    //user should be able to click on story and reels
    @Given("user should be able to click on story and reels")
    public void userShouldBeAbleToClickOnStoryAndReels() throws InterruptedException {
        url = QaProps.getValue("url");
        homePage = new HomePage(driver);
        driver.get(url);
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(homePage.getClickStory()));
        homePage.getClickStory().click();
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getClickReels()));
        homePage.getClickReels().click();
    }

    //user is able to see stories and reels
    @When("user is able to see stories and reels")
    public void userIsAbleToSeeStoriesAndReels() {
         homePage.getDisplayStories().isDisplayed();
        homePage.getDisplayReels().isDisplayed();
    }

    //relevant story and reels should be displayed to user
    @Then("relevant story and reels should be displayed to user")
    public void relevantStoryAndReelsShouldBeDisplayedToUser() throws InterruptedException {
         new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getDisplayStories()));
        Assert.assertTrue(homePage.getDisplayStories().isDisplayed());
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getDisplayReels()));
        Assert.assertTrue(homePage.getDisplayReels().isDisplayed());
    }

   // scenario 3
    //user is able to click on live,add photos and react
    @Given("user is able to click on live,add photos and react")
    public void userIsAbleToClickOnLiveAddPhotosAndReact() throws InterruptedException {
        homePage = new HomePage(driver);
        url = QaProps.getValue("url");
        driver.get(url);
        //live
        homePage.getClickLive().click();
        //photo
        driver.get(url);
        homePage.getClickPhoto().click();
        //clickback
        homePage.getClickBack().click();
        //react
        Thread.sleep(5000);
        //react
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(homePage.getClickReact()));
        homePage.getClickReact().click();
        //clickback
        homePage.getClickBack1().click();
    }

    //user is able to access live,add photos and react
    @When("user is able to access live,add photos and react")
    public void userIsAbleToAccessLiveAddPhotosAndReact() throws InterruptedException {
        //live
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(homePage.getLiveClicked()));
        homePage.getLiveClicked().isDisplayed();
        //photo
        homePage.getPhotoClicked().isDisplayed();
        //react
        homePage.getReactClicked().isDisplayed();
    }

    //relevant box is displayed in homepage to user
    @Then("relevant box is displayed in homepage to user")
    public void relevantBoxIsDisplayedInHomepageToUser() throws InterruptedException {
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getLiveClicked()));
        Assert.assertTrue(homePage.getLiveClicked().isDisplayed());
        new WebDriverWait(driver,Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(homePage.getPhotoClicked()));
        Assert.assertTrue(homePage.getPhotoClicked().isDisplayed());
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getReactClicked()));
        Assert.assertTrue(homePage.getReactClicked().isDisplayed());
        Thread.sleep(5000);
        // new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(driver.get(url)));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
     }

    //scenario 4
    //post should be displayed on homepage
    @Given("post should be displayed on homepage")
    public void postShouldBeDisplayedOnHomepage() throws InterruptedException {
        url = QaProps.getValue("url");
        homePage = new HomePage(driver);
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    //user is able to click on Like and Comment button
    @When("user is able to click on Like and Comment button")
    public void userIsAbleToClickOnLikeAndCommentButton() throws InterruptedException {
         new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(homePage.getClickLike()));
        homePage.getClickLike().click();
        homePage.getClickComment().click();
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getTypeComment()));
        homePage.getTypeComment().sendKeys(data.get("Data"));
    }

    //post should be Liked and Comment should be displayed
    @Then("post should be Liked and Comment should be displayed")
    public void postShouldBeLikedAndCommentShouldBeDisplayed() {
        String text =
              homePage.getPostCommented().getText();
        Assert.assertEquals(text,"Nice pic");
    }

    //scenario 5
    //user is able to click on create group
    @Given("user is able to click on create group")
    public void userIsAbleToClickOnCreateGroup() throws InterruptedException {
        homePage = new HomePage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(homePage.getCreateGroup()));
        homePage.getCreateGroup().click();
        new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(homePage.getDisplayGroup()));
        homePage.getDisplayGroup().isDisplayed();
        data = TestDataReader.getData(scenario.getName());
    }

    //user is able to add two or more friends
    @When("user is able to add two or more friends")
    public void userIsAbleToAddTwoOrMoreFriends() throws InterruptedException {
        homePage.getTypeFriends().sendKeys(data.get("Data"));
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(homePage.getAddfriend()));
        homePage.getAddfriend().click();
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getTypeFriends()));
        homePage.getTypeFriends().sendKeys(data.get("Data"));
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(homePage.getAddFreind2()));
        homePage.getAddFreind2().click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getDisplayGroup()));
    }

    //group is created with selected friends
    @Then("group is created with selected friends")
    public void groupIsCreatedWithSelectedFriends() throws InterruptedException {
        Assert.assertTrue(homePage.getDisplayGroup().isDisplayed());
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(homePage.getCreatedGroup()));
        String group = homePage.getCreatedGroup().getText();
        Assert.assertEquals(group, "You created this group");
    }

    //Scenario outline
    // user is on Homepage
    @Given("user is on Homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        url = QaProps.getValue("url");
        driver.get(url);
    }

    //user type the {string text}
    @When("user type the {string}")
    public void userTypeThe(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@aria-label=\"Search Facebook\"]"))));
             homePage.getSendText().sendKeys(text);
     }

     //relevant {string result} should be displayed
    @Then("relevant {string} should be displayed")
    public void relevantShouldBeDisplayed(String result) {
     String status =
             String.valueOf(homePage.getResultDisplayed().isDisplayed());
      Assert.assertEquals(status, result);
    }
}
