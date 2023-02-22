package day06;

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

public class C01_DropDown {
    WebDriver driver;

// Eger test sinifinda birden fazla method olusturulmussa ,@Before kullanilir
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void selectByIndexTest(){
//       Dogum yilini,ayini ve gununu su sekilde secer :2000 ,January,10
//        1.LOCATE dropdown element
        WebElement year=driver.findElement(By.xpath("//select[@id='year']"));

//       2.Select objesini olustur
        Select yearDropdown= new Select(year);

//        3.Select object i kullanarak 3 farkli sekilde secim yapabilirim
        yearDropdown.selectByIndex(22);//Secenek sirasi :0 dan baslar .2000 yili 23.sirada 22 index sirasi

//        Ay secimi
        WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropdown=new Select(month);
        monthDropdown.selectByValue("0");

//       Gun secimi selecByVisibleText=gorunen metin ile sec
        WebElement day=driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropdown= new Select(day);
        dayDropdown.selectByVisibleText("10");//CASE SENSITIVE-Buyuk kucuk harfe karsi duyarli
    }


   @Test
    public void printAllTest(){
//  Tum eyalet isimlerini consola yazdiralim
       WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
       Select stateDropdown= new Select(state);
       List<WebElement> stateList=stateDropdown.getOptions();
//       for(WebElement w:stateList){
//           System.out.println(w.getText());
//       }

       stateList.stream().forEach(t-> System.out.println(t.getText()));
   }
   @Test
    public void getSelectedOptionsTest(){
//      State dropdowndaki varsayilan secili secenegin "Select a State" oldugunu verify edelim
       WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
       Select stateDropdown= new Select(state);
//       WebElement varsayilanElement=stateDropdown.getFirstSelectedOption(); asagidaki string ile ayni
//       String varsailanElementText=varsayilanElement.getText();
//
       String varsayilanText=stateDropdown.getFirstSelectedOption().getText();
       Assert.assertEquals("Select a State",varsayilanText);

   }

   @After
    public void tearDown(){
        driver.quit();
   }

   //REUSABLE METHOD:Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim

    /*
     1.What is dropdown?Dropdown nedir?
     Dropdown liste olusturmak icin kullanilir.it is used for the creating list

     2.How to handle dropdown elements? Dropdown nasil automate edilir?
     -Dropdown I locate ederim
     -select objesi olustururm
     -select objesi ile istedigim secenegi secerim
     NOT:select objesi olustuma nedenim, dropdownlarin select classi ile olusturulmasi

     3.Tum dropdown seceneklerini nasil print ederiz?
     -Tum dropdown elementlerini getOptions() methodu ile listeye koyariz
     -sonra secenekleri loop ile yazdirabiliriz

     4.Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
     Ornek:Gun olarak 10 ' sectik ama ya secilmediyse
     getFirstSelectedOption() secili olan secenegi return eder
      */
   /*
      Dropdown?
    -Acilir menu. Birden fazla seçenegi koyabilecegimiz liste.
    ***Dropdown nasil automate edilir? How to handle dropdown?
     Dropdown elementi locate edilir.8 locatordan biri kulllaninbilir.
    Select classi kullanilarak bir Select objesi olusturulur. Select select = new Select(dropdownElement);
    Select objectini kullanarak ugun methodlarla islem yapilir
    selectBylndex(int); index 0 dan baslar
    selectByValue(“String”);
    selectByVisibleText(“String”);
    getOptions(); tum dropdown seçenekleri List<WebElement> olarak return eder
    getFirstSelectedOption(); secili olan ilk
    */

}
