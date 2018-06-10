package com.blog.junitTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotTest {
	//Declaring variables
	private WebDriver driver; 
	private String baseUrl;
	private String testCaseName = "ScreenshotTest";

	@Before
	public void setUp() throws Exception{
		// Selenium version 3 beta releases require system property set up
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\"
				+ "Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		// Create a new instance for the class FirefoxDriver
		// that implements WebDriver interface
		driver = new FirefoxDriver();
		// Implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Assign the URL to be invoked to a String variable
		baseUrl = "https://accounts.google.com/SignUp";
	}
	
	@Test
	public void testPageTitle() throws Exception{
		// Open baseUrl in Firefox browser window
		driver.get(baseUrl);
		// Locate First Name text box by id and
		// assign it to a variable of type WebElement
		WebElement firstName = driver.findElement(By.id("firstName"));
		// Clear the default placeholder or any value present
		firstName.clear();
		// Enter/type the value to the text box
		firstName.sendKeys("fname01");
		// Locate last name text box by name
		WebElement lastName = driver.findElement(By.name("lastName"));
		// Clear and enter a value
		lastName.clear();
		lastName.sendKeys("lname01");
		//Take a screenshot
		SaveScreenshot.capture(testCaseName, driver);
	}
	
	 @After
	  public void tearDown() throws Exception{
		// Close the Firefox browser
		driver.close();
	}
}
