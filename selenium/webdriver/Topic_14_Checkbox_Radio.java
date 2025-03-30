package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        // 1 - Browser mở ra nhưng không maximize -> False
        // 2 - Brower maximize nhưng loading icon chưa biến mất -> false
        // 3 - Browser kích thước nhỏ và loading icon biến mất nhưng kích thước màn hình nhỏ -> False
        // 4 - Nếu mở ra cái element cần tương tác nó đã được chọn rồi/ chưa chọn (mặc định)
    }
    @Test
    public void TC_01_KendoUI() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        Thread.sleep(3000);
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true),",driver.findElement(By
                //.xpath("//div[@id='demo-runner']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//div[@id='demo-runner']")));

        Thread.sleep(2000);
        // Click chọn
        // Nếu như element chưa được chọn thì mới click
        // Nếu chọn rồi thì không click
        if (!driver.findElement(dualZoneCheckbox).isSelected()){
            driver.findElement(dualZoneCheckbox).click();
            Thread.sleep(2000);
        }
        // Verify chọn thành công
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        // Click bỏ chọn
        // Nếu như element đã bỏ chọn rồi thì không cần click lên nữa
        // Nếu như đang được chọn thì cần click tiếp 1 lần nữa => Bỏ chọn
        if (driver.findElement(dualZoneCheckbox).isSelected()){
            driver.findElement(dualZoneCheckbox).click();
            Thread.sleep(2000);
        }
        // Verify bỏ chọn
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
    }
    @Test
    public void TC_02_KendoUI_Radio_Button() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        Thread.sleep(2000);
        By twoPetrol = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true),",driver.findElement(By
              //  .xpath("//div[@id='demo-runner']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//div[@id='demo-runner']")));
        Thread.sleep(2000);
        if (!driver.findElement(twoPetrol).isSelected()){
            //driver.findElement(twoPetrol).click();
            driver.findElement(twoPetrol).click();
            Thread.sleep(2000);
        }
        // Verify chọn thành công
        Assert.assertTrue(driver.findElement(twoPetrol).isSelected());
    }
    @Test
    public void TC_03_Select_ALL() {
        // Select/ Deselect 1 item trong all item
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // Select hết tất cả checkbox
        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        // Verify các điều kiện trên
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }
        // Deselected hết tất cả
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        // Verify các điều kiện trên
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }
        /*
        // Select/ Deselect 1 item trong all item
        for (WebElement checkbox : allCheckboxes){
            if (checkbox.getDomAttribute("value").equals("Fainting Spells") && !checkbox.isSelected()){
                checkbox.click();
            }
        }
        // Verify các điều kiện trên
        for (WebElement checkbox : allCheckboxes){
            if(checkbox.getDomAttribute("value").equals("Fainting Spells")){
            Assert.assertTrue(checkbox.isSelected());
            }
        }
        */
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
