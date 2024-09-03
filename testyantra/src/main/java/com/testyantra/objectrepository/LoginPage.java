package com.testyantra.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testyantra.generic.webdriverUtility.WebDriverUtility;

public class LoginPage {
	/**
	 * this is how we can provide java doc
	 * @author Bal krishna
	 * Contains login page elements &businesss lib like login()
	 */
	WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="user_name")
private WebElement usernametestfield;
@FindBy(name="user_password")
private WebElement passwordtestfield;
@FindBy(id="submitButton")
private WebElement loginButton;
/**
 * @return the usernametestfield
 */
public WebElement getUsernametestfield() {
	return usernametestfield;
}
/**
 * @return the passwordtestfield
 */
public WebElement getPasswordtestfield() {
	return passwordtestfield;
}
/**
 * @return the loginButton
 */
public WebElement getLoginButton() {
	return loginButton;
}
/**
 * login to application based on username ,password ,url ,argument
 * @param url
 * @param username
 * @param password
 */
public void login(String url,String username,String password) {
	WebDriverUtility wutil=new WebDriverUtility();
	wutil.waitForpageToLoad(driver);
	driver.get(url);
	driver.manage().window().maximize();
	usernametestfield.sendKeys(username);
	passwordtestfield.sendKeys(password);
	loginButton.click();
	
}
}
