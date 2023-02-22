package practice2.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandles extends TestBase {

    @Test
    public void windowHandles(){

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");

        // arama motoruna 'oppo' yazıp aratın
        WebElement aramaMotoru=driver.findElement(By.xpath("//input[@id='searchData']"));
        aramaMotoru.sendKeys("oppo"+ Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();
        waitFor(3);

        // Basligin 'Oppo' icerdigini test edin.
        //yeni page acildigi icin window handle edilmeli
        List<String > allWindow=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));

        WebElement baslik=driver.findElement(By.xpath("//h1"));
       String baslikStr= baslik.getText();
        Assert.assertTrue(baslikStr.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(allWindow.get(0));
       String  title=driver.getTitle();
        System.out.println("Title " + title);



    }
}
