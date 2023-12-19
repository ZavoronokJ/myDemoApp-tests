package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.AssertJUnit.*;
import static steps.DriverFactory.driver;

public class ProductDetailedPage {
    @Given("User sees product with title, description, photo, price, rating, color, count, and an Add to cart button")
    public void userSeesProductWithTitleDescriptionPhotoPriceStarRatingColorCountAndAnButton() {
        WebElement title = driver.findElement(AppiumBy.accessibilityId("container header"));
        assertTrue(title.isDisplayed());

        WebElement description = driver.findElement(AppiumBy.accessibilityId("product description"));
        assertTrue(description.isDisplayed());

        WebElement photo = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"product screen\"]/android.view.ViewGroup/android.widget.ImageView"));
        assertTrue(photo.isDisplayed());

        WebElement price = driver.findElement(AppiumBy.accessibilityId("product price"));
        assertTrue(price.isDisplayed());

        List<WebElement> ratings = driver.findElements(AppiumBy.androidUIAutomator(
                "new UiSelector().descriptionStartsWith(\"review star\")"
        ));
        assertEquals(5, ratings.size());

        List<WebElement> colors = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"circle\")"));
        assertFalse(colors.isEmpty());

        WebElement count = driver.findElement(AppiumBy.accessibilityId("counter amount"));
        assertTrue(count.isDisplayed());

        WebElement button = driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        assertTrue(button.isDisplayed());
    }

    @When("User increase product amount")
    public void userIncreaseProductAmount() {
        driver.findElement(AppiumBy.accessibilityId("counter plus button")).click();
    }

    @Then("User select {string} color")
    public void userSelectColor(String color) {
        driver.findElement(AppiumBy.accessibilityId(color + " circle")).click();
    }

    @Then("Cart badge should display the total count of {string} in the cart")
    public void cartBadgeShouldDisplayTheTotalCountOfItemsInTheCart(String amount) {
        WebElement productCart = driver.findElement(AppiumBy.xpath("//*[@content-desc=\"cart badge\"]/android.widget.TextView"));
        assertEquals(amount, productCart.getText());
    }
}
