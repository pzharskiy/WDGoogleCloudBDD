package stepsdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverSingleton;

public class ScenarioHooks {
    @Before
    public void beforeScenario() {
    }

    @After
    public void afterScenario() {
        DriverSingleton.closeDriver();
    }

}

