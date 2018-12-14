package com.blog.junitTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssertAndVerify {
	// Declaring variables
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		// Selenium version 3 beta releases require system property set up
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\"
				+ "Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		// Create a new instance for the class FirefoxDriver
		// that implements WebDriver interface
		driver = new FirefoxDriver();
		// Implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Assign the URL to be invoked to a String variable
		baseUrl = "https://chandanachaitanya.github.io/selenium-practice-site/";
	}
	
	@Test
	public void testPageTitle() throws Exception {
		// Open baseUrl in Firefox browser window
		driver.get(baseUrl);
		
		// Get the page title
		String pageTitle = driver.getTitle();
		// Print the title to console
		System.out.println("The actual title is: " + pageTitle);
		
		//CASE 1
		// Check if actual and expected values are equal
		Assert.assertEquals("WebDriver Demo Website", pageTitle);
		// Printing success message
		System.out.println("Assert equals passed.");
		
		//CASE 2
		// Making the test fail
		//Assert.assertNotEquals("WebDriver Demo Website", pageTitle);
		// Following lines will not be executed as above assert condition fails
		//System.out.println("Assert not equals failed");
		
		//CASE 3
		//Verify title not equal using try-catch block
		try {
			// Making the test fail
			Assert.assertNotEquals("WebDriver Demo Website", pageTitle);	
		} catch(Error e){
			// Following lines will be printed when the assert condition fails
			System.out.println("Assert not equals failed. But test execution is not aborted.");
			System.out.println("Error message: " + e.toString());
		}

	} // End of @Test

	@After
	public void tearDown() throws Exception {
		// Close the Firefox browser
		driver.close();
	}
}
