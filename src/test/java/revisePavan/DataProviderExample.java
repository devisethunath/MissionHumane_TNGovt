package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	WebDriver driver=null;
	@BeforeClass
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
			
			Thread.sleep(10000);
		
	}
	
	@Test(dataProvider="users")
	public void logintest(String username, String password) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		driver.navigate().back();
		
	}
	@DataProvider(name="users")
	String[][] logindata()
	{
		String data[][]= {{"Admin","admin123"},{"adf","asd"},{"asfg","sdff"}};
		return data;
	}
	@AfterClass
	public void close()
	{
		
	}
}
