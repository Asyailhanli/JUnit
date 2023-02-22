package automationexercises.TestCase7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class VerifyTestCasesPage extends TestBase {

    @Test
    public void testCasePage(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();

        //5. Verify user is navigated to test cases page successfully!!!REKLAM HANDLE EDEMEDIM
       // Assert.assertTrue(driver.findElement(By.xpath("//span[@style='color: red;']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("form")).isDisplayed());



    }
}
