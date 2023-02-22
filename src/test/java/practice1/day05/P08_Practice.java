package practice1.day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P08_Practice extends TestBase {

    @Test
    public void test(){
//Amazon sayfasına gidelim
        driver.get("https://amazon.com");

//iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

//Çıkan ürünlerde sadece Apple iPhone yazanları tıklayalım
        List<WebElement> urunler=driver.findElements(By.partialLinkText("Apple iPhone"));//text icinde apple iphone gecenleri alacak
        for (int i = 0; i < urunler.size(); i++) {//stale exception atti
            urunler=driver.findElements(By.partialLinkText("Apple iPhone"));//handle icin kod buraya kopyalandi
            urunler.get(i).click();
            driver.navigate().back();
        }
        //StaleElementReferansException hatasini handle etmek icin loop icine webelementlerden olusturdugumuz listi
        //koymaliyiz

    }
}
