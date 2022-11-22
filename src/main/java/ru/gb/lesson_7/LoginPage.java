package ru.gb.lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordField;

    @FindBy(xpath = "//span[text()='ВОЙТИ']")
    public WebElement logInButton;

public MyAccountPage login(String login, String password){

    emailField.sendKeys(login);
    passwordField.sendKeys(password);
    logInButton.click();
    return new MyAccountPage(driver);
}

}
