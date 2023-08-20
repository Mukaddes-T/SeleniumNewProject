package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));

        //arama kutusunun tag name'inin input oldugunu test edelim
        System.out.println("Arama Kutusu WebElementi Tag Name'i :" + aramaKutusu.getTagName());//-->input
        String gercekTagName = aramaKutusu.getTagName();
        String beklenentagname="input";
        if (gercekTagName.equals(beklenentagname)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //arama kutusunun class attribütunun degerinin form-input oldugunu test ediniz
        String  gercekAttributeName =aramaKutusu.getAttribute("class");
        System.out.println("Class Attribute degeri : " + gercekAttributeName);
        String beklenenAttributeDegeri ="form-input";
        if (gercekAttributeName.equals(beklenenAttributeDegeri)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //sayfayı kapatınız
        driver.close();



    }
}
