package com.testyantra.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.testyantra.BaseUtility.BaseClass;
import com.testyantra.generic.webdriverUtility.WebDriverUtility;
import com.testyantra.objectrepository.CreatingNewOrganizationPage;
import com.testyantra.objectrepository.HomePage;
import com.testyantra.objectrepository.OrganizationInformationPage;
import com.testyantra.objectrepository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
@Test
public void createOrganizationTest() throws EncryptedDocumentException, IOException {
	String organization =eutil.getDataFromExcel("org", 1, 2)+jutil.getRandomNumber();
	HomePage page =new HomePage(driver);
	page.getorganizationlink().click();
	OrganizationsPage op =new OrganizationsPage(driver);
	op.getorganizationlookupButton().click();
	CreatingNewOrganizationPage cnop =new CreatingNewOrganizationPage(driver);
	cnop.getorganizationtextfield().sendKeys(organization);
	cnop.getsaveButton().click();
	OrganizationInformationPage oip= new OrganizationInformationPage(driver);
	String actualinformation = oip.getheaderorganizationinformation().getText();
	if(actualinformation.contains(organization)) {
		System.out.println(actualinformation+"information is veryfied");
	}
	else
	{
		System.out.println("information is not verified");
	}
}
@Test
public void createOrganizationWithIndustry() throws EncryptedDocumentException, IOException {
	String organization =eutil.getDataFromExcel("org", 1, 2)+jutil.getRandomNumber();
	String industry=eutil.getDataFromExcel("org", 1, 6);
	String type=eutil.getDataFromExcel("org", 1, 7);
	HomePage page =new HomePage(driver);
	page.getorganizationlink().click();
	OrganizationsPage op =new OrganizationsPage(driver);
	op.getorganizationlookupButton().click();
	CreatingNewOrganizationPage cnop =new CreatingNewOrganizationPage(driver);
	cnop.getorganizationtextfield().sendKeys(organization);
	
	  WebDriverUtility wutil =new WebDriverUtility();
	  
	  wutil.select(cnop.getindustrytest(), industry ); 
	  wutil.select(cnop.getaccountTypetext(),type );
	 
	//WebElement industrytextfield = driver.findElement(By.name("industry"));
	//Select sel =new Select(industrytextfield);
//	sel.selectByVisibleText(industry);
	//WebElement accounttextfield = driver.findElement(By.name("accounttype") );
//	Select sect=new Select(accounttextfield);
	//sect.selectByVisibleText(type);
	cnop.getsaveButton().click();
	OrganizationInformationPage oip= new OrganizationInformationPage(driver);
	String actualinformation = oip.getheaderorganizationwithindustry().getText();
	if(actualinformation.contains(organization)) {
		System.out.println(actualinformation+"information is veryfied");
	}
	else
	{
		System.out.println("information is not verified");
	}
	
}
}
