package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePOM {
    WebDriver webDriver;

    public LoginPagePOM(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement email(){
        return webDriver.findElement(By.id("Email"));
    }

    public WebElement password(){
        return  webDriver.findElement(By.id("Password"));
    }

    public WebElement submit(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }
}
