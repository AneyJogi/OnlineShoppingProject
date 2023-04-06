package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.IPathConstants;

public class DataProviderfetchdatafromExcel{
	
	@DataProvider
	public Object[][] data() throws Throwable {
		
	
	FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("DataproviderDetails");
	int lastRow=sh.getLastRowNum()+1;
	int lastCel = sh.getRow(0).getLastCellNum();
	
	Object[][] obj= new Object[lastRow][lastCel];
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCel;j++)
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}
	}
