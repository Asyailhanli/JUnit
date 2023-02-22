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

import java.time.Duration;

public class C03_RadioButton {


    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test03() throws InterruptedException {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        // radiobutton elementlerini locate edin
        WebElement option1=driver.findElement(By.id("vfb-7-1"));
        WebElement option2=driver.findElement(By.id("vfb-7-2"));
        WebElement option3=driver.findElement(By.id("vfb-7-3"));
        // option2'yi secin
        option2.click();
        Thread.sleep(3000);

        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(option2.isSelected());
        Thread.sleep(3000);

        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option1.isSelected());
        Thread.sleep(3000);

        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option3.isSelected());
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
