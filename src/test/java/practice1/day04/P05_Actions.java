package practice1.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_Actions extends TestBase {
    @Test
    public void actions() {

        // -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

        //-Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        Actions actions= new Actions(driver);
//        actions.
//                sendKeys(Keys.PAGE_DOWN).
//                sendKeys(Keys.PAGE_DOWN).
//                sendKeys(Keys.PAGE_DOWN).
//                sendKeys(Keys.PAGE_DOWN).
//                sendKeys(Keys.PAGE_DOWN).
//                build().perform();
        WebElement aboutUs=driver.findElement(By.xpath("//*[.='About Us']"));
        actions.moveToElement(aboutUs).perform();
        driver.findElement(By.xpath("(//*[.='Fleet'])[1]")).click();

        //-Sayfa başlığının Fleet içerdiğini test edelim
//        String actualTitle=driver.getTitle();
//        Assert.assertTrue(actualTitle.contains("Fleet"));
        String baslik = driver.findElement(By.xpath("(//*[.='Fleet'])[3]")).getText();
        Assert.assertTrue(baslik.contains("Fleet"));


    }
}
