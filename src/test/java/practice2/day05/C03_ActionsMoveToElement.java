package practice2.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_ActionsMoveToElement extends TestBase {

    public static class C04_ActionMoveToElement extends TestBase {

        @Test
        public void actionMoveToElement(){
            // https://amazon.com adresine gidiniz
            driver.get("https://amazon.com");
            String sayfa1Handle= driver.getWindowHandle();

            // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
            Actions actions= new Actions(driver);
            WebElement menu=driver.findElement(By.xpath("//a[@id='icp-nav-flyout']"));
            actions.moveToElement(menu).perform();

            // Change country/region butonuna basiniz
            driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]")).click();

            // United States dropdown'undan 'Turkey (Türkiye)' seciniz
            WebElement drop=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
            Select select= new Select(drop);
            select.selectByVisibleText(" Turkey (Türkiye)");

            // Go to website butonuna tiklayiniz LOOK!!!!!!!
            //Drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
            //herhangi bir yere clic yapıp drop down opsiyon listesinin toparlanmasını sagladık
            driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
            // Go to website butonuna tiklayiniz
            driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();

            // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
            //1.yol
//            List<String> handles=new ArrayList<>(driver.getWindowHandles());
//            driver.switchTo().window(handles.get(1));
//            String title=driver.getTitle();
//            Assert.assertTrue(title.contains("Elektronik"));
//
            //2.yol
            Set<String> windowHandlesSeti=driver.getWindowHandles();

            System.out.println(windowHandlesSeti);
            System.out.println(sayfa1Handle);

            String sayfa2Handle="";
             for (String each:windowHandlesSeti){
                 if (!each.equals(sayfa1Handle)){
                     sayfa2Handle=each;
                 }

                 driver.switchTo().window(sayfa2Handle);
             }

            String title1=driver.getTitle();
            System.out.println(title1);
            Assert.assertTrue(title1.contains("Elektronik"));


        }
    }
}
