package tests.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
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
	private static final String CHROME = "Chrome";
	private static final String FIREFOX = "firefox";

	public void openApp() {

		System.out.println(System.getProperties());
		if (System.getProperty("user.dir").contains("ernst")) { // geckodriver
			System.setProperty("webdriver.chrome.driver",
					"/Users/Ernst/Desktop/EXE/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();

			driver.get(HTTP_PVN_SYMBIOTICS_CO_ZA);
			driver.manage().window().maximize();
		} else {
			System.setProperty("webdriver.gecko.driver", "/Users/Ernst/Desktop/EXE/chromedriver_win32/geckodriver.exe");
			 driver = new FirefoxDriver();
			driver.get(HTTP_PVN_SYMBIOTICS_CO_ZA);
			 String sTitle = driver.getTitle();
		        System.out.println(sTitle);
			driver.manage().window().maximize();

		}
		/*
		 * driver = new FirefoxDriver(); driver.get(HTTP_PVN_SYMBIOTICS_CO_ZA);
		 * driver.manage().window().maximize();
		 */
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
