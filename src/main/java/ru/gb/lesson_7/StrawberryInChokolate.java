package ru.gb.lesson_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StrawberryInChokolate extends BasePage {
    public StrawberryInChokolate(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-name='Набор из свежей клубники в шоколаде с декором (32 ягоды)']")
    public WebElement cartProduct;

    @FindBy(xpath = "//a[@class='btn btn btn--cart']")
    public WebElement cartItem;

    public void StrawberryChoice() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-name='Набор из свежей клубники в шоколаде с декором (32 ягоды)']")));
        actions.click(cartProduct)
                .perform();
    }
    public void StrawberryChoice_1() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn btn--cart']")));
        actions.moveToElement(cartItem).click()
                .perform();
    }
}
