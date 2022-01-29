package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day17MousehoverOrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		
		WebElement admin=driver.findElement(By.xpath("//b[normalize-space()='Admin']"));
		WebElement usermgmt=driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
		WebElement users=driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(admin).moveToElement(usermgmt).click().build().perform();
		
		//act.moveToElement(users).moveToElement(usermgmt).moveToElement(users).click().build().perform();
		Thread.sleep(5000);
		
		
		
	}

	
		
	}

