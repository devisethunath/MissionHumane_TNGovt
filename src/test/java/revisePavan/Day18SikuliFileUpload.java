package revisePavan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Day18SikuliFileUpload {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		//driver.switchTo().frame(0);
		
		//driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Devi");
		
		driver.findElement(By.xpath("//input[@id='imagesrc']")).click();
		
		//file Upload
		
		String imagesfilepath="C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\";
		
		String inputfilepath="C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\";
		
		Screen s= new Screen();
		
		Pattern fileinputtextbox=new Pattern(imagesfilepath+"filetextbox2022.png");
		Pattern openbutton=new Pattern (imagesfilepath+"open2022.png");
		Thread.sleep(5000);
		
				
		s.wait(fileinputtextbox,20);
		s.type(fileinputtextbox,inputfilepath+"apple.jpg.jpg");
		s.click(openbutton);
		
		
		
	}

}
