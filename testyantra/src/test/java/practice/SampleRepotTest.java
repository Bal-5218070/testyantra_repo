package practice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleRepotTest {
	public ExtentTest test;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	@BeforeSuite
	public void configBS() {
		//spark report config
		 spark =new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM TEst Suite results");//what should be title of page
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		//add Envoronment information and create tset
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	@AfterSuite
	public void configAS() {
		report.flush();
	}
@Test

public void createContactTest() {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	TakesScreenshot ts = (TakesScreenshot)driver;
	String source=ts.getScreenshotAs(OutputType.BASE64);//extent report support base64
	
	
	
 test=report.createTest("createContactTest");//create test return the object of extenttext 
test.log(Status.INFO, " login to app");
	test.log(Status.INFO," nevigate to contactPage");
test.log	(Status.INFO," create contact");
	if("hdFc".equals("hdfc")) {
		test.log(Status.PASS,"contact is created ");
	}
	else {
		test.addScreenCaptureFromBase64String(source, "errorfile");
	}
	
	test.log(Status.INFO," login to app");
	driver.close();
}
@Test

public void createContactWithOrgTest() {
	
	
ExtentTest test=report.createTest("createContactWithOrgTest");//create test return the object of extenttext 
test.log(Status.INFO, " login to app");
	test.log(Status.INFO," nevigate to contactPage");
test.log	(Status.INFO," create contact");
	if("hdfc".equals("hdfc")) {
		test.log(Status.PASS,"contact is created ");
	}
	else {
		test.log(Status.FAIL,"contact is not created");
	}
	
	test.log(Status.INFO," login to app");
}
@Test

public void createContactWithPhoneTest() {
	
	
ExtentTest test=report.createTest("createContactWithPhoneTest");//create test return the object of extenttext 
test.log(Status.INFO, " login to app");
	test.log(Status.INFO," nevigate to contactPage");
test.log	(Status.INFO," create contact");
	if("hdfc".equals("hdfc")) {
		test.log(Status.PASS,"contact is created ");
	}
	else {
		test.log(Status.FAIL,"contact is not created");
	}
	
	test.log(Status.INFO," login to app");
}
}
