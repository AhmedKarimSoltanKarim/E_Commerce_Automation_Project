package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@AllTests",
        features = "src/main/resources/Features",
        glue = "StepDefinitions"
)

public class Runner extends AbstractTestNGCucumberTests {
}
