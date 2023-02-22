package day11;


import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class C03_FileExist  {
    @Test
    public void isExistTest(){

        String userDIR=System.getProperty("user.dir");
        System.out.println(userDIR);///Users/apple/IdeaProjects/MavenJunit_Batch103

        String userHome=System.getProperty("user.home");
        System.out.println(userHome);///Users/apple

//        logo.jpeg indirip MASAUSTUNE kaydedin
//        logo masaustunde:
        String filePath=userHome+ "/Desktop/logo.jpeg";
//        String filePath=/User/apple/Desktop/logo.jpeg
        System.out.println(filePath);

       boolean isExits= Files.exists(Path.of(filePath));//dosya var ise true,yok ise false
        Assert.assertTrue(isExits);

    }
}
