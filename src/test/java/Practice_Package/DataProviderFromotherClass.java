package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;

public class DataProviderFromotherClass {
//	
//	@Test(dataProviderClass=DataProviderfetchdatafromExcel.class,dataProvider="data")
//	public void dataPro(String name,String job,String age) {
//		System.out.println(name+" "+job+" "+age);
//		
//	}

	@Test(dataProvider = "getData")
	public void dataPro(String name, String job,String age)
	{
		System.out.println(name+" "+job+" "+age);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.readMultipleDataSet();
		return value;
		
	}
}
