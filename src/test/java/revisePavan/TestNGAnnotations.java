package revisePavan;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	/*@BeforeMethod
	void login()
	{
		System.out.println("This is Login");
	}
@AfterMethod
	void logout()
	{
		System.out.println("This is Logout");
	}*/
	
	
/*	@BeforeClass
	void login()
	{
		System.out.println("This is Login");
	}
	
	@AfterClass
	void logout()
	{
		System.out.println("This is Logout");
	}
	*/
	
	
	
	
	@Test(priority=2 ,dependsOnMethods= {"recharge"})
	void search()
	{
		System.out.println("This is search");
	}
	@Test(priority=3 ,enabled=false)
	void advsearch()
	{
		System.out.println("This is advsearch");
	}
	@Test(priority=1)
	void recharge()
	{
		System.out.println("This is recharge");
		//Assert.assertTrue(false);
	}
}
