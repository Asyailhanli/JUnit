package automationexercises.TestCase4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class LogoutUser extends TestBase {

    @Test
    public void logoutUser(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed());

        //6. Enter correct email address and password
         driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("asya@gmail.com", Keys.TAB,"12345678");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        //10. Verify that user is navigated to login page!!!!!!





    }
}
