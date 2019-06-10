package by.it.stanishevski.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/by/it/stanishevski/cucumber",
        glue = "by.it.stanishevski.cucumber",
        snippets = SnippetType.CAMELCASE
)
public class BddAirLineTest extends AbstractTestNGCucumberTests {
}
