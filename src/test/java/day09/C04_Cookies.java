package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookiesTest(){
         //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);

        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies=driver.manage().getCookies();
        int cookiesSayisi=allCookies.size();
        System.out.println("Sayfada " + cookiesSayisi + " adet cookie var");

        //3. Bir Cookie yi ismiyle bul
        //driver.manage().getCookieNamed("ubid-main");

        //tum cookie leri yazdiralim
        //allCookies.stream().forEach(t-> System.out.println(t.getName()));

    for(Cookie eachCookie:allCookies){
        System.out.println("Cookie :" + eachCookie);//Cookie nin tamamini yazdik
        System.out.println("Cookie isimleri : "+ eachCookie.getName());
        System.out.println("Cookie Value :"+ eachCookie.getValue());
    }
        System.out.println("Cookie ismiyle cagiriyorum:" + driver.manage().getCookieNamed(" i18n-prefs"));

        //4. Yeni bir cookie ekle
        Cookie cookie =new Cookie("cikolatam","antep-fistikli-cikolata");//cookie olustur
        driver.manage().addCookie(cookie);//sayfaya yeni cookie ekle
        waitFor(3);
        System.out.println("Yeni Cookie sayisi:" + driver.manage().getCookies().size());//cookie sayisi artti

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("ubid-main");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("Tum cookileri sildim.Yeni cookie sayisi : " + driver.manage().getCookies().size());


    }
}
