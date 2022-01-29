package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();


		//Single Frame

		/*driver.switchTo().frame("SingleFrame");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");

		driver.switchTo().defaultContent();*/



		//Nested Iframe

		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		WebElement outerframe=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outerframe);//Passing WebElement //outer frame

		WebElement innerframe=driver.findElement(By.xpath("//iframe[normalize-space()='<p>Your browser does not support iframes.</p>']"));
		driver.switchTo().frame(innerframe);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("frames");


		//driver.swithchTo()frame(name)
		//driver.swithchTo()frame(index))
		//driver.swithchTo()frame(webelement name)





	}

}
