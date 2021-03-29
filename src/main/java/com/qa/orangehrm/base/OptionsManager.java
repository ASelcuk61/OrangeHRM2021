package com.qa.orangehrm.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	// Fields
	public ChromeOptions cOptions;
	public FirefoxOptions fOptions;
	public Properties properties;
	
	public OptionsManager(Properties properties) {
		this.properties = properties;
	}
	
	public ChromeOptions getChromeOptions(){
		cOptions = new ChromeOptions();
		if(properties.get("incognito").equals("yes"))
			cOptions.addArguments("--incognito");
		if (properties.getProperty("headless").equals("yes"))
			cOptions.addArguments("--headless");
		
		return cOptions;
	}
	
	public FirefoxOptions getFireFoxOptions(){
		fOptions = new FirefoxOptions();
		if(properties.get("incognito").equals("yes"))
			fOptions.addArguments("--incognito");
		if (properties.getProperty("headless").equals("yes"))
			fOptions.addArguments("--headless");
		
		return fOptions;
	}
}
