package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleLandingPage {
	WebDriver driver;

	public GoogleLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public By searchTxt = By.id("lst-ib");
	public By searchIcon = By.id("_fZl");
	public By searchResult = By.linkText("Building Serenity projects in Maven - Symbiotics");
	
	public void userSearchForSerenityAndMaven(String searchValue) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(searchTxt).sendKeys(searchValue);
	}

	public void userClicksTheSearchIcon() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(searchIcon).click();
	}
	
	

	public void validateSearchResults() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(searchResult).isDisplayed();
		
	} 
}
