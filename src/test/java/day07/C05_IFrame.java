package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iFrameTest(){
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String anaMetin=driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        // tag[.='metin']->Bana bu tagli metni ver
        //tag[text()='metin']->

        String expectedText="black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//index o dan baslar ilk frame e switch yapiyoruz
        String icMetin=driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1="Applications lists";
        Assert.assertEquals(expectedText1,icMetin);

//        Alternatif olarak altdaki secenekler de kullanilabilir
//        Assert.assertTrue(expectedText1.contains(icMetin));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed();

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip

        //Ana sayfadaki Povered By yazisini test etmek istiyorum.Ama driver hala iframemin icinde
//      //Iframemin disina cikmak icin
        driver.switchTo().defaultContent();
        String footerText=driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
        //clear() ->elemani siler

        /*
          How do you find the number of iframe on a page? Bir sayfadaki toplam iframe sayisini nasil buluruz?
          -iframeler iframe tagi kullanilarak olusturulur.Bu durumda find elements by frame
          -locatirini kullanarak tum iframeleri bulurum.
          -driver.findelement(By.tagName("iframe");
          -driver.findelement(By.xpaht("//iframe");

          Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
          -2 farkli yol vardir.
          -DefaultContent yada parentFrame e gecis yapabiliriz

          What is the difference between DefaultContent and parentFrame? DefaultContent yada parentFrame arasindaki farklar nelerdir?
          -Oncelikle her ikisi de frame in disina cikmamizi saglar.Ama DefaultContent direk ana sayfaya atlatir.
          -parentFrame ise bir ust seviyeye atlatir

          What might be the reason for your test case to fail ?Bir test case in fail etme sebepleri neler olabilir?
          1.Yanlis locator.Cozum:Tekrar elementi locate etmek.Degisken element var ise ona gore dynamic bir xpath yazariz
          2.Wait/Synchronization /Bekleme problemi:Cozum:implicit wait de yeterli sure oldugundan emin oluruz.O sureyi
          arttirabiliriz.30 saniye verilebilir.Explicit wait kullanilabilir(sonra gorecegiz)
          3.Iframe .Cozum:switchTo Iframe
          4.Alert.Cozum:switch to alert
          5.New window;Cozum:switch to window

         */



    }


}
