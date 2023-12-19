package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.time.Duration;

public class DriverFactory {
    static AppiumDriver driver;
    public static  AppiumDriver getDriver() {
        return driver;
    }

    public static void startAppiumServer() {
        System.out.println("Starting Appium server...");
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
        System.out.println("Appium service started successfully.");

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setPlatformName("Android")
                .setPlatformVersion("12.0")
                .setAutomationName("UiAutomator2")
                .setAvdReadyTimeout(Duration.ofSeconds(5))
                .setAvdLaunchTimeout(Duration.ofSeconds(10))
                .setApp("C:/Users/Lenovo2/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk")
                .eventTimings();

        System.out.println("Initializing Appium driver...");
        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void stopAppiumServer() {
        if (driver != null) {
            driver.quit();
        }
    }
}