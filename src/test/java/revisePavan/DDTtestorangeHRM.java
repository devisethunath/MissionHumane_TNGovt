package revisePavan;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTtestorangeHRM {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		
		String path="C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\login.xlsx";
		
		 XLUtils.setExcelFile(path, "Sheet1");
		
		int rows=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<rows;i++)
		{
			String username= XLUtils.getCellData(path, "Sheet1", i, 0);
			String password=XLUtils.getCellData(path, "Sheet1", i, 1);
			
			System.out.println(username);
			System.out.println(password);
			
			WebElement uname=driver.findElement(By.xpath("//input[@id='txtUsername']"));
			uname.clear();
			uname.sendKeys(username);
			
			WebElement pwd=driver.findElement(By.xpath("//input[@id='txtPassword']"));
			pwd.clear();
			pwd.sendKeys(password);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			
			
			String value=driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
			System.out.println(value);
			if(value.equals("Dashboard"))
			{
				System.out.println("test passed");
				XLUtils.setCellData(path, "Sheet1", i, 2, "passed");
			}
			else
			{
				System.out.println("test failed");
				XLUtils.setCellData(path, "Sheet1", i, 2, "failed");
			}
			
			driver.navigate().back();
		}

	}

}
