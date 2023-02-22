package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

    @Test
    public void acceptAlertTest() throws InterruptedException {
//     https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        driver.get(" https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        1.butona tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//        uyaridaki OK butonuna tiklayin
        Thread.sleep(5000);
        driver
                .switchTo()//degistir
                .alert()//alertte degistir
                .accept();//accept()->OK secenegine tiklanir
        Thread.sleep(5000);
//        ve result mesajinin
//        "You successfully clicked an alert' oldugunu test edin
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);
    }
    /*
      Alertleri nasil automate edersiniz? How to handle alerts in selenium?
       -Alertler javascript ile olusur.Inspect edilemezler.Oncelikle alerte switch etmemiz gerekir
     */

}
