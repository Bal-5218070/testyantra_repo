package com.testyantra.listenerutility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testyantra.BaseUtility.BaseClass;
import com.testyantra.generic.webdriverUtility.UtilityClassObject;

public class ListenerImpClass implements ITestListener,ISuiteListener{
public ExtentSparkReporter spark;
public  static ExtentTest test;
public  ExtentReports report;// if you want to use this report in every testcase make this varaible static
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("reportconfiguratio");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		 spark =new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("CRM TEst Suite results");//what should be title of page
			spark.config().setReportName("CRM report");
			spark.config().setTheme(Theme.DARK);

			//add Envoronment information and create tset
			 report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("os", "Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");
			//we have implemented this method to configure the report
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("reportbackup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====>"+result.getMethod().getMethodName()+">=========START==========");
		 test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);//how to set this
		 //to create testcase inside testcase i know onteststart method is going to execute before executing the test case
//before executing my test case i want to write some statement
		 test.log(Status.INFO, result.getMethod().getMethodName()+"===> STARTED");
	
	
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====>"+result.getMethod().getMethodName()+">=========END==========");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"===> COMPLETED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		//in how we want browser session id
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		
		String srcFile= ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(srcFile, testName+"_"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"===> FAIL");
		//if want to overcome the overide of screeshot in this case i will add time stamp
		/*
		 * try { FileUtils.copyFile(srcFile, new
		 * File("./Screenshot/"+testName+"+"+time+".png")); //screenshot name mustbe
		 * same as failed testcase } catch (Exception e) { // TODO: handle exception
		 * e.printStackTrace(); }
		 */
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// test.log(Status.SKIP, result.getMethod().getMethodName()+"===> SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
