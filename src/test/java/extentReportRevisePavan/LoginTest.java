package extentReportRevisePavan;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver=null;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		 driver= new ChromeDriver();
		
		
	}

	@Test
	public void logintest()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername4']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
	}
	
	@AfterClass
	public void closebrowser()
	{
		
	}
	
	@AfterMethod
	public void capturescreen(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot ts= (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
			FileUtils.copyFile(source, target);
			System.out.println("screenshot captured");
			
		}
	}
	
}
