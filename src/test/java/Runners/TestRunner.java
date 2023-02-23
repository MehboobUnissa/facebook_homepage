package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "Steps", publish = true,
        plugin = {"pretty","json:target/cucumber-reports.json"},
        monochrome = true, tags="@smoke")
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider()
    public Object[][] scenarios(){
        return super.scenarios();
    }
}


