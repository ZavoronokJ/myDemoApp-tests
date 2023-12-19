package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SortProductsSteps {
    private final AppiumDriver driver;

    public SortProductsSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @Given("User is on Sort by page")
    public void userIsOnSortByPage() {
        driver.findElement(AppiumBy.xpath("//*[@content-desc=\"sort button\"]")).click();
    }

    @Given("User sees popup with sort criteria")
    public void userSeesPopupWithSortCriteria(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement sortBy = driver.findElement(AppiumBy.androidUIAutomator("textContains(\"Sort by:\")"));
        Assert.assertTrue(sortBy.isDisplayed());
    }

    @Then("User sees first product title is {string}")
    public void userSeesFirstProductTitleIs(String title) {
        String element = driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item text\")")).get(0).getText();
        assertEquals(element, title);
    }
}