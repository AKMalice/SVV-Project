package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class AddStudent {

    WebDriver driver;

    @Given("the user is admin")
    public void the_user_is_admin() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://akmalice.pythonanywhere.com/login");

        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        usernameField.sendKeys("kluadmin");
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div[1]/button"));
        loginButton.click();
    }

    @When("the user goes to the student page")
    public void the_user_goes_to_the_student_page() {
        driver.get("https://akmalice.pythonanywhere.com/students");
    }

    @And("enters student details and clicks on the \"Add\" button")
    public void enters_student_details_and_clicks_on_the_add_button() {
        WebElement studentIdField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[1]/input[1]"));
        studentIdField.sendKeys("68");

        WebElement nameField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[2]/input[1]"));
        nameField.sendKeys("TarunJr");

        WebElement emailField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[3]/input"));
        emailField.sendKeys("student68@example.com");

        WebElement usernameField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[1]/input[2]"));
        usernameField.sendKeys("student68");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[2]/input[2]"));
        passwordField.sendKeys("password123");

        WebElement addButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[3]/button"));
        addButton.click();
    }

    @Then("the student is added successfully")
    public void student_is_added_successfully() {
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
