package runners;

import io.cucumber.testng.CucumberOptions;

public class SmokeTests {


    @CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
    public class RunCukesTest {
        // ..
    }


}
