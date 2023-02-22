package automationexercises.TestCase10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class VerifySubscriptionInHomePage extends TestBase {

    @Test
    public void verifySubscription() throws InterruptedException, AWTException {
         //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

//        //4. Scroll down to footer
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_END);
        Actions actions= new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                build().perform();

        //5. Verify text 'SUBSCRIPTION'
        Assert.assertEquals("SUBSCRIPTION",driver.findElement(By.xpath("//h2[text()='Subscription']")).getText());

        //6. Enter email address in input and click arrow button
        WebElement emailClick=driver.findElement(By.xpath("//input[@id='susbscribe_email']"));
        emailClick.sendKeys("asya@gmail.com");
        waitFor(4);
        driver.findElement(By.xpath("//*[@class='fa fa-arrow-circle-o-right']")).click();
      waitFor(4);

        //7. Verify success message 'You have been successfully subscribed!' is visible!!!yazi cok hizli kapaniyor


    }

}
