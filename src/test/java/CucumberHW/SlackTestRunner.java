package CucumberHW;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/",
        glue = "CucumberHW",
        monochrome = true

)

public class SlackTestRunner extends AbstractTestNGCucumberTests {

}