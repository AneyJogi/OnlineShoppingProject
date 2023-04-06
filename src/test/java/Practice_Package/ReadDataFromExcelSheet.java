package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Sh= wb.getSheet("Organisation");
		Row rw = Sh.getRow(1);
		Cell cel = rw.getCell(0);
		String value = cel.toString();
		System.out.println(value);
		String value1=Sh.getRow(2).getCell(1).getStringCellValue();
		System.out.println(value1);
		wb.close();

	}

}
