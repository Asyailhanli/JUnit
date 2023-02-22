package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void handleWindowTest() throws InterruptedException {
        //Tests package'inda yeni bir class olusturun: WindowHandle
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //     ILK SAYFANIN IDSINI ALALIM
        String window1Handle=driver.getWindowHandle();

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String window1Text=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);

        //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String windowTitle=driver.getTitle();
        Assert.assertEquals("The Internet",windowTitle);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.

        // BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECIS YAPMAK ISTIYORUM
        //BUNUN ICIN driver.getWindowHandles() ILE TUM PENCERELERIN IDLERINI ALALIM
        Set<String> allWindowHandles= driver.getWindowHandles();//{window1Handle,window2Handle}
        System.out.println(allWindowHandles);
        for(String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)){//eger listedeki id window1 esit degilse otomatik olarak 2 ye esittir
                driver.switchTo().window(eachHandle);//buradaki eachHandle window2  handle ina esittir
                break;
            }
        }

//        BU NOKTA DA DRIVER 2.PENCEREDE
        // Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());

        // Sayfadaki textin "New Window" olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());

        String window2Handle=driver.getWindowHandle();
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        Thread.sleep(3000);

//        1.window gecis yapiyorum
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());

        Thread.sleep(3000);
//        2.windowa tekrar gecelim
        driver.switchTo().window(window2Handle);

//        1.windowa tekrar gecelim
        driver.switchTo().window(window1Handle);



    }
}
