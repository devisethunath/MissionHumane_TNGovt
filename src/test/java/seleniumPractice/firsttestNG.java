package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class firsttestNG {




	@Test
	public void f() {

		Reporter.log("Inside first  Test method");
	}

	@Test
	public void f1() {

		Reporter.log("Inside Second  Test method");
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Inside Before Test method");
	}




	@AfterTest
	public void afterTest() {

		Reporter.log("Inside After  Test method");
	}

}
