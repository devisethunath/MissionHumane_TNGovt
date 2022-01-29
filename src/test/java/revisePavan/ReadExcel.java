package revisePavan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		FileInputStream file= new FileInputStream("C:/Users/sethu/eclipse-workspace/nopCommercePractice/src/test/java/com/nopcommercepractice/testData/LoginData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		
		//counting Rows
		
		int rownum=sheet.getLastRowNum();
		
	int cellnum=sheet.getRow(0).getLastCellNum();
	
	System.out.println(rownum );
	System.out.println(cellnum);
			
	
	for(int r=0;r<=rownum;r++)
	{
		
		XSSFRow row= sheet.getRow(r);
		for(int c=0;c<cellnum;c++)
		{
			XSSFCell cell=row.getCell(c);
			System.out.println(cell);
		}
	}

	}

}
