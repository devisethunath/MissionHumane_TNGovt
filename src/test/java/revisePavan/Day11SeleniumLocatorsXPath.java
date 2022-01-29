package revisePavan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day11SeleniumLocatorsXPath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://cosmocode.io/automation-practice");
		driver.manage().window().maximize();
		
		/*xpath writing 
		
		abs xpath starts with  /html[1]
		rel xpath starts with  //input[@id='receipt_number']
		
		identify with text() method
		
		//div[text()='Sign Up']
		 * 
		 * 
		 *  text() -identify labels
		 * contains() 
		 * 
		 * starts-with() whenever attribute values dynamically changing
		 * 
		 * 
		 * following 
		 * preceding
		 * 
		 * 
		 * 
		
		*/
		
		
		
		

	}

}
