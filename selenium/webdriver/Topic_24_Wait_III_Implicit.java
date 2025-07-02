package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_III_Implicit {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test (description = "Thời gian implicit bằng 0")
    public void TC_01(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }
    @Test (description = "Thời gian implicit ngắn hơn thời gian element nó xuất hiện")
    public void TC_02(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @Test (description = "Thời gian implicit bằng thời gian element nó xuất hiện")
    public void TC_03(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @Test (description = "Thời gian implicit dài hơn thời gian element nó xuất hiện")
    public void TC_04(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
