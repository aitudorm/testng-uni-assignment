package dpack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

	// logger add and logger configs as well
	private static Logger logger = LogManager.getLogger(TestNG.class);
	public String baseUrl = "https://moodle.astanait.edu.kz/";
	public WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		// change path in order to correct launch
		System.setProperty("webdriver.gecko.driver", "/home/user/assignment6/Assignment6/driver/geckodriver/geckodriver"); 
		logger.info("launching Firefox browser");
		driver =  new FirefoxDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void verifyHomePageTitle() {
		// changing titles causes failure in test
		String expectedTitle = "Astana IT University";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		if (expectedTitle != actualTitle) {
			logger.error("Error");
		};
		
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
	

}
