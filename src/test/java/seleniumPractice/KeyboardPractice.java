package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//import org.sikuli.hotkey.Keys;
import org.openqa.selenium.Keys;

public class KeyboardPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		driver.manage().window().maximize();
		
		
		WebElement search=driver.findElement(By.name("q"));
		
		Actions action=new Actions(driver);
		/*search.sendKeys("hello world");
		
		Actions act=new Actions(driver);
		
		act.sendKeys(Keys.ENTER).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();*/
		
		 action.keyDown(Keys.SHIFT).sendKeys(search,"selenium").keyUp(Keys.SHIFT).sendKeys(" classes").perform(); 
		 
		    Action keydown = action.keyDown(Keys.CONTROL).sendKeys("a").build();
			keydown.perform();
		    

	}

}
