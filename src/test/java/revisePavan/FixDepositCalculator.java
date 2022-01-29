package revisePavan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixDepositCalculator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();


		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		driver.manage().window().maximize();

		
		String path="C:\\Users\\sethu\\OneDrive\\Desktop\\sikuli\\caldata.xlsx";
		
		             XLUtils.setExcelFile(path, "Sheet1");
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rowcount;i++)
		{
			int princ=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 0));//principle
			int rateofinterest=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 1));//tate of interest
			int per=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 2));//period
			String fre= XLUtils.getCellData(path, "Sheet1", i, 3);//period frequency
			
			double exp_mvalue=Double.parseDouble(XLUtils.getCellData(path, "Sheet1", i, 4));
			
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
			
		
			
			Select dropdown=new Select(driver.findElement(By.id("tenurePeriod")));
			dropdown.selectByVisibleText("year(s)");
			
			Select frequency=new Select (driver.findElement(By.id("frequency")));
			frequency.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			String act_mvalue=driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[5]/div[1]/div[1]/div[4]/div[1]/div[2]/span[2]/strong[1]")).getText();
			
			if(exp_mvalue==Double.parseDouble(act_mvalue))
			{
				System.out.println("test passed");
			}
			else
			{
				System.out.println("test failed");
			}
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
			Thread.sleep(5000);
		}
	}

}

