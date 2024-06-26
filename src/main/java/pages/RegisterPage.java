package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private final WebDriver driver;


    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By passwordConfirmField = By.name("passwordConfirm");
    private final By registerButton = By.xpath("//button[@class='btn btn-lg btn-primary btn-block' and @type='submit']");


    public RegisterPage(WebDriver driver) {
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

    public void setPasswordConfirm(String passwordConfirm) {
        WebElement passwordConfirmElement = driver.findElement(passwordConfirmField);
        passwordConfirmElement.sendKeys(passwordConfirm);
    }

    public void clickRegisterButton() {
        WebElement registerButtonElement = driver.findElement(registerButton);
        registerButtonElement.click();
    }

    public void register(String username, String password, String passwordConfirm) {
        setUsername(username);
        setPassword(password);
        setPasswordConfirm(passwordConfirm);
        clickRegisterButton();
    }
}
