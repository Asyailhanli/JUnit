package practice2.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_IFrame extends TestBase {

    @Test
    public void iframe(){

        // ...Exercise 2...


        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslikIframe=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikIframe.isEnabled());
        System.out.println("BASLIK : " + baslikIframe.getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

        WebElement textBox=driver.findElement(By.xpath("//p[.='Your content goes here.']"));
         textBox.clear();
         textBox.sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        //once iframe icinden cikmamiz lazim
        driver.switchTo().defaultContent();

        WebElement poweredText=driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        Assert.assertTrue(poweredText.isDisplayed());
        System.out.println(poweredText.getText());

    }
}
