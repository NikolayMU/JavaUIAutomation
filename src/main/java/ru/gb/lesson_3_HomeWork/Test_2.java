package ru.gb.lesson_3_HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        driver.get("https://confaelshop.ru/?logout=yes");


        driver.get("https://confaelshop.ru/");
        String s = driver.findElement(By.xpath("//a[@class='phone']")).getText();
        assert (s.equals("8 (495) 241-91-04"));     // проверка значения


        System.out.println("Тест №2 пройден");



        driver.quit();
    }

}
