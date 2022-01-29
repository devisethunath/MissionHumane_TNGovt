package revisePavan;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day15WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']")).click();
		
		
		Set<String>handleValues=driver.getWindowHandles();
		
		for(String e:handleValues)
		{
			//System.out.println(e);
			String title=driver.switchTo().window(e).getTitle();
			
			System.out.println(title);
			
			if (title.equals("Selenium")||title.equals("Frames & windows"))
			{
				driver.close();
			}
		
		}
    
	}

}
