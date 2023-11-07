package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Logout {

    WebDriver driver;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://akmalice.pythonanywhere.com/login");

        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        usernameField.sendKeys("kluSVV123");
        passwordField.sendKeys("userSVV1234!");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div[1]/button"));
        loginButton.click();

    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[1]/nav/div/div/a"));
        logoutButton.click();
    }

    @Then("the user should be logged out")
    public void user_should_be_logged_out() {
        driver.get("https://akmalice.pythonanywhere.com");
        if (driver != null) {
            driver.quit();
        }
    }
}

