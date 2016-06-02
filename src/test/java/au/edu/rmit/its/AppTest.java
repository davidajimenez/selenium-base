package au.edu.rmit.its;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {

	
	private final static Logger logger = Logger.getLogger(AppTest.class);
	private Browser browser = Browser.CHROME;
	

	@Before
	public void beforeTest() throws Exception {
		try {
			driver = Setup.BrowserSetup(browser, driver);
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
	public void testLoginInvalid() throws InterruptedException {

		driver.get(myResources.getString("website.url"));
		//driver.manage().window().maximize();

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
	
	@Test
	public void testCopyrightValue() {
		driver.get(myResources.getString("website.url"));
		WebElement footer = driver.findElement(By.xpath("//*[@id='footerContent']/p"));
		String footerText = footer.getText();
 
		assertTrue(footerText.contains("2013"));
	}
	
	
}
