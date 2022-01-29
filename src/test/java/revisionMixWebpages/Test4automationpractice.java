package revisionMixWebpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4automationpractice {


	static  {
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
	}
	static  WebDriver driver = new ChromeDriver();
	static {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();}


	public static void main(String[] args) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("search_query_top")).sendKeys("Summer dresses");

		driver.findElement(By.name("submit_search")).click();

		driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();

		driver.findElement(By.cssSelector(".add_to_compare[href='http://automationpractice.com/index.php?id_product=5&controller=product&search_query=Summer+dresses&results=4']")).click();

		WebElement faded= driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));

		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",faded);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//li[@class='ajax_block_product first-in-line last-line last-item-of-tablet-line first-item-of-mobile-line last-mobile-line col-xs-12']//a[@class='add_to_compare'][normalize-space()='Add to Compare']")).click();
		
		driver.findElement(By.xpath("//div[@class='bottom-pagination-content clearfix']//span[1]")).click();
		
		WebElement orange= driver.findElement(By.cssSelector("td[class='ajax_block_product comparison_infos product-block product-1'] div[class='prices-container']"));
		Thread.sleep(5000);
		
		String ora=orange.getText();
		
		
		
		String ora2=ora.substring(1);
		
		System.out.print(ora2);
		
		
		
		WebElement yellow=driver.findElement(By.xpath("//span[normalize-space()='$28.98']"));
		
		String yel=yellow.getText();
		
		String yel2=yel.substring(1);
		
		
		
		System.out.println(yel2);
		
		
		if (Double.valueOf(yel2)>Double.valueOf(ora2))
		{
			driver.findElement(By.cssSelector("td[class='ajax_block_product comparison_infos product-block product-1'] i[class='icon-trash']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//td[@class='ajax_block_product comparison_infos product-block product-5']//i[@class='icon-trash']")).click();
		}
	
	}

}
