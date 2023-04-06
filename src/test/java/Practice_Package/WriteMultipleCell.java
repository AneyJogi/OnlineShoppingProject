package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleCell {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet Sh=wb.getSheet("Organisation");
		int Rcount = Sh.getLastRowNum();
		
		
		
		for(int i=Rcount+1;i<=10;i++) {
			for(int j=0;j<=10;j++){
				Sh.createRow(i).createCell(i).setCellValue(" alwi");
				
			}
		}
			
		
		
		FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
		

	}

}
