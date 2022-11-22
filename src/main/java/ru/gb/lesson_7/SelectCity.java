package ru.gb.lesson_7;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCity extends BasePage {
    public SelectCity(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='cf-your-city']")
    public WebElement selectCityButton;



    public void CityCheckMode() {

        actions.moveToElement(selectCityButton).click()
                .perform();

    }
    @FindBy(xpath = "//a[@class='change-city']")
    public WebElement cityCheck;

    public void CheckCity(String expectedCity) {
        Assertions.assertEquals(cityCheck.getText(), expectedCity);
    }
}
