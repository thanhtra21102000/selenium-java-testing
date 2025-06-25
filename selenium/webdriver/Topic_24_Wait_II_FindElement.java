package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_24_Wait_II_FindElement {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test
    public void TC_01_FindElement(){
        // Tìm thấy 1 element
        // Vào sẽ tìm thấy element ngay chứ không cần chờ hết timeout của Implicit
        // driver.findElement(By.cssSelector("input#email"));

        // Tìm thấy 0 element
        // Vào sẽ không thấy element và sẽ tìm đi tìm lại mỗi 0.5s 1 lần cho đến khi hết timeout là 10s = 20 lần
        // Đánh fail testcase tại vị trí này và show ra lỗi NoSuchElementException

        // Trong TH mà element không tìm thấy và vẫn đang tìm lại
        // Nếu element có xuất hiện thì vẫn pass
        // driver.findElement(By.cssSelector("input#emailAdrress"));

        // Tìm thấy nhiều hơn 1 element
        // Nó sẽ luôn thao tác với element đầu tiên
        // Tips: Khi bắt locator thì luôn tìm ra 1 note duy nhất
        // driver.findElement(By.cssSelector("input:not([type='hidden'])")).sendKeys("Selenium");
    }
    @Test
    public void TC_02_FindElements(){
        // Tìm thấy 1 element
        // Trả về 1 element và cũng không cần chờ hết timeout
        // List<WebElement> elementList = driver.findElements(By.cssSelector("input#email"));
        // System.out.println(elementList.size());

        // Tìm thấy 0 element
        // Vào sẽ không thấy element và sẽ tìm đi tìm lại mỗi 0.5s 1 lần cho đến khi hết timeout là 10s = 20 lần
        // Không đánh fail testcase mà trả về 1 list rỗng (empty) = 0
        // List<WebElement> elementList = driver.findElements(By.cssSelector("input#emailAdress"));
        // System.out.println(elementList.size());
        // Không hiển thị và không có trong HTML
        // Assert.assertEquals(elementList.size(), 0);

        // Tìm thấy nhiều hơn 1 element
        // Lấy hết tất cả lưu vào List
        List<WebElement> elementList = driver.findElements(By.cssSelector("input:not([type='hidden'])"));
        // Thao tác với List
        //elementList.get(1).sendKeys("Selenium");

        for(WebElement element:elementList){
            element.sendKeys("Selenium");
        }
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
