package missionHumaneProject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CovidResources_Bengaluru {

	WebDriver driver=null;

	static int b=0;
	WebElement button1;

	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		driver= new ChromeDriver();

		driver.get("https://www.covidresourcesindia.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void test01() throws InterruptedException, IOException
	{
		WebElement cities=driver.findElement(By.xpath("//div[@class='header-display-desktop']//a[@class='header-nav-folder-title'][normalize-space()='Cities']"));
		WebElement bengaluru=driver.findElement(By.xpath("//div[@class='header-display-desktop']//a[normalize-space()='Bengaluru']"));

		Actions act=new Actions(driver);
		act.moveToElement(cities).perform();
		act.moveToElement(bengaluru).click().build().perform();

		Thread.sleep(5000);

		WebDriverWait mywait=new WebDriverWait(driver,30000);
		WebElement link=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='https://covidbengaluru.com/']")));
		link.click();

		JavascriptExecutor js=(JavascriptExecutor)driver;
	
		button1=	mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-primary']")));
		js.executeScript("arguments[0].scrollIntoView();", button1);

		for(int b=0;b<7;b++)
		{
			js.executeScript("arguments[0].click()",button1);
		
		}
	
		
		int rows=driver.findElements(By.xpath("//tbody/tr")).size();
		int columns=driver.findElements(By.xpath("//tbody/tr[1]/td/span[1]/span[1]")).size();
		System.out.println(rows+"  "+columns);
		
		int rowsTwice=rows*2;
		
		for(int k=1;k<=rowsTwice;k++)
		{
		WebElement details=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr["+k+"]/td[1]"));
		js.executeScript("arguments[0].click();", details);
		}
		

		String path=	"C:/Users/sethu/OneDrive/Desktop/Mission Humane/covid resources bangalore.xlsx";

		XLUtils xlutil=new XLUtils(path);
		
		//Headers for Excel
		
		XLUtils.setCellData("Sheet1",0,0,"Hospital Details");
		XLUtils.setCellData("Sheet1",0,1,"Without Oxygen");
		XLUtils.setCellData("Sheet1",0,2,"With Oxygen");
		XLUtils.setCellData("Sheet1",0,3,"ICU Without Ventilator");
		XLUtils.setCellData("Sheet1",0,4,"ICU With Ventilator");

	
		for(int r=1;r<=rowsTwice; r++)
		{	
     
			int remainder=r%2;
			if (remainder==0)
			{
				String column_address=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr["+r+"]/td[1]")).getText();
				
				System.out.println(column_address);
				XLUtils.setCellData("Sheet1", r ,0,column_address);
			}
			else
			{	
			String column_one=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr["+r+"]/td[1]")).getText();
			
			System.out.println(column_one);
			XLUtils.setCellData("Sheet1", r ,0,column_one);
			
			for(int c=2;c<=columns;c++)
			{
				
			String cell=driver.findElement(By.xpath("//tbody/tr["+r+"]/td["+c+"]")).getText();
			System.out.print(cell);
			XLUtils.setCellData("Sheet1", r ,c,cell);

			}
			System.out.println();
		}}

	}}








