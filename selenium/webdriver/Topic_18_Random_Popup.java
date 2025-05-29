package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Random_Popup {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_DeHieu_In_DOM(){
        driver.get("https://dehieu.vn/");
        By popup = By.cssSelector("div.modal-content");
        if (driver.findElement(popup).isDisplayed()) {
            // Điều kiện: Nếu popup hiển thị Close đi rồi click Đăng nhập
            System.out.println("Điều kiện: Nếu popup hiển thị thì Close đi rồi Click Đăng nhập");
            driver.findElement(By.cssSelector("div.modal-content button.close")).click();
        } else {
            // Nếu popup không hiển thị thì click vào Đăng nhập luôn
            System.out.println("Điều kiện: Nếu popup không thì Click Đăng nhập luôn");
            driver.findElement(By.cssSelector("a.signin-site-menu")).click();
            // Verify form Login hiển thị
            Assert.assertTrue(driver.findElement(By.cssSelector("div.b-login")).isDisplayed());
        }
    }
    @Test
    public void TC_02_KMPlayer_In_DOM() throws InterruptedException {
        driver.get("https://www.kmplayer.com/home");
        Thread.sleep(5000);
        By popup = By.cssSelector("div.pop-container");
        if (driver.findElement(popup).isDisplayed()) {
            // Điều kiện: Nếu popup hiển thị Close đi rồi click Đăng nhập
            System.out.println("Điều kiện: Nếu popup hiển thị thì Close đi rồi qua step tiếp theo");
            driver.findElement(By.cssSelector("div.pop-container div.close")).click();
            Thread.sleep(2000);
        } else {
            // Nếu popup không hiển thị thì hover vào KMPlayer
            System.out.println("Điều kiện: Nếu popup không hiển thị thì hover vào PC và Click KMPlayer");
            new Actions(driver).moveToElement(driver.findElement(By.cssSelector("li.pc.pc64x"))).perform();
            driver.findElement(By.xpath("//li[@class='pc']/a[text()='KMPlayer']")).click();
            // Verify header text hiển thị
            Assert.assertEquals(driver.findElement(By.cssSelector("div.sub>h1")).getText(),"KMPlayer - " +
                    "Video Player for PC");
        }
    }
    @Test
    public void TC_03_JavaCodeGeeks_Not_In_DOM() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");
        Thread.sleep(15000);
        By popup = By.xpath("//div[starts-with(@data-title,'Newsletter') and not (contains(@style,'display:none'))]");
        if (driver.findElements(popup).size() > 0 && driver.findElements(popup).get(0).isDisplayed()) {
            // Điều kiện: Nếu popup hiển thị Close đi rồi click Đăng nhập
            System.out.println("Điều kiện: Nếu popup hiển thị thì Close đi rồi qua step tiếp theo");
            driver.findElement(By.xpath("//div[starts-with(@data-title,'Newsletter')] " +
                    "and not (contains(@style,'display:none'))]//a[text()='x']")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Selenium");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button#search-submit")).click();
        Thread.sleep(2000);
        List<WebElement> articles = driver.findElements(By.cssSelector("ul#posts-container h2.post-title>a"));
        for(WebElement article : articles){
            System.out.println(article.getText());
        }
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
