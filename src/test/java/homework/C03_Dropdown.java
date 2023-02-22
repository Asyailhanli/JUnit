package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C03_Dropdown extends TestBase {

    /*
      Test01 :  1- amazon gidin
Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
dropdown menude 40 eleman olduğunu doğrulayın
Test02
dropdown menuden elektronik bölümü seçin
arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
sonuc sayisi bildiren yazinin iphone icerdigini test edin
ikinci ürüne relative locater kullanarak tıklayin
ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
Test03
yeni bir sekme açarak amazon anasayfaya gidin
dropdown’dan bebek bölümüne secin
bebek puset aratıp bulundan sonuç sayısını yazdırın
sonuç yazsının puset içerdiğini test edin
5-üçüncü ürüne relative locater kullanarak tıklayin
6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */
    @Test
    public void dropDown(){
        driver.get("https://amazon.com");

        List<WebElement> allElement=driver.findElements(By.xpath("//div[@class='nav-search-scope nav-sprite']"));

        for (WebElement w:allElement){
            System.out.println(w.getText());
        }
       Assert.assertEquals("40",allElement.size());







    }
}
