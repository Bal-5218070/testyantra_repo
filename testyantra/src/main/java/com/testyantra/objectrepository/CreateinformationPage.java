package com.testyantra.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateinformationPage {
public CreateinformationPage(WebDriver driver ) {
	PageFactory.initElements(driver, this);
}
@FindBy(className="dvHeaderText")
private WebElement headercontactinformation;
@FindBy(className ="dvHeaderText")
private WebElement headerwithcontactnumberinformation;
public WebElement getheaderwithcontactnumberinformation() {
	return headerwithcontactnumberinformation;
}

public WebElement getHeadercontactinformation() {
	return headercontactinformation;
}

}
