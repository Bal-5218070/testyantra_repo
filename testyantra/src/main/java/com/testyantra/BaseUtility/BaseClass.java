package com.testyantra.BaseUtility;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testyantra.generic.databaseUtility.DataBaseUtility;
import com.testyantra.generic.fileUtility.ExcelUtility;
import com.testyantra.generic.fileUtility.FileUtility;
import com.testyantra.generic.webdriverUtility.JavaUtility;
import com.testyantra.generic.webdriverUtility.UtilityClassObject;
import com.testyantra.generic.webdriverUtility.WebDriverUtility;
import com.testyantra.objectrepository.HomePage;
import com.testyantra.objectrepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver =null;

public FileUtility futil =new FileUtility();
public  ExcelUtility eutil =new ExcelUtility();
public JavaUtility jutil =new JavaUtility();
public WebDriverUtility wutil= new WebDriverUtility();
public DataBaseUtility dbutil =new DataBaseUtility();

public static WebDriver sdriver=null;

@BeforeSuite
public void configBs() {
	System.out.println("connect to db");
	dbutil.getDataBaseConnection();
	// i will put breakpoint on my first line base class program
}
@BeforeClass
public void configBc() throws IOException {
	System.out.println("launch the browser");
	String BROWSER = futil.getDataFromPropertyFile("browser");
	if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("edge")) {
		driver =new EdgeDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	sdriver=driver;
	UtilityClassObject.setDriver(driver);
}
@BeforeMethod
public void configBm() throws IOException {
	System.out.println("login to application");
	String URL = futil.getDataFromPropertyFile("url");
	String USERNAME = futil.getDataFromPropertyFile("username");
	String PASSWORD = futil.getDataFromPropertyFile("password");
	LoginPage page =new LoginPage(driver);
	page.login(URL, USERNAME, PASSWORD);
	
}
@AfterMethod
public void configAm() throws InterruptedException {
	System.out.println("logout from the application");
	HomePage page =new HomePage(driver);
			page.logout();
			
			
}
@AfterClass
public void configAc() {
	System.out.println("close the browser");
	driver.close();
}
@AfterSuite
public void configAs() {
	System.out.println("close the database connection");
	
}
}
