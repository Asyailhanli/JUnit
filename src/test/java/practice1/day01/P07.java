package practice1.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {


//    https://www.google.com/ adresine gidin
//    cookies uyarisini kabul ederek kapatin
//    Sayfa basliginin “Google” ifadesi icerdigini test edin
//    Arama cubuguna “Nutella” yazip aratin
//    Bulunan sonuc sayisini yazdirin
//    sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
//    Sayfayi kapatin

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        //    https://www.google.com/ adresine gidin
        driver.get(" https://www.google.com/");

//    cookies uyarisini kabul ederek kapatin
//    Sayfa basliginin “Google” ifadesi icerdigini test edin
       String actualTitle= driver.getTitle();
       String expectedTitle="Google";
       Assert.assertEquals(expectedTitle,actualTitle);

//    Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
//    Bulunan sonuc sayisini yazdirin
//       WebElement result= driver.findElement(By.xpath("//div[@id='result-stats']"));
//        System.out.println("sonuc;" + result.getText());
        String [] sonucSayisi=driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");
        String sonuc=sonucSayisi[1];
        System.out.println("sonucSayisi[1] = " + sonuc);
//    sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       sonuc=sonuc.replaceAll("\\D","");//REPLACEALL methodu ile \\D'i kullanarak butun noktalama isaretlerini hiclikle degistir
        int istenenSayi=10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);

//    Sayfayi kapatin

        driver.close();
    }
}
