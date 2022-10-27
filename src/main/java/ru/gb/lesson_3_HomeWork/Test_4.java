package ru.gb.lesson_3_HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Test_4 {

    public static void main(String[] args) {
        // аворизауия с невалидным паролем
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // проверка отсутсвия авторизированного пользователя на сайте
        driver.get("https://confaelshop.ru/#popup-login/?logout=yes");

        // тестовые действия
        driver.get("https://confaelshop.ru/#popup-login");

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("nmu1989@gmail.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("f111albc");
        driver.findElement(By.xpath("//span[text()='ВОЙТИ']")).click();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div[5]/div[3]/a")).click();
        String s = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/form/div[1]/p/font")).getText();

        assert (s.equals("Неверный логин или пароль."));


        System.out.println("Тест №4 пройден");


        driver.quit();

    }
}
