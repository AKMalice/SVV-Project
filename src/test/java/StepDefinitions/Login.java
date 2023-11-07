package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Login {

    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String projectpath = System.getProperty("user.dir");
        System.out.println(projectpath);
        System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://akmalice.pythonanywhere.com/login");
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_valid_username_and_password() {
        // Wait for the username field to become visible
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));


        usernameField.sendKeys("kluSVV123");
        passwordField.sendKeys("userSVV1234!");
    }

    @When("the user enters an invalid username and password")
    public void the_user_enters_invalid_username_and_password() {
        // Wait for the username field to become visible
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));


        usernameField.sendKeys("kluSVV1s23");
        passwordField.sendKeys("userSVV12s34!");
    }

    @And("clicks the login button")
    public void click_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div[1]/button"));        loginButton.click();
    }

    @Then("the user should be logged in successfully")
    public void user_logged_in_successfully() {
        driver.get("https://akmalice.pythonanywhere.com/dashboard");

    }

    @Then("the user should see an error message")
    public void user_sees_error_message() {
        driver.get("https://akmalice.pythonanywhere.com/login");

    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
