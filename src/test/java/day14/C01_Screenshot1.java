package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {
    /*
      Selenium da tum ekran goruntusu nasil alinir?
      -tum ekran goruntusu  seleniumdan gelen getScreenshotAS methodu ila alinir
      -getScreenshotAs methodu seleniumdaki takeScreenshot API indan gelir
     */

    @Test
    public void fullPageScreenshotTest() throws IOException {
         //Class : screenShot1
        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

//        1.Ekran goruntusunu getScreenshots methodu ile alip File olarak olusturalim
       File goruntu= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//       2.Almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet.dir=directory=dosya
//        NOTE:kayit ismini dinamik yapmak icin date objesini kullandim
       String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       String path=System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);

//       3.Goruntum ile dosyami birlestirip kaydet
        //FileUtils.copyFile(goruntu,new File(path));
         FileUtils.copyFile(goruntu,hedef);

//        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
//                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));
//

        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+Keys.ENTER);
        waitFor(3);
        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));
        waitFor(2);

//       Reusable metod yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();

    }

}
