package StepDefinitions;

import Pages.HomePagePOM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class CategorySelectionSteps {
    WebDriver webDriver = null;
    HomePagePOM homePagePOM;
    Actions actions;
    SoftAssert softAssert;

    @Before("@SelectCategory")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        homePagePOM = new HomePagePOM(webDriver);
        webDriver.manage().window().maximize();
    }

    @When("user goes to landing home page to chose category")
    public void navigationToHome(){
        webDriver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user hovers to Computers category")
    public void hoverToCategory(){
        actions = new Actions(webDriver);
        actions.moveToElement(homePagePOM.category());
    }

    @And("user clicks on Desktops subcategory")
    public void clickOnSubcategory(){
        actions.moveToElement(homePagePOM.subcategory());
        actions.click().build().perform();
    }

    @Then("user will be directed to Desktops page")
    public void validCategory(){
        String expectUrl = "https://demo.nopcommerce.com/desktops";
        String actualUrl = webDriver.getCurrentUrl();
        softAssert = new SoftAssert();
        softAssert.assertEquals(expectUrl, actualUrl);
        softAssert.assertAll();
    }

    @After("@SelectCategory")
    public void exit(){
        webDriver.quit();
    }

}
