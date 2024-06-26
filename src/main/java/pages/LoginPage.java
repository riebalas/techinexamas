package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;


    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit' and contains(text(), 'Prisijungti')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    public void loginWithInvalidCredentials(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    public void login() {
    }
}
