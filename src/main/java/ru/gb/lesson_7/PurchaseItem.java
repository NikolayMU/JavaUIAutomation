package ru.gb.lesson_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PurchaseItem extends BasePage {
    public PurchaseItem(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='footerlink__content']/a[.='Клубника в шоколаде']")
    public WebElement strawberryBlock;


    public void PurchaseProduct() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='footerlink__content']/a[.='Клубника в шоколаде']")));
        actions.click(strawberryBlock)
                .perform();
    }
}
