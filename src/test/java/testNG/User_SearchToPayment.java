package testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtility;
import com.ObjectRepository.User_HomePage;
import com.ObjectRepository.User_MyCartPage;
import com.ObjectRepository.User_PaymentMethodpage;
import com.ObjectRepository.User_ProductCategoryPage;

@Listeners(com.GenericUtilities.ListnersImplementationClass.class)
public class User_SearchToPayment extends BaseClass {

	@Test(groups="Regression suite")
	public void checkOut() throws Throwable{
		User_HomePage hp=new User_HomePage(driver);
		hp.SearchProductTF(eLib);
		System.out.println("Testscript 02 failed");
		Assert.fail();
	    User_ProductCategoryPage pcp= new User_ProductCategoryPage(driver);
	    pcp.clkAddToCartBtn();
	    
	    wLib.acceptAlert(driver);
	    
	    hp.MyCartBtn();
	    User_MyCartPage mcp=new User_MyCartPage(driver);
	    mcp.clkCheckOutBtn();
	    
	    User_PaymentMethodpage pmp= new User_PaymentMethodpage(driver);
	    pmp.getClkCODPaymentOptions();
	    pmp.clickSubmitBtn();
	    }
}
