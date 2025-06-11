package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_iframe {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Map(){
        // A chứa iframe B
        driver.get("https://www.embedgooglemap.net/");
        // Switch vào iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.gmap_canvas>iframe")));
        // Đang ở B
        String addressName = driver.findElement(By.cssSelector("div.place-name")).getText();
        System.out.println(addressName);
        // B chứa iframe C
        // Switch vào iframe C
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv>div>div>iframe")));
        // Đang ở C
        System.out.println(driver.getPageSource());
        // Từ C quay lại B
        driver.switchTo().parentFrame();
        addressName = driver.findElement(By.cssSelector("div.place-name")).getText();
        System.out.println(addressName);
        // B quay lại A
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input#s")).clear();
        driver.findElement(By.cssSelector("input#s")).sendKeys("22 Le Loi, HCM");
    }
    @Test
    public void TC_02_FormSite() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("button.osano-cm-accept-all")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        new Select(driver.findElement(By.xpath("//label[contains(text(),'Year')]/following-sibling::select"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.xpath("//label[contains(text(),'Residence')]/following-sibling::select"))).selectByVisibleText("South Dorm");
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input#FSsubmit")).click();
        Thread.sleep(5000);
        // Từ trong iframe switch ra bên ngoài chứa nó
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav[class='header header--desktop'] a.menu-item-login")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
