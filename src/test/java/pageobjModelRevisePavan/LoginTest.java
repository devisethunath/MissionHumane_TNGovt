package pageobjModelRevisePavan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {


	WebDriver driver;

	@BeforeClass
	void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		 driver= new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

	}

	@Test
	void login()
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUsername("Admin");
		lp.setpassword("admin123");
		lp.click();
	}
}
