package revisePavan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day17KeyPress {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		WebDriver driver=new ChromeDriver();
		
		
		
		/*driver.get("https://the-internet.herokuapp.com/key_presses");//opens url
		driver.manage().window().maximize();
		
		
		Actions act= new Actions(driver);
		act.sendKeys(Keys.SPACE).build().perform();*/
		
		//ctrl+A
		
		driver.get("https://en.wikipedia.org/wiki/Kerala");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		Actions act= new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();//This works
		//act.sendKeys(Keys.CONTROL+"A").build().perform();
		Thread.sleep(5000);
		

	}

}
