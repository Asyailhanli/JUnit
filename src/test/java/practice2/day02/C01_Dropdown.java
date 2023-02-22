package practice2.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {


    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        //1-dropdown locate edilir
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        //2-select objesi olusturulur
        Select select= new Select(ddm);
        //3-option secilir
        select.selectByIndex(1);

        String sectigimOptionIndex=select.getFirstSelectedOption().getText();
        System.out.println("SECTIGIM OPTION INDEX = " + sectigimOptionIndex);
        Thread.sleep(3000);


        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String sectigimOptionValue=select.getFirstSelectedOption().getText();
        System.out.println("sectigimOptionValue = " + sectigimOptionValue);
        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String sectigimOptionVisibleText=select.getFirstSelectedOption().getText();
        System.out.println("sectigimOptionVisibleText = " + sectigimOptionVisibleText);
        Thread.sleep(3000);

        // Tüm option'ları yazdırın
        List<WebElement> tumOptions=select.getOptions();

        int sayac=1;
        for (WebElement w:tumOptions){
            System.out.println(sayac+" . OPTION "+w.getText());
            sayac++;
        }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int actualOption=tumOptions.size();
        int expectedOption=3;
        Assert.assertEquals(expectedOption,actualOption);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
