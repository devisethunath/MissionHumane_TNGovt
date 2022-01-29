package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class GeckoDriver {
	WebDriver driver = null;
	@Test
	public void f() {

		
		System.out.println("testpasses");
		//WebDriver   driver = new ChromeDriver();
		String valuetitle = driver.getTitle();   


		//Reporter.log("Page Title : " + driver.getTitle());
		Reporter.log("Page Title : " + valuetitle);    

		//To get the url of the page    
		Reporter.log("Page Current Url : " + driver.getCurrentUrl());


		//To get the page sourceg
		Reporter.log("Page Source : " + driver.getPageSource());
	}
	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {


		System.setProperty("webdriver.gecko.driver","C://Users/sethu/Downloads/geckodriver-v0.30.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();

		//To launch the url

		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();

	}



	@AfterTest
	public void afterTest() {
		//driver.close();
		//driver.quit();

	}

}
