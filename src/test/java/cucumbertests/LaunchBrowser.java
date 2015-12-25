package cucumbertests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by sagar on 06-12-2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/main/resources/features"})
public class LaunchBrowser {
}
