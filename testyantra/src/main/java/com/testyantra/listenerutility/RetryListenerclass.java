package com.testyantra.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerclass implements IRetryAnalyzer {
int count=0;
int limitcount=5;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limitcount) {
			count++;
			return true;
		}
		return false;
	}
//if ypu want to execute this functionality in your testcase
}
