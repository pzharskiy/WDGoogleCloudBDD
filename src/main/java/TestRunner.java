import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


public class TestRunner {

/*    @CucumberOptions(
            strict = true,
            plugin = { "json:target/cucumber-report.json",
                    "html:target/cucumber-report"
            }
    )
    public class CucumberTestNGTest extends AbstractTestNGCucumberTests {
// some custom code stuff here
    }*/

    @RunWith(Cucumber.class)
    @CucumberOptions(
            strict = true,
            plugin = {
                    "pretty", "json:target/Cucumber.json",
                    "html:target/cucumber-html-report"
            }
    )
    public class RunTests {
// some custom code stuff here
    }



}
