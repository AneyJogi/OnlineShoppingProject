package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Sh= wb.getSheet("Organisation");
		int count = Sh.getLastRowNum();
		
		for(int i=1;i<=count;i++)
		{
			String orgn = Sh.getRow(i).getCell(0).getStringCellValue();
			String loc =Sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(orgn+" "+loc);
		}
	}

}
