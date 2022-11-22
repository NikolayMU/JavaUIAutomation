package ru.gb.lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorLoginPage extends BasePage {
    public ErrorLoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordField;

    @FindBy(xpath = "//span[text()='ВОЙТИ']")
    public WebElement logInButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div/div/div[5]/div[3]/a")
    public WebElement mainLogButton;

    @FindBy(xpath = "//div[@class='form-error']")
    public WebElement errorMessage;


    public MyAccountPage login(String login, String password){

        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        logInButton.click();
        mainLogButton.click();
        return new MyAccountPage(driver);
    }

    }


