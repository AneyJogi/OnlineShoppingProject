package testNG;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ListnersImplementationClass;
import com.ObjectRepository.User_HomePage;
import com.ObjectRepository.User_MyCartPage;
import com.ObjectRepository.User_PaymentMethodpage;
import com.ObjectRepository.User_ProductCategoryPage;
import com.ObjectRepository.User_ProductDetailsPage;

@Listeners(com.GenericUtilities.ListnersImplementationClass.class)
public class CategoryToPaymentTest extends BaseClass {
	@Test(groups="smoke suite")
	public void payment() throws InterruptedException {
		
		User_HomePage hp=new User_HomePage(driver);
		User_ProductCategoryPage pcp=new User_ProductCategoryPage(driver);
		hp.clkCategory();
		pcp.clkSubCategoryTshirts();
		
		pcp.clkProduct();
		System.out.println("Testscript 01 failed");
		//Assert.fail();
		
		System.out.println("working");
		User_ProductDetailsPage pdp=new User_ProductDetailsPage(driver);
		pdp.clkAddToCartBtn();
		
		wLib.acceptAlert(driver);
		
		 User_MyCartPage mcp=new User_MyCartPage(driver);
		mcp.clkCheckOutBtn();
		
		User_PaymentMethodpage pmp=new User_PaymentMethodpage(driver);
		pmp.clickCODPaymentOptions();
		
		pmp.clickSubmitBtn();
		

}
}
