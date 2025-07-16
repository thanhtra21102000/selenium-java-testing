package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic_13_Parallel_Method {
     private WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
    }
    @Test()
    public void register(){
        System.out.println("Register new account");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "register")
    public void login(){
        System.out.println("Login to system");
    }
    @Test(dependsOnMethods = {"register","login"})
    public void order(){
        System.out.println("Oder product");
    }
    @Test()
    public void pay(){
        System.out.println("Pay product");
    }
    @Test()
    public void ship(){
        System.out.println("ship product");
    }
    @AfterMethod
    public void afterMethod(){
        if (driver==null){
            driver.quit();
        }

    }
}
