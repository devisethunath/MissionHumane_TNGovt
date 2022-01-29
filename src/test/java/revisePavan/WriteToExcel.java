package revisePavan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream file= new FileOutputStream("C:/Users/sethu/OneDrive/Desktop/sikuli/test.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("data");

		for(int i=0;i<=5;i++)
		{
			XSSFRow row= sheet.createRow(i);
			for(int c=0;c<3;c++)
			{
				row.createCell(c).setCellValue("welcome");
			}
		}
		workbook.write(file);
		System.out.println("writing excel done");
	}


}
