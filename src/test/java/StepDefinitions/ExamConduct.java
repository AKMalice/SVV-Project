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

public class ExamConduct {

    WebDriver driver;

    @Given("the user is an admin")
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

    @When("the user goes to the exams page")
    public void the_user_goes_to_the_exams_page() {
        driver.get("https://akmalice.pythonanywhere.com/admin-exams");
    }

    @And("enters exam details and clicks on the Add button")
    public void enters_exam_details_and_clicks_on_the_add_button() {
        WebElement nameField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[1]/input[1]"));
        nameField.sendKeys("Software Verification and Validation");

        WebElement maxMarksField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[2]/input[1]"));
        maxMarksField.sendKeys("100");

        WebElement dateField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[3]/input"));
        dateField.sendKeys("08-10-2023");

        WebElement courseIdField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[1]/input[2]"));
        courseIdField.sendKeys("1");

        WebElement passMarksField = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[2]/input[2]"));
        passMarksField.sendKeys("95");

        WebElement addButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div/div[3]/button"));
        addButton.click();
    }

    @Then("the exam is added successfully")
    public void exam_is_added_successfully() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement messageElement = driver.findElement(By.xpath("/html/body/div[2]/strong"));
        String expectedMessage = "Exam Added Successfully";

        String actualMessage = messageElement.getText();

        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Exam addition failed. Actual message: " + actualMessage);
        }
    }





    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
