package automationexercises.TestCase15;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class PlaceOrderRegisterBeforeCheckout extends TestBase {
    @Test
    public void placeOrderRegisterBeforeCheckout(){
//        1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

//4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//5. Fill all details in Signup and create account
        WebElement name=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("Ase"+ Keys.TAB+"ase21@gmail.com"+Keys.ENTER);

        WebElement accountInformation=driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        driver.findElement(By.xpath("(//div[@class='radio-inline'])[2]")).click();
        driver.findElement(By.id("password")).sendKeys("12345678"+Keys.TAB+"15"+Keys.TAB+"August"+Keys.TAB+"1993");

        WebElement firstName=driver.findElement(By.xpath("//input[@id='first_name']"));
       firstName.sendKeys("Asya"+Keys.TAB+"Davutoglu"+Keys.TAB+"IBM COMPANY"+Keys.TAB+"Zigana Evleri"+
               Keys.TAB+"Beylikduzu/Istanbul"+Keys.TAB+"United States"+Keys.TAB+"New York"+Keys.TAB+"Brooklyn"+
               Keys.TAB+"1234"+Keys.TAB+"5378904567"+Keys.ENTER);

//6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//h2//b[.='Account Created!']")).isDisplayed());
        driver.navigate().back();
        Assert.assertTrue(driver.findElement(By.xpath("//h2//b[.='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

//7. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//ul//li[10]")).isDisplayed());

//8. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();

//9. Click 'Cart' button
        driver.findElement(By.xpath("//p//a[.='View Cart']")).click();
//10. Verify that cart page is displayed
      String title=driver.getTitle();
     Assert.assertTrue(title.contains("view_cart"));

//11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();

//12. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='Your delivery address']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Review Your Order']")).isDisplayed());

//13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Please pay attention to my products");
        driver.findElement(By.xpath("//a[.='Place Order']")).click();

//14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameCard=driver.findElement(By.name("name_on_card"));
        nameCard.sendKeys("ASYA"+Keys.TAB+"123456789"+Keys.TAB+"221"+Keys.TAB+"10"+Keys.TAB+"2027");

//15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[.='Pay and Confirm Order']")).click();

//16. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("//p[@style='font-size: 20px; font-family: garamond;']")).isDisplayed());

//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//h2//b[.='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
    }
}
