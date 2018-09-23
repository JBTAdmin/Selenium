package com.blog.junitTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutorTest {
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
		Thread.sleep(5000);
		
		// Typecast driver to JavascriptExecutor
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		// Execute JavaScript code and assign it to a String
		String pageURL = (String)jsExecutor.executeScript("return document.URL;");
		// Print the URL to the console
		System.out.println("URL : " + pageURL);
		// Print the URL without JavaScript to the console
		System.out.println("URL without JavascriptExecutor: " + driver.getCurrentUrl());
		// Scroll down by 100 pixels
		jsExecutor.executeScript("window.scrollBy(0,100)");
		// Refresh the page
		jsExecutor.executeScript("history.go(0)");
		// Navigating to a different page
		jsExecutor.executeScript("window.location = 'https://www.google.com/';");
		
	} // End of @Test

	@After
	public void tearDown() throws Exception {
		// Close the Firefox browser
		driver.close();
	}
}
