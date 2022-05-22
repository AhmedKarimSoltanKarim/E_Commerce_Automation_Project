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

public class ShoppingCartSteps {
    WebDriver webDriver = null;
    HomePagePOM homePagePOM;
    SoftAssert softAssert;

    @Before("@ShoppingCart")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        homePagePOM = new HomePagePOM(webDriver);
        webDriver.manage().window().maximize();
    }

    @When("User goes to home page to add an item to the cart")
    public void navigationToHome(){
        webDriver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("User clicks on Add To Cart below HTC ONE M8 phone")
    public void clickOnAddToCart() throws InterruptedException {
        homePagePOM.shoppingPhone().click();
        Thread.sleep(3000);
    }
    @Then("A Success message will be pop up for shopping cart")
    public void validShoppingMessage(){
        String successMessageText = "The product has been added to your shopping cart";
        String actualMessageText = homePagePOM.successNotification().getText();
        softAssert = new SoftAssert();
        softAssert.assertTrue(actualMessageText.contains(successMessageText));
        softAssert.assertTrue(homePagePOM.successNotification().getCssValue("background-color").contains("rgba(75, 176, 122, 1)"));
        softAssert.assertAll();
    }

    @And("the selected Item will be displayed in the cart page")
    public void validShoppingView(){
        homePagePOM.link().click();
        softAssert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[1]/span")).getText().contains("M8_HTC_5L"));
        softAssert.assertAll();
    }

    @After("@ShoppingCart")
    public void exit(){
        webDriver.quit();
    }
}
