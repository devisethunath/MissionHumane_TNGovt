package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LoginTestOnWindowsWithChrome {


	WebDriver driver;

	@	Test(priority=1)


	void setup() throws MalformedURLException 
	{
		String nodeUrl=" http://192.168.0.17:37636/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		driver= new  RemoteWebDriver(new URL(nodeUrl),cap);
	}


	@Test(priority=2)
	void login()
	{
		driver.get("http://practice.automationtesting.in/my-account/");
		driver.findElement(By.name("username")).sendKeys("devisethunath@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Devi@1983!@#$");
		driver.findElement(By.xpath("//input[@name='login']")).click();

		String capText=driver.findElement(By.xpath("//strong[normalize-space()='devisethunath']")).getText();
		if(capText.contains("devisethunath"))
		{
			System.out.println("test passed");

		}

		else
		{
			System.out.println("test failed");
		}
driver.close();	}

}
