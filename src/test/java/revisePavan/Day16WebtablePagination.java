package revisePavan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day16WebtablePagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
		driver.manage().window().maximize();



		WebElement pagingElement=driver.findElement(By.xpath("//ul[@class='pagination']"));
		List <WebElement>sublinks=pagingElement.findElements(By.tagName("li"));
		System.out.println("no of elements"+sublinks.size());


		if(sublinks.size()>0)
		{
			for(int i=1;i<(sublinks.size()-3);i++)
			{
				driver.findElement(By.xpath("//a[contains(text(),'"+i+"')]")).click();

				Thread.sleep(3000);

				int rows=driver.findElements(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/section[2]/section[1]/div[1]/div[2]/div[1]/table[1]/tbody/tr")).size();
				System.out.println("no of rows is"+rows);



				int columns= driver.findElements(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/section[2]/section[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td")).size();

				for(int r=1;r<=rows;r++)
				{
					for(int c=1;c<=columns;c++)
					{
						String value=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/section[2]/section[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+r+"]/td["+c+"]")).getText();
						System.out.println(value);
					}


				}

			}}}}
