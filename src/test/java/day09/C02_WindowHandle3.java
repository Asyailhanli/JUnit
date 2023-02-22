package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest(){
//        1.Techpro education sayfasinin title'nin "TechPro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        String techProHandle= driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

//        2.Yeni bir pencerede Amazon sayfasini acip title'nin "Amazon" metnini icerdigini test edin
        waitFor(3);
        String amazonHandle= driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);//1.yeni pencere olusturup 2.oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//        3.Yeni bir pencerede linkedin sayfasini acip title'nin "LinkedIn" metnini icerdigini test edin
        waitFor(3);
        String linkedinHandle= driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        waitFor(3);

//        DRIVER NERDE?  LINKEDINDE
//        TECHPRO SAYFASINA GITMEK ICIN TEKRAR driver.switchto.window(techprohandle)
        driver.switchTo().window(techProHandle);
        waitFor(3);

//        DRIVER NERDE ? TECHPROEDUCATION SAYFASINDA
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);

    }



}
