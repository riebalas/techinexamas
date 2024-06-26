package test.registertests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

class RegisterNegativeTest {

    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRegisterWithMismatchedPasswords() {
        driver.get("http://localhost:8080/registruoti");

        registerPage.register("testuser2", "password2", "password233");


    }
}
