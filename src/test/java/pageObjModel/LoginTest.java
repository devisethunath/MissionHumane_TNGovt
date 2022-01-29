package pageObjModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {


	WebDriver driver;

	@BeforeClass
	void setup()
	{
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//opens url
	}
	@Test
	void login()
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickSubmit();
	}
}
