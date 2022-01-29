package tesatNGListenersPVN;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.annotations.Test;

 public class LoginTest {

	@Test
	void stup()
	{
		Assert.assertTrue(false);
	}

	@Test
	void loginByEmail()
	{
		Assert.assertTrue(true);
	}
	
	
	@Test(dependsOnMethods={"stup"})
	void LoginByFacebook()
	{
		Assert.assertTrue(true);
	}

}
