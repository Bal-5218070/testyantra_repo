package com.testyantra.contacttest;

import java.io.IOException;
//if you want to run testscript via xml file dont need to give listener annotation 
//other wise it will give null pointer exception cannot invoke extent tests

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testyantra.BaseUtility.BaseClass;
import com.testyantra.generic.webdriverUtility.UtilityClassObject;
import com.testyantra.generic.webdriverUtility.WebDriverUtility;
import com.testyantra.listenerutility.ListenerImpClass;
import com.testyantra.objectrepository.ContactPage;
import com.testyantra.objectrepository.CreateinformationPage;
import com.testyantra.objectrepository.CreatingNewContactPage;
import com.testyantra.objectrepository.CreatingNewOrganizationPage;
import com.testyantra.objectrepository.HomePage;
import com.testyantra.objectrepository.OrganizationsPage;

//@Listeners(com.testyantra.listenerutility.ListenerImpClass.class)
public class CreateContactTest extends BaseClass {
	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		// read testscriptdata from excel
		// ListenerImpClass.test.log(Status.INFO, "read data from excel");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastname = eutil.getDataFromExcel("org", 1, 5) + jutil.getRandomNumber();
		// nevigate to contact module
		// ListenerImpClass.test.log(Status.INFO, "nevigate to contact module");
		UtilityClassObject.getTest().log(Status.INFO, "nevigate to contact module");
		HomePage page = new HomePage(driver);
		page.getContactlink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbutton().click();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastnametextfield().sendKeys(lastname);
		// craete contact
		// ListenerImpClass.test.log(Status.INFO, "nevigate to contact module");
		cncp.getSavebutton().click();
		CreateinformationPage cip = new CreateinformationPage(driver);
		String headercontactinformation = cip.getHeadercontactinformation().getText();
		Assert.assertTrue(headercontactinformation.contains(lastname));
		/*
		 * if (headercontactinformation.contains(lastname)) {
		 * System.out.println(headercontactinformation + "information is verified"); }
		 * else { System.out.println("information is not verified"); }
		 */
	}

	@Test
	public void createContactWithPhoneNumber() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastname = eutil.getDataFromExcel("org", 1, 5) + jutil.getRandomNumber();
		String pnonenumber = eutil.getDataFromExcel("org", 1, 3);
		HomePage page = new HomePage(driver);
		page.getContactlink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbutton().click();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastnametextfield().sendKeys(lastname);
		cncp.getphonenumbertextfield().sendKeys(pnonenumber);
		cncp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO, "nevigate to contact module");
		CreateinformationPage cip = new CreateinformationPage(driver);
		String contactinformation = cip.getheaderwithcontactnumberinformation().getText();
		Assert.assertTrue(contactinformation.contains(lastname));
		/*
		 * if (contactinformation.contains(lastname)) {
		 * System.out.println(contactinformation + "information is verified"); } else {
		 * System.out.println("information is not verified"); }
		 */
	}

	@Test
	public void createContactWithOrganizationTest() throws EncryptedDocumentException, IOException, Throwable {
		// read testscriptdata

		// low level log
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastname = eutil.getDataFromExcel("org", 1, 5) + jutil.getRandomNumber();

		String orgnizationname = eutil.getDataFromExcel("org", 1, 2) + jutil.getRandomNumber();

		// nevigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		HomePage page = new HomePage(driver);
		page.getorganizationlink().click();
		OrganizationsPage page1 = new OrganizationsPage(driver);
		page1.getorganizationlookupButton().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getorganizationtextfield().sendKeys(orgnizationname);
		cnop.getsaveButton().click();
		Thread.sleep(2000);
		// ask by sir
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.waitForElementPresent(driver, page.getContactlink());

		page.getContactlink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbutton().click(); // in case of display some information we
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastnametextfield().sendKeys(lastname);

		cncp.getSelectOrganizationbutton().click();

		wutil.switchToChildBrowser(driver, "module=Accounts");
		driver.findElement(By.name("search_text")).sendKeys(orgnizationname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgnizationname + "']")).click();
		wutil.switchToParentBrowser(driver, "module=Contacts&action=EditView&return_action");
		cncp.getSavebutton().click();

	}
}
