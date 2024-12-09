package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_() throws InterruptedException {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        // Tim dropdown
        // Click vao dropdown
        // Xo het item ra
        // Click vao item can chon
        // Salutation
        selectItemInSelectableDropdown("span#salutation-button",
                "ul#salutation-menu div","Dr.");
        Assert.assertEquals(driver.findElement(By.cssSelector
                ("span#salutation-button>span.ui-selectmenu-text")).getText(),"Dr.");
        // Speed
        selectItemInSelectableDropdown("span#speed-button",
                "ul#speed-menu div","Fast");
        Assert.assertEquals(driver.findElement(By.cssSelector
                ("span#speed-button>span.ui-selectmenu-text")).getText(),"Fast");
    }
    @Test
    public void TC_02_React_Semantic() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInSelectableDropdown("div.dropdown",
                "div.item>span.text","Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector
                ("div.divider.text")).getText(),"Christian");
    }
    @Test
    public void TC_03_VueJs() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInSelectableDropdown("li.dropdown-toggle","ul.dropdown-menu a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");
    }
    @Test
    public void TC_04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInSelectableDropdown("div.dropdown","div.item>span.text","Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown")).getText(),"Algeria");
        selectItemInEditableDropdown("input.search","div.item>span.text","Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown")).getText(),"Algeria");
    }
    @Test
    public void TC_05_Huawei() throws InterruptedException {
        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");
        selectItemHuaweiDropdown("div[ht='input_emailregister_dropdown']",
                "input[ht='input_emailregister_search']","ul.hwid-alpla-list span","South Korea");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[ht='input_emailregister_dropdown']")).getText(),"South Korea");
    }
    private void selectItemInEditableDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).clear();
        driver.findElement(By.cssSelector(parentLocator)).sendKeys(textItem);
        Thread.sleep(2000);
        // Cho cho tat ca item duoc load het
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
        // Tim va lay ra het tat ca item ben trong va luu vao 1 bien (kieu du lieu la List)
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        // Duyet qua tung cai element de kiem tra
        for (WebElement item:allItems){
            // Kiem tra dieu kien: neu text cua item lay ra bang voi mong doi
            if (item.getText().equals(textItem)){
                // Click vao chinh item do
                item.click();
                // Thoat khoi vong lap
                break;
            }
        }
    }
    private void selectItemInSelectableDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);
        // Cho cho tat ca item duoc load het
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
        // Tim va lay ra het tat ca item ben trong va luu vao 1 bien (kieu du lieu la List)
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        // Duyet qua tung cai element de kiem tra
        for (WebElement item:allItems){
            // Kiem tra dieu kien: neu text cua item lay ra bang voi mong doi
            if (item.getText().equals(textItem)){
                // Click vao chinh item do
                item.click();
                // Thoat khoi vong lap
                break;
            }
        }
    }
    private void selectItemHuaweiDropdown(String parentLocator,String editableLocator, String childLocator, String textItem) throws InterruptedException {
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentLocator)));
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(editableLocator)).clear();
        driver.findElement(By.cssSelector(editableLocator)).sendKeys(textItem);
        Thread.sleep(2000);
        // Cho cho tat ca item duoc load het
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
        // Tim va lay ra het tat ca item ben trong va luu vao 1 bien (kieu du lieu la List)
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        // Duyet qua tung cai element de kiem tra
        for (WebElement item:allItems){
            // Kiem tra dieu kien: neu text cua item lay ra bang voi mong doi
            if (item.getText().equals(textItem)){
                // Click vao chinh item do
                item.click();
                // Thoat khoi vong lap
                break;
            }
        }
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
