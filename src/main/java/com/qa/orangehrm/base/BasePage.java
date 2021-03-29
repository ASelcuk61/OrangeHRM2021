package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.orangehrm.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {	
	// Fields, driver, properties
	
	WebDriver driver;
	Properties properties;
	OptionsManager optionsManager;
	
	// initialize driver
	
	public WebDriver initialize_driver(){
		properties = initialize_properties();
		optionsManager = new OptionsManager(properties);
		String browser = properties.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		} 
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFireFoxOptions());
		}
		else {
			System.out.println("Undefined Browser");
		}
		
		// List all options here
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		return driver;
	}
	
	
	// initializing properties
	public Properties initialize_properties(){
		properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(
					 ".//src//main//java//com//qa//orangehrm"
					+ "//config//config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			
		}
		return properties;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
