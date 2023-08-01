package tests;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest {
    WebDriver driver;
    LoginPage signIn;
    HomePage home;


    @BeforeTest
    public void browserSetup() {

        driver = new EdgeDriver();
        WebDriverManager.edgedriver().setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/identity/login");

    }

    @Test(priority = 0)
    public void login() {
        signIn = new LoginPage(driver);
        signIn.addEmail();
        signIn.addPassword();
        signIn.login();

    }

    @Test(priority = 1)
    public void homePage() {
        home = new HomePage(driver);
        home.homePage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Welcome To Dashboard']")));
        Assert.assertEquals(home.setSuccessMsg(), "Welcome To Dashboard");

    }

    @Test(priority = 2)
    public void logout() {
        home.logOut().click();
        Assert.assertEquals(home.verifyToLogout(), "Sign In");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}









