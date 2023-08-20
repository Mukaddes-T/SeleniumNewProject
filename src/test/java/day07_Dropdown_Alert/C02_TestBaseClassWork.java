package day07_Dropdown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillities.Testbase;

public class C02_TestBaseClassWork extends Testbase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Arama kutusuna Java yazdıralım
        driver.findElement(By.cssSelector("#searchHeaderInput")).sendKeys("Java");

    }


}
