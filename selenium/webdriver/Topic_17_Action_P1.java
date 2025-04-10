package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_P1 {
    WebDriver driver;
    Actions action;
    @BeforeClass
    public void BeforeClass(){
        // Selenium se init browser len voi config mac dinh
        // Tham so de nhan dien dang chay browser bang automation test
        driver = new ChromeDriver();
        // No dang chay voi 1 browser co profile da duoc config/ da duoc manual test (end user)
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:/Users/ngtra/AppData/Local/Google/Chrome/User Data/");
        chromeOptions.addArguments("--profile-directory=Profile 11");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }
    @Test
    public void TC_01_JQuery(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).
                pause(Duration.ofSeconds(3)).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),
                "We ask for your age only for statistical purposes.");
    }
    @Test
    public  void TC_02_Myntra(){
        driver.get("http://www.myntra.com/");
        action.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Kids']")))
                .pause(Duration.ofSeconds(2)).perform();
        action.click(driver.findElement(By.xpath("//a[text()='Home & Bath']")))
                .perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb"))
                .getText(),"Kids Home Bath");
    }
    @Test
    public  void TC_03_Fahasa() throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        //Thread.sleep(5000);
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu")))
                .pause(Duration.ofSeconds(2)).perform();
        action.moveToElement(driver.findElement(By.xpath("//span[text()='VPP - Dụng Cụ Học Sinh']")))
                .pause(Duration.ofSeconds(2)).perform();
        action.click(driver.findElement(By.xpath("//div[contains(@class, 'fhs_menu_content')]//a[text()='Gọt Bút Chì']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(),"GỌT BÚT CHÌ");
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
