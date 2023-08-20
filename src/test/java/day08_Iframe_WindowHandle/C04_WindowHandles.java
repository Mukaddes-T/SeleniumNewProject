package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utillities.Testbase;

import java.util.Set;

public class C04_WindowHandles extends Testbase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandleDegeri = driver.getWindowHandle();//0516BBA3FD90781AF254E35A696DDE5F

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(2);

        Set<String> pencereler = driver.getWindowHandles();
        for (String w:pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandleDegeri)){
                driver.switchTo().window(w);//1FE124B2B5C6C5219C1BDEE920C0E49C
            }
        }


        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        Assert.assertEquals("New Window",driver.getTitle());
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();//1FE124B2B5C6C5219C1BDEE920C0E49C

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandleDegeri);
    }
}
