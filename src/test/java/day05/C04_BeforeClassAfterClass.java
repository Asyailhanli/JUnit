package day05;

import org.junit.*;

public class C04_BeforeClassAfterClass {

   /*
     @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
     @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test methodlarinin hepsini ayni anda calistirip
     en son @AfterClass'i calistiririz
     Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After kullanir.
    */
    @BeforeClass
    public static void setUp(){
        System.out.println("Butun Testlerden once calisti");
        System.out.println("------------------------------");

    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Butun Testlerden sonra calistir");
    }
    @Before
    public void setUp01(){
        System.out.println("Her Testten Once Calisir");
        System.out.println("--------------------------");
    }
    @After
    public void tearDown01(){
        System.out.println("Her Testten Sonra Calisir");
        System.out.println("------------------------");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }

    @Test
    public  void test02(){
        System.out.println("Ikinci Test");
    }
    @Test
    @Ignore//Eger bir testi calistirmka istemezsek bu sekilde kullanabiliriz
    public void test03(){
        System.out.println("Ucuncu Test");
    }
}
