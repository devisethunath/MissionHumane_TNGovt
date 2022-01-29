package revisionMixWebpages;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Test2Cosmocode {


	static  {
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
	}
	static  WebDriver driver = new ChromeDriver();
	static {
		driver.get("https://cosmocode.io/automation-practice/");
		driver.manage().window().maximize();
	}
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();

		// This will make Selenium WebDriver to wait for the entire page is loaded.
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//This capability checks whether an expired (or) invalid TLS Certificate is used while navigating during a session
		chromeOptions.setAcceptInsecureCerts(true);
		
		//Specifies when to interrupt an executing script in a current browsing context. The default timeout 30,000 ms
		chromeOptions.setScriptTimeout(Duration.ofSeconds(20));
		
		//Specifies the time interval in which web page needs to be loaded in a current browsing context. The default timeout 300,000 ms
		chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));
		
		//This specifies the time to wait for the implicit element location strategy when locating elements. The default timeout 0 ms
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(10));
		
		//Adding chrome extensions with webdriver
		//chromeOptions.addExtensions(new File("/path/to/extension.crx"));
		
		chromeOptions.addArguments("start-maximized");
		//more capabilities at https://sites.google.com/a/chromium.org/chromedriver/capabilities
		


		
		driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		
		driver.findElement(By.linkText("Click here to reload this page")).click();

		driver.findElement(By.id("firstname")).sendKeys("Devi");
		driver.findElement(By.xpath("//input[@class='lastname']")).sendKeys("Sethunath");

		WebElement radfemale=driver.findElement(By.xpath("//input[@value='Female']"));

		System.out.println(radfemale.isSelected());
		System.out.println(radfemale.isEnabled());
		System.out.println(radfemale.isSelected());

		radfemale.click();

		driver.findElement(By.name("language_java")).click();
		driver.findElement(By.name("language_c")).click();

		WebElement drp=driver.findElement(By.xpath("//select[@name='age']"));



		Select dropdown= new Select(drp);
		System.out.println(dropdown.getOptions().size());

		List<WebElement>options= dropdown.getOptions();

		for(WebElement e:options)
		{
			System.out.println(e.getText());
		}
		dropdown.selectByVisibleText("Under 40");

		//driver.findElement(By.id("submit_htmlform")).click()

		driver.findElement(By.linkText("random-text-xyz-i-wont-change-random-digit-123")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		;		

		driver.findElement(By.linkText("Click Me to get Alert")).click();

		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("Click Me to open New Window")).click();
		
		Set<String>handles=driver.getWindowHandles();
		
		
			
		
		for(String e:handles)
		{
			System.out.println(e);
			driver.switchTo().window(e);
			System.out.println(driver.getTitle());
			
			if (driver.getTitle().equalsIgnoreCase("Beginner | Automation Practice – 2nd Window – CosmoCode"))
			{
				driver.findElement(By.linkText("Click Me To Open Third Window")).click();
			}
		}
		
	}

}
