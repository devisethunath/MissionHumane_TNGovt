package revisePavan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver=null;

	@	Parameters("browser")
	@Test(priority=1)

	public void launchbrowser(String br)
	{   if (br.equals("chrome"))

	{System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
	driver= new ChromeDriver();}

	else if (br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C://Users/sethu/Downloads/geckodriver-v0.30.0-win64/geckodriver.exe");
		driver= new FirefoxDriver();}
	
	driver.get("http://google.com");
	}


	@Test(priority=2)
	public void m2()
	{
		System.out.println("method2");
	}
	@Test(priority=3)
	public void m3()
	{
		System.out.println("method3");
	}

}
