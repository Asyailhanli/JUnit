package practice1.day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P06_DownloadFile extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
  @Test
    public void download(){
      //https://www.selenium.dev/downloads/ adresine gidelim
      driver.get("https://www.selenium.dev/downloads/");

      //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
      Actions actions= new Actions(driver);
      WebElement browser=driver.findElement(By.xpath("//button[@aria-controls='supported-browsers']"));
     actions.moveToElement(browser).perform();

      //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
      browser.click();
      waitFor(1);
      driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
      waitFor(1);

      //All versions available in Downloads altında Latest stable release olan linki tıklayalım
       driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
      List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
      driver.switchTo().window(pencereler.get(1));

      //Açılan pencerede chromedriver'i indirelim
      driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();

      //Driver'in indiğini doğrulayalım
      String dosyaYolu=System.getProperty("user.home")+"/Desktop/chromedriver_win32.zip";
      assert Files.exists(Paths.get(dosyaYolu));

  }
}
