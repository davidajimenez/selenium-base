package au.edu.rmit.its;

import java.util.ResourceBundle;

import org.junit.After;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
	
	ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");
	WebDriver driver;
	
	@After
	public void afterTest() {
		driver.quit();
	}
}
