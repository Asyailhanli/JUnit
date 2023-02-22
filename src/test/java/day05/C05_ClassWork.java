package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
            driver.close();
    }
    @Test
    public void test01(){
        // Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chechbox1 = driver.findElement(By.xpath("//*[@type=\"checkbox\"]"));
        WebElement chechbox2 = driver.findElement(By.xpath("//*[@type=\"checkbox\"][2]"));

        //Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!chechbox1.isSelected()){//eger secili degilse
            chechbox1.click();
        }
        //Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!chechbox2.isSelected()){
            chechbox2.click();
        }


    }

}
