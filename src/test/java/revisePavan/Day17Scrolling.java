package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day17Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		WebDriver driver=new ChromeDriver();



		driver.get("https://www.countries-ofthe-world.com/flags-of-europe.html");//opens url
		driver.manage().window().maximize();


		Thread.sleep(3000);
		
		//First approach ----by specifying pixel
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,2000)", "");
		
		//Approach 2 ------till we found certain element
		
		WebElement denmark=driver.findElement(By.xpath("//td[normalize-space()='Denmark']"));
		//js.executeScript("arguments[0].scrollIntoView();", denmark);
		
		//Approach3-------scroll till end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

}
