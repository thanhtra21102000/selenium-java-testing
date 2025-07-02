package webdriver;

import org.openqa.selenium.Alert;
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

public class Topic_24_Wait_V_Explicit_I {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_(){
        // Chờ cho 1 alert được xuất hiện trong HTML + sau đó switch vào
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        // Element clickable (Button/ Checkbox/ Radio/ Link/ Image/ ...)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));
        driver.findElement(By.cssSelector("")).click();
        // Element visible (All element)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());
        // Element selected (Checkbox/ Radio)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isSelected());
        // Invisible (All element)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());
        // Presence ( All element in HTML)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
        // Element size
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),15));
        Assert.assertEquals(driver.findElements(By.cssSelector("")).size(),15);
        // Attribute
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"value","John"));
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("value"),"John");
        // Text
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),"Selenium"));
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(),"Selenium");

    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
