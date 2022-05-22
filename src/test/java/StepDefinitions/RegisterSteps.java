package StepDefinitions;

import Pages.HomePagePOM;
import Pages.RegisterPagePOM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class RegisterSteps {
    WebDriver driver;
    RegisterPagePOM registerPagePOM;
    SoftAssert softAssert;
    HomePagePOM homePagePOM;
    Select day;
    Select month;
    Select year;

    public void fieldsInput(String firstName, String lastName, String email){
        registerPagePOM.firstName().clear();
        registerPagePOM.lastName().clear();
        registerPagePOM.email().clear();
        registerPagePOM.firstName().sendKeys(firstName);
        registerPagePOM.lastName().sendKeys(lastName);
        registerPagePOM.email().sendKeys(email);
    }
    public void passwordInput(String password, String confirmPassword){
        registerPagePOM.password().clear();
        registerPagePOM.confirmPassword().clear();
        registerPagePOM.password().sendKeys(password);
        registerPagePOM.confirmPassword().sendKeys(confirmPassword);
    }

    @Before("@Register")
    public void driver(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        homePagePOM = new HomePagePOM(driver);
        registerPagePOM = new RegisterPagePOM(driver);
        driver.manage().window().maximize();
    }

    @When("user navigates to website")
    public void navigation() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com");
        Thread.sleep(3000);
    }

    @And("Click on Register Tab")
    public void clickOnRegister(){
        homePagePOM.registerTab().click();
    }

    @And("select gender")
    public void genderSelection(){
        registerPagePOM.genderSelectionMale().click();
    }

    @And("^user enters \"(.*)\" as a first name, \"(.*)\" as a last name, \"(.*)\" as an email$")
    public void validReg(String firstName, String lastName, String email)  {
        fieldsInput(firstName, lastName, email);
    }

    @And("Select Day, Month and Year")
    public void dateSelection(){
        day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        day.selectByVisibleText("2");
        month.selectByVisibleText("October");
        year.selectByVisibleText("1985");
    }

    @And("^fill \"(.*)\" as company name$")
    public void companyInput(String company){
        registerPagePOM.company().clear();
        registerPagePOM.company().sendKeys(company);
    }

    @And("^fill \"(.*)\" as a password and \"(.*)\" as a confirm password$")
    public void validPassword(String password, String confirmPassword){
        passwordInput(password, confirmPassword);
    }

    @And("clicks on Register")
    public void submitting() {
        registerPagePOM.submit().click();
    }

    @Then("user could successfully register")
    public void result() {
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.className("result"))
                .getCssValue("color")
                .contains("rgba(76, 177, 124, 1)"));
        softAssert.assertTrue(actualMessage.
                contains(expectedMessage));
        softAssert.assertAll();
    }

    @After("@Register")
    public void exit(){
        driver.quit();
    }
}

