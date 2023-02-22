package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C04_FileDownLoadTest extends TestBase {

    @Test
    public void fileDownLoadTest(){

        //Class : FileDownloadTest Method : downloadTestExist
        //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
         driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim
         driver.findElement(By.partialLinkText("b10 all test cases")).click();
         waitFor(3);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath=System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean downLoad= Files.exists(Path.of(filePath));
        Assert.assertTrue(downLoad);

    }
}
