package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testyantra.BaseUtility.BaseClass;
//@Listeners(com.testyantra.listenerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass {
@Test
public void craeteInvoiceTest() {
	System.out.println("createinvoicetest");
	String acttitle = driver.getTitle();
	Assert.assertEquals(acttitle, "login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
	
}
@Test
public void createinvoicewithcontactTest() {
	System.out.println("createinvoicewithcontactTest");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
}
