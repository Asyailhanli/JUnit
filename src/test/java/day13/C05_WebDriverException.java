package day13;

public class C05_WebDriverException {
    /*
     WebDriverExceptioni
     -Driver versiyonlari ve browser versiyonlari ayni veya yakin olmadiginda alinir
     -Driver(browser)i kapattiktan sonra tekrar kullanmak istediginiz durumlarda alinabilir
     Solutions:
     Framework designin guzel kurulmus olmasi gerekir.Ornegin:Driver sinifinda birden fazla driver.quit() olmamali

     WebDriverException
     When you close the browser, but still want to use that in correctly
     When the versions of the driver and browsers are not compatible
     Solution
     Your design should be good. We should use singleton Driver to prevent this exception
     Keep drivers up to date that is compatible with the  browser version
     */
}
