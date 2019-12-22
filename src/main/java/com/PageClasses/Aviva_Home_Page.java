package com.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;



////li[@class='o-masthead__login-link']//ul/li/a[contains(text(),'MyAviva')]
public class Aviva_Home_Page extends BaseClass {
	
	@FindBy(xpath="//li/ul/li/a[contains(text(),'MyAviva')]")
	WebElement login;
	
	public Aviva_Home_Page(){
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle(){
		
		String title=driver.getTitle();
		
		return title;
	}
	
	public void clickOnLogin(){
		WebElement lgn=driver.findElement(By.xpath("//li/ul/li/a[contains(text(),'MyAviva')]"));
		waitForElementClickable(lgn);
		lgn.click();
	}
}
