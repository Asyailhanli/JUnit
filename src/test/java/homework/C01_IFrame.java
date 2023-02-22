package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class C01_IFrame extends TestBase {

    //Bir class olusturun: IframeOdev
 //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
//sayfadaki toplam iframe sayısını bulunuz.
//Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
//Paragrafdaki yaziyi silelim
//Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
//Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim

    @Test
    public void iFrametest() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> toplamIframe=driver.findElements(By.xpath("//iframe"));
        System.out.println("Toplam iframe : "+ toplamIframe.size());


        //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
       String actualTitle= driver.findElement(By.xpath("//h3")).getText();
       assertTrue(actualTitle.contains("Editor"));

        Thread.sleep(3000);
        driver.switchTo().frame("mce_0_ifr");

        //Paragrafdaki yaziyi silelim
       WebElement text= driver.findElement(By.xpath("//p"));
       text.clear();

       Thread.sleep(3000);

        //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        text.sendKeys("iframein icindeyim");

        //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String textContains=driver.findElement(By.xpath("//a[.='Elemental Selenium']")).getText();
        assertTrue(textContains.contains("Elemental Selenium"));
    }
}
