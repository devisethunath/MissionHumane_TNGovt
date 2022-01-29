package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class NewTest



{ WebDriver driver = null;


	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		  driver = new ChromeDriver();

		//To launch the url

		driver.get("https://www.google.com");
		driver.manage().window().maximize();

	}
	@Test
	public void f() {
		//WebDriver   driver = new ChromeDriver();
		String valuetitle = driver.getTitle();   


		//Reporter.log("Page Title : " + driver.getTitle());
		Reporter.log("Page Title : " + valuetitle);    

		//To get the url of the page    
		Reporter.log("Page Current Url : " + driver.getCurrentUrl());


		//To get the page sourceg
		Reporter.log("Page Source : " + driver.getPageSource());


	}





	@AfterTest
	public void afterTest() {
		//WebDriver   driver = new ChromeDriver();
		//To close the current browser
		driver.close();

		//To exit the browser instances
		//driver.quit(); 

	}

}
