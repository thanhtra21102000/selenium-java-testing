package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_ID(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtSearch"));
        driver.findElement(By.id("txtFirstname"));
        driver.findElement(By.id("txtEmail"));
        driver.findElement(By.id("txtCEmail"));
        driver.findElement(By.id("txtPassword"));
        driver.findElement(By.id("txtCPassword"));
        driver.findElement(By.id("txtPhone"));
        driver.findElement(By.id("chkRight"));
        driver.findElement(By.id("btndknfooter"));
    }
    @Test
    public void TC_02_Class(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElements(By.className("inputsearch2"));
        driver.findElements(By.className("box-item-login"));
        driver.findElements(By.className("bor"));
        driver.findElements(By.className("field"));
        driver.findElements(By.className("field_link"));
        driver.findElements(By.className("field_btn"));
        driver.findElements(By.className("martop15"));
    }
    @Test
    public void TC_03_Name(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElements(By.name("txtSearch"));
        driver.findElements(By.name("txtFirstname"));
        driver.findElements(By.name("txtEmail"));
        driver.findElements(By.name("txtCEmail"));
        driver.findElements(By.name("txtPassword"));
        driver.findElements(By.name("txtCPassword"));
        driver.findElements(By.name("txtPhone"));
        driver.findElements(By.name("chkRight"));
    }
    @Test
    public void TC_04_Link(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElements(By.linkText("Đăng Ký"));
        driver.findElements(By.linkText("Đăng Nhập"));
        driver.findElements(By.linkText("chính sách"));
        driver.findElements(By.linkText("thỏa thuận sử dụng"));
    }
    @Test
    public void TC_05_PartialLink(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElements(By.partialLinkText("Ký"));
        driver.findElements(By.partialLinkText("Nhập"));
        driver.findElements(By.partialLinkText("chính"));
        driver.findElements(By.partialLinkText("thỏa thuận"));
    }
    @Test
    public void TC_06_TagName(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("a"));
        driver.findElements(By.tagName("button"));
    }
    @Test
    public void TC_07_Css(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElements(By.cssSelector("#txtSearch"));
        driver.findElements(By.cssSelector(".box-item-login"));
        driver.findElements(By.cssSelector("input[name='txtFirstname']"));
    }
    @Test
    public void TC_08_XPath(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElements(By.xpath("//a"));
        driver.findElements(By.xpath("//input[@id='txtSearch']"));
        driver.findElements(By.xpath("//button[@class='bor']"));
        driver.findElements(By.xpath("//a[contains(text(),'sách')]"));
    }
}
