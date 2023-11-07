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

public class MakeAnnouncement {

    WebDriver driver;

    @Given("the user is logged in as admin")
    public void the_user_is_logged_in_as_admin() {
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

    @When("the user goes to the dashboard")
    public void the_user_goes_to_the_dashboard() {
        driver.get("https://akmalice.pythonanywhere.com/dashboard");
    }

    @And("types an announcement text and sends it")
    public void types_announcement_text_and_sends_it() {
        WebElement announcementField = driver.findElement(By.id("textArea"));
        announcementField.sendKeys("This is a test announcement made by Admin Akhil using Cucumber while others are writing workbooks");

        WebElement sendButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div[2]/button"));
        sendButton.click();
    }

    @And("the user checks if the announcement is successful")
    public void the_user_checks_if_the_announcement_is_successful() {
        boolean announcementSuccess = isAnnouncementSuccessful(driver, "This is a test announcement made by Admin Akhil using Cucumber while others are writing workbooks");
        if (announcementSuccess) {
            System.out.println("Announcement was made successfully!");
        } else {
            System.out.println("Announcement was not made as expected.");
        }
    }

    public boolean isAnnouncementSuccessful(WebDriver driver, String expectedText) {
        WebElement announcementHeader = driver.findElement(By.xpath("/html/body/div[3]/div/h3"));
        String actualText = announcementHeader.getText();

        return actualText.equals(expectedText);
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
