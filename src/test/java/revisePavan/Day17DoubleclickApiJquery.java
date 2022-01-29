package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day17DoubleclickApiJquery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://api.jquery.com/dblclick/");
		
		driver.manage().window().maximize();
		WebElement frame=driver.findElement(By.xpath("//div[@class='demo code-demo']//iframe"));
		
		driver.switchTo().frame(frame);
		
		WebElement box=driver.findElement(By.xpath("//body//div"));
		
		Actions act= new Actions(driver);
		
		act.moveToElement(box).doubleClick().build().perform();

	}

}
