package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void windowHandleTest(){
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle=driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualwindow1Text=driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        String expectedWindow1Text="Opening a new window";
        Assert.assertEquals(expectedWindow1Text,actualwindow1Text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        waitFor(3);

//        IKINCI PENCERE ACILIR VE IKINCI PENCEREDE ISLEM YAPMAK ISTEDIGIMDEN ,O PENCEREYE SWITCH-GECIS YAPMALIYIZ
       // switchToWindow("New Window");
        switchToWindow(1);//2.window gecis yaptik.driver artik 2.window da

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertTrue(driver.getTitle().contains("New Window"));

    }
}
