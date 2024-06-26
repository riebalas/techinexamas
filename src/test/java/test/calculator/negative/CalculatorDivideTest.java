package test.calculator.negative;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CalculatorDivideTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Login and Perform Calculator Addition")
    public void testCalculatorAddition() {

        login();


        performCalculation();



    }

    private void login() {
        driver.get("http://localhost:8080/prisijungti");

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and contains(text(), 'Prisijungti')]"));
        loginButton.click();

        String expectedUrlAfterLogin = "http://localhost:8080/";
        wait.until(ExpectedConditions.urlToBe(expectedUrlAfterLogin));

        Assertions.assertEquals(expectedUrlAfterLogin, driver.getCurrentUrl(), "Login was not successful.");
    }

    private void performCalculation() {
        WebElement firstNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sk1")));
        firstNumberField.clear();
        firstNumberField.sendKeys("-2");

        WebElement secondNumberField = driver.findElement(By.id("sk2"));
        secondNumberField.clear();
        secondNumberField.sendKeys("-2");

        WebElement operationSelect = driver.findElement(By.name("zenklas"));
        Select select = new Select(operationSelect);
        select.selectByValue("/");

        WebElement calculateButton = driver.findElement(By.cssSelector("input[type='submit'][value='skaičiuoti']"));
        calculateButton.click();
    }


}
