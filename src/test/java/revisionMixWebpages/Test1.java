package revisionMixWebpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://twitter.com/");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://twitter.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Sign up with phone or email')]")).click();
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Devi Sethunath");
		driver.findElement(By.xpath("//input[@name='phone_number']")).sendKeys("9713307765");
		
		
		//Month
		/*WebElement drp=driver.findElement(By.cssSelector("select#SELECTOR_7"));
		Thread.sleep(5000);
		Select dropdown=new Select(drp);
		
		List<WebElement>options=dropdown.getOptions();
		
		for(WebElement e:options)
		{
			System.out.println(e.getText());
			
		}
		dropdown.selectByVisibleText("May");*/
		
	//day
		
		WebElement day= driver.findElement(By.id("SELECTOR_8"));
		Thread.sleep(10000);
		Select dropdown1=new Select(day);
		
		System.out.println(dropdown1.getOptions().size());
		
		List<WebElement>options1=dropdown1.getOptions();
		for(WebElement f:options1)
		{
			System.out.println(f.getText());
		}
		
		dropdown1.selectByVisibleText("30");
		
		//Year
		
		WebElement year= driver.findElement(By.id("SELECTOR_9"));
		
		Select dropdown2=new Select(year);
		System.out.println(dropdown2.getOptions().size());
		
		List<WebElement>options2=dropdown2.getOptions();
		
		for(WebElement g:options2)
		{
			System.out.println(g.getText());
		}
		
dropdown2.selectByVisibleText("1984");
	}

}
