package reporting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginClass {

	static WebDriver driver;

	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		 driver=new ChromeDriver();
		//driver.get("https://www.google.com/");
	}

	@Test
	public void LoginTest()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Assert.assertEquals(driver.getTitle(), "irkuda - Google Search");

	}

	@AfterClass
	public void closeBrowser()
	{
		driver.close();

	}
	
	//Capture screen shot
	
	
	@AfterMethod
	public void captureScreen(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		
		{TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);//capture screenshot file
		
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot captured");
		
		
		
		}
	}

}
