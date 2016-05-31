package au.edu.rmit.its;

import static org.junit.Assert.assertTrue;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");
	private WebDriver driver;
	private final static Logger logger = Logger.getLogger(AppTest.class);

	

	@Before
	public void beforeTest() throws Exception {
		try {
			driver = Setup.BrowserSetup(myResources.getString("driver.browser"), driver);
		} catch (Exception e) {
			logger.info("failed at setting up webdriver");
			e.printStackTrace();
		}

		if (driver == null) {
			throw new Exception("Driver Setup is not done properly.");
		}
		logger.debug("before test complete");
	}

	@Test
	public void testLogin() throws InterruptedException {

		driver.get(myResources.getString("website.url"));
		driver.manage().window().maximize();

		WebElement headerTitle = driver.findElement(By.xpath("//*[@id='appName']"));
		String headingTitleText = headerTitle.getText();

		assertTrue(headingTitleText.contains("Central"));
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(myResources.getString("user.name"));
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(myResources.getString("user.password"));
		driver.findElement(By.xpath("//*[@id='fm1']/div[3]/input[4]")).click();

		
		Thread.sleep(5000);

		WebElement message = driver.findElement(By.xpath("//*[@id='status']"));

		assertTrue(message.getText().contains("ID or password invalid"));
	}
}
