package practice2.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void fileDownload(){
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        waitFor(2);

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
//        String homeUser=System.getProperty("user.home");
//        String path=homeUser+ "/Downloads/some-file.txt";

       // /Users/apple       /Downloads/some-file.txt  ==> dosya yolunu
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim=" /Downloads/some-file.txt";

        //String dosyaYolu="/Users/apple/Downloads/some-file.txt";
        String dosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
