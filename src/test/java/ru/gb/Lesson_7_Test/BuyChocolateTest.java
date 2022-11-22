package ru.gb.Lesson_7_Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gb.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyChocolateTest {
    WebDriver driver;
    MainPage mainPage;
    Logger logger = LoggerFactory.getLogger(" Тест-кейсы 1-5");
    public WebDriver getWebDriver(){
        return this.driver;
    }
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();

    // процедура логирования логов браузера для этого класса
    void saveBrowserLogs() {
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();

        if (allLogRows.size() > 0) {
            allLogRows.forEach(logEntry -> {
                logger.debug("BROWSERLOGS: "+logEntry.getMessage());
            });
        }
    }
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
    @Description("Тест-кейс №1: Авторизация на сайте")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Авторизация на сайте")
    @Story("Вход на сайт по имени пользователя и паролю")
    void buyChocolateTest() throws InterruptedException {
        driver.get("https://confaelshop.ru/#popup-login");
       Thread.sleep(3000);
       new LoginPage(driver).login("nmu1989@gmail.com","f697albc");

       Assertions.assertTrue(driver.getCurrentUrl().contains("AUTH&USER_LOGIN=nmu1989%40gmail.com"));

        // сохранение логов браузера
        saveBrowserLogs();
        // сохранение скриншота с именем пользователя
        String fileName =  "Тест-кейс_1-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(),fileName);

        // логирование об успешности теста
        logger.info("Тест-кейс №1 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №2: Авторизация на сайте c невалиными данными")
    @Description("Тест-кейс №2: Авторизация на сайте c невалиными данными")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Авторизация на сайте")
    @Story("Вход на сайт по неверному имени пользователя или паролю")
     void buyChocolateTest_2() throws InterruptedException {
        driver.get("https://confaelshop.ru/#popup-login");
        Thread.sleep(3000);
        new ErrorLoginPage(driver).login("nmu1989@gmail.com","password");

        String s = driver.findElement(By.xpath("//div[@class='form-error']")).getText();

        assertTrue (s.equals("Неверный логин или пароль."));


        saveBrowserLogs();

        String fileName =  "Тест-кейс_2-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(),fileName);


        logger.info("Тест-кейс №2 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №3: Проверка контактного номера телефона")
    @Description("Тест-кейс №3: Проверка отображения корректного номера телефона")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.MINOR)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Контактный номер телефона")
    @Story("Проверка отображения контактного номера телефона на сайте")
    void buyChocolateTest_3() throws InterruptedException {
        driver.get("https://confaelshop.ru/");
        Thread.sleep(3000);
      new TelephoneNumber(driver).telephone("8 (495) 241-91-04");

        String s = driver.findElement(By.xpath("//a[@class='phone']")).getText();
        assert (s.equals("8 (495) 241-91-04"));     // проверка значения

        saveBrowserLogs();

        String fileName =  "Тест-кейс_3-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(),fileName);


        logger.info("Тест-кейс №3 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №4: Добавление товара в корзину")
    @Description("Тест-кейс №4: Добавление товара в корзину")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Корзина интернет-магазина")
    @Story("Добавление пользователем товара в корзину")
    void buyChocolateTest_4() throws InterruptedException  {
        driver.get("https://confaelshop.ru/");
        Thread.sleep(5000);
        new PurchaseItem(driver).PurchaseProduct();
        Thread.sleep(5000);
        new StrawberryInChokolate(driver).StrawberryChoice();
        new StrawberryInChokolate(driver).StrawberryChoice_1();
        new SuccessBlock(driver).TotalSum("7 020 ₽");

        saveBrowserLogs();

        String fileName =  "Тест-кейс_4-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(),fileName);


        logger.info("Тест-кейс №4 пройден");
    }


    @Test
    @DisplayName("Тест-кейс №5: Проверка геолокации на сайте")
    @Description("Тест-кейс №5: Проверка геолокации на сайте")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.MINOR)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Геолокация")
    @Story("Отображение города в котором находится пользователь")
    void buyChocolateTest_5() throws InterruptedException  {
        driver.get("https://confaelshop.ru/");
        Thread.sleep(3000);
        new SelectCity(driver).CityCheckMode();
        new SelectCity(driver).CheckCity("Москва");

        saveBrowserLogs();

        String fileName =  "Тест-кейс_5-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(),fileName);


        logger.info("Тест-кейс №5 пройден");
    }

    @AfterEach

        void tearDown() {

            driver.quit();
        }
    }



