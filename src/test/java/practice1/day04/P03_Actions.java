package practice1.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions  extends TestBase {

    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
   Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
  */
    //actions.scrollToElement(driver.findElement(By.xpath("(//div[@class='render'])[1]"))).perform();
    //bu sekilde direk istedigimiz elemente kaydirabiliyoruz!!!

    @Test
    public void actions(){

        //http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        // Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement maviKutu=driver.findElement(By.xpath("//*[@id='div2']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(maviKutu);
        waitFor(3);


        //Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
           WebElement doubleClick=driver.findElement(By.xpath("//button[@name='dblClick']"));
           actions.doubleClick(doubleClick).build().perform();
          String text= driver.switchTo().alert().getText();
         Assert.assertEquals("Double Clicked !!",text);

        //Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

        //Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).perform();
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//p[.='Dropped!']")).getText());



    }
}
