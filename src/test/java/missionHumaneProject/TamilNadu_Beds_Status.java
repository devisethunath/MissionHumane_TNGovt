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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TamilNadu_Beds_Status {

	WebDriver driver=null;

	static int b=0;

	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		driver= new ChromeDriver();

		driver.get("https://stopcorona.tn.gov.in/beds.php");
		driver.manage().window().maximize();

	}

	@Test
	public void scraping()
	{

		//Dropdown
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		WebElement drp=driver.findElement(By.name("dtBasicExample_length"));
		Select dropdown=new Select(drp);

		//No of elements in dropdown
		System.out.println(dropdown.getOptions().size());

		//Extract all Elements
		List<WebElement>options=dropdown.getOptions();
		for(WebElement e:options)
		{
			System.out.println(e.getText());
		}

		dropdown.selectByVisibleText("100");
	}

	@Test
	public void webtable() throws InterruptedException, IOException

	{
		String text= driver.findElement(By.id("dtBasicExample_info")).getText();

		System.out.println(text);
		System.out.println(text.substring(20, 23));
		String value=text.substring(20, 23);
		System.out.println(value);

		int number=(Integer.valueOf(value));
		int number1=number/100;
		System.out.println(number1);

		String path=	"C:/Users/sethu/OneDrive/Desktop/Mission Humane/test1.xlsx";

		XLUtils xlutil=new XLUtils(path);

		//Write Headers
		XLUtils.setCellData("Sheet1",0,0,"S.NO");
		XLUtils.setCellData("Sheet1",0,1,"District");
		XLUtils.setCellData("Sheet1",0,2,"Institution");
		
		XLUtils.setCellData("Sheet1",0,3,"   Covid Beds(Total)");
		XLUtils.setCellData("Sheet1",0,4,"Covid Beds(Occupied)  ");
		XLUtils.setCellData("Sheet1",0,5," Covid Beds(Vacant) ");
		
		XLUtils.setCellData("Sheet1",0,6,"Oxygen Supported Beds(Total) ");
		XLUtils.setCellData("Sheet1",0,7,"Oxygen Supported Beds(Occupied )");
		XLUtils.setCellData("Sheet1",0,8,"Oxygen Supported Beds(Vacant) ");
		
		XLUtils.setCellData("Sheet1",0,9,"Non Oxygen Supported Beds(Total )");
		XLUtils.setCellData("Sheet1",0,10,"Non Oxygen Supported Beds(Occupied) ");
		XLUtils.setCellData("Sheet1",0,11,"Non Oxygen Supported Beds(Vacant) ");
		
		XLUtils.setCellData("Sheet1",0,12,"ICU Beds(Total) ");
		XLUtils.setCellData("Sheet1",0,13,"ICU Beds(Occupied) ");
		XLUtils.setCellData("Sheet1",0,14,"ICU Beds(Vacant) ");
		
		XLUtils.setCellData("Sheet1",0,15,"Ventilator(Total)  ");
		XLUtils.setCellData("Sheet1",0,16,"Ventilator(Occupied)");
		XLUtils.setCellData("Sheet1",0,17,"Ventilator(Vacant)");
		
		XLUtils.setCellData("Sheet1",0,18,"Last Updated");
		XLUtils.setCellData("Sheet1",0,19,"Contact No: ");
		XLUtils.setCellData("Sheet1",0,20,"Remarks");
		

		for(int i=0;i<=number1;i++)
		{
			//WebTable scraping
			int rows=	driver.findElements(By.xpath("//tbody/tr")).size();
			int columns=driver.findElements(By.xpath("//tbody/tr[1]/td")).size();
			
			//int rows_increment=rows++;

			System.out.println("District   "+"               Institution   "+"                              Covid Beds          "+"        Oxygen Supported Beds            "+"        Non Oxygen Supported Beds           "+"        ICU Beds                        "+"   Ventilator                    "+" Last Updated     "+" Contact Number    "+" Remarks    ");

			System.out.println("                                                       Total "+"Occupied "+"Vacant"+"          Total "+"Occupied "+"Vacant      "+"            Total "+"Occupied "+"Vacant"         +"                  Total "+"Occupied "+"Vacant     "+"       Total "+"Occupied "+"Vacant");

			for(int r=1;r<=rows ;r++)
			{	
				for(int c=1;c<=columns;c++)
				{ 
					String cell1=driver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/main[1]/div[1]/table[1]/tbody[1]/tr["+r+"]/td["+c+"]")).getText();
					System.out.print(" "+cell1+" ");

					XLUtils.setCellData("Sheet1", (r+b) ,c,cell1);
				}
				System.out.println();
			}
			b=b+rows;
			driver.findElement(By.id("dtBasicExample_next")).click();
		}

	}




}
