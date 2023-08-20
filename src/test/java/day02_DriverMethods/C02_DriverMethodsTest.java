package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Techpro sayfasina gidelim. https://techproeducation.com
        driver.get("https://techproeducation.com");

        //Sayfa basligini(title) yazdirin
        System.out.println("Sayfa Başlığı : "+driver.getTitle());

        //Sayfa basliginin “TechPro” icerdigini test edin
        if (driver.getTitle().contains("TechPro")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //Sayfa adresini(url) yazdirin
        System.out.println("Sayfa Url'i : "+driver.getCurrentUrl());

        //Sayfa url’inin “techpro” icerdigini test edin.
        if (driver.getCurrentUrl().contains("techpro")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //Sayfa handle degerini yazdirin
        String techproSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println("Sayfa Handle Değeri : "+techproSayfaHandleDegeri);
        /*
            getWindowHandle() methodu ile kendimiz isteyerek başka bir pencereye geçiş yaptığımızda iki tane pencere
        açmış olucaz. Dolayısıyla ilk açtığımız pencereye tekrar geçiş yapmak istediğimizde ilk açtığımız pencereden
        sonra almış olduğumuz window handle değeri ile geçiş yapabiliriz. Pencereler arası geçiş konusunda bunu detaylı
        göreceğiz. Birde bir sayfaya gittiğimizde bir linke tıkladığımızda bizim kontrolümüz dışında yeni bir pencere
        açılabilir. Bu gibi durumlarda da getWindowHandles() methodu ile driver'in açmış olduğu pencerelerin handle
        değerlerini bir list'e assing ederiz ve istediğimiz pencereye index ile çok rahat geçiş yapabiliriz.
         */

        //Sayfa HTML kodlarinda “text” kelimesi gectigini test edin
        System.out.println(driver.getPageSource());
        System.out.println(driver.getPageSource().contains("text"));

        //sayfayı kapatınız
        driver.close();//-->close() methodu driver en son açtığı sayfayı kapatır
        //driver.quit(); --> Bu method ise bizim açtığımız birden fazla sekme yada pencerelerin hepsini kapatmak için kullanılır
    }
}
