package practice1.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P03 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox=driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(3000);
        textBox.sendKeys("Techproeducation");

        driver.switchTo().defaultContent();
        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
      WebElement elementSeleniumLinki=driver.findElement(By.xpath("//div[@style='text-align: center;']"));
      Assert.assertTrue(elementSeleniumLinki.isDisplayed());

        // Elemental Selenium linkine tıklayın
        elementSeleniumLinki.click();
        List<String> windowHandles=new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Acilan pencerelerin handle degerleri : " + windowHandles);
        driver.switchTo().window(windowHandles.get(1));

        /*
        Set<String> windowHandleseti=driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for(String each:windowHandleseti){
            if(!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
       */

        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println("Elemantal Selenium Sayfa Basligi :" + driver.getTitle());

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
         WebElement sourceLabsLinki=driver.findElement(By.xpath("//a[@class='link']"));
         Assert.assertTrue(sourceLabsLinki.isDisplayed());

        // Source labs linkine tıklayın
        sourceLabsLinki.click();

        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> windowHandles2=new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Acilan pencerelerin handle degerleri : " + windowHandles2);
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println("Sources Lab: " + driver.getTitle());

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(windowHandles2.get(0));
        System.out.println("Herokuapp Url:" + driver.getCurrentUrl());

        // ilk sekmeyi kapatalım
        driver.close();
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println(driver.getCurrentUrl());

    }
}
