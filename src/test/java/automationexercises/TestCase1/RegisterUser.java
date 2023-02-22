package automationexercises.TestCase1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RegisterUser extends TestBase {
    @Test
    public void registerUser() throws InterruptedException {
//    1.Launch browser
//    2.Navigate to url "https://automationexercises.com"
        driver.navigate().to("https://automationexercise.com");

//    3. Verify that home page is visible successfully
      boolean homePage=driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed();
      assertTrue(homePage);

//      4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        Thread.sleep(5000);
//        5. Verify 'New User Signup!' is visible
       String newUser=driver.findElement(By.xpath("//h2[.='New User Signup!']")).getText();
        Assert.assertEquals("New User Signup!",newUser);


//        6. Enter name and email address
          driver.findElement(By.name("name")).sendKeys("Asya");
          driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("asye@gmail.com");

//        7. Click 'Signup' button
        driver.findElement(By.xpath("//button[.='Signup']")).click();

//       8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String enterAccount=driver.findElement(By.xpath("//b[.='Enter Account Information']")).getText();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION",enterAccount);

//        9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
//        driver.findElement(By.id("name")).sendKeys("Asya");
//        driver.findElement(By.id("email")).sendKeys("asya@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        WebElement days=driver.findElement(By.id("days"));
        Select select=new Select(days);
        select.selectByValue("18");

        WebElement months=driver.findElement(By.id("months"));
        Select select1=new Select(months);
        select1.selectByVisibleText("August");

        WebElement year=driver.findElement(By.id("years"));
        Select select2=new Select(year);
        select2.selectByValue("1993");

//        10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkBox1=driver.findElement(By.xpath("//label[.='Sign up for our newsletter!']"));
        checkBox1.isSelected();

//        11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox2=driver.findElement(By.xpath("//label[.='Receive special offers from our partners!']"));
        checkBox2.isSelected();

        Thread.sleep(3000);
//    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       List<WebElement> allInformation=driver.findElements(By.xpath("//p[@class='required form-group']/input"));
       List<String> allWord=new ArrayList<>(Arrays.asList("asya","ilhanli","Bank Of America","Zigana Apartment","Beylikduzu",
               "Canada","Turkish","Istanbul","34567","5378905432"));
        for (int i = 0; i < allInformation.size(); i++) {
            allInformation.get(i).sendKeys(allWord.get(i));
        }

//     13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

//        14. Verify that 'ACCOUNT CREATED!' is visible !!!!!!AFTER THAT NOT TEST EXECUTION!!!!
       // Assert.assertEquals("ACCOUNT CREATED!",driver.findElement(By.xpath("//b[.='Account Created!']")));




    }
}
