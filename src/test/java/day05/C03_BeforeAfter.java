package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {

    WebDriver driver;

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.techproeducation.com");
        Thread.sleep(3000);
    }


    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(3000);
    }

}
