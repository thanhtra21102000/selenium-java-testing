package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_15_Custom_Checkbox_Radio {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Ubuntu() throws InterruptedException {
        driver.get("https://login.ubuntu.com/");
        Thread.sleep(3000);
        // Test thử input không hề visible
        /*new WebDriverWait(driver,Duration.ofSeconds(5).
                until(ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("input#id_new_user"))));*/
        // Case 1: Thẻ input không click được nhưng lại dùng để verify được
        //driver.findElement(By.cssSelector("input#id_new_user")).click();
        //Assert.assertTrue(driver.findElement(By.cssSelector("input#id_new_user")).isSelected());
        // Case 2:
        // Không dùng thẻ input để click
        // Dùng thẻ khác để thay thế
        // Thẻ khác này lại không verify được
        // Thẻ label/span/li/ul... trạng thái selected luôn bằng false
        //driver.findElement(By.cssSelector("label.new-user")).click();
        //Assert.assertTrue(driver.findElement(By.cssSelector("label.new-user")).isSelected());
        // Case 3:
        // Dùng thẻ label để click
        // Label để verify
        // 1 element dùng tới 2 locator => có change => maintain code mất nhiều thời gian
        //driver.findElement(By.cssSelector("label.new-user")).click();
        //Assert.assertTrue(driver.findElement(By.cssSelector("input#id_new_user")).isSelected());
        // Case 4
        // Dùng thẻ input để click => Không dùng hàm click của WebElement
        // Dùng hàm click của Js
        // Verify bình thường
        By registerRadio = By.cssSelector("input#id_new_user");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(registerRadio));
        Assert.assertTrue(driver.findElement(registerRadio).isSelected());
        By termCheckbox = By.cssSelector("input#id_accept_tos");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(termCheckbox));
        Assert.assertTrue(driver.findElement(termCheckbox).isSelected());
    }
    @Test
    public void TC_02_Google_Form() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        Thread.sleep(3000);
        By canthoRadio = By.cssSelector("div[aria-label='Cần Thơ']");
        // Click leen checkbox/radio
        driver.findElement(canthoRadio).click();
        Thread.sleep(3000);
        // Verify = cách hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("div[aria-label='Cần Thơ'][aria-checked='true']")).isDisplayed());
        // Verify lấy thuộc tính ra
        Assert.assertEquals(driver.findElement(canthoRadio).getDomAttribute("aria-checked"),"true");
        By myQuangCheckbox = By.cssSelector("div[aria-label='Mì Quảng']");
        // Click leen checkbox/radio
        driver.findElement(myQuangCheckbox).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(myQuangCheckbox).getDomAttribute("aria-checked"),"true");
        // Select all checkboxes
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div[role='checkbox']"));
        for (WebElement checkbox : allCheckboxes){
            if (!checkbox.getDomAttribute("aria-checked").equals("true")){
                checkbox.click();
            }
        }
        // Verify all
        for (WebElement checkbox:allCheckboxes){
            Assert.assertEquals(checkbox.getDomAttribute("aria-checked"),"true");
        }
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
