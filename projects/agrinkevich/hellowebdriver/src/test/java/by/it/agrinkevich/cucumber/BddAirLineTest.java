package by.it.agrinkevich.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/by/it/agrinkevich/cucumber",
        glue = "by.it.agrinkevich.cucumber",
        snippets = SnippetType.CAMELCASE
)

public class BddAirLineTest extends AbstractTestNGCucumberTests {
}


