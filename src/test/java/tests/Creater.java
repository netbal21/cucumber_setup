package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty",
		"html:target/cucumber-html-report" },
features = "src/test/resources/features/TestPack A Google Search/Search for Serenity And Maven.feature")
public class Creater {

	/*
	 * /cucumber_jira_sp17/src/test/resources/features/Valuations/Valuation End
	 * to End/EndToEnd.feature /cucumber_jira_sp17/src/test/resources/Temp
	 * Placeholder/Valuations/CreatedValuations/HubCompleteValuation/
	 * CompletedtoHubValuer.feature
	 * Valuations/CreatedValuations/HubCompleteValuation/CompletedToManager.
	 * feature
	 */
}
