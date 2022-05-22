package StepDefinitions;

import Pages.HomePagePOM;
import Pages.LoginPagePOM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class LoginSteps {
    WebDriver webDriver;
    LoginPagePOM loginPagePOM;
    HomePagePOM homePagePOM;
    SoftAssert softAssert;

    public void loginInput(String email, String password){
        loginPagePOM.email().clear();
        loginPagePOM.password().clear();
        loginPagePOM.email().sendKeys(email);
        loginPagePOM.password().sendKeys(password);
    }


    @Before("@Login")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        loginPagePOM = new LoginPagePOM(webDriver);
        homePagePOM = new HomePagePOM(webDriver);
        webDriver.manage().window().maximize();
    }

    @When("User goes to homepage Link")
    public void navigation() {
        webDriver.navigate().to("https://demo.nopcommerce.com");
    }

    @And("User clicks the login Tab")
    public void clickOnLogin() throws InterruptedException {
        homePagePOM.loginTab().click();
        Thread.sleep(5000);
    }

    @And("^User Types \"(.*)\" as User's email and \"(.*)\" as User's password$")
    public void validReg(String email, String password) {
        loginInput(email, password);
    }

    @And("User clicks Login")
    public void submitting() {
        loginPagePOM.submit().click();
    }

    @Then("User is successfully logged in")
    public void result() {
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = webDriver.getCurrentUrl();
        String expectedMyAccount = "My account";
        String actualMyAccount = homePagePOM.firstItem().getText();
        softAssert = new SoftAssert();
        softAssert.assertEquals(expectedUrl, actualUrl);
        softAssert.assertEquals(expectedMyAccount,actualMyAccount);
        softAssert.assertAll();
    }

    @After("@Login")
    public void exit(){
        webDriver.quit();
    }
}
