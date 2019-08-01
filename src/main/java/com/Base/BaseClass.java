package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.DriverFactory;
import com.Utils.ReusableMethods;

public class BaseClass {
	
	public static WebDriver driver=null;
	public static WebDriverWait driverWait;
	public static Properties prop=null;
	
	public BaseClass(){
		
		try {
			
			FileInputStream file=new FileInputStream(new File(ReusableMethods.configFilePath));
			prop=new Properties();
			prop.load(file);
		
		
		} catch (FileNotFoundException e) {
			System.out.println("Properties File not found at given location");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//intialising the browser
	public void initialise(){
		if(!prop.getProperty("browser").isEmpty()&&!prop.getProperty("browserDriverPath").isEmpty()){
			
			driver=DriverFactory.getWebDriver(prop.getProperty("browser"),prop.getProperty("browserDriverPath"));

		}else{
			System.out.println("*** Please give BrowserName and driverPath in config properties file ***");
		}
		
		driverWait=new WebDriverWait(driver,ReusableMethods.webDriverWait);
		
		
	}

	//wait for element until element to be clickable
	public void waitForElementClickable(WebElement element){
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//close the browser
	public void killBrowser(){
		driver.quit();
	}
	
}



















