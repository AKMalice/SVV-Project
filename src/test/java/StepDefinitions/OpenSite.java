package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class OpenSite {

    WebDriver driver;

    @Given("the browser is open")
    public void the_browser_is_open() {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath); // Print the project path
        String driverPath = projectPath + "/src/test/resources/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @When("the user navigates to the NOVA website")
    public void the_user_navigates_to_the_nova_website() {
        // Navigate to the NOVA website
        driver.get("https://www.saucedemo.com/"); // Replace with the actual URL
    }

    @Then("the user should be on the NOVA website")
    public void the_user_should_be_on_the_nova_website() {
        // Verify the current URL to confirm that the user is on the NOVA website
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("akmalice.pythonanywhere.com")) {
            System.out.println("User is on the NOVA website");
        } else {
            System.out.println("User is not on the NOVA website");
        }
        driver.quit();
    }
}
