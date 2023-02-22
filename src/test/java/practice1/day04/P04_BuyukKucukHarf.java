package practice1.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04_BuyukKucukHarf extends TestBase {

    @Test
    public void test01() {

//        Google sayfasina gidelim
        driver.get("https://google.com");

//        Buyuk kucuk harf olacak sekilde HeLlO yazdiralim
        WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);



    }
}
