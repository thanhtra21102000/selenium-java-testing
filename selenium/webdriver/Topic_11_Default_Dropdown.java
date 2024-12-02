package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void BeforeClass(){
        /*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:/Users/ngtra/AppData/Local/Google/Chrome/User Data/");
        chromeOptions.addArguments("--profile-directory=Profile 11");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();*/
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-geolocation");
        driver = new ChromeDriver(option);
    }
    @Test
    public void TC_01_() throws InterruptedException {
        driver.get("https://egov.danang.gov.vn/reg");
        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_tinhthanh")));
        /*// Chạy bị fail khó tìm lỗi
        // Update lại giá trị trong dropdown -> Index thay đổi
        select.selectByIndex(4);
        Thread.sleep(4000);
        // Chạy bị fail khó tìm lỗi
        // Update lại giá trị trong dropdown -> Khó nhớ là tỉnh thành nào
        // Thuộc tính value nó không phải là bắt buộc
        select.selectByValue("9806");
        Thread.sleep(4000);*/
        // Chạy fail nhìn text biết ngay để manual test lại
        // Nếu dev/client họ thay đổi giá trị của text item thì detect ra ngay
        select.selectByVisibleText("tỉnh Bình Thuận"); //****
        Thread.sleep(4000);
        // Lấy ra được item vừa chọn và verify
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"tỉnh Bình Thuận");//****
        // Kiểm tra 1 dropdown là single hay multiple
        Assert.assertFalse(select.isMultiple());
        /*// Lấy ra tất cả các item bên trong dropdown Quận/huyện
        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_quanhuyen")));
        List<WebElement> districElements = select.getOptions();
        List<String> districText = new ArrayList<String>();
        for(WebElement distric: districElements){
            districText.add(distric.getText());
        }
        Assert.assertTrue(districText.contains("thành phố Phan Thiết"));
        Assert.assertTrue(districText.contains("thị xã La Gi"));
        Assert.assertTrue(districText.contains("huyện Tuy Phong"));
        Assert.assertTrue(districText.contains("huyện Bắc Bình"));
        Assert.assertTrue(districText.contains("huyện Hàm Thuận Bắc"));*/
    }
    @Test
    public void TC_02(){
        driver.get("https://demo.nopcommerce.com/register");
        String firstName = "John";
        String lastName = "Wick";
        String emailAddress = "John" + new Random().nextInt(9999) + "@gmail.com";
        String companyName = "Walt Disney";
        String password = "123456789";
        String day = "8";
        String month = "May";
        String year = "1980";
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText(day);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText(month);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText(year);
        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"),emailAddress);
        Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"),companyName);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")))
                .getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")))
                .getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")))
                .getFirstSelectedOption().getText(),year);
    }
    @Test
    public void TC_03() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");

        select = new Select(driver.findElement(By.cssSelector("select#country")));
        Assert.assertFalse(select.isMultiple());//Kiểm tra dropdown không hỗ trợ multiple

        select.selectByVisibleText("Vietnam"); // Chọn Vietnam trong dropdown
        Thread.sleep(4000);

        driver.findElement(By.id("map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(3000);
        List<WebElement> dealerBranches = driver.findElements(By.cssSelector("div.dealer_branch h4"));
        Assert.assertEquals(dealerBranches.size(),16);
        for (WebElement dealerName:dealerBranches){
            System.out.println(dealerName.getSize());
        }
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
