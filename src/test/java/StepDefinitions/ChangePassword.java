package StepDefinitions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ChangePassword {
	
	WebDriver driver;
	String resetLink;

    @Given("the user is on the login-page")
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

    @When("the user clicks the forgot password link")
    public void the_user_clicks_the_forgot_password_link() {
        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot password"));
        forgotPasswordLink.click();
    }


    @When("the user types the username")
    public void the_user_types_the_username() {
    	WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("abdul");
    }

    @When("the user clicks the reset password button")
    public void the_user_clicks_the_reset_password_button() {
        // Add code for clicking the reset password button
        WebElement resetButton = driver.findElement(By.xpath("//button[contains(text(),'Reset Password')]"));
        resetButton.click();
    }

    @When("the user enters the reset link")
    public void the_user_enters_the_reset_link() throws InterruptedException {
        // Add code for entering the reset link
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the reset link: ");
        resetLink = scanner.nextLine();
        scanner.close();

    }

    @When("the user enters the new password")
    public void the_user_enters_the_new_password() {
        String newPassword = "Abdul123!@#";
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='password1']"));
        WebElement confirmPasswordField = driver.findElement(By.cssSelector("input[name='password2']"));
        passwordField.sendKeys(newPassword);
        confirmPasswordField.sendKeys(newPassword);
    }


    @When("the user clicks the return to login page")
    public void the_user_clicks_the_return_to_login_page() {
        // Add code for clicking the return to login page
        WebElement returnToLoginButton = driver.findElement(By.xpath("//a[contains(text(),'Return To Login')]"));
        returnToLoginButton.click();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        // Add code for verifying if the user is redirected to the login page
        String expectedUrl = "https://akmalice.pythonanywhere.com/login"; // Replace with the expected login page URL
        String currentUrl = driver.getCurrentUrl();

        if (!currentUrl.equals(expectedUrl)) {
            throw new RuntimeException("User is not redirected to the login page.");
        }
        else
        {
        	System.out.println("Password Changed sucessfully");
        }
    }
}
