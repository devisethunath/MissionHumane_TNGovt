package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest_pvn {


	@Test(priority=3,enabled=false)
	public void f() {
		System.out.println("this is search");
	}

	@Test(priority=2)
	public void f1() {
		System.out.println("this is advsearch");
	}
	
	
	@Test(priority=1)
	public void f2() {
		System.out.println("open url");
	}

	@BeforeMethod
	public void beforeMethod() {


		System.out.println("this is login");
	}


	@AfterMethod
	public void afterMethod() {
		System.out.println("this is logout");
	}

}
