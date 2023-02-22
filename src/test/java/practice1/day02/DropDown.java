package practice1.day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class DropDown extends TestBase {

    @Test
    public void test01(){//cookies surekli hata veriyor

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Dropdown menuyu yazdiralim
        // List<WebElement> dropdown=driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        // dropdown.forEach(t-> System.out.println(t.getText()));

        WebElement dropdown=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropdown);
        for(WebElement w: select.getOptions()){
            System.out.println(w.getText());
        }

        //Dropdown menuden baby seçelim
        //arama bolumunden milk aratalim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby",
                Keys.TAB,"Milk",Keys.ENTER);


    }


}
