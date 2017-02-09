package tests.steps.search_steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import pages.GoogleLandingPage;
import tests.steps.DriverFactory;

public class SearchSteps extends DriverFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Given("^the user sees the google search page$")
	public void the_user_sees_the_google_search_page() throws Throwable {
		Serenity.takeScreenshot();
		openApp();
		Serenity.takeScreenshot();
	}

	@When("^the user decides to search for Serenity and Maven ([^\"]*)$")
	public void the_user_decides_to_search_for_Serenity_and_Maven(String searchValue) throws Throwable {
	    new GoogleLandingPage(driver).userSearchForSerenityAndMaven(searchValue);
	}

	@When("^the user clicks the Search icon$")
	public void the_user_clicks_the_Search_icon() throws Throwable {
		new GoogleLandingPage(driver).userClicksTheSearchIcon();
	}

	@Then("^the user should see results on Serenity and Maven$")
	public void the_user_shouls_see_results_on_Serenity_and_Maven() throws Throwable {
		
		Serenity.takeScreenshot();
		new GoogleLandingPage(driver).validateSearchResults();
	}
	@After()
	public void tearDown(Scenario scenario) {
		System.out.println(scenario.isFailed() + " DDDDDDDDDd");
	 /*   if (scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png"); //stick it in the report
	    }*/
	    driver.quit();
	}

}
