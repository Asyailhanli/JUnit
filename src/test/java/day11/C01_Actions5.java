package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {

    @Test
    public void keyboardActionsTest(){

        //Create a class: Action5
        //Create a method keyboardActions
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        WebElement aramaKutusu=driver.findElement(By.name("q"));
       // aramaKutusu.sendKeys("IPHONE X FIYATLARI" + Keys.ENTER);
        Actions actions= new Actions(driver) ;
        actions.
                keyDown(aramaKutusu,Keys.SHIFT).//arama kutusunun ustunde shift tusuna bas
                sendKeys("iphone X fiyatlari").//shift e basiliyken yazi yaz
                keyUp(aramaKutusu,Keys.SHIFT).//shift e artik basma
                sendKeys(" cok pahali! "+ Keys.ENTER).//normal halde yaz ve Enter tusuna bas
                build().//birden fazla actions methodu kullanildiginda build() kullanilmasi onerilir
                perform();

        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas

    }
    /*
      1)Actions nedir? Actions Class nedir?
      -Actions selenium dan gelen bir kutuphanedir.Mouse ve keyboard islemlerini
        gerceklestirmek icin kullandigimiz hazir bir selenium kutuphanesidir.
        Ornegin:sag tiklamak (contexClick), cift tiklamak(doubleClick),elementin uzerine gitmek(hoverOver) gibi
        mouse islemlerini gerceklestirebiliriz.Ayni zamanda shift,control,delete,enter gibi keyboard tuslarina da actions
        yardimiyla da basabiliriz.Bu tur islemlerde sendkeys metodu kullanilir.

       2)Ne tur methodlar kullandin?
        -Actions methodlari onemlidir. Ve tekrar tekrar kullanmam gerektiginde ,Actions methodlari iceren
         Reusable methodlari olusturdum.Ve gerektiginde bu reusable methodlari kullaniyorum.
         Ornegin:rightClick methodunu bir elemente sag tiklamak icin test classinda cagirabilirim.

       3)Hangi methodlari kullandin ne ise yarar?
       Ornegin:sag tiklamak (contexClick), cift tiklamak(doubleClick),elementin uzerine gitmek(hoverOver) gibi
       mouse islemlerini gerceklestirebiliriz.Ayni zamanda shift,control,delete,enter gibi keyboard tuslarina da actions
       yardimiyla da basabiliriz.Bu tur islemlerde sendkeys metodu kullanilir.

     */
}
