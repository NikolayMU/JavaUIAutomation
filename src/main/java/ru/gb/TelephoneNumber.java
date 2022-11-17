package ru.gb;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;

public class TelephoneNumber extends BasePage{
    public TelephoneNumber(WebDriver driver) {

        super(driver);
    }
// проверка правильности отображения номер телефона для конкретного региона
    @FindBy (xpath = "//a[@class='phone']")
    public WebElement correctPhone;

    public void telephone(String number) {

        actions.moveToElement(correctPhone)
                .pause(Duration.ofSeconds(3))
                .perform();
    }


}




