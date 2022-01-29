package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day14Framesiframes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='fixedNav']//div[@class='subNav']//ul[@class='navList']//li//a[@href='index.html?overview-summary.html'][normalize-space()='Frames']")).click();
	
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent();
		driver.navigate().back();
		
		//driver.findElement(By.xpath("//div[@class='fixedNav']//div[@class='subNav']//ul[@class='navList']//li//a[@href='index.html?overview-summary.html'][normalize-space()='Frames']")).click();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("AbstractAnnotations")).click();
		driver.switchTo().defaultContent();
		driver.navigate().back();
		
		
		//driver.findElement(By.xpath("//div[@class='fixedNav']//div[@class='subNav']//ul[@class='navList']//li//a[@href='index.html?overview-summary.html'][normalize-space()='Frames']")).click();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.partialLinkText("org.openqa.selenium.")).click();
		driver.switchTo().defaultContent();
		
		

	}

}
