package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class SetupHooks {

    @Before
    public void setUp() {
        DriverFactory.startAppiumServer();
    }

    @After
    public void tearDown() {
        DriverFactory.stopAppiumServer();
    }
}