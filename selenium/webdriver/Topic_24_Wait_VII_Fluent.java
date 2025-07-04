package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_24_Wait_VII_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentwait;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();

    }
    @Test
    public void TC_01_(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Trong vòng 5s cứ mỗi 1/3s sẽ tìm chữ HelloWorld hiển thị
        fluentwait = new FluentWait<>(driver);
        fluentwait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(333)).ignoring(NoSuchElementException.class);

        String helloText = fluentwait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("div#finish>h4")).getText();
            }
        });
        Assert.assertEquals(helloText,"Hello World!");

        boolean helloStatus = fluentwait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(By.cssSelector("div#finish>h4")).getText().equals("Hello World!");
            }
        });
        Assert.assertTrue(helloStatus);
    }
    @Test
    public void TC_02_(){
        driver.get("https://automationfc.github.io/fluent-wait/");
        // Đếm ngược giây từ 12 về 00 => Thỏa mãn điều kiện
        fluentwait = new FluentWait<>(driver);
        fluentwait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class);
        boolean countDownTextStatus = fluentwait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(By.cssSelector("div#javascript_countdown_time")).getText().equals("01:01:00");
            }
        });
        Assert.assertTrue(countDownTextStatus);
    }
    // Tìm element với Polling Time là 1s kiểm tra 1 lần: WebElement
    public WebElement findElement(By by){
        // Khai báo + Khởi tạo
        FluentWait fluentwait = new FluentWait(driver);
        // Config Time/ Polling/ Exception
        fluentwait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        // Condition
        return (WebElement) fluentwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }
    // Kiểm tra element hiển thị: isDisplayed()
    public boolean isElementDisplay(By by){
        // Khai báo + Khởi tạo
        FluentWait fluentwait = new FluentWait(driver);
        // Config Time/ Polling/ Exception
        fluentwait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return (boolean) fluentwait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
