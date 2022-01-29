package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day11Loginpage {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users//sethu//Downloads//chromedriver_win32//chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sethu\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver= new ChromeDriver();
		//WebDriver driver= new FirefoxDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		String Title=driver.getTitle();
		String actTitle="OrangeHRM";
		
		if (Title.equals(actTitle))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		
		
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		
		
		//CSS SELECTOR
		
		//TAG and ID
		
		//driver.findElement(By.cssSelector("input#searchSystemUser_employeeName_empName")).sendKeys("test");
		
		//Tag and Class separate by dot(.)
		
		driver.findElement(By.cssSelector("input.ac_input")).sendKeys("test");
		
		//Tag and attribute
		
		driver.findElement(By.cssSelector("input[id=searchSystemUser_userName]")).sendKeys("devi");
		
		//Tag class attribute
		
		driver.findElement(By.cssSelector("input.ac_input[id=\"input.ac_input]")).sendKeys("Sethu");
		
		
		
		
		

	}

}
