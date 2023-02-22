package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {
    /*
    MANUAL:
    Amazon home sayfasina git
    Account&List e uzerinde bekle -mouse over-hover over-
    Acilan pencerede Account linkini tikla
    Acilan sayfanin title nin Your Account oldugunu dogrula
     */
    @Test
    public void hoverOverTest(){
//        Class: Actions2
//Method : hoverOver() and test the following scenario:
//Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//Sag ust bolumde bulunan “Account & Lists” menüsüne git
//        1.ACTIONS OBJESI
        Actions actions = new Actions(driver);

//        2.ELEMANI BUL
        WebElement accountList= driver.findElement(By.id("nav-link-accountList"));

        waitFor(1);
//        3.UYGUN ACTIONS METHODUNU KULLAN.EN SONRA PERFORM KULLANMAMAYI UNUTMA
        actions.moveToElement(accountList).perform();
        waitFor(3);

//“Account” secenegine tikla
        driver.findElement(By.linkText("Account")).click();

//Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));


    }
}
