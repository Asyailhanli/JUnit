package automationexercises.TestCase11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class VerifySubscriptionInChartPage extends TestBase {

    @Test
    public void verifySubscriptionChartPage() throws AWTException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //5. Scroll down to footer
        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_END);

        //6. Verify text 'SUBSCRIPTION'
        Assert.assertEquals("SUBSCRIPTION",driver.findElement(By.xpath("//h2[text()='Subscription']")).getText());

        //7. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("ase@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //8. Verify success message 'You have been successfully subscribed!' is visible!!!!cok hizli gectigi icin locate edemedim



    }


}
