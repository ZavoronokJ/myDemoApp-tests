package steps;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CommonSteps {
    private final AppiumDriver driver;

    public CommonSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @And("User is in {string} page")
    public void userIsInPage(String page) {
        String logout = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + page + "\")")).getText();
        assertEquals(logout, page);
    }

    @Then("User clicks {string} menu item")
    public void userClicksLogOutMenuItem(String name) {
        driver.findElement(AppiumBy.xpath("//*[@content-desc=\"open menu\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item " + name)).click();
    }

    @Then("User is navigated to product details page")
    public void userIsNavigatedToProductDetailsPage() {
        WebElement productDescription = driver.findElement(AppiumBy.accessibilityId("product description"));
        assertTrue(productDescription.isDisplayed());
    }

    @When("User clicks at {string} button")
    public void userClicksAtButton(String id) {
        WebElement button = driver.findElement(AppiumBy.accessibilityId(id));
        button.click();
    }

    @Then("User is auto redirected to {string} page")
    public void userIsAutoRedirectedToPage(String page) {
        String pageName = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + page + "\")")).getText();
        assertEquals(pageName, page);
    }

    @Given("User scrolls down the page")
    public void userScrollsDownThePage() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                ImmutableMap.builder()
                        .put("left", 404)
                        .put("top", 400)
                        .put("width", 110)
                        .put("height", 1200)
                        .put("direction", "down")
                        .put("percent", 0.85)
                        .build());
    }
}