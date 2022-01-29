package revisePavan;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Day18FileDownload {

	public static void main(String[] args) {

		//To change browser profile to download in specific location
		
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", "C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli");
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				
				DesiredCapabilities cap = DesiredCapabilities.chrome();//deprecated
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);//end of code
				
				
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver(cap);//passing cap to download at specific location

		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("testing file");

		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();

		if ( isFileExists("C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\info.txt"))
		{
			System.out.println("file exists");}






		//PDF
		driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys("Testing selenium");
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();
	}


	static boolean isFileExists( String path)
	{
		File f=new File (path);

		if (f.exists())
		{
			return true;
		}
		else
		{
			return false;}
	}
}


