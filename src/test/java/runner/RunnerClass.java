package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="features/Bidder-BidProduct.feature",glue= {"steps/BidderBidProductSteps"})
@CucumberOptions(
features="features",
glue= {"steps"})
//dryRun = true)
public class RunnerClass {

}