package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.util.ElementUtil;

public class HomePage extends BasePage{
	// Driver
	WebDriver driver;
	
	//ElementUtil
	ElementUtil elementUtil;
	
	// Locator
	By header = By.xpath("//h1[contains(text(),'Dashboard')]");
	By accountName = By.id("welcome");
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// Methods
	public String getHomePageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public String getPageHeader(){
		WebElement element = driver.findElement(header);
		return element.getText();
	}
	
	public String getLoggedInUserAccountName(){
		return driver.findElement(accountName).getText();
	}
	

}
