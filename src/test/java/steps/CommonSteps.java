package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

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
}