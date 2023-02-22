package automationexercises.TestCase2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class LoginUserWithCorrectEmailAndPassword extends TestBase {

    @Test
    public void loginEmailAndPassword(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
     WebElement homePage=driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Verify 'Login to your account' is visible
       boolean loginAccount=driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed();
        Assert.assertTrue(loginAccount);

//        6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("asye@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678",Keys.ENTER);

//      7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

//      8. Verify that 'Logged in as username' is visible
         WebElement loggedUser=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
         Assert.assertTrue(loggedUser.isDisplayed());

//         9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        10. Verify that 'ACCOUNT DELETED!' is visible//not execute
        assertEquals("ACCOUNT DELETED!",driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());



    }
}
