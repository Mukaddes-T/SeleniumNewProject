package calisma_01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillities.Testbase;

import java.util.List;

public class Task01 extends Testbase {
   /* 
   
   **** Aşağıdaki Task'i Junit framework'u ile yapınız
- ebay sayfasına gidiniz
- electronics bölümüne tıklayınız
- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
- Her sayfanın sayfa başlığını yazdıralım

    */

    @Test
    public void test1() {
        driver.get("https://ebay.com");
        driver.findElement(By.cssSelector("li>[_sp='p2481888.m1379.l3250']")).click();

       List<WebElement>resimler = driver.findElements(By.xpath("//img[@width ='225' and @height='225']"));
        for (WebElement w: resimler) {
            bekle(1);
            w.click();
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }



    }
}
