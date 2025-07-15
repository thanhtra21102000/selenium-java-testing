package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_VIII_PageReady {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void BeforeClass(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:/Users/ngtra/AppData/Local/Google/Chrome/User Data/");
        chromeOptions.addArguments("--profile-directory=Profile 11");
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_Element_Invisible(){
        driver.get("https://api.orangehrm.com/");
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#project h1"),"OrangeHRM REST API Documentation"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(),"OrangeHRM REST API Documentation");
    }
    @Test
    public void TC_02_All_Element_Invisible(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Nếu như tất cả các page trong application đều có sự kiện loading thì nên viết thành 1 hàm dùng chung (Reusable Method) để gọi ra dùng cho tất cả các page
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        Assert.assertTrue(isAllLoadingSpinnerInvisible());

        // Chuyển qua trang PIM
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        Assert.assertTrue(isAllLoadingSpinnerInvisible());

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.oxd-topbar-header h6"),"PIM"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.oxd-topbar-header h6")).getText(),"PIM");
        // Chuyển qua trang Time
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Time']")));
        driver.findElement(By.xpath("//span[text()='Time']")).click();

        Assert.assertTrue(isAllLoadingSpinnerInvisible());

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.oxd-topbar-header h6"),"Time"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.oxd-topbar-header h6")).getText(),"Time");
    }
    @Test
    public void TC_03_Page_Ready(){
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email")));
        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Password")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(isPageLoadedSuccess());

        // Chuyển qua trang Product
        driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
        Assert.assertTrue(isPageLoadedSuccess());
        // Chuyển qua trang Customer
        driver.get("https://admin-demo.nopcommerce.com/Admin/Customer/List");
        Assert.assertTrue(isPageLoadedSuccess());
        // Chuyển về trang Dashboard
        driver.get("https://admin-demo.nopcommerce.com/Admin");
        Assert.assertTrue(isPageLoadedSuccess());
    }
    public boolean isAllLoadingSpinnerInvisible(){
        return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
    }
    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
