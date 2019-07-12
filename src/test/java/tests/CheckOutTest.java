package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        plugin = "json:target/cucumber-report.json",
        glue = "steps"
)
public class CheckOutTest  extends AbstractTestNGCucumberTests {
}
