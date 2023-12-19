package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import static org.junit.Assert.assertEquals;


public class LoginSteps {
    private final AppiumDriver driver;
    public LoginSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys(username);
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys(password);
    }
    @And("User clicks {string} button")
    public void userClicksLoginButton(String button) {
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
    }
    @Then("User successfully logins and sees {string} page")
    public void userSuccessfullyLogIn(String page) {
        String pageName = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + page + "\")")).getText();
        assertEquals(pageName, page);
    }

    @When("User enters invalid username {string} and password {string}")
    public void userEntersInvalidUsernameAndPassword(String username, String password) {
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys(username);
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys(password);
    }

    @Then("User get error message {string}")
    public void userGetErrorMessage(String message) {
        String errorMessage = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + message + "\")")).getText();
        assertEquals(errorMessage, message);
    }
}