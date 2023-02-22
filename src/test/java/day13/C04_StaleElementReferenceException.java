package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    -Stale Element =eski kullanilamaz durumda,kullanim artik elverisli degil
    -Sayfayi yenilediginizde (refresh())
    -Sayfada ileri geri gittigimizde

    Solutions:
    -Elementi tekrar bulmak

    Stale Element means the element is no longer fresh. It is old and no longer available
    When the element is no longer fresh on the page and you try to use it
    When the element is detached from the DOM
    When the element is removed after session started
    Solution:
    Relocate the same element again. You can use a new variable name as well.
    Example:
     */
    @Test
    public void staleElementReferenceExceptionTest1(){
        driver.get("https://www.techproeducation.com");
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement  lmsLoginLink=driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(3);
        lmsLoginLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URL in lms kelimesini icerdigini test et
        waitFor(3);

//        Tekrar ana sayfaya gel ve LMS LOGIN LINKINE sayfasina  tekrar git
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(3);
        lmsLoginLink.click();//LMS e git //org.openqa.selenium.StaleElementReferenceException:

        /*
        lmsloginLink linkini sayfa yenilendikten (back) sonra kullandigim icin StaleElementRefrenceException aldim
         */

    }
    @Test
    public void staleElementReferenceExceptionTest2(){
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement  lmsLoginLink=driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        //SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI ,SAYFA YENILENDIKTEN SONRA KULLANMAK ISTEDIM
        lmsLoginLink.click();//org.openqa.selenium.StaleElementReferenceException

        //COZUM ESKI(STALE ELEMENT) ELEMENTI TEKRAR LOCATE ET
        //driver.findElement(By.linkText("LMS LOGIN"));

    }
}
