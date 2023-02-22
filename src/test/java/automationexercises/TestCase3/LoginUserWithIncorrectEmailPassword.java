package automationexercises.TestCase3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class LoginUserWithIncorrectEmailPassword extends TestBase {

    @Test
    public void loginUserIncorrectEmailPassword(){

        //  1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("mehmet@gmail.com", Keys.TAB,"123456",Keys.ENTER);

        //7. Click 'login' button

        //8. Verify error 'Your email or password is incorrect!' is visible
         Assert.assertEquals("Your email or password is incorrect!",driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText());


    }
}
