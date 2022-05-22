package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePOM {
    WebDriver webDriver;

    public HomePagePOM(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public WebElement registerTab(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }
    public WebElement loginTab(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }
    public WebElement firstItem(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }
    public WebElement slider(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[1]"));
    }
    public WebElement facebookLogo(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a"));
    }
    public WebElement currencySwitcher(){
        return webDriver.findElement(By.id("customerCurrency"));
    }
    public WebElement selectedCurrency(){
        return webDriver.findElement(By.cssSelector("option[selected]"));
    }
    public WebElement category(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
    }
    public WebElement subcategory(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a"));
    }
    public WebElement searchField(){
        return webDriver.findElement(By.id("small-searchterms"));
    }
    public WebElement wishlistPhone(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }
    public WebElement successNotification(){
        return webDriver.findElement(By.cssSelector("[class=\"bar-notification success\"]"));
    }
    public WebElement link(){
        return webDriver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a"));
    }
    public WebElement shoppingPhone(){
        return webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[1]"));
    }
}
