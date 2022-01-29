package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day17Tooltip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		WebDriver driver=new ChromeDriver();



		driver.get("https://jqueryui.com/tooltip/");//opens url
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement element=driver.findElement(By.xpath("//input[@id='age']"));
		String text=element.getAttribute("title");
		
		System.out.println(text);

	}

}
