package practice1.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {

    /*
    - ebay sayfasina gidiniz
    - electronics bolumune tiklayiniz
    - genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
    - her sayfanin basligini yazdiralim
    - sayfayi kapatalim
 */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() throws InterruptedException {
        // ebay sayfasina gidiniz
        driver.get("https://www.ebay.com/");

        // electronics bolumune tiklayiniz
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        // genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
        // her sayfanin basligini yazdiralim
        for (int i = 0 ; i < 24; i++) {
            List<WebElement> urunler=driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println(i+". baslik : " + driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
