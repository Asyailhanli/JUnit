package practice1.day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class P03 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe=driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe sayisi : "+ iframe.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame=driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
       driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@class='ytp-impression-link-text']")).click();
       Thread.sleep(3000);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        driver.navigate().back();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        WebElement iframe2=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();



    }
}
