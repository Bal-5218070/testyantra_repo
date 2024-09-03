package com.testyantra.generic.webdriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
//threadlocal class
public static	ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
//extent report object
public static	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
//if any body wants to use my extent test object
public static ExtentTest getTest() {
	return test.get();
	//this method will give the extent report object for the multiple thread when you achive parallee execution
	
}
public static void setTest(ExtentTest actTest) {
	test.set(actTest);
}

public static WebDriver getDriver() {
	return driver.get();
	//this method will give the extent report object for the multiple thread when you achive parallee execution
	
}
public static void setDriver(WebDriver actDriver ) {
	driver.set(actDriver);
}
//basically this class helps us to share my static varaible for multiple threads in case parallel execution


}
