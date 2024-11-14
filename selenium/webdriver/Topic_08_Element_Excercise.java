package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Element_Excercise {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Displayed(){
        // Display # Undisplay
        // Người dùng có thể nhìn thấy (kích thước cụ thể)
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if(driver.findElement(By.cssSelector("input#email")).isDisplayed()){
            driver.findElement(By.cssSelector("input#email")).sendKeys("Automation testing");
            System.out.println("Email textbox is displayed");
        } else{
            System.out.println("Email textbox is not displayed");
        }
        if(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation testing");
            System.out.println("Education area is displayed");
        } else{
            System.out.println("Education area is not displayed");
        }
        if(driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();;
            System.out.println("Age under 18 radio is displayed");
        } else{
            System.out.println("Age under 18 radio is not displayed");
        }
        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            driver.findElement(By.xpath("//h5[text()='Name: User5']/following-sibling::a")).click();
            System.out.println("Name user 5 text is displayed");
        } else{
            System.out.println("Name user 5 text is not displayed");
        }
    }
    @Test
    public void TC_02_Enable(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if(driver.findElement(By.cssSelector("input#email")).isEnabled()){
            System.out.println("Email textbox is enabled");
        } else{
            System.out.println("Email textbox is disabled");
        }
        if(driver.findElement(By.cssSelector("textarea#edu")).isEnabled()){
            System.out.println("Education area is enabled");
        } else{
            System.out.println("Education area is disabled");
        }
        if(driver.findElement(By.cssSelector("input#under_18")).isEnabled()){
            System.out.println("Age under 18 radio is enabled");
        } else{
            System.out.println("Age under 18 radio is disabled");
        }
        if(driver.findElement(By.cssSelector("select#job1")).isEnabled()){
            System.out.println("Job role 1 dropdown is enabled");
        } else{
            System.out.println("Job role 1 dropdown is disabled");
        }
        if(driver.findElement(By.cssSelector("select#job2")).isEnabled()){
            System.out.println("Job role 2 dropdown is enabled");
        } else{
            System.out.println("Job role 2 dropdown is disabled");
        }
        if(driver.findElement(By.cssSelector("input#development")).isEnabled()){
            System.out.println("Interests checkbox is enabled");
        } else{
            System.out.println("Interests checkbox is disabled");
        }
        if(driver.findElement(By.cssSelector("input#slider-1")).isEnabled()){
            System.out.println("Slider 1 is enabled");
        } else{
            System.out.println("Slider 1 is disabled");
        }
        if(driver.findElement(By.cssSelector("input#disable_password")).isEnabled()){
            System.out.println("Password is enabled");
        } else{
            System.out.println("Password is disabled");
        }
        if(driver.findElement(By.cssSelector("input#radio-disabled")).isEnabled()){
            System.out.println("Age radio button is enabled");
        } else{
            System.out.println("Age radio button is disabled");
        }
        if(driver.findElement(By.cssSelector("textarea#bio")).isEnabled()){
            System.out.println("Biography textarea is enabled");
        } else{
            System.out.println("Biography textarea is disabled");
        }
        if(driver.findElement(By.cssSelector("select#job3")).isEnabled()){
            System.out.println("Job role 3 dropdown is enabled");
        } else{
            System.out.println("Job role 3 dropdown is disabled");
        }
        if(driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()){
            System.out.println("Interests checkbox is enabled");
        } else{
            System.out.println("Interests checkbox is disabled");
        }
        if(driver.findElement(By.cssSelector("input#slider-2")).isEnabled()){
            System.out.println("Slider 2 is enabled");
        } else{
            System.out.println("Slider 2 is disabled");
        }
    }
    @Test
    public void TC_03_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();
        if(driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Age under 18 radio is Selected");
        } else{
            System.out.println("Age under 18 radio is de-selected");
        }
        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java checkbox is Selected");
        } else{
            System.out.println("Java checkbox is de-selected");
        }
        driver.findElement(By.cssSelector("input#java")).click();
        if(driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Age under 18 radio is Selected");
        } else{
            System.out.println("Age under 18 radio is de-selected");
        }
        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java checkbox is Selected");
        } else{
            System.out.println("Java checkbox is de-selected");
        }
    }
    @Test
    public void TC_04_Mailchimp(){
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("ngtra21@gmail.com");
        // Empty
        /*driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed()); */
        // Lowercase
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("sele");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Uppercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("SELE");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Numbercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Specialcase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("&^%$#@");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Username
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ngtra");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        // Full
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Automation12@");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
