package practice1.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    //-"amazon.com" adresine gidelim
    //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    //-title ve url'nin "amazon" kelimesinin icerip icermedigini kontrol edelim
    //-Ardindan "trendyol.com" adresine gidelim
    //-bu adresin basligini alalim ve "Sitesi" kelimesini icerip icermedigini kontrol edelim
    //-Bi onceki web sayfamiza geri donelim
    //-sayfayi yenileyelim
    //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com/");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle=driver.getTitle();
        String actualURL=driver.getCurrentUrl();
        System.out.println("Sayfa basligi = " + actualTitle);
        System.out.println("Sayfa URL = " + actualURL);

        //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
//        if(actualTitle.contains("spend") && actualURL.contains("spend")){
//            System.out.println("TEST PASS");
//        } else {
//            System.out.println("TEST FAIL");
//            System.out.println("actualURL = " + actualURL);
//            System.out.println("actualTitle = " + actualTitle);
//        }

        Assert.assertFalse(actualTitle.contains("spend") && actualURL.contains("spend"));//icermiyorsa false iceriyorsa true yapin

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelimesini icerip icermedigini kontrol edelim
       String trendyolTtitle=driver.getTitle();
       Assert.assertTrue(trendyolTtitle.contains("Sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();



    }

}
