package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertEquals;

public class LogoutSteps {
    private final AppiumDriver driver;

    public LogoutSteps() {
        this.driver = DriverFactory.getDriver();
    }
    @Given("User logged in")
    public void userLoggedIn() {
        driver.findElement(AppiumBy.xpath("//*[@content-desc=\"open menu\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
    }

    @Given("User sees popup with a message {string}")
    public void userSeesPopupWithAMessage(String message) {
        String popupMessage = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + message + "\")")).getText();
        assertEquals(popupMessage, message);
    }

    @When("User clicks on {string} button")
    public void userClicksOnButton(String button) {
        driver.findElement(AppiumBy.androidUIAutomator("text(\"" + button + "\")")).click();
    }

    @Then("User is auto redirected to {string} page")
    public void userIsAutoRedirectedToPage(String page) {
        String pageName = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + page + "\")")).getText();
        assertEquals(pageName, page);
    }
}