package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Analytics {
	
    WebDriver driver;

    @Given("the user is logged in as an admin")
    public void the_user_is_logged_in_as_an_admin() {
    	  String projectPath = System.getProperty("user.dir");
          System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
          driver.manage().window().maximize();
          driver.get("https://akmalice.pythonanywhere.com/login");

          WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
          WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
          usernameField.sendKeys("guestadmin");
          passwordField.sendKeys("123456");
          WebElement loginButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div[1]/button"));
          loginButton.click();
    }

    @When("the user goes to the analytics page")
    public void the_user_goes_to_the_analytics_page() {
    	driver.get("https://akmalice.pythonanywhere.com/admin-analytics");
    }

    @When("selects report to generate")
    public void selects_report_to_generate() {
        // Write code here to select the report to generate
        WebElement dropDownElement = driver.findElement(By.name("exam")); // Assuming the 'name' attribute is 'exam' for the drop-down
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByIndex(2); // Select the second option (index 2) from the drop-down
        
        WebElement generateButton = driver.findElement(By.xpath("//button[@type='submit']")); // Adjust the XPath accordingly
        generateButton.click();
    }

    @Then("analytics data is generated")
    public void analytics_data_is_generated() {
        // Write code here to verify that analytics data is generated
        WebElement imageElement = driver.findElement(By.cssSelector("img")); // Adjust the CSS selector accordingly
        boolean isImageDisplayed = imageElement.isDisplayed();
        if (isImageDisplayed) {
            System.out.println("Analytics Generated successfully!");
        } else {
            System.out.println("Failed to Generate Analytics");
        }
    }
    
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
