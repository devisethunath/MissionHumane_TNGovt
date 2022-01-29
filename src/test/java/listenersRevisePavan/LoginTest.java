package listenersRevisePavan;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {

	@Test
	public void setup()
	{
		Assert.assertTrue(false);
	}
	@Test
	public void loginbyemail()
	{Assert.assertTrue(true);
	}

	@Test(dependsOnMethods="setup")
	public void loginbyfacebook()
	{Assert.assertTrue(true);
	}


}


