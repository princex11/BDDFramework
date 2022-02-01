package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\Prince\\eclipse-workspace\\BDDFramework\\src\\test\\java\\feature\\signup.feature"
        , "C:\\Users\\Prince\\eclipse-workspace\\BDDFramework\\src\\test\\java\\feature\\addToCart.feature"}
        , glue = "stepDefinition"
        , stepNotifications = true
        , plugin = {"pretty", "html:target/report.html"}
        , tags = "~@a_signup or @b_addLaptopToCart"
)

public class TestRunner {

}
