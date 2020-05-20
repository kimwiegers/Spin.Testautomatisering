package Steps.Setup;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = {"cucumber.hook", "cucumber.steps"})

public class CucumberRunTest {
}
