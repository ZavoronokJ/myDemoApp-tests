package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static steps.DriverFactory.driver;

public class CheckoutSteps {
    @And("User fills {string} input field with {string}")
    public void userFillsInputFieldWith(String field, String value) {
        driver.findElement(AppiumBy.accessibilityId(field + " input field")).sendKeys(value);
    }

    @And("User checks that his {string} contains {string}")
    public void userChecksThatHisContains(String accessibilityId, String value) {

        WebElement deliveryAddressElement = driver.findElement(AppiumBy.accessibilityId(accessibilityId));
        WebElement valueElement = deliveryAddressElement.findElement(AppiumBy.androidUIAutomator("textContains(\"" + value + "\")"));
        Assert.assertTrue(valueElement.isDisplayed());
    }

    @And("User clicks at {string}")
    public void userClicksAt(String cart) {
        driver.findElement(AppiumBy.xpath("//*[@content-desc=\"cart badge\"]")).click();
    }
}