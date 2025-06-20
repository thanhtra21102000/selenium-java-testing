package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_23_Upload_File {
    WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Single() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFile = By.xpath("//input[@type='file']");
        // Load file lên
        driver.findElement(uploadFile).sendKeys(chandungPath);
        driver.findElement(uploadFile).sendKeys(otoPath);
        driver.findElement(uploadFile).sendKeys(sutuPath);

        // Verify file được load lên
        Assert.assertTrue(driver.findElement(By
                .xpath("//p[@class = 'name' and text() = '" + chandung + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By
                .xpath("//p[@class = 'name' and text() = '" + oto + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By
                .xpath("//p[@class = 'name' and text() = '" + sutu + "']")).isDisplayed());
        // Upload từng file
        List<WebElement> StartButtons = driver.findElements(By.cssSelector("table button.start"));
        for(WebElement start : StartButtons){
            start.click();
            Thread.sleep(3000);
        }

        // Verify file được upload lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ chandung + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ oto + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ sutu + "']")).isDisplayed());
    }
    @Test
    public void TC_01_Multiple() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFile = By.xpath("//input[@type='file']");
        // Load file lên
        driver.findElement(uploadFile).sendKeys(chandungPath + "\n" + otoPath + "\n" + sutuPath);

        // Verify file được load lên
        Assert.assertTrue(driver.findElement(By
                .xpath("//p[@class = 'name' and text() = '" + chandung + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By
                .xpath("//p[@class = 'name' and text() = '" + oto + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By
                .xpath("//p[@class = 'name' and text() = '" + sutu + "']")).isDisplayed());
        // Upload từng file
        List<WebElement> StartButtons = driver.findElements(By.cssSelector("table button.start"));
        for(WebElement start : StartButtons){
            start.click();
            Thread.sleep(3000);
        }

        // Verify file được upload lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ chandung + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ oto + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ sutu + "']")).isDisplayed());
    }
    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}
