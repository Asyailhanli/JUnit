package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;


public class C02_WindowHandle extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=multiple-windows
    //Title in ‘Windows’ oldugunu test edin
    //Click here a tiklayin
    //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
    @Test
    public void handleWindow(){
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //Title in ‘Windows’ oldugunu test edin
          switchToWindow("Windows");

        //Click here a tiklayin
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        switchToWindow("New Window");

    }
    @Test
    public void handleWindow2() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //Title in ‘Windows’ oldugunu test edin
        assertEquals("Windows",driver.getTitle());

        //getWindowHandle 1
        String window1Handle=driver.getWindowHandle();

        //Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();

        Thread.sleep(3000);

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin

        Set<String > allWindows=driver.getWindowHandles();
        for (String window2:allWindows){
            if(!window2.equals(window1Handle)){
                driver.switchTo().window(window2);
                break;
            }
        }

      String window2Handle=driver.getWindowHandle();

        Assert.assertEquals("New Window",driver.getTitle());

    }
}
