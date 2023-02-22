package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {
    @Test
    public void dragAndDropTest(){
        //EN FAZLA SURUKLEMEK ICIN BU METHOD KULLANILIR
        //Class: Action4
        //Method: dragAndDropTest

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak=driver.findElement(By.id("draggable"));
        WebElement hedef=driver.findElement(By.id("droppable"));

        //dragAndDrop() surukleme islemni gerceklestirir
        Actions actions= new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();
        waitFor(5);

    }

    @Test
    public void clickAndHold(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak=driver.findElement(By.id("draggable"));
        WebElement hedef=driver.findElement(By.id("droppable"));

        //dragAndDrop() surukleme islemni gerceklestirir
        Actions actions= new Actions(driver);
        actions.
                clickAndHold(kaynak).//KAYNAGI TUT
                moveToElement(hedef).//hedefe koy
                release().//KAYNAGI BIRAK
                build().//onceki methodlarin iliskisini kur/guclendir.Kullanilmasi tercih edilir
                perform();//islemi gerceklestir
    }
    @Test
    public void moveByOffSetTest(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak=driver.findElement(By.id("draggable"));

        //dragAndDrop() surukleme islemni gerceklestirir
        Actions actions= new Actions(driver);
        actions.
                clickAndHold(kaynak).
                moveByOffset(430,30).
                release().
                build().
                perform();

    }

}
