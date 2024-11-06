package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_WebElement_Commands {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_Element(){
        WebElement element = driver.findElement(By.cssSelector("input#firstname"));
        // Xóa dữ liệu ở trong 1 editable element (nhập)
        // Textbox/TextArea/Dropdowm
        element.clear(); //**
        // Nhập dữ liệu vào 1 editable element (nhập)
        element.sendKeys(""); //**
        // 1 - Element cha dùng 1 loại locator - element con 1 loại locator
        driver.findElement(By.cssSelector("div.form-fields"))
                .findElement(By.xpath("//input[@id='FirstName']"));
        // 2 - Cả cha với con đều chung 1 loại locator
        driver.findElement(By.cssSelector("div.form-fields input#FirstName"));
        // Tìm 1 element với locator là tham số truyền vào
        driver.findElement(By.cssSelector("")); //**
        // Tìm nhiều element với locator là tham số truyền vào
        driver.findElements(By.cssSelector("")); //**
        // Click lên clickable element
        // Button/ Checkbox / Radio / Link / Image / Dropdown/ Icon
        element.click(); //**
        // Tương đương với submit thông tin gửi lên server
        // Giả lập hành vi Enter của End user
        // Register / Login/ Search..
        element.submit();
        // II - Verify thông tin/dữ liệu đã action
        // Kiểm tra 1 element có hiển thị hay không?
        // Áp dụng cho tất cả các loại element
        element.isDisplayed(); //**
        // Kiểm tra 1 element đã được chọn hay chưa?
        // Áp dụng: Checkbox/Radio/Dropdown
        element.isSelected(); //*
        // Kiểm tra 1 element có cho phép thao tác lên hay không?
        // Cho phép sửa dữ liệu
        // True = được phép chỉnh sửa/ thao tác
        // False = bị disabled
        // Test tính năng phân quyền
        element.isEnabled();
        // III - Lấy dữ liệu
        // Lấy ra text của 1 element
        element.getText(); //**
        element.getAttribute("placeholder");//*
        // Search store
        // Shadow DOM
        element.getShadowRoot(); //*
        // Dev Frontend
        element.getAriaRole();
        element.getDomProperty("");
        element.getDomAttribute("");
        element.getAccessibleName();
        // Front / Background / Fontsize/ ... => CSS
        element.getCssValue("background-color"); //8
        // #df280a
        element.getCssValue("font-size");
        // 13px
        element.getCssValue("font-family");
        // 13px
        Rectangle elementRect = element.getRect();
        elementRect.getDimension();
        // Lấy ra chiều rộng/ chiều cao của element
        element.getSize();
        elementRect.getPoint();
        // Lấy ra vị trí của element (góc trên bên trái) so với lại browser
        element.getLocation();
        // Lấy ra tên thẻ HTML của element
        // By.id/class/name/css
        element.getTagName();
        driver.findElement(By.id("email")).getTagName();
        // input
        // Take Screenshot (chụp hình lỗi)
        element.getScreenshotAs(OutputType.FILE);
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
