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

public class Topic_24_Wait_V_Explicit_III {
    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFilePath = System.getProperty("user.dir") + "\\uploadFiles\\";
    String chandung = "chandung.jpg";
    String oto = "oto.jpg";
    String sutu = "sutu.jpg";

    String chandungPath = uploadFilePath + chandung;
    String otoPath = uploadFilePath + oto;
    String sutuPath = uploadFilePath + sutu;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait cho calendar hiển thị
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1")));

        // Wait cho text được hiển thị
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display."));
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(),"No Selected Dates to display.");

        // Wait để click vào ngày/tháng/năm hiện tại
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='2']")));
        // Click vào 1 ngày/tháng/năm hiện tại
        driver.findElement(By.xpath("//td/a[text()='2']")).click();
        // Wait loading icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar']>div.raDiv")));
        // Wait cho text được cập nhật lại ngày
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Wednesday, July 2, 2025"));
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(),"Wednesday, July 2, 2025");
        // Wait ngày được chọn có attribute có class = rcSelected rồi
        explicitWait.until(ExpectedConditions.attributeContains(By.xpath("//a[text()='2']/parent::td"),"class","rcSelected"));
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='2']/parent::td")).getDomAttribute("class").contains("rcSelected"));
    }
    @Test
    public void TC_02(){
        driver.get("https://gofile.io/?t=uploadFiles");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Wait cho all loading icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#index_loader"))));
        // Load file lên
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(chandungPath + "\n" + otoPath + "\n" + sutuPath);
        // Wait cho tất cả các Progress bar biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#fileList div.progress-container"))));
        // Wait text hiển thị
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.text-center>h2"),"Upload Complete"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text-center>h2")).getText(),"Upload Complete");

        driver.get(driver.findElement(By.cssSelector("a.linkSuccessCard")).getDomAttribute("href"));

        // Wait cho all loading icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#index_loader"))));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='truncate']/a[text()='" + chandung + "']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='truncate']/a[text()='" + chandung + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='truncate']/a[text()='" + oto + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='truncate']/a[text()='" + sutu + "']")).isDisplayed());
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
