package revisePavan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day14lLinksAlertsFramesBrowserWndows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Count all links in page by using tagname anchor tag // use findelements when locator  matches  multiple elements
		
		 List<WebElement>lists= driver.findElements(By.tagName("a"));
		
       System.out.println( lists.size());
       
       for(WebElement e:lists)
       {
    	   System.out.println(e.getText());
       }
       
     //Alerts/PopUps
       
       driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
       //driver.switchTo().alert().accept();
      driver.switchTo().alert().dismiss();
	}
	
	
	//Frames/iframes
	
	

	

}
