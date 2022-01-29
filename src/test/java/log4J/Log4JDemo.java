package log4J;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class Log4JDemo {

	static Logger logger;

	@Test(priority=1)
	public void setup()

	{
		logger=Logger.getLogger("Log4JDemo");          //provide testname or class name
		PropertyConfigurator.configure("Log4J.properties");



		logger.info("setup is started");

		logger.info("setup method is in progress");

		//Configuration setup code here
		System.out.println("This is set up method");
	}


	@Test(priority=2)

	public void login()
	{

		logger.info("login is started");
		System.out.println("This is login test // actual write code here");
	}


	@Test(priority=3)
	public void logout()
	{
		logger.info("logout  is started");
		System.out.println("This is logout method ");
	}

}
