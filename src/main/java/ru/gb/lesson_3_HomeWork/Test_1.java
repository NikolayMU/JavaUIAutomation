package ru.gb.lesson_3_HomeWork;
// Тест на прохождение авторизации на сайте

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_1 {

    public static void main(String[] args) {


            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--incognito");
            options.addArguments("disable-popup-blocking");
            options.addArguments("--disable-notifications");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));



            driver.get("https://confaelshop.ru/#popup-login");

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("nmu1989@gmail.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("f697albc");
        driver.findElement(By.xpath("//span[text()='ВОЙТИ']")).click();
        String s = driver.findElement(By.xpath("//a[@class='btn btn--text']/span[1]")).getText();

        assert (s.equals("Украинский Николай"));
        System.out.println("Тест №1 пройден");

        driver.quit();
    }
}