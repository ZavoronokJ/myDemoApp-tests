package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.sql.Driver;

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