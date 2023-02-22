package automationexercises.TestCase6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ContactUsForm extends TestBase {

    @Test
    public void contactForm(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("asya",Keys.TAB,
                Keys.ARROW_RIGHT,"asya@gmail.com",Keys.TAB,"exercises",Keys.TAB,"i hope i take offer job as soon as ");

        //7. Upload file!!!!!
         WebElement uploadFile= driver.findElement(By.xpath("//input[@type='file']"));
         uploadFile.isSelected();

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String actualMessage=driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.",actualMessage);

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@style='color: orange;']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());




    }
}
