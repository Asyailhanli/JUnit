package automationexercises.TestCase8;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class VerifyAllProductsAnd extends TestBase {

    @Test
    public void verifyAllProduct(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
//        String actualUrl="https://automationexercise.com/";
//        String expectedUrl=driver.getCurrentUrl();
//        Assert.assertEquals(expectedUrl,actualUrl);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();



        //5. Verify user is navigated to ALL PRODUCTS page successfully
          String actualUrl=driver.getCurrentUrl();
          String expectedUrl="https://automationexercise.com/products";
          Assert.assertEquals(expectedUrl,actualUrl);

        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isEnabled());

        //7. Click on 'View Product' of first product
       driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        String actualURLProduct = driver.getCurrentUrl();
        String expectedUrlProduct = "https://automationexercise.com/product_details/1";
        Assert.assertEquals(actualURLProduct, expectedUrlProduct);


        //9. Verify that detail  is visible: product name, category, price, availability, condition, brand
        driver.findElement(By.xpath("//*[@class='product-information']")).isDisplayed();

    }
}
