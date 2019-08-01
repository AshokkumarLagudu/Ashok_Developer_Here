package com.PageClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;

public class DocumentationPage extends BaseClass {
	
	
	public DocumentationPage(){
		super();
	}
	
	public List<WebElement> findAllLinks(){
		List<WebElement> links=driver.findElements(By.xpath("//div[@class='documentation-link-group']//a"));
		return links;
	}
	
	public void validateLinks(List<WebElement> links){
		String url="";
		HttpURLConnection htconn = null;
		int respCode = 200;
		Iterator<WebElement> iter = links.iterator();
		while (iter.hasNext()) {
			url = iter.next().getAttribute("href");
			System.out.println(url);
			if (url == null || url.isEmpty()) {
				System.out.println("URL not configured for anchor tag or it is empty");
				continue;
			}
			
			
			try {
				htconn = (HttpURLConnection)(new URL(url).openConnection());
				htconn.setRequestMethod("HEAD");
				htconn.connect();

				respCode = htconn.getResponseCode();
				System.out.println("Response Cose :"+respCode);

				if (respCode >= 400) {
					System.out.println(url + " is broken link");
				} else {
					System.out.println(url + " is valid link");
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	public String getPageTitle(){
		String title=driver.getTitle();
		
		return title;
	}
	

}
