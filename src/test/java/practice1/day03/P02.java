package practice1.day03;


import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");

        String window1Handle=driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement iframe=driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //    - iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
         String [] aramaSonuc=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println("aramasonucu : "+ aramaSonuc[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(window1Handle);
        System.out.println("ilk window url " + driver.getCurrentUrl());

        //    - ilk sekmeyi kapatalım
         driver.close();
        //    - Sonra diğer sekmeyide kapatalım
        //TestBase'deki @After notasyonu çalışacak

    }
}
