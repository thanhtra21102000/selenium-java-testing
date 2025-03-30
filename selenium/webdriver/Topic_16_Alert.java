 package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_Alert {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Accept_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        // Cho cho 1 Alert duoc xuat hien trong html + sau do switch vao
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        // Switch vaof 1 alert (k dung wait)
        // Alert alert = dirver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        // Accept Alert
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");
        /*
        // Cancel Alert
        driver.switchTo().alert().dismiss();
        // Get text ra de verify
        driver.switchTo().alert().getText();
        // Nhap text roi accept
        driver.switchTo().alert().sendKeys(""); */
    }
    @Test
    public void TC_02_Confirm_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        // Cho cho 1 Alert duoc xuat hien trong html + sau do switch vao
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");
    }
    @Test
    public void TC_03_Prompt_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        // Cho cho 1 Alert duoc xuat hien trong html + sau do switch vao
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        String name = "Tra";
        alert.sendKeys(name);
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: " + name);
    }
    @Test
    public void TC_04_Authentication_Alert() throws InterruptedException {
        String username = "admin";
        String password = "admin";
        // Cach 1: Truyen thang user/pass vao trong url
        driver.get("http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),
                "Congratulations! You must have the proper credentials.");

    }
    @Test
    public void TC_05_Authentication_Alert() throws InterruptedException {
        String username = "admin";
        String password = "admin";
        // Cach 1: Truyen thang user/pass vao trong url
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        String authenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getDomProperty("href");
        System.out.println(authenLink);
        driver.get(passUserToAuthenLink(authenLink,username,password));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),
                "Congratulations! You must have the proper credentials.");
    }
    public String passUserToAuthenLink(String authenLink,String username,String password){
        String[] text = authenLink.split("//");
        return text[0] + "//" + username + ":" + password + "@" + text[1];
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
