package com.testyantra.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {

	@FindBy(xpath="//img[@alt=Create Product...")
	private WebElement createProductImgBtn;

	@FindBy(name="searchbtn")
	private WebElement ele6;

	@FindBy(name="search")
	private WebElement ele2;
	@FindBy(name="search")
	private WebElement ele3;
	@FindBy(name="search")
	private WebElement ele4;
}
