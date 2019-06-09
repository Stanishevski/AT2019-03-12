package by.it.okoyro.cucumber;

// add dependencies cucumber-java and cucumber-testNG into pom.xml

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/by/it/okoyro/cucumber", // set path to .feature file
		glue = "by.it.okoyro.cucumber", // set path to package with scenario realization (test code)
		snippets = SnippetType.CAMELCASE
)

public class BddAviaTest extends AbstractTestNGCucumberTests { 
}
