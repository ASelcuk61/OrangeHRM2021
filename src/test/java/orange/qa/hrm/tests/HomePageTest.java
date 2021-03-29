package orange.qa.hrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;


public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		//homePage = loginPage.doLogin("Admin","admin123");
		
		homePage = loginPage.doLogin(properties.getProperty("username"),
				properties.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitle(){
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test
	public void verifyHeader(){
		Assert.assertEquals(homePage.getPageHeader(), "Dashboard");
	}
	
	@Test
	public void verifyAccountName(){
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println(accountName);
		Assert.assertTrue(accountName.contains("Welcome"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
