package practice2.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void iframe(){
        // ...Exercise 1...

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);

        // Videoyu izlemek icin Play tusuna basiniz

        //Play'i dogru locate edip click yapmamiza ragmen videoyu calistirmadi
        //Bunun uzerine HTML kodlraini inceleyince Play'in aslinda bir i frame icerisinde
        //oldugu gorduk
        //Bu durumda once iframe mi locate edip sonra switchto() ile iframe e gecmeliyiz
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement play=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        // Videoyu calistirdiginizi test ediniz
       WebElement youtubeYazisi= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());

        //iframe den cikmak gerekiyor
        driver.switchTo().defaultContent();


        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
                WebElement powerful=driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
                Assert.assertTrue(powerful.isDisplayed());
    }

}
