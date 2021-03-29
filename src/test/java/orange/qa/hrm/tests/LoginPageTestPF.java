package orange.qa.hrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPagePF;

public class LoginPageTestPF {
	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPagePF loginPagePF;
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPagePF = new LoginPagePF(driver);
	}
	
	@Test
	public void loginTest(){
		loginPagePF.doLogin();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
