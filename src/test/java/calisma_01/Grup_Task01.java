package calisma_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Grup_Task01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("user-data-dir=C:\\Users\\tavsa\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
        options.addArguments("--profile-directory=TESTSELENIUM");


        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://automationexercise.com");

      WebElement homePage=  driver.findElement(By.cssSelector("html"));

      if (homePage.isDisplayed()){
          System.out.println("TEST PASSED");
      }else System.out.println("TEST FAILED");

      driver.findElement(By.xpath("//a[@href=!/login']")).click();

      WebElement text = driver.findElement(By.xpath("//div[@class='login-form']/h2"));

      if (text.isDisplayed()){
          System.out.println("TEST PASSED");
      }else System.out.println("TEST FAILED");


    }
}
