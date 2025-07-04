package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_24_Wait_VI_Mixing {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_Only_Implicit(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Dùng timeout của implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("input#email"));
    }
    @Test
    public void TC_02_Implicit_And_Explicit(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // 01 - Equal: 10s

        // 02 - Implicit > Explicit: 12s (12 - 10)
        // 02 - Implicit > Explicit: 12s (12 - 5)
        // 02 - Implicit > Explicit: 10s (10 - 5)

        // 03 - Explicit > Implicit: 20s (10 - 12)
        // 03 - Explicit > Implicit: 16s (5 - 12)
        // 03 - Explicit > Implicit: 11s (5 - 10)

        // 03 - Explicit > Implicit: 7s (2 - 5)
        // 03 - Explicit > Implicit: 7s (2 - 5)
        // 03 - Explicit > Implicit: 7s (2 - 5)

        // Implicit sẽ luôn được ưu tiên để chạy trước
        // Explicit sẽ chạy sau tầm nửa giây - 3/5s - gần hoàn thành mới kích hoạt explicit chạy (hên xui)
        // Tránh gây hiểu nhầm: set 2 wait bằng nhau

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Start = " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
        } catch (Exception e) {
            System.out.println("End = " + getDateTimeNow());
            throw new RuntimeException(e);
        }
    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }
    @Test
    public void TC_03_Only_Explicit_By(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Dùng timeout của explicit
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Lấy 10s của explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
    }
    @Test
    public void TC_04_Only_Explicit_WebElement(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Dùng timeout của explicit
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Của explicit nhưng fail 0s
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#advice-required-entry-email"))));
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
