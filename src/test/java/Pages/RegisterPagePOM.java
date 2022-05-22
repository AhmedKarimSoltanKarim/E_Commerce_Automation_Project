package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPagePOM {
    WebDriver webDriver;

    public RegisterPagePOM(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement firstName(){
        return webDriver.findElement(By.id("FirstName"));
    }
    public WebElement lastName(){
        return  webDriver.findElement(By.id("LastName"));
    }
    public WebElement email(){
        return webDriver.findElement(By.id("Email"));
    }
    public WebElement password(){
        return  webDriver.findElement(By.id("Password"));
    }
    public WebElement confirmPassword(){
        return webDriver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement company(){ return webDriver.findElement(By.id("Company"));}
    public WebElement genderSelectionMale(){
        return webDriver.findElement(By.id("gender-male"));
    }
    public WebElement genderSelectionFemale(){
        return webDriver.findElement(By.id("gender-female"));
    }
    public WebElement submit(){
        return webDriver.findElement(By.xpath("//*[@id=\"register-button\"]"));
    }
}
