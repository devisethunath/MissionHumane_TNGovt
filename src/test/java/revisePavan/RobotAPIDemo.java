package revisePavan;
import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.event.KeyEvent;

public class RobotAPIDemo {

	public static void main(String[] args) throws AWTException, InterruptedException {
	
		System.setProperty("webdriver.gecko.driver", "C://Users//sethu//Downloads//geckodriver-v0.30.0-win64//geckodriver.exe");
		WebDriver driver= new FirefoxDriver ();

		driver.get("https://www.calendar-12.com/printable_calendar/2022");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		
		//driver.switchTo().alert().dismiss();
		
		Robot robot= new Robot();
		
	   robot.keyPress(KeyEvent.VK_DOWN);
	   Thread.sleep(3000);
	   robot.keyPress(KeyEvent.VK_DOWN);
	   Thread.sleep(3000);
	   
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		  Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

}
