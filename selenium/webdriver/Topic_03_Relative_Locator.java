package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Relative_Locator {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_NopCommerce_Register() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.xpath("//span[@class='male']"));
        driver.findElement(By.xpath("//input[@id='gender-female']"));
        driver.findElement(By.xpath("//input[@name='FirstName']"));
        driver.findElement(By.xpath("//input[@id='LastName']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        driver.findElement(By.xpath("//input[@id='Email']"));
        driver.findElement(By.xpath("//input[@name='Company']"));
        driver.findElement(By.xpath("//input[@type='checkbox']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        driver.findElement(By.xpath("//button[contains(text(),'Register')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
