package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    @Test
    public void rightClickTest(){
        //Class: Actions1
        //Method: rightClick
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        1.ACTIONS OBJESINI OLUSTURUN
        Actions actions=new Actions(driver);

//        2.ELEMENT I LOCATE EDELIM
        WebElement kutu=driver.findElement(By.id("hot-spot"));

//        3. Kutuya sag tıklayın
        //TUM ACTIONS LAR actions OBJESIYLE BASLAR perform() ILE BITER
        actions.contextClick(kutu).perform();
        //contextClick()=>rastgele tiklar

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        //Object olusturmak wait gerektiren durumlarda makul
        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",actualText);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}
