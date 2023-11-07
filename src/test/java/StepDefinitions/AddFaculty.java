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

public class AddFaculty {

    WebDriver driver;

    @Given("the user is logged in as admin id")
    public void the_user_is_logged_in_as_admin_id() {
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

    @When("the user goes to the faculty page")
    public void the_user_goes_to_the_faculty_page() {
        driver.get("https://akmalice.pythonanywhere.com/faculty");
    }

    @And("enters faculty details and clicks on the \"Add\" button")
    public void enters_faculty_details_and_clicks_on_the_add_button() {
        WebElement teacherIdField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[1]/input[1]"));
        teacherIdField.sendKeys("0");

        WebElement nameField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[2]/input[1]"));
        nameField.sendKeys("Akhil");

        WebElement emailField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[3]/input"));
        emailField.sendKeys("emp0@Akhil.com");

        WebElement usernameField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[1]/input[2]"));
        usernameField.sendKeys("emp0_Akhil");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[2]/input[2]"));
        passwordField.sendKeys("password123");

        WebElement addButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[3]/button"));
        addButton.click();
    }

    @Then("the faculty member is added successfully")
    public void faculty_member_is_added_successfully() {
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
