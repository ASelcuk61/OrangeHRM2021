package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.util.ElementUtil;

public class AddEmployeePage extends BasePage {
	
	
	// fields, locators, driver, elementUtil
	WebDriver driver;
	ElementUtil elementUtil;
	// firstName,lastName,btnSave
	// header xpath : //h1[contains(text(),'Add Employee')]
	// //b[contains(text(),'PIM')]
	// menu_pim_addEmployee
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By btnSave = By.id("btnSave");
	By header = By.xpath("//h1[contains(text(),'Add Employee')]");
	By clickPIM = By.xpath("//b[contains(text(),'PIM')]");
	By addEmployee = By.id("menu_pim_addEmployee");
	
	// constructor
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// methods
	
	public String getAddEmployeePageHeader(){
		return driver.findElement(header).getText();
	}
	
	public void goToAddEmployee(){
		driver.findElement(clickPIM).click();
		driver.findElement(addEmployee).click();
	}
	
	public void addEmployee(String firstName, String lastname){
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).sendKeys(lastname);
		driver.findElement(btnSave).click();
		
	}
	
	
	
	
	
}
