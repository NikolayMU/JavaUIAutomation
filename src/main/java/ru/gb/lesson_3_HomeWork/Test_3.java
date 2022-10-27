package ru.gb.lesson_3_HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
//Тест на добавление товара в корзину

public class Test_3 {

    public static void main(String[] args) throws InterruptedException {


            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-popup-blocking");
            options.addArguments("--disable-notifications");
            options.addArguments("--headless");
            options.addArguments("--user-agent=Googlebot/2.1 (=https://www.google.com/bot.html)");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            JavascriptExecutor js = (JavascriptExecutor) driver;



        driver.get("https://confaelshop.ru/");

        driver.findElement(By.xpath("//a[@class='cf-menu-link']")).click();
        js.executeScript("window.scrollTo(0,700)");
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"bx_3966226736_208875_362ce596257894d11ab5c1d73d13c755\"]/div/div[2]/button/div/span")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//a[@class='btn btn btn--cart']")).click();

        String s = driver.findElement(By.xpath("//div[@class='cartitem__title']/a")).getText();

        assert (s.equals("Поднос с конфетами Клубника в шоколаде 1640г"));
        //Проверка  наличия в корзине товара
        System.out.println("Тест №3 пройден");


        driver.quit();
    }


}
