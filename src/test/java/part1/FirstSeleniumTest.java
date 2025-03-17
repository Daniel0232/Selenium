package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    //Interface which aim is to control the browser and look for elements
    WebDriver driver;

    //Run code before the class FirstSeleniumTest
    @BeforeClass
    public void setUp() {

        //Instance of Chrome driver
        driver = new ChromeDriver();
        //Maximaze the window
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    //To clean up our test acting as a post condition
    @AfterTest
    public void tearDown() {
        //Closes every window and closes the driver
        driver.quit();
        //Only Closes the current window
        //driver.close();
    }
    //Identifica nuestro test
    @Test
    public void testLoggin() throws InterruptedException {
        Thread.sleep(2000);
        //WebElement is an interface that represents the html element
        //By is a class we used to locate elements
        WebElement username = driver.findElement(By.cssSelector("input[placeholder='Username']"));
        //Sends Information to the element
        username.sendKeys("Admin");

        var password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        password.sendKeys("admin123");

        driver.findElement(By.className("oxd-button")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.tagName("h6")).getText(),"Dashboard");

    }
}
