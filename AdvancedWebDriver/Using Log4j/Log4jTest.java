package com.blog.junitTests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4jTest {
	// Declaring variables
	private WebDriver driver;
	private String baseUrl;
	private Logger log;

	@Before
	public void setUp() throws Exception {
		// System property set up for Chrome driver
		System.setProperty("webdriver.chrome.driver", "browser-drivers\\chromedriver.exe");
		// Create a new instance for the class ChromeDriver
		// that implements WebDriver interface
		driver = new ChromeDriver();
		// Implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Assign the URL to be invoked to a String variable
		baseUrl = "https://chandanachaitanya.github.io/selenium-practice-site/";
		
		// Create a logger instance and pass Class name which is Log4jTest in this case
		log = Logger.getLogger("SeleniumTestLogger");
	}
	
	@Test
	public void testElementsWithLogging() throws Exception {
		// Open baseUrl in Chrome browser window
		driver.get(baseUrl);
		log.debug("opening selenium-practice-site");
		
		// Locate 'Bicycle' checkbox using name
		WebElement bicycle = driver.findElement(By.name("vehicle1"));
		// Click the checkbox
		bicycle.click();
		log.debug("Bicycle checkbox selected");
		
		// Locate 'Magazines' radio button using cssSelector
		WebElement magazinesRadioBtn = driver.findElement(By
			.cssSelector("input[value='Magazines']"));
		// Click the radio button
		magazinesRadioBtn.click();
		log.debug("Magazines radio button clicked");
		log.debug("Log4jTest executed successfully");
		
	} // End of @Test

	@After
	public void tearDown() throws Exception {
		// Close the Firefox browser
		//driver.close();
		System.out.println("Closing the driver");
	}
}