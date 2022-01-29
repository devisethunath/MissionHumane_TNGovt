package log4jDemoRevisePavan;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
 
public class Log4jDemo {
	static Logger logger;
	
	
	@Test(priority=1)
	public void setup()
	{
		logger=Logger.getLogger("Log4jDemo");
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("setup started");
		System.out.println("this is setup method");
	}
	
	@Test(priority=2)
	public void login()
	{logger.info("login progress");
	}

	@Test(priority=3)
	public void logout()
	{logger.info("login complete");
	}
}
