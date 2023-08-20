package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillities.Testbase;

public class C01_Iframe extends Testbase {
    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        WebElement anaSayfadakiText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']"));
        Assert.assertTrue(anaSayfadakiText.getText().contains("black border"));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//-->Driver'i index kullanarak iframe geçiş yaptırdık
        bekle(2);
        WebElement aplicationListWE = driver.findElement(By.xpath("//h1"));
        String expectedText = "Applications lists";
        Assert.assertEquals(expectedText,aplicationListWE.getText());

        //Son olarak ana sayfadaki, sayfanın en altındaki daki ‘Povered By’ yazisini varligini test edelim
        //driver.get(driver.getCurrentUrl());
        //driver.navigate().refresh();-->Refresh() methodu'da bizi anasayfaya götürür fakat iframe içinde bir form
        // doldurma gibi işlemler yaparsak bunları sıfırlar.
        // refresh() kullandığımızda tüm elementleride yenilediği için tekrar locate almamız
        // gerekebilir.-->staleElementReferansException
        driver.switchTo().defaultContent();//-->Ana sayfaya geçiş yapar
        WebElement sayfaninAltindakiText = driver.findElement(By.xpath("//*[text()='Povered By']"));
        Assert.assertTrue(sayfaninAltindakiText.getText().contains("Povered By"));

    }
    /*
        Iframe(inline frame) bir html dökümanının içine yerleştirilmiş başka bir html dökümanına denir.
    Iframe'deki bir webelementi locate etmek için driver'imizi yine geçiş komutları için kullandığımız
    switchTo() methodu ile iframe'e geçirmeliyiz. Sayfada kaçtane iframe olduğuna bakarak index(index 0'dan başlar) ile
    geçiş yapabiliriz, iframe'i locate ederekte geçiş yapabiliriz yada iframe tag'ındaki id ve name attribute
    değerleri ilede geçiş yapabiliriz.
    SYNTAX;
            driver.switchTo().frame(index - yada iframeWE - yada iframeWE id/name atribute değeri)
     */
}
