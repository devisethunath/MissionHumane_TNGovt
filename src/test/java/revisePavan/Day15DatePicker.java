package revisePavan;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day15DatePicker {

	public static WebDriver driver;

	public static void main(String[] args) {



		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		 driver= new ChromeDriver();

		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		String date="25";
		String month="May";


		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		//selectCurrentDate();
		selectFutureDate(date,month);
		//selectPastDate();
	}

	static void selectCurrentDate() {
		//Getting Calender 

		Calendar cal=Calendar.getInstance();
		int d=cal.get(Calendar.DATE);
		String date= String.valueOf(d);

		driver.findElement(By.linkText(date)).click();
	}

	static void selectFutureDate(String d,String m)
	{

		Calendar cal=Calendar.getInstance();
		int currentmonth=cal.get(Calendar.MONTH);
		System.out.println(currentmonth);

		for(int i=currentmonth;i>=0;i++)
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println(mon);

			if (mon.equals(m))
			{
				driver.findElement(By.linkText(d)).click();
				break;
			}
		}


	}

}
