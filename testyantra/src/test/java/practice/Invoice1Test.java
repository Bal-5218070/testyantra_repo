package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testyantra.BaseUtility.BaseClass;

public class Invoice1Test extends BaseClass {
	@Test(retryAnalyzer =com.testyantra.listenerutility.RetryListenerclass.class )//path of implementation class
	public void activateSimTest() {
		System.out.println("createinvoicetest");
		//
		String acttitle = driver.getTitle();
	//	Assert.assertEquals(acttitle, "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
}
}