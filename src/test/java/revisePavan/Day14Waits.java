package revisePavan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day14Waits {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		//implicit wait just after webdriver initiation

		//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		//ExplicitWait
		WebDriverWait mywait= new WebDriverWait(driver,10000);

		driver.get("http://google.com");

		WebElement username=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		username.sendKeys("devi");

		
		//WebDriverWait mywait1=new WebDriverWait(driver,6000);
		//mywait.until(ExpectedConditions.visibilityOf(username));
		//mywait.until(ExpectedConditions.visibilityOf(username));
	}

}
