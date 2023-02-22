package practice1.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P01 extends TestBase {

    @Test
    public void test01(){
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String windowHandle=driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATIO"));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://walmart.com");

        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(windowHandle);
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
