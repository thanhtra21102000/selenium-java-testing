package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_Browser_Element {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Page_Url(){
        driver.get("http://live.techpanda.org/");
        // Click vao My Account tai footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
    }
    @Test
    public void TC_02_Page_Title(){
        driver.get("http://live.techpanda.org/");
        // Click vao My Account tai footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }
    @Test
    public void TC_03_Navigation(){
        driver.get("http://live.techpanda.org/");
        // Click vao My Account tai footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }
    @Test
    public void TC_04_Page_Source(){
        driver.get("http://live.techpanda.org/");
        // Click vao My Account tai footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        // Tuyệt đối = bằng nhau
        Assert.assertEquals(driver.getPageSource(),"");
        // Tương đối = assertTrue/False
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
