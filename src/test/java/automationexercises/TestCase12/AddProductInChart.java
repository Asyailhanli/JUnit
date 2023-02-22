package automationexercises.TestCase12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class AddProductInChart extends TestBase {

    @Test
    public void addProduct() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
//        driver.findElement(By.id("dismiss-button")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Hover over first product and click 'Add to cart'
//        Robot robot = new Robot();
//        robot.mouseWheel(8);
//        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();

        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement firstProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        actions.moveToElement(firstProduct).build().perform();

        driver.findElement(By.linkText("Add to cart")).click();


        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
         waitFor(4);

        //7. Hover over second product and click 'Add to cart'
      //  robot.mouseWheel(8);
        WebElement secondProduct=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));
        actions.moveToElement(secondProduct).build().perform();
         waitFor(3);

         WebElement secondAddChart=driver.findElement(By.xpath("(//*[@data-product-id='2'])[1]"));
         actions.click(secondAddChart).perform();

//        8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();
        waitFor(4);

        //9. Verify both products are added to Cart
        Assert.assertTrue(driver.findElement(By.id("product-1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("product-2")).isDisplayed());

        //10. Verify their prices, quantity and total price
         Assert.assertTrue(driver.findElement(By.xpath("(//p[.='Rs. 500'])[1]")).isDisplayed());
         Assert.assertTrue(driver.findElement(By.xpath("(//button[@class='disabled'])[1]")).isDisplayed());
         Assert.assertTrue(driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]")).isDisplayed());

         Assert.assertTrue(driver.findElement(By.xpath("(//P[.='Rs. 400'])[1]")).isDisplayed());
         Assert.assertTrue(driver.findElement(By.xpath("(//button[@class='disabled'])[2]")).isDisplayed());
         Assert.assertTrue(driver.findElement(By.xpath("(//p[@class='cart_total_price'])[2]")).isDisplayed());


    }
}
