package com.blog.junitTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActions {
	// Declaring variables
	private WebDriver driver;
	private String baseUrl;

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
	}
	
	@Test
	public void testKeyboardAndMouseActions() throws Exception {
		// Open baseUrl in Chrome browser window
		driver.get(baseUrl);
		
		// Locate 'Bicycle' checkbox using name
		WebElement bicyle = driver.findElement(By.name("vehicle1"));
		// Locate 'Enter Text' textbox using id
		WebElement messageTextBox = driver.findElement(By.id("enterText"));
		// Locate 'click()' using id
		WebElement element = driver.findElement(By.id("click"));
		
		//Create an instance of the Actions Class
		Actions actions = new Actions(driver);
		
		// Perform multiple actions
		// Type 'hi there' in uppercase in the text box
		actions
			.moveToElement(messageTextBox)
			.keyDown(Keys.SHIFT)
			.sendKeys(messageTextBox, "hi there")
			.keyUp(Keys.SHIFT)
			.perform();
		// Click 'Bicycle' checkbox
		actions
			.click(bicyle)
			.perform();
		// Print a message to console
		System.out.println("Bicylce checkbox clicked.");
		// Double click/highlight the text, 'Message'
		actions
			.moveToElement(driver.findElement(By.id("labelText")))
			.doubleClick()
			.perform();
		// Print the text of the element that will be dragged and dropped
		System.out.println("Element that is dragged : " + element.getText());
		// Drag and drop 'click()' using Actions class
		actions
			.dragAndDropBy(element, 50, 100)
			.perform();

	} // End of @Test

	@After
	public void tearDown() throws Exception {
		// Close the Chrome browser
		driver.close();
		System.out.println("Closing the driver");
	}
}
