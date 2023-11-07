package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 glue = "StepDefinitions",
                		 plugin = {"pretty", "json:target/cucumber-reports/CucumberTestReport.json", "html:target/cucumber-reports/CucumberTestReport.html"})

public class TestRunner {
}

