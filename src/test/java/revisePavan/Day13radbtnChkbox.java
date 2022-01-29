package revisePavan;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day13radbtnChkbox {

	public static void main(String[] args) {



		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//Implicit Wit
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		//Explicit Wait
		
		WebDriverWait mywait= new WebDriverWait (driver,10000);
		
		//mywait.until(ExpectedConditions.visibilityOfElementLocated("By.xpath("//input[@placeholder='First Name']")));

		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Devi");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Sethunath");

		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/textarea[1]")).sendKeys("address");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("devisethunath@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("938393");


		//Radiobutton
		WebElement radmale=driver.findElement(By.xpath("//input[@value='Male']"));
		System.out.println(radmale.isDisplayed());
		System.out.println(radmale.isEnabled());
		System.out.println(radmale.isSelected());

		radmale.click();

		WebElement chkbox1= driver.findElement(By.id("checkbox1"));
		chkbox1.click();

		WebElement chkbox2= driver.findElement(By.id("checkbox3"));
		chkbox2.click();

		//dropdown 

		WebElement drp=driver.findElement(By.xpath("//select[@id='Skills']"));
		Select dropdown=new Select(drp);

		System.out.println(dropdown.getOptions().size());

		List <WebElement>options=dropdown.getOptions();

		for(WebElement e:options)
		{
			System.out.println(e.getText());

		}
		//select valuein dropdown
		
		//SElectByVisibleText
		//SelectByIndex
		//SelectBy Value
		
		//dropdown.selectByVisibleText("C");
		dropdown.selectByValue("Android");
		//dropdown.selectByIndex(1);
		
		//DROPDWN COUNTRY
		
		/*WebElement drp1=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[10]/div[1]/span[1]/span[1]/span[1]"));
		Select dropdown1=new Select(drp1);
		System.out.println(dropdown1.getOptions().size());
		List<WebElement>options1=dropdown1.getOptions();
		for(WebElement f:options1)
		{
			System.out.println(f.getText());
		}
		
		dropdown.selectByVisibleText("Japan");*/
		
		//DropdownYear
		
		WebElement drpYear=driver.findElement(By.xpath("//select[@id='yearbox']"));
		Select dropdownYear= new Select (drpYear);
		System.out.println(dropdownYear.getOptions().size());
		List<WebElement>optionsYear=dropdownYear.getOptions();
		for(WebElement g:optionsYear)
		{
			System.out.println(g.getText());
		}
		dropdownYear.selectByVisibleText("1927");
		
		//Dropdown month
		
		WebElement drpMonth=driver.findElement(By.xpath("//select[@placeholder='Month']"));
		
		Select dropdownMonth=new Select(drpMonth);
		dropdownMonth.selectByValue("March");
		
		//Dropdown day
		
		WebElement drpDay=driver.findElement(By.xpath("//select[@id='daybox']"));
		Select dropdownDay=new Select (drpDay);
		dropdownDay.selectByVisibleText("15");
		
		driver.findElement(By.id("firstpassword")).sendKeys("asdf");
		driver.findElement(By.id("secondpassword")).sendKeys("asdf");
		driver.findElement(By.id("submitbtn")).click();
		
	}

}
