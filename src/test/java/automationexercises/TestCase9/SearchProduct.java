package automationexercises.TestCase9;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class SearchProduct extends TestBase {

    @Test
    public void searchProduct() throws InterruptedException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@href='/products']")).click();



        //5. Verify user is navigated to ALL PRODUCTS page successfully
         WebElement allProductPage=driver.findElement(By.xpath("//h2[@class='title text-center']"));
         Assert.assertTrue(allProductPage.isDisplayed());

        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Blue Top",Keys.ENTER);
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        //8. Verify all the products related to search are visible
        driver.navigate().back();
        List<WebElement> allProducts=driver.findElements(By.xpath("//*[@class='productinfo text-center']/p"));
       for(WebElement w: allProducts){
           Assert.assertTrue(w.isDisplayed());
       }
       //allProducts.stream().forEach(t->t.isDisplayed());

    }
}
