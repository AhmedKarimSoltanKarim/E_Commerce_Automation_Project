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

public class SliderWrapperSteps {
    WebDriver webDriver = null;
    HomePagePOM homePagePOM;
    Actions actions;
    SoftAssert softAssert;

    @Before("@Slider")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        homePagePOM = new HomePagePOM(webDriver);
        webDriver.manage().window().maximize();
    }

    @When("user goes to home page")
    public void navigationToHome(){
        webDriver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user hovers to slider wrapper")
    public void hoverOnSlider(){
        actions = new Actions(webDriver);
        actions.moveToElement(homePagePOM.slider());
    }

    @And("user clicks on slider")
    public void clickOnSlider(){
        actions.click().build().perform();
    }

    @Then("user will be redirected to item page")
    public void validSliderClick(){
        String expectUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualUrl = webDriver.getCurrentUrl();
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl, expectUrl);
        softAssert.assertAll();
    }

    @After("@Slider")
    public void exit(){
        webDriver.quit();
    }
}