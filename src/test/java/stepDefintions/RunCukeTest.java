package stepDefintions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		tags = "@feature",
		glue = {"stepDefintions"},
		plugin = {"pretty", "html:target/cucumber-reports.html"}
)

public class RunCukeTest {
	
}
