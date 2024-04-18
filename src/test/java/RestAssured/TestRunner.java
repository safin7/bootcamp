package RestAssured;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue="RestAssured"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
