package testRunner;

import org.junit.runner.RunWith;

import com.Utils.ReusableMethods;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\ASHOK\\workspace\\Ashok_Developer_Here\\src\\test\\java\\features\\document.feature",
		glue="stepDefinitions",
		format={"pretty","html:target/Documentation-report","junit:XmlReports/Documetation.xml",
				"json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
		monochrome=true,
		dryRun=false,
		tags={"@aviva"}
		
		)

public class Runner {
	
   
}
