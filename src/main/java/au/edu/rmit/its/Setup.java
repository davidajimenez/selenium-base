package au.edu.rmit.its;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class Setup {

	private final static Logger logger = Logger.getLogger(Setup.class);
	private final static ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");

	public static WebDriver BrowserSetup(String browser, WebDriver driver) throws Exception {
		String browser1 = myResources.getString("driver.browser");
		switch (browser1) {
		case "FF":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			File file = new File("chromedriver.exe");

            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}
}
