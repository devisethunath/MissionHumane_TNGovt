package parameterisationPVN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver=null;

	@Parameters("browser")

	@Test(priority=1)
	public void launchbrowser(String br) {

		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
			 driver=new ChromeDriver();}
		else
			if (br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C://Users/sethu/Downloads/geckodriver-v0.30.0-win64/geckodriver.exe");//opens browser
				 driver=new FirefoxDriver();
			}

		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}




	@Test(priority=2)
	public void verifytitle() {

		Assert.assertEquals(driver.getTitle(),"Automation Testing Practice");

	}


	@Test(priority=3)
	public void registration() {
		//Registration process
		
		Assert.assertTrue(true);

	}


	@Test(priority=4)
	public void closebrowser() {
		driver.close();
	}
}
