package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	
	@Test(dataProvider="data")    //(dataProvider="getData")
	public void dataProvidePractice(String Name,String age) 
	{
		System.out.println("test run  => "+Name+" "+age);	 
	}
	
	@DataProvider
	
	public Object[][] data(){
		
		Object[][] obj= new Object[2][2];
		
		obj[0][0]="Aney";
		obj[0][1]="28";
		obj[1][0]="Alwin";
		obj[1][1]="29";
		return obj;
		
	}

}
