package automationexercises.TestCase13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class VerifyProductQuantityInChart extends TestBase {

    @Test
    public void verifyProductQuantityChart(){

//        1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

//4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();

//5. Verify product detail is opened
          Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed());

//6. Increase quantity to 4
        WebElement quantity=driver.findElement(By.xpath("//input[@value='1']"));
        quantity.sendKeys(Keys.DELETE+"4"+ Keys.ENTER);

//7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

//8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();

//9. Verify that product is displayed in cart page with exact quantity
        Assert.assertTrue(driver.findElement(By.id("product-3")).isDisplayed());
    }
}
