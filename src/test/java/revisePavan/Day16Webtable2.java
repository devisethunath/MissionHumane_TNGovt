package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day16Webtable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		int rows=driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/table[1]/tbody/tr")).size();

		System.out.println(rows);

		int columns= driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/table[1]/tbody/tr[1]/td")).size();
		System.out.println(columns);

         int count=0;
         for(int r=2;r<=rows;r++)
         {
        	 String status=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/table[1]/tbody[1]/tr["+r+"]/td[5]")).getText();
        	 if (status.equals("French"))
        	 {
        		 count++;
        	 }
         }

System.out.println("No of French language is" +count++);
System.out.println("No of non french is"+ (rows-count++));
	}

}