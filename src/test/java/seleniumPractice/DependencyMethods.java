package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.testng.annotations.AfterTest;

public class DependencyMethods {



	@Test(priority=1)
	public void f() {
		;	  
		System.out.println("url opened");
		Assert.assertTrue(true);
	}


	@Test(priority=2 ,dependsOnMethods= {"f"})
	public void f1() {
		System.out.println("login");
		Assert.assertTrue(true);

	}

	@Test(priority=3,dependsOnMethods= {"f1"})
	public void f2() {
		System.out.println("search");
		Assert.assertTrue(false);

	}

	@Test(priority=4,dependsOnMethods= {"f1","f2"})
	public void f3() {
		System.out.println("adv search");
		Assert.assertTrue(true);
	}


	@Test(priority=5,dependsOnMethods= {"f1"})
	public void f4() {
		System.out.println("logout");
		Assert.assertTrue(true);
	}




	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
