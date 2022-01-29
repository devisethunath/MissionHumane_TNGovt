package seleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class EdDr

{
	
	WebDriver driver=null;
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  
		System.setProperty("webdriver.edge.driver","C:\\Users\\sethu\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver myDriver= new EdgeDriver();

	//To launch the url

	driver.get("https://www.amazon.com");
	driver.manage().window().maximize();

  }

  @AfterTest
  public void afterTest() {
  }

}
