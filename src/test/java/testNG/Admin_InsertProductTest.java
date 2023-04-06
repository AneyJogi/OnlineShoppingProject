package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.AdminBaseClass;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.ObjectRepository.Admin_CreateCategoryPage;
import com.ObjectRepository.Admin_HomePage;
import com.ObjectRepository.Admin_InsertProductPage;
import com.ObjectRepository.Admin_SubCategoryPage;
@Listeners(com.GenericUtilities.ListnersImplementationClass.class)
public class Admin_InsertProductTest extends AdminBaseClass{
	@Test(groups="smoke suite")
	public void InsertProdut() throws Throwable
	{
		
		Admin_HomePage ahp= new Admin_HomePage(driver);
		ahp.clickOncreateCategoryLink();
		
		Admin_CreateCategoryPage accp = new Admin_CreateCategoryPage(driver);
		
		String categoryvalue = accp.CreateCategory(eLib,jLib,driver); 
		
		ahp.clickOnSubCategoryLink();
	
		Admin_SubCategoryPage ascp = new Admin_SubCategoryPage(driver);
		String subcategoryvalue = ascp.CreateSubCategory(wLib, categoryvalue);
		System.out.println(subcategoryvalue);
		 
		
		ahp.clickOnInsertProductLink();
	
	    Admin_InsertProductPage aipp = new Admin_InsertProductPage(driver);
        aipp.insertProduct(wLib, driver, eLib, jLib, categoryvalue, subcategoryvalue);
 
	 ahp.logOut();
	
	
	}

}
