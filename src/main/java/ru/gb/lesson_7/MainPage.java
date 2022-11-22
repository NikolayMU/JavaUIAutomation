package ru.gb.lesson_7;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {

@FindBy(xpath = "//span[text()='ВОЙТИ']")
    public WebElement singInButton;

    // имя пользователя
    @FindBy(xpath = "//a[@class='btn btn--text']//span[.='Украинский Николай']")
    private WebElement userName;

public MainPage (WebDriver driver) {

    super(driver);
}

public void clickSingInButton() {

    singInButton.click();
}

    public Boolean checkUser(String chUserName){
        String s = userName.getText();
        return s.equals(chUserName);
    }
}



