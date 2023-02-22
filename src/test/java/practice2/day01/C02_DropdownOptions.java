package practice2.day01;

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

public class C02_DropdownOptions {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){

        //// ...Exercise 2...
        //// https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //// dropdown'dan "Baby" secenegini secin
        //Dropdwon 3 adimda handle edilir

        //1-locate edilmeli
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        //2-Select objesi olusturulmali
        Select select= new Select(ddm);

        //3-opsiyon secilir
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String option=select.getFirstSelectedOption().getText();
        System.out.println("sectigim option = " + option);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumOptions=select.getOptions();
        int actualOption= tumOptions.size();
        int expectedOption=28;
        Assert.assertEquals(expectedOption,actualOption);

    }
    @After
    public void tearDown(){

        driver.close();
    }

}
