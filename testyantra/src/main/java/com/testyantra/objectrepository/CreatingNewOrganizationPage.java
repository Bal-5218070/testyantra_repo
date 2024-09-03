package com.testyantra.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
public CreatingNewOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="accountname")
private WebElement organizationtextfield;
@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveButton;
@FindBy(name="industry")
private WebElement industrytext;
@FindBy(name="accounttype")
private WebElement accountTypetext;
public WebElement getaccountTypetext() {
	return accountTypetext;
}
public WebElement getindustrytest() {
	return industrytext;	
}
public WebElement getsaveButton() {
	return saveButton;
}
public WebElement getorganizationtextfield() {
	return organizationtextfield;
}
}
