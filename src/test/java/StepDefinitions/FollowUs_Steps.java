package StepDefinitions;

import Pages.HomePagePOM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;

public class FollowUs_Steps {
    WebDriver webDriver = null;
    HomePagePOM homePagePOM;
    SoftAssert softAssert;

    @Before("@FollowUs")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        homePagePOM = new HomePagePOM(webDriver);
        webDriver.manage().window().maximize();
    }
    @When("User goes to homepage to check follow us option")
    public void navigationToHome(){
        webDriver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("User clicks on facebook logo below follow us")
    public void clickOnFacebookLogo() throws InterruptedException {
        homePagePOM.facebookLogo().click();
        Thread.sleep(2500);
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        Thread.sleep(3500);
    }

    @Then("A new tab directing to facebook page will open")
    public void validFacebookRedirection(){
        String expectUrl = "https://www.facebook.com/nopCommerce";
        String actualUrl = webDriver.getCurrentUrl();
        softAssert = new SoftAssert();
        softAssert.assertEquals(expectUrl, actualUrl);
        softAssert.assertAll();
    }

    @After("@FollowUs")
    public void exit(){
        webDriver.quit();
    }
}
