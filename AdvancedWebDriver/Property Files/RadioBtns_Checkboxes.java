package com.blog.junitTests;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioBtns_Checkboxes {
	// Declaring variables
	private WebDriver driver;
	private String baseUrl;
	Properties props; 

	@Before
	public void setUp() throws Exception {
		// Creates an empty property list
		props = new Properties();
		// A connection is created to config.properties file
		FileInputStream fis = new FileInputStream("resources//config.properties");
		// Reads the properties from the input byte stream
		props.load(fis);
		// Get the firefox driver path from property file
		String firefoxPath = props.getProperty("firefoxPath");
		// Assign the URL to be invoked to a String variable
		baseUrl = props.getProperty("baseUrl");

		// Mention the property where required
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		// Create a new instance for the class FirefoxDriver
		// that implements WebDriver interface
		driver = new FirefoxDriver();
		// Implicit wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void testPageTitle() throws Exception {
		// Open baseUrl in Firefox browser window
		driver.get(baseUrl);

		// Locate 'Tricycle' checkbox using name
		WebElement tricycleCheckbox = driver.findElement(By.name("vehicle2"));
		// Check if tricyle is displayed
		System.out.println("Is tricycle displayed? "+ tricycleCheckbox.isDisplayed());
		
		// Check if tricyle is enabled to select
		if (tricycleCheckbox.isEnabled()) {
			// Click if enabled
			tricycleCheckbox.click();
		} else {
			// Print message to console if disabled
			System.out.println("Unable to select 'Tricycle' checkbox as it is disabled.");
		}
		
		//Get all checkbox elements in a list
		List<WebElement> list = driver.findElements(By
				.cssSelector("input[type='checkbox']"));

		// Loops through all checkboxe elements
		for (int i = 0; i < list.size(); i++) {
			// Checking if the checkbox is a 'Van' or 'SUV'
			if ((list.get(i).getAttribute("value").trim()
					.equalsIgnoreCase("van"))
					|| (list.get(i).getAttribute("value").trim()
							.equalsIgnoreCase("suv"))) {
				// Print selection status to console
				System.out.println("BEFORE: Is "
						+ list.get(i).getAttribute("value") + " selected? "
						+ list.get(i).isSelected());
				// Check if the checkbox is selected
				if (!(list.get(i).isSelected())) {
					// Click the checkbox
					list.get(i).click();
					System.out.println("AFTER: Is "
							+ list.get(i).getAttribute("value") + " selected? "
							+ list.get(i).isSelected());
				} else {
					// Uncheck the checkbox
					list.get(i).click();
					System.out.println("AFTER: Is "
							+ list.get(i).getAttribute("value") + " selected? "
							+ list.get(i).isSelected());
				}
				System.out.println("Next...");
			}
		}
		// Locate 'Sedan' checkbox using xPath
		WebElement sedanCheckbox = driver.findElement(By
				.xpath("//input[@name='vehicle5']"));
		System.out.println("Trying to select and de-select Sedan checkbox...");
		for (int i = 0; i < 2; i++) {
			// Click the checkbox
			sedanCheckbox.click();
			// Print current status to console
			System.out.println("Selection status of 'Sedan' checkbox: "
					+ sedanCheckbox.isSelected());
		}
		// Locate 'Magazines' radio button using cssSelector
		WebElement magazinesRadioBtn = driver.findElement(By
				.cssSelector("input[value='Magazines']"));
		// Check if radio button is selected by default
		if (magazinesRadioBtn.isSelected()) {
			// Print message to console
			System.out.println("Magazines radio button is selected by default");
		} else {
			// Click the radio button
			magazinesRadioBtn.click();
		}
		
	} //End of @Test

	@After
	public void tearDown() throws Exception {
		// Close the Firefox browser
		driver.close();
	}
}
