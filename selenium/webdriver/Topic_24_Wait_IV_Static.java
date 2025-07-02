package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_Wait_IV_Static {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test (description = "Thời gian bằng 0")
    public void TC_01(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        sleepInSecond(0);
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }
    @Test (description = "Thời gian ngắn hơn element nó xuất hiện")
    public void TC_02(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        sleepInSecond(3);
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @Test (description = "Thời gian bằng thời gian element nó xuất hiện")
    public void TC_03(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        sleepInSecond(5);
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @Test (description = "Thời gian dài hơn thời gian element nó xuất hiện")
    public void TC_04(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Step 1: Click vào button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon xuất hiện trong 5s
        sleepInSecond(10);
        // Step 2: HelloWorld text hiển thị = cần verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
