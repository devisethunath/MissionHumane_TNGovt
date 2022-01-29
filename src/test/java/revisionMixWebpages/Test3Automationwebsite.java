package revisionMixWebpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test3Automationwebsite {

	static  {
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
	}
	static  WebDriver driver = new ChromeDriver();
	static {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();}

	public static void main(String[] args) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement women=driver.findElement(By.xpath("//a[@class='sf-with-ul'][normalize-space()='Women']"));
		
		WebElement blouses=driver.findElement(By.xpath("//a[@title='Blouses']"));
		
		//WebElement casualdresses=driver.findElement(By.xpath("//li[@class='sfHover']//a[@title='Casual Dresses'][normalize-space()='Casual Dresses']"));
		
		Thread.sleep(5000);

       Actions act= new Actions(driver);
       act.moveToElement(women).perform();
       
       act.moveToElement(blouses).click().build().perform();
       
       
       JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)", "");
		
		WebElement bl=driver.findElement(By.xpath("//img[@title='Blouse']"));
		act.moveToElement(bl).perform();
		
		driver.findElement(By.cssSelector("a[title='View'] span")).click();
		
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("3");
		
		WebElement drp=driver.findElement(By.id("group_1"));
		
		Select dropdown= new Select(drp);
		
		dropdown.selectByVisibleText("M");
		
		driver.findElement(By.id("color_8")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='Add to cart']")).click();
		
		
		driver.findElement(By.xpath("//span[@title='Continue shopping']//span[1]")).click();
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		
		driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();
		
		driver.findElement(By.cssSelector(".add_to_compare[href='http://automationpractice.com/index.php?id_product=5&controller=product&search_query=dress&results=7']")).click();
		driver.findElement(By.xpath("//li[@class='ajax_block_product last-item-of-tablet-line col-xs-12']//a[@class='add_to_compare'][normalize-space()='Add to Compare']")).click();
	       
	}}


