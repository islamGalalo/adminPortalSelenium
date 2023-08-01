package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    By successMsg = By.xpath("//p[normalize-space()='Welcome To Dashboard']");
    By selectSideMenu = By.xpath("//img[@src='assets/images/user.svg']");
    By logoutBtn = By.xpath("//li[normalize-space()='Logout']");
    By verifyLogout = By.xpath("//h3[normalize-space()='Sign In']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String setSuccessMsg() {

        return driver.findElement(successMsg).getText();


    }

    public void homePage() {


        System.out.println("Page title is : " + driver.getTitle());

    }

    public WebElement logOut() {
        driver.findElement(selectSideMenu).click();
        ;
        return driver.findElement(logoutBtn);
    }

    public String verifyToLogout() {

        return driver.findElement(verifyLogout).getText();


    }
}
