package practice2.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandle extends TestBase {

    @Test
    public void windowHandle(){
        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String sayfa1Handle=driver.getWindowHandle();

        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        ilkUrun.click();

        // 4- yeni tab'da acilan urunun basligini yazdirin
        WebElement baslik=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(baslik.getText());

        // 5- ilk sayfaya gecip url'i yazdırın
//        List<String> allWindows=new ArrayList<>(driver.getWindowHandles());
//       driver.switchTo().window(allWindows.get(0));
//       String  url=driver.getCurrentUrl();
//        System.out.println(url);
        driver.switchTo().window(sayfa1Handle);
        String ilkSayfaUrl=driver.getCurrentUrl();
        System.out.println("ILKSAYFA URL " + ilkSayfaUrl);


    }
}
