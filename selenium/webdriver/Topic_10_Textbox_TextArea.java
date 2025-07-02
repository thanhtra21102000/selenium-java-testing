package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Textbox_TextArea {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Techpanda(){
        driver.get("http://live.techpanda.org/index.php/");
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[title = 'Create an Account']")).click();
        String firstname = "Donald";
        String lastname = "Trump";
        String fullname = firstname + " " + lastname;
        String emailAddress = "donaldtrump" + new Random().nextInt(9999) + "@gmail.com";
        String password = "1234567";
        String thoughReview = "Best Phone\nBest Provider\nBest Product";
        String summaryReview = "Hot Phone";
        String nickname = "US President";
        driver.findElement(By.id("firstname")).sendKeys(firstname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),
                "Thank you for registering with Main Website Store.");
        String ContactInformation = driver.findElement(By.
                 xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(ContactInformation.contains(fullname));
        Assert.assertTrue(ContactInformation.contains(emailAddress));
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys(thoughReview);
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys(summaryReview);
        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(nickname);
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),
                "Your review has been accepted for moderation.");
    }
    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String firstName = "Donald";
        String lastName = "Trump";
        String userName = "donald" + new Random().nextInt(9999);
        String password = "Donald123^%*";
        String passpostNumber = "5555-6666-7777-8888";
        String passpostComment = "Automation FC\nBest Tour";
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click(); // C2: button.orangehrm-login-button
        Thread.sleep(4000);
        // Admin Employee
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);
        String EmployeeID = driver.findElement(By
                .xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
        //driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//label")).click();
        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//label")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(8000);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),EmployeeID);
        Assert.assertTrue(driver.findElement(By.xpath(
                "//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passpostNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passpostComment);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),passpostNumber);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea]")).getAttribute("value"),passpostComment);
        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(4000);
        // Normal Employee
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),EmployeeID);
        Assert.assertFalse(driver.findElement(By.xpath(
                "//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),passpostNumber);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea']")).getAttribute("value"),passpostComment);


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
