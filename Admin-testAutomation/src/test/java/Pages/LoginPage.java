package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    WebDriver driver;
    By email = By.xpath("//input[@id='mat-input-0']");
    By password = By.xpath("//input[@id='mat-input-1']");
    By loginBtn = By.xpath("//button[@class='block primary']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmail() {

         driver.findElement(email).sendKeys("store@admin.com");;


    }

    public void addPassword() {

          driver.findElement(password).sendKeys("P@ssw0rd");


    }

    public void login() {

         driver.findElement(loginBtn).click();


    }


}
