package test;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

import test.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {
	
	 
	public static WebDriver  getNewDriverInstance(Browser browser)
	{
		
		switch(browser) {
			case CHROME:
				WebDriverManager.chromedriver().setup();;
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				return new ChromeDriver(options);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options1 = new FirefoxOptions();
				options.addArguments("--headless");
				
				return new FirefoxDriver(options1);
			case EDGE:
				WebDriverManager.edgedriver().setup();
				EdgeOptions options2 = new EdgeOptions();
				options.addArguments("--headless");
				
				
				return new EdgeDriver(options2);
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
