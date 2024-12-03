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
        selectItemInDropdown("span#salutation-button",
                "ul#salutation-menu div","Dr.");
        Assert.assertEquals(driver.findElement(By.cssSelector
                ("span#salutation-button>span.ui-selectmenu-text")).getText(),"Dr.");
        // Speed
        selectItemInDropdown("span#speed-button",
                "ul#speed-menu div","Fast");
        Assert.assertEquals(driver.findElement(By.cssSelector
                ("span#speed-button>span.ui-selectmenu-text")).getText(),"Fast");
    }
    @Test
    public void TC_02_React_Semantic() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropdown("div.dropdown",
                "div.item>span.text","Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector
                ("div.divider.text")).getText(),"Christian");
    }
    private void selectItemInDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
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

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
