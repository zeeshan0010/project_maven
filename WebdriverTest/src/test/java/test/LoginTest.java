package test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;

import POs.LoginFormPO;
import POs.LoginSuccessPO;


public class LoginTest extends DriverLifeCycleSetting {
	
  private LoginFormPO login;
  private LoginSuccessPO loginSuccess;
  private WebDriver driver;
  
  @ParameterizedTest
  @EnumSource(Browser.class)
  public void testLoginOK(Browser browser) throws InterruptedException {
	 driver=DriverLifeCycleSetting.getNewDriverInstance(browser);
	 login = new LoginFormPO(driver);
	 loginSuccess = (LoginSuccessPO) login.with("user","user"); 
	 assertTrue(loginSuccess.successBoxIsPresent());
	 driver.quit();
		
  }
  
  @ParameterizedTest
  @EnumSource(Browser.class)
  public void testLoginNoOK(Browser browser) {
	 driver= DriverLifeCycleSetting.getNewDriverInstance(browser);
	 login = new LoginFormPO(driver);
	 login.with("user", "error"); 
	 assertTrue(login.invalidBoxIsPresent());
	 driver.quit();
  }
}
