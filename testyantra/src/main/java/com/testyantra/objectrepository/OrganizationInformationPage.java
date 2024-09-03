package com.testyantra.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
public OrganizationInformationPage(WebDriver driver ) {
	PageFactory.initElements(driver, this);
	//OrganizationInformationPage.class = this
}
@FindBy(className  ="dvHeaderText")
private WebElement headerorganizationinformation;
@FindBy(className="dvHeaderText")
private WebElement headerorganizationwithindustry;
public WebElement getheaderorganizationwithindustry() {
	return headerorganizationwithindustry;
}
public WebElement getheaderorganizationinformation() {
	return headerorganizationinformation;
}
}
