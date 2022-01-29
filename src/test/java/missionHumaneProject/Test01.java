package missionHumaneProject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class Test01 {
	
	static int b=0;

	WebDriver driver=null;
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
		
		//Header for excel
		
		int columns_header=driver.findElements(By.xpath("//tbody/tr[1]/td")).size();
		FileOutputStream file=new FileOutputStream ("C:/Users/sethu/OneDrive/Desktop/Mission Humane/test1.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("data");
		
		//Array List
		
	/*	ArrayList list=new ArrayList();
		list.add("District");
		list.add("Institution");
		list.add("Covid Beds");
		list.add("Oxygen Supported Beds");
		list.add("Non Oxygen Supported Beds");
		list.add("ICU Beds");
		list.add("Ventilator");
		list.add("Last Updated");
		list.add("Contact No: ");
		list.add("Remarks");
		
		for(Object l:list)
		{
			
		}*/
		
		//for(int h=1;h<=columns_header;h++)
		XSSFRow row_header=sheet.createRow(0);
		row_header.createCell(1).setCellValue("District");
		row_header.createCell(2).setCellValue("Institution");
		row_header.createCell(3).setCellValue("Covid Beds");
		row_header.createCell(4).setCellValue("Oxygen Supported Beds");
		row_header.createCell(5).setCellValue("Non Oxygen Supported Beds");
		row_header.createCell(6).setCellValue("ICU Beds");
		row_header.createCell(7).setCellValue("Ventilator");
		row_header.createCell(8).setCellValue("Last Updated");
		row_header.createCell(9).setCellValue("Contact No: ");
		row_header.createCell(10).setCellValue("Remarks");
		
		

		for(int i=0;i<=number1;i++)
		{
			//WebTable scraping
			int rows=	driver.findElements(By.xpath("//tbody/tr")).size();
			int columns=driver.findElements(By.xpath("//tbody/tr[1]/td")).size();
			
			System.out.println("District   "+"               Institution   "+"                              Covid Beds          "+"        Oxygen Supported Beds            "+"        Non Oxygen Supported Beds           "+"        ICU Beds                        "+"   Ventilator                    "+" Last Updated     "+" Contact Number    "+" Remarks    ");
			System.out.println("                                                       Total "+"Occupied "+"Vacant"+"          Total "+"Occupied "+"Vacant      "+"            Total "+"Occupied "+"Vacant"         +"                  Total "+"Occupied "+"Vacant     "+"       Total "+"Occupied "+"Vacant");
			for(int r=1;r<=rows;r++)
			{	
				XSSFRow row= sheet.createRow(r+b);
				for(int c=1;c<=columns;c++)
				{
					String cell1=driver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/main[1]/div[1]/table[1]/tbody[1]/tr["+r+"]/td["+c+"]")).getText();
					System.out.print(" "+cell1+" ");
					row.createCell(c).setCellValue(cell1);
				}
				System.out.println();
			}
			b=b+rows;
			driver.findElement(By.id("dtBasicExample_next")).click();
		}

		workbook.write(file);
	}

}

























