package test;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import test.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {

	 
	public static WebDriver  getNewDriverInstance(Browser browser)
	{
		switch(browser) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver();
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();;
				return new FirefoxDriver();
			case EDGE:
				WebDriverManager.edgedriver().setup();
				return new EdgeDriver();
			default:
				throw new IllegalArgumentException();
		}
	}
	
	

//	@BeforeAll
//	public static void beforeAll() {
//		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriverManager.edgedriver().setup();
//	}
//
//	@BeforeEach
//	
//	public void beforeEach() {
////		driver = new ChromeDriver();
//	//	DriverFactory.getNewDriverInstance(browser);
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	}
//
//	@AfterEach
//	public void afterEach() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
}
