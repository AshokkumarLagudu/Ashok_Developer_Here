package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.Base.BaseClass;
import com.PageClasses.Aviva_Home_Page;
import com.PageClasses.DocumentationPage;
import com.Utils.ReusableMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition_Documentaion extends BaseClass {
	
	DocumentationPage documentationPage;
	Aviva_Home_Page avivaHomePage;
	
	//opening browser
	@Given("^open browser$")
	public void _open_browser() throws Throwable {
		documentationPage=new DocumentationPage();
		avivaHomePage=new Aviva_Home_Page();
		initialise();
	}

	
	//Enter url
	@When("^enter \"([^\"]*)\"$")
	public void enter(String arg) throws Throwable {
	    if(arg.equals("ulr")){
	    	driver.get(prop.getProperty("url"));
	    }else if(arg.equals("avivaURL")){
	    	driver.get(prop.getProperty("avivaURL"));

	    }
	}


	//validating page title
	@Then("^validate page title$")
	public void _validate_page_title() throws Throwable {
		String pageTitle=documentationPage.getPageTitle();
		System.out.println("documentationPage Title : "+pageTitle);
		Assert.assertEquals(ReusableMethods.titleOfTheDocumentationPage, pageTitle);
	    
	}

	//getting all links present in the page
	@Then("^get linkes presen in the page$")
	public void _get_linkes_presen_in_the_page() throws Throwable {
		int totalLinks=documentationPage.findAllLinks().size();
		System.out.println("Number of links presen in documentation page : "+totalLinks);
	}

	//validating all links
	@Then("^validate all links$")
	public void _validate_all_links() throws Throwable {
		
		List<WebElement> links=documentationPage.findAllLinks();
		documentationPage.validateLinks(links);
		
	    
	}

	@Then("^Verify page title$")
	public void Verify_page_title() throws Throwable {
	   String title= avivaHomePage.getPageTitle();
	    Assert.assertEquals(prop.getProperty("avivaHomePageTitle"), title);
	}

	@Then("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    avivaHomePage.clickOnLogin();;
	}
	
	//closing the browser
	@Then("^close browser$")
	public void close_browser() throws Throwable {
	   
		killBrowser();
	}



}
