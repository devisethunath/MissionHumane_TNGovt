package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DAY18FileuploadOrangeHRM {

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		WebElement pim=driver.findElement(By.xpath("//b[normalize-space()='PIM']"));
		WebElement addemployee=driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
		
		Actions act= new Actions(driver);
		act.moveToElement(pim).moveToElement(addemployee).click().build().perform();
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Devi");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sethunath");
		
		driver.findElement(By.xpath("//input[@id='photofile']")).click();//not working
		
		Screen s= new Screen();
		
		Pattern fileinputtextbox=new Pattern("C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\filetextbox2022.png");
		Pattern openbutton=new Pattern("C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\open2022.png");
		
		s.wait(fileinputtextbox,20);
		s.type(fileinputtextbox,"C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\apple.jpg.jpg");
		s.click(openbutton);
		

	}

}
