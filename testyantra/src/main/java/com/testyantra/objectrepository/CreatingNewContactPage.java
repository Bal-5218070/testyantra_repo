package com.testyantra.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	public CreatingNewContactPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnametextfield;
	@FindBy(xpath = ("(//input[@title=\"Save [Alt+S]\"])[1]"))
	private WebElement savebutton;
	@FindBy(id = "mobile")
	private WebElement phonenumbertextfield;
	@FindBy(xpath = ("//input[@name='account_name']/following-sibling::img"))
	private WebElement selectOrganizationbutton;

	public WebElement getSelectOrganizationbutton() {
		return selectOrganizationbutton;
	}

	public WebElement getphonenumbertextfield() {
		return phonenumbertextfield;
	}

	public WebElement getLastnametextfield() {
		return lastnametextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

}
