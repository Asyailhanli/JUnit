package day18;

public class Interview_JSExecutor {
/*
  1)JavaScript Executor nedir?
     1)Seleniumdan gelen ve javascript kodlari calistirmaya yarayan bir interface dir.
      Normal selenium methodlari yeterli olmadigi durumlarda kullanilabilir

  2)Ne zaman ve nasil kullandin?
      1) Normal selenium methodlari yeterli olmadigi durumlarda kullanilabilir.
      Ornegin:bazi buttonlara tiklamada problem olabilir, yada belirli bir web elementin gorunur olacagi sekilde sayfanin
      kaydirma islemi,ya da input kutularindaki degerleri almak icin kullanilabilir

  3)Sayfayi asagi veya yukari kaydirma islemi seleniumdan nasil yapilir?
         1)Seleniumdaki actions ya da javascript executor methodlari ile kaydirma islemleri yapilabilir.
         Ornegin:actionslarda pageup,pageDown,arrowup, arrowdown methodlari ile ya da js executordaki scrollIntoView(true)
         ile yapilabilir.Ben olusturdugumuz reusable methodlari kullanarak bu islemlerini kolaylikla yapabiliyorum.

  4)Bir kutucuktaki(input) elemani metni nasil alinabilir?
        1)Javascript executor ile alabiliriz.Cunku js executor ile attribute degerlerini alma imkanimiz var.
        getText() methodu bu durumlarda calismaz.

  5)Selenium da click yaparken problem yasadigin oldu mu?
       1)Bazen yanlis locator ya da wait problemi gibi durumlarda problem yasadim.Bazen gizli(hidden)
       elementlere tiklarken problem yasadim.Bu durumda javascript executor kullandim ve problemi cozdum.

  6)Selenium automasyonda ne tur problemler yasadin?*****
       1)Teknik problemler: yanlis locator,bekleme(wait),alert,iframe,pop-up seklindeki reklam bildirimleri,
       multiple window, hidden elementlere tiklama....
       2)Takimla ilgili problemler:(cok gundeme getirilmeme).Developer bazen buldugum buglari kabul etmiyordu.
       Cozum:Takimla beraber degerlendirip fikir birligine variyorduk.
 */
}
