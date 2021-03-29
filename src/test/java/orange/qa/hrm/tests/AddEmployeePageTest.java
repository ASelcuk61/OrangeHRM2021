package orange.qa.hrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.AddEmployeePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.util.ExcelUtil;

public class AddEmployeePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	AddEmployeePage addEmployeePage;
	
	@BeforeTest
	public void setup(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		
		homePage = loginPage.doLogin(properties.getProperty("username"),
				properties.getProperty("password"));
		addEmployeePage = new AddEmployeePage(driver);
		addEmployeePage.goToAddEmployee();
		
	}
	
	@Test
	public void verifyAddEmployeeHeader(){
		String header = addEmployeePage.getAddEmployeePageHeader();
		Assert.assertEquals(header, "Add Employee");
	}
	
	@DataProvider
	public Object[][] getContactData(){
		Object [][] data = ExcelUtil.getTestData("Employees");
		return data;
	}
	
	@Test(dataProvider = "getContactData")
	public void addEmployee(String name, String lastname){
		addEmployeePage.goToAddEmployee();
		addEmployeePage.addEmployee(name, lastname);
	}

	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
