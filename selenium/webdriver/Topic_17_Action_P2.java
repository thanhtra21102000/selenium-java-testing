package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_17_Action_P2 {
    WebDriver driver;
    Actions action;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }
    @Test
    public void TC_01_ClickAndHold_Fix(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        // Click 1 so dau tien (chua nha chuot trai)
        // Di chuot den so cuoi cung
        // Nha chuot trai ra
        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable>li"));
        // click(): click xong nha chuot ra luon
        // clickAndHold(): click nhung chua nha chuot
        action.clickAndHold(numbers.get(4)) // Click va giu chuot tai element 5
                .moveToElement(numbers.get(11)) // Di chuot den element 12
                .pause(Duration.ofSeconds(2))
                .release() // Nha chuot ra
                .perform(); // Thuc thi cac cau lenh tren
        List<WebElement> numberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(numberSelected.size(),8);
    }
    @Test
    public void TC_02_ClickAndHold_Random(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        // Click 1 so dau tien (chua nha chuot trai)
        // Di chuot den so cuoi cung
        // Nha chuot trai ra
        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable>li"));
        String osName = System.getProperty("os.name");
        Keys keys = null;
        if (osName.contains("Windows")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }
        // Actual number: 3 6 12 14 20
        List<String> actualNumber = new ArrayList<String>();
        actualNumber.add("3");
        actualNumber.add("6");
        actualNumber.add("12");
        actualNumber.add("14");
        actualNumber.add("20");
        action.keyDown(keys).perform(); // Nhan phim control xuong
        /*
        for (String number:actuaNumber){
            action.click(numbers.get(Integer.parseInt(number)-1));
        }
         */
        // 3 6 12 14 20
        action.click(numbers.get(2))
                .pause(Duration.ofSeconds(1))
                .click(numbers.get(5))
                .pause(Duration.ofSeconds(1))
                .click(numbers.get(11))
                .pause(Duration.ofSeconds(1))
                .click(numbers.get(13))
                .pause(Duration.ofSeconds(1))
                .click(numbers.get(19))
                .perform();
        action.keyUp(keys).perform();
        List<WebElement> numberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(numberSelected.size(),5);
        // Expected number: 3 6 12 14 20
        List<String> expectedNumber = new ArrayList<String>();
        for (WebElement number:numberSelected){
            expectedNumber.add(number.getText());
        }
        Assert.assertEquals(actualNumber, expectedNumber);
    }
    @Test
    public void TC_03_DoubleClick() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement button = driver.findElement(By.xpath("//button[text()='Double click me']"));
        if (driver.toString().contains("Firefox")){
            //Scoll toi element bang JS
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",button);
            Thread.sleep(2000);
        }
        action.doubleClick(button).pause(Duration.ofSeconds(2)).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }
    @Test
    public void TC_04_RightClick(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        // Verify Quit menu không hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
        // Click chuột phải
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        // Verify Quit menu hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
        // Hover vào Quit menu
        action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        // Verify Quit menu có sự kiện hover
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());
        // Click vào Quit menu
        action.click(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        // Accept alert
        driver.switchTo().alert().accept();
        // Verify Quit menu không còn hiển thị
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}