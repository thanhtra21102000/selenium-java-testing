package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_I_Element_Status {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Visible() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(10000);
        // Điều kiện 1: Element có hiển thị trên UI và có trong cây HTML
        // Nếu 1 element thỏa mãn điều kiện số 1: Element đó gọi là Hiển thị (Visible/Disable) => Có trên UI
        // Vì có trên UI thì 100% phải có trong HTML
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        // Chờ cho Element hiển thị (Visible/Displayed)
        explicitWait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='tel']"))));
    }
    @Test
    public void TC_02_Invisible_HTML() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        Thread.sleep(5000);
        // Điều kiện 2: Element không hiển thị trên UI nhưng vẫn có trong HTML
        // Nếu 1 element thỏa mãn điều kiện số 2 hoặc 3 thì element đó gọi là không Hiển thị (Invisible/Undisplayed) => Không có trên UI
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#header-account a[title='My Account']")));
    }
    @Test
    public void TC_03_Invisible_Not_HTML() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(10000);
        // Điều kiện 3: Element không hiển thị trên UI và không có trong HTML
        // Nếu 1 element thỏa mãn điều kiện số 2 hoặc 3 thì element đó gọi là không Hiển thị (Invisible/Undisplayed) => Không có trên UI
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        driver.findElement(By.cssSelector("p.login-with-email")).click();
        // Vì sao nó chạy lâu
        // Phải tìm element trước: findElement => Ko có trong HTML => Tìm lâu và tìm đi tìm lại cho đến khi hết timeout
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#header-account a[title='My Account']")));
    }
    @Test
    public void TC_04_Present(){
        driver.get("https://live.techpanda.org/");
        // Nếu 1 element thỏa mãn điều kiện số 1 hoặc 2 thì element đó gọi là Present => Có trong HTML
        // Điều kiện 1: Element có hiển thị trên UI và có trong cây HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.footer a[title='My Account']")));
        // Điều kiện 2: Element không hiển thị trên UI nhưng vẫn có trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#header-account a[title='My Account']")));
    }
    @Test
    public void TC_05_Staleness() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(10000);
        // Điều kiện 3: Element không hiển thị trên UI và không có trong HTML
        // Điều kiện cần: invisible not in HTML
        // Điều kiện đủ: Element tại thời điểm A nó có trong HTML (Present) và sau đó dùng element kiểm tra tại thời điểm B thì không còn trong HTML
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        // Phone textbox xuất hiện có trong HTML
        WebElement phoneTextbox = driver.findElement(By.cssSelector("input[name='tel']"));
        driver.findElement(By.cssSelector("p.login-with-email")).click();
        // Tới đây Phone textbox không còn trong HTML nữa => Wait staleness là đúng
        explicitWait.until(ExpectedConditions.stalenessOf(phoneTextbox));
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
