package com.testyantra.generic.webdriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForpageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchToChildBrowser(WebDriver driver, String partialchildurl) {
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> it = allids.iterator();
		while (it.hasNext()) {
			String id = it.next();
			driver.switchTo().window(id);
			String childurl = driver.getCurrentUrl();
			if (childurl.contains("module=Accounts")) {
				break;
			}
		}
	}

	public void switchToParentBrowser(WebDriver driver, String partialParenturl) {
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> it = allids.iterator();
		while (it.hasNext()) {
			String id = it.next();
			driver.switchTo().window(id);
			String parenturl = driver.getCurrentUrl();
			if (parenturl.contains("module=Contacts&action=EditView&return_action")) {
				break;
			}
		}
	}

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void moVeToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
}