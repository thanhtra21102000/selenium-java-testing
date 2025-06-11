package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_21_Window_Tab {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addPreference("geo.enabled",false);
        firefoxOptions.addPreference("geo.provider.use_corelocation",false);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Github() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        // Lấy ra Window ID của 1 cửa sổ đang active (driver đang đứng đó)
        String githubID = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(3000);
        // Lấy ra Window ID của 2 cửa sổ/tab
        switchToWindowByTitle("Google");
        // Đã qua trang google
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium WebDriver");
        // Lấy ra Window ID của Google
        String googleID = driver.getWindowHandle();
        switchToWindowByTitle("Selenium WebDriver");
        // Đã quay lại trang github
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(3000);
        switchToWindowByTitle("Facebook – log in or sign up");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("input#email")).sendKeys("dam@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("dam@gmail.com");
        closeAllExceptMain(githubID);
    }
    @Test
    public void TC_02_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath(
                "//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        driver.findElement(By.xpath(
                "//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        switchToWindowByContainTitle("Products Comparison List");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(),"COMPARE PRODUCTS");
        driver.findElement(By.cssSelector("button[title='Close Window']")).click();
        Thread.sleep(3000);
        switchToWindowByContainTitle("Mobile");
        driver.findElement(By.cssSelector("input#search")).sendKeys("Samsung Galaxy");
        driver.findElement(By.cssSelector("button.search-button")).click();
    }
    @Test
    public void TC_03_Naukri(){ // Bị chặn auto
        driver.get("https://www.naukri.com/");
        driver.findElement(By.cssSelector("div.keywordSugg input.suggestor-input")).sendKeys("Automation Testing");
        driver.findElement(By.cssSelector("div.qsbSubmit")).click();
        driver.findElement(By.xpath("//a[text()='HCLTech']/ancestor::div[contains(@class,'row2')]/preceding-sibling::div/a[text()='Senior Automation Test Engineer']")).click();
        switchToWindowByContainTitle("Senior Automation Test Engineer");
        driver.findElement(By.xpath("//h3[text()='Sap Automation Tester with worksoft certify']")).click();
        switchToWindowByContainTitle("Sap Automation Tester with worksoft certify");
    }
    // Dùng cho duy nhất 2 window
    private void switchToWindowID(String windowID) {
        // Lấy ra Window ID của 2 cửa sổ/ tab
        Set<String> allWindows = driver.getWindowHandles();
        // Duyệt qua từng ID
        for (String window : allWindows){
            // Nếu ID nào khác với ID truyền vào thì switch qua
            if (!window.equals(windowID)){
                driver.switchTo().window(window);
                break;
            }
        }
    }
    // Dùng cho 2 window trở lên
    private void switchToWindowByTitle(String expectedTitle) {
        // Lấy ra Window ID của 2 cửa sổ/ tab
        Set<String> allWindows = driver.getWindowHandles();
        // Duyệt qua từng ID
        for (String window : allWindows){
            // Switch trước vào từng window
            driver.switchTo().window(window);
            // Lấy ra page title đang active
            String pageTitle = driver.getTitle();
            // Kiểm tra nếu page title hiện tại bằng với title mong đợi
            if (pageTitle.equals(expectedTitle)){
                break;
            }
        }
    }
    // Close tất cả các window/tab ngoại trừ trang gốc
    private void closeAllExceptMain(String windowID) {
        // Lấy ra Window ID của 2 cửa sổ/ tab
        Set<String> allWindows = driver.getWindowHandles();
        // Duyệt qua từng ID
        for (String window : allWindows){
            // Nếu ID nào khác với ID truyền vào
            if (!window.equals(windowID)){
                // Thì switch qua
                driver.switchTo().window(window);
                // Close tab đó đi
                driver.close();
            }
        }
        driver.switchTo().window(windowID);
    }
    private void switchToWindowByContainTitle(String expectedTitle) {
        // Lấy ra Window ID của 2 cửa sổ/ tab
        Set<String> allWindows = driver.getWindowHandles();
        // Duyệt qua từng ID
        for (String window : allWindows){
            // Switch trước vào từng window
            driver.switchTo().window(window);
            // Lấy ra page title đang active
            String pageTitle = driver.getTitle();
            // Kiểm tra nếu page title hiện tại bằng với title mong đợi
            if (pageTitle.contains(expectedTitle)){
                break;
            }
        }
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
