package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Xpath_Text {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Text(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Text()=
        driver.findElements(By.xpath("//p[@class='title_login' and text()='Đăng ký bằng Facebook (khuyến khích)']"));
        // Contains(text(),'')
        driver.findElements(By.xpath("//label[contains(text(),'Họ và tên')]"));
        // Contains(.,'')
        driver.findElements(By.xpath("//label[contains(.,'Địa chỉ Email')]"));
        // Contains(string(),'')
        driver.findElements(By.xpath("//label[contains(string(),'Nhập lại Email')]"));
        // Concat()
    }
    @Test
    public void TC_02_And(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // and
        driver.findElements(By.xpath("//input[@class='text form-control' and @type='text' and @id='txtFirstname']"));
        // or
        driver.findElements(By.xpath("//input[@name='txtEmail' or @id='txtEmail']"));
        // not
        driver.findElements(By.xpath("//input[not(@id='txtEmail') and @id='txtPhone']"));
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    } 
}
