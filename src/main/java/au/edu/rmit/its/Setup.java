package au.edu.rmit.its;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class Setup {


	public static WebDriver BrowserSetup(Browser browser, WebDriver driver) throws Exception {
		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case IE:
			driver = new InternetExplorerDriver();
			break;
		case CHROME:
			File file = new File("chromedriver.exe");

            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}
}
