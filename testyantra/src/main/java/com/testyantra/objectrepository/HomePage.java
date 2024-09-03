 package com.testyantra.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testyantra.generic.webdriverUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorlink;
@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
private WebElement logoutlink;

@FindBy(linkText="Products")
private WebElement productLink;

 
public WebElement getProductLink() {
	return productLink;
}
@FindBy(linkText="Contacts")
private WebElement contactlink;
@FindBy(xpath="//a[text()='Organizations']")
private WebElement organizationlink;
public WebElement getorganizationlink() {
	return organizationlink;
}

public WebElement getAdministratorlink() {
	return administratorlink;
}




/**
 * @return the contactlink
 */
public WebElement getContactlink() {
	return contactlink;
}




public WebElement getLogoutlink() {
	return logoutlink;
}

public void logout() throws InterruptedException {
	WebDriverUtility wutil =new WebDriverUtility();
	Thread.sleep(2000);
	wutil.moVeToElement(driver, administratorlink);
	logoutlink.click();
}




}
