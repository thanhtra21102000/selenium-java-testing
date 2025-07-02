package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_V_Explicit_II {
    WebDriver driver;
    WebDriverWait explicitWait;
    By startButton = By.cssSelector("div#start>button");
    By loadingIcon = By.cssSelector("div#loading");
    By helloText = By.cssSelector("div#finish>h4");
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test (description = "Thời gian explicit bằng 0")
    public void TC_01(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(0));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startButton));
        driver.findElement(startButton).click();

        // 1 - Chờ cho step trước hoàn thành (loading icon biến mất) - không quan tâm step sau (Hello text)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        // 2- Chờ cho step sau xuất hiện (Hello text hiển thị/visible) - không quan tâm step trước (loading icon)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");
    }
    @Test (description = "Thời gian explicit ngắn hơn điều kiện xảy ra")
    public void TC_02(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startButton));
        driver.findElement(startButton).click();

        // 1 - Chờ cho step trước hoàn thành (loading icon biến mất) - không quan tâm step sau (Hello text)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        // 2- Chờ cho step sau xuất hiện (Hello text hiển thị/visible) - không quan tâm step trước (loading icon)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");
    }
    @Test (description = "Thời gian explicit bằng thời gian điều kiện xảy ra")
    public void TC_03(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startButton));
        driver.findElement(startButton).click();

        // 1 - Chờ cho step trước hoàn thành (loading icon biến mất) - không quan tâm step sau (Hello text)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        // 2- Chờ cho step sau xuất hiện (Hello text hiển thị/visible) - không quan tâm step trước (loading icon)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");
    }
    @Test (description = "Thời gian explicit dài hơn thời gian điều kiện xảy ra")
    public void TC_04(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startButton));
        driver.findElement(startButton).click();

        // 1 - Chờ cho step trước hoàn thành (loading icon biến mất) - không quan tâm step sau (Hello text)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        // 2- Chờ cho step sau xuất hiện (Hello text hiển thị/visible) - không quan tâm step trước (loading icon)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
