package StepDefinitions;

import Pages.HomePagePOM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SwitchCurrencySteps {
    WebDriver webDriver = null;
    HomePagePOM homePagePOM;
    SoftAssert softAssert;
    Select select;

    @Before("@SwitchCurrency")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        homePagePOM = new HomePagePOM(webDriver);
        webDriver.manage().window().maximize();
    }

    @When("user navigates to home page to switch currency")
    public void navigationToHome(){
        webDriver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("select Euro instead of default US Dollar")
    public void switchToEuro() {
        select = new Select(homePagePOM.currencySwitcher());
        select.selectByVisibleText("Euro");
    }

    @Then("Euro should be selected")
    public void validFacebookRedirection(){
        String expectSelection = "Euro";
        String actualSelection = homePagePOM.selectedCurrency().getText();
        softAssert = new SoftAssert();
        softAssert.assertEquals(expectSelection, actualSelection);
        softAssert.assertAll();
    }

    @After("@SwitchCurrency")
    public void exit(){
        webDriver.quit();
    }


}
