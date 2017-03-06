package tests.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.steps.ScenarioSteps;

public abstract class DriverFactory extends ScenarioSteps {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static WebDriver driver;
	public String browser;

	private static final String HTTP_PVN_SYMBIOTICS_CO_ZA = "https://www.google.co.za/";

	public void openApp() {

	
	/*		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"C:/Program Files/phantomjs-2.1.1-windows/bin/phantomjs.exe");*/
		
		

				System.setProperty("webdriver.chrome.driver",
						"C:/Program Files (x86)/Jenkins/plugins/chromedriver/WEB-INF/lib/chromedriver.exe");
		
			driver = new ChromeDriver();

			driver.get(HTTP_PVN_SYMBIOTICS_CO_ZA);
			driver.manage().window().maximize();
		
		
	}

	public void manageWait() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		DriverFactory.driver = driver;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void userLogon(String logonUser, String logonPassword) throws Throwable {

		driver.findElement(By.id("usernameTxt")).sendKeys(logonUser);
		driver.findElement(By.id("passwordTxt")).sendKeys(logonPassword);
		driver.findElement(By.id("kc-login")).click();

	}

	public void quitDriver() {
		try {
			driver.quit();
			driver = null;

		} catch (NullPointerException e) {
			return;
		}

	}

}
