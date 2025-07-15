package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_MultipleEnviroment {
    WebDriver driver;
    String environmentUrl;
    @Parameters({"browser","environmentName"})
    @BeforeClass
    public void BeforeClass(String browserName, String environmentName){
        System.out.println("Browser name = "+ browserName);
        System.out.println("Environment name = "+ environmentName);
        switch (browserName.toUpperCase()){
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not support");
        }
        switch (environmentName.toUpperCase()){
            case "DEV":
                environmentUrl = "https://dev.fahasa.com";
                break;
            case "TESTING":
                environmentUrl = "https://testing.fahasa.com";
                break;
            case "STAGING":
                environmentUrl = "https://staging.fahasa.com";
                break;
            case "PROD":
                environmentUrl = "https://www.fahasa.com";
                break;
            default:
                throw new RuntimeException("Enviroment name is not support");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(environmentUrl + "/customer/account/create");
    }
    @Test
    public void TC_01_Button() throws InterruptedException {
        By registerButton = By.cssSelector("button.fhs-btn-register");
        By loginButton = By.cssSelector("button.fhs-btn-login");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        // Verify button disabled
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton)
                .getCssValue("background-color")).asHex().toUpperCase(),"#000000");
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("tra@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");
        Thread.sleep(2000);
        // Verify button enabled
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton)
                .getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
