package practice1.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

    }
    @Test
    public void test(){
        //fill the lastname
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("asya", Keys.ENTER,Keys.TAB,"ilhanli",Keys.ENTER, Keys.TAB,Keys.ARROW_RIGHT, Keys.TAB,
                Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.TAB,"10/10/2022",Keys.ENTER,
                Keys.TAB,Keys.ARROW_RIGHT,Keys.TAB,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.TAB,"Antartica",Keys.ENTER,Keys.TAB,"Browser Commands",Keys.ENTER);
        // driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ilhanli");
        //check the gender
        //check the experience
        //fill the date
        //choose your profession -> Automation Tester
        //choose your tool -> Selenium Webdriver
        //choose your continent -> Antartica
        //choose your command  -> Browser Commands
        //click submit button
    }
    @After
    public void tearDown(){

    }
}
