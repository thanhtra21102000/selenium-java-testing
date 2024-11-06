package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Topic_05_WebBrowser_Commands {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        // Tương tác với browser thông qua biến driver
        driver = new FirefoxDriver();
        System.out.println("Driver ID = " + driver.toString());
    }
    @Test
    public void TC_01_Browser(){
        // Mở ra 1 url bất kì
        driver.get("https://www.facebook.com/login");//*
        // Đóng browser - không quan tâm có bao nhiêu tab/window
        driver.quit(); //*
        // Đóng browser - chỉ đóng tab/window hiện tại
        // Nếu chỉ có 1 tab/window thì cũng tương tụ đóng browser
        //driver.close();
        // Tìm 1 element với locator là tham số truyền vào
        driver.findElement(By.cssSelector("")); //*
        // Tìm nhiều element với locator là tham số truyền vào
        driver.findElements(By.cssSelector("")); //*
        // Lấy ra url ở page hiện tại
        driver.getCurrentUrl();
        System.out.println("Page URL = " + driver.getCurrentUrl());
        // Lấy ra title ở page hiện tại
        driver.getTitle();
        System.out.println("Page Title = " + driver.getTitle());
        // Lấy ra window ID ở page hiện tại
        driver.getWindowHandle();
        System.out.println("Window ID = " + driver.getWindowHandle());
        // Lấy ra tất cả các window ID của các tab/window
        driver.getWindowHandles();
        // Lấy ra source code của page hiện tại
        driver.getPageSource();
        System.out.println("Page source code = " + driver.getPageSource());
        WebDriver.TargetLocator switchTo = driver.switchTo();
        switchTo.alert();
        // Alert - Frame/iFrame - Window/Tab
        // ALert
        driver.switchTo().alert(); //*
        // Frame/iFrame
        // Switch vào frame/iframe
        driver.switchTo().frame(""); //*
        // Switch ra trang cha trở lại (chỉ có 1 frame)
        driver.switchTo().defaultContent();
        // Switch từ frame con ra frame cha (nhiều frame lồng nhau)
        driver.switchTo().parentFrame();
        // Window
        driver.switchTo().window(); //*
        driver.switchTo().newWindow(WindowType.TAB).get("");
        driver.switchTo().newWindow(WindowType.WINDOW).get("");
        // Set timeout để tìm element (áp dụng cho 2 hàm findelement/findelements)
        // Trường hợp không tìm thấy sẽ chờ hết chừng đó thời gian rồi mới show lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //*
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(30));
        // Set timeout để chờ page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // Set timeout để chờ đoạn code JS được thực thi thành công
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        // Cookie
        driver.manage().getCookies();
        driver.manage().addCookie();
        // Browser: fullscreen/maximize/minimize
        driver.manage().window().maximize(); //*
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        // Set browser có kích thước bằng bao nhiêu (Responsive)
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().getSize();
        // Set browser tại vị trí nào
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();
        // Selenium log: Browser/Driver/Network
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().get(LogType.PERFORMANCE);
        driver.manage().logs().get(LogType.CLIENT);
        driver.manage().logs().get(LogType.SERVER);

        driver.manage().logs().getAvailableLogTypes();
        // Quay lại trang trước đó
        driver.navigate().back();
        // Chuyển tiếp đến trang trước đó
        driver.navigate().forward();
        // Refresh lại trang hiện tại
        driver.navigate().refresh();
        // Mở 1 URL
        driver.navigate().to("https://www.facebook.com/login");
        driver.navigate().to(new URL("https://www.facebook.com/login"));

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
