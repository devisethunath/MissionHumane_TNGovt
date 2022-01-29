package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date16WebTable1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();


		int rows=driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[2]/div[2]/footer[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody/tr")).size();
		System.out.println(rows);


		int columns=driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[2]/div[2]/footer[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody/tr/th")).size();
		System.out.println(columns);

		for(int i=2;i<=rows;i++)
		{
			for(int j=1;j<=columns;j++)
			{String value=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[2]/div[2]/footer[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["+i+"]/td["+j+"]")).getText();
			System.out.println(value);
			}
		}

	}}
