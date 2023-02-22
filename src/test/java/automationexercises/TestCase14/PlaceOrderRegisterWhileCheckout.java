package automationexercises.TestCase14;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class PlaceOrderRegisterWhileCheckout extends TestBase {

    @Test
    public void placeOrderRegister(){

// 1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

//4. Add products to cart
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        driver.findElement(By.xpath("//a[@data-product-id='1'][1]")).click();
        waitFor(3);
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        waitFor(3);
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();


//5. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

//6. Verify that cart page is displayed
       Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='container'])[2]")).isDisplayed());

//7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();

//8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[.='Register / Login']")).click();

//9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        driver.findElement(By.name("name")).sendKeys("Asya"+Keys.TAB+"asya21@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        WebElement accountInfromation=driver.findElement(By.xpath("//b[.='Enter Account Information']"));
          driver.findElement(By.xpath("(//div[@class='radio-inline'])[2]")).click();
          driver.findElement(By.id("password")).sendKeys("12345678");

        WebElement days=driver.findElement(By.id("days"));
        Select select= new Select(days);
        select.selectByVisibleText("8");
        waitFor(2);

        WebElement months=driver.findElement(By.xpath("//select[@name='months']"));
        Select select1=new Select(months);
        select1.selectByValue("8");
        waitFor(2);

        WebElement years=driver.findElement(By.xpath("//select[@name='years']"));
        Select select2=new Select(years);
        select2.selectByValue("1993");
        waitFor(2);

        WebElement addressInformation=driver.findElement(By.xpath("//input[@data-qa='first_name']"));
        addressInformation.sendKeys("Asya"+Keys.TAB+"davutoglu"+Keys.TAB+
                "ilhanli"+Keys.TAB+"buyuksehir mah."+Keys.TAB+"Zigana evleri"+Keys.TAB+"Canada"+Keys.TAB+"America"+Keys.TAB+
                "Miami"+Keys.TAB+"12345"+Keys.TAB+"5322801785");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertEquals("ACCOUNT CREATED!",driver.findElement(By.xpath("ACCOUNT CREATED!")).getText());
         driver.findElement(By.xpath("//a[.='Continue']")).click();

//11. Verify ' Logged in as username' at top
        WebElement loggedInUsername=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loggedInUsername.sendKeys("asya21@gmail.com"+Keys.TAB+"12345678"+Keys.ENTER);


//12.Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

//13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

//14. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='Your delivery address']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='Your billing address']")).isDisplayed());

//15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Pay Attention Please!!!");
        waitFor(2);
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("asya ilhanli"+Keys.TAB+
               "1234567890"+Keys.TAB+"212"+Keys.TAB+"02"+Keys.TAB+"2027" );

//17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();
//18. Verify success message 'Your order has been placed successfully!'
        Assert.assertEquals("Your order has been placed successfully!",driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).getText());

//19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertEquals("ACCOUNT DELETED!",driver.findElement(By.xpath("//b")));
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}
