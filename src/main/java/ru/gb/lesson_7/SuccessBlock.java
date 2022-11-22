package ru.gb.lesson_7;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessBlock {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public SuccessBlock(WebDriver driver){

        this.driver = driver;
        webDriverWait =  new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = " //em[@class='total-sum']")
    public WebElement cartConsist;

    public void TotalSum(String expectedSum) {
        Assertions.assertEquals(cartConsist.getText(), expectedSum);
    }
}
