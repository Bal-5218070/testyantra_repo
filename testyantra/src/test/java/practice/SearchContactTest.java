package practice;
/**
 * 
 * test class for Contact module
 * @author Balkrishna
 */

import org.testng.annotations.Test;

import com.testyantra.BaseUtility.BaseClass;
import com.testyantra.objectrepository.LoginPage;

public class SearchContactTest extends BaseClass{
 
 /* login()==>navigateContact==>createcontact()==verify*/
 
	@Test
	public void searchContactTest() {
		/*
		 * step 1:login to app
		 */
	LoginPage lp =new LoginPage(driver);
	lp.login("url", "username", "password");
	}
}
