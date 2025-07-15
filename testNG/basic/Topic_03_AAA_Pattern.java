package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_AAA_Pattern {
    // Arrange
    // Setup/ Initial Data / Browser/ Driver/ Variable/ DB///
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new FirefoxDriver();
        driver.get("");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    // Action
    @Test
    public void register(){
        // --------------Action-----------
        // Open page
        // Fill data to form
        // Submit
        // ---------------Assert----------
        // Verify success message

    }

}
