package CucumberTestingDemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "CucumberTestingDemo",
        plugin = {
                "pretty",
                "html:test-output/cucumber_report/cucumber-html-report.html"
        },
        monochrome = true
)


public class TestRunner extends AbstractTestNGCucumberTests {
}
