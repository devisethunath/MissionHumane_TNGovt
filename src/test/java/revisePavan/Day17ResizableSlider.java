package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day17ResizableSlider {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		WebDriver driver=new ChromeDriver();



	/*	driver.get("https://jqueryui.com/resizable/");//opens url
		driver.manage().window().maximize();
		
		WebElement abc=driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));//iframe[@class='demo-frame']
		
		driver.switchTo().frame(abc);
		
		WebElement element=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Thread.sleep(5000);
		Actions act= new Actions(driver);
		act.moveToElement(element).dragAndDropBy(element, 200, 200).build().perform();*/
		
		
		//Slider
		
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Actions act= new Actions(driver);
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
	}

}
