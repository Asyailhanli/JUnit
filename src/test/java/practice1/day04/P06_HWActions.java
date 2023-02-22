package practice1.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P06_HWActions extends TestBase {

    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        Actions actions= new Actions(driver);
        WebElement buton=driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[3]"));
        actions.moveToElement(buton).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
         driver.findElement(By.xpath(" //*[text()='Alerts, Frame & Windows']")).click();

        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
         WebElement yazi=driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
         Assert.assertTrue(yazi.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());

        //New Tab butonuna click yap
        driver.findElement(By.id("tabButton")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='This is a sample page']")).isDisplayed());

        //İlk Tab'a geri dön
        driver.switchTo().window(windowHandles.get(0));

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());

    }
}
