package parameterisationPVN;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {


	WebDriver driver;


	@BeforeClass
	public void setup() {

		System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
		driver=new ChromeDriver();

	}



	@Test(dataProvider="users")
	public void logintest(String uname,String pwd) {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("uname");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("pwd");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");

	}

	@DataProvider(name="users")
	String[][] logindata() {
		String data[][]= {{"Admin","admin123"},{"mer","mer"},{"mer2","mer2"}};
		return data;



	}



	@AfterClass
	public void closebrowser() {
		driver.close();
	}
}
