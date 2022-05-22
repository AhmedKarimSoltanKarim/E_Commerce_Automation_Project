package StepDefinitions;

import Pages.HomePagePOM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class WishlistSteps {
    WebDriver webDriver = null;
    HomePagePOM homePagePOM;
    SoftAssert softAssert;

    @Before("@Wishlist")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        homePagePOM = new HomePagePOM(webDriver);
        webDriver.manage().window().maximize();
    }

    @When("User goes to home page to add products to wishlist")
    public void navigationToHome(){
        webDriver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("User clicks on Heart below HTC ONE M8 phone")
    public void clickOnWishlistSymbol() throws InterruptedException {
        homePagePOM.wishlistPhone().click();
        Thread.sleep(3000);
    }

    @Then("A Success message will appear")
    public void validWishlistMessage(){
        String successMessageText = "The product has been added to your wishlist";
        String actualMessageText = homePagePOM.successNotification().getText();
        softAssert = new SoftAssert();
        softAssert.assertTrue(actualMessageText.contains(successMessageText));
        softAssert.assertTrue(homePagePOM.successNotification().getCssValue("background-color").contains("rgba(75, 176, 122, 1)"));
        softAssert.assertAll();
    }

    @And("the selected Product will be available in Wishlist page")
    public void validWishlistView(){
        homePagePOM.link().click();
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("img[alt=\"Picture of HTC One M8 Android L 5.0 Lollipop\"]")).isDisplayed());
        softAssert.assertAll();
    }

    @After("@Wishlist")
    public void exit(){
        webDriver.quit();
    }
}

