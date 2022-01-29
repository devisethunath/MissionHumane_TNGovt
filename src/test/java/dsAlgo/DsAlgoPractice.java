package dsAlgo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DsAlgoPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://dsportalapp.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='btn']")).click();

		//		//Register

		//		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		//		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("devisethunath@gmail.com");
		//		driver.findElement(By.id("id_password1")).sendKeys("Sethu@1975");
		//		driver.findElement(By.id("id_password2")).sendKeys("Sethu@1975");
		//		
		//		driver.findElement(By.xpath("//input[@value='Register']")).click();
		//		

		//Sign In
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("id_username")).sendKeys("devisethunath@gmail.com");
		driver.findElement(By.id("id_password")).sendKeys("Sethu@1975");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		//Selecting dropdown

		driver.findElement(By.linkText("Data Structures")).click();
		//Arrays

		driver.findElement(By.linkText("Arrays")).click();

		//Arrays in python

		driver.findElement(By.linkText("Arrays in Python")).click();
		//Try here button
		driver.findElement(By.linkText("Try here>>>")).click();

		//editor


		WebElement textarea=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/textarea[1]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.display='block';",textarea);
		textarea.sendKeys("helloo");


		//Button
		driver.findElement(By.xpath("//button[@type='button']")).click();

	}}
