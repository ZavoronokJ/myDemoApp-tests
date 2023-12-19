package steps;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ProductsPageSteps {
    private final AppiumDriver driver;

    public ProductsPageSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @Given("User scrolls down the page")
    public void userScrollsDownThePage() throws InterruptedException{
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                ImmutableMap.builder()
                        .put("left", 404)
                        .put("top", 400)
                        .put("width", 110)
                        .put("height", 1500)
                        .put("direction", "down")
                        .put("percent", 0.85)
                        .build());
    }

    @When("User should see a continuous list of products")
    public void userShouldSeeAContinuousListOfProducts() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String lastProductTitleText = driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"Test.allTheThings() T-Shirt\")")).getAttribute("displayed");
        assertTrue(lastProductTitleText.contains("true"));
    }

    @Then("User sees products in the list where product photo, title, price and rating is displayed")
    public void userSeesProductsInTheListWithVisibleAttributes() throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> elements = driver.findElements(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"store item\")"
        ));

        assertFalse(elements.isEmpty());

        for (WebElement element : elements) {
            WebElement productImage = element.findElement(AppiumBy.xpath("//android.view.ViewGroup[1]"));
            assertTrue(productImage.isDisplayed());

            WebElement productTitle = element.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"store item text\")"
            ));

            assertTrue(productTitle.isDisplayed());

            WebElement productPrice = element.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"store item price\")"
            ));

            assertTrue(productPrice.isDisplayed());

            WebElement productRating = element.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionStartsWith(\"review star\")"
            ));

            assertTrue(productRating.isDisplayed());
        }
    }

    @Given("User selects {int} product in the list")
    public void userSelectsProductInTheList(Integer index) {

        WebElement element = driver.findElement(AppiumBy.xpath(
                "(//*[@content-desc=\"store item\"])[" + index + "]/android.view.ViewGroup[1]"
        ));

        element.click();
    }

    @Given("User clicks on first product {int} rating star")
    public void userClicksOnFirstProductRatingStar(Integer number) {
        WebElement productRating = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"review star "+ number +"\")"
        ));

        productRating.click();
    }

    @When("User sees popup with the message {string}")
    public void userSeesPopupWithTheMessage(String message) {
        WebElement popup = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + message + "\")"));

        assertTrue(popup.isDisplayed());
    }

    @Then("User clicks on popup close button")
    public void userClicksOnPopupCloseButton() {
        WebElement button = driver.findElement(AppiumBy.androidUIAutomator("text(\"Close Modal\")"));
        button.click();
    }

    @Then("Popup is not displayed")
    public void popupIsNotDisplayed() throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> elements = driver.findElements(AppiumBy.accessibilityId("Close Modal button"));

        assertEquals(0, elements.size());
    }
}