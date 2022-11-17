package Lesson_6_Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyChocolateTest {
    WebDriver driver;
    MainPage mainPage;

    @BeforeAll

    static void registerDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {

        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
       // driver.get("https://confaelshop.ru/");

    }

    @Test
    @DisplayName("Тест-кейс №1: Авторизация на сайте")
    void buyChocolateTest() throws InterruptedException {
        driver.get("https://confaelshop.ru/#popup-login");
       Thread.sleep(3000);
       new LoginPage(driver).login("nmu1989@gmail.com","f697albc");

       Assertions.assertTrue(driver.getCurrentUrl().contains("AUTH&USER_LOGIN=nmu1989%40gmail.com"));
    }

    @Test
    @DisplayName("Тест-кейс №2: Авторизация на сайте c невалиными данными")
     void buyChocolateTest_2() throws InterruptedException {
        driver.get("https://confaelshop.ru/#popup-login");
        Thread.sleep(3000);
        new ErrorLoginPage(driver).login("nmu1989@gmail.com","password");

        String s = driver.findElement(By.xpath("//div[@class='form-error']")).getText();

        assertTrue (s.equals("Неверный логин или пароль."));


    }

    @Test
    @DisplayName("Тест-кейс №3: Проверка контактного номера телефона")
    void buyChocolateTest_3() throws InterruptedException {
        driver.get("https://confaelshop.ru/");
        Thread.sleep(3000);
      new TelephoneNumber(driver).telephone("8 (495) 241-91-04");

        String s = driver.findElement(By.xpath("//a[@class='phone']")).getText();
        assert (s.equals("8 (495) 241-91-04"));     // проверка значения
    }

    @Test
    @DisplayName("Тест-кейс №4: Добавление товара в корзину")
    void buyChocolateTest_4() throws InterruptedException  {
        driver.get("https://confaelshop.ru/");
        Thread.sleep(5000);
        new PurchaseItem(driver).PurchaseProduct();
        Thread.sleep(5000);
        new StrawberryInChokolate(driver).StrawberryChoice();
        new StrawberryInChokolate(driver).StrawberryChoice_1();
        new SuccessBlock(driver).TotalSum("7 020 ₽");
    }


    @Test
    @DisplayName("Тест-кейс №5: Проверка геолокации на сайте")
    void buyChocolateTest_5() throws InterruptedException  {
        driver.get("https://confaelshop.ru/");
        Thread.sleep(3000);
        new SelectCity(driver).CityCheckMode();
        new SelectCity(driver).CheckCity("Москва");
    }

    @AfterEach

        void tearDown() {

            driver.quit();
        }
    }



