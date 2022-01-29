package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day17MouseHover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);

		WebElement fashions=driver.findElement(By.xpath("//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[4]/a[1]"));
		//Thread.sleep(10000);

		WebElement clothing=driver.findElement(By.xpath("//a[normalize-space()=\"Men's Clothing\"]"));
		//Thread.sleep(5000);
		
		Actions act =new  Actions(driver);
		
		act.moveToElement(fashions).perform();    //  moveToElement(clothing).click().build().perform();
		Thread.sleep(10000);
		//boat.click();
	}

}
