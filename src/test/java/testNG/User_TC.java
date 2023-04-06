package testNG;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	import com.GenericUtilities.BaseClass;
	import com.GenericUtilities.ExcelUtility;
	import com.GenericUtilities.FileUtility;
	import com.GenericUtilities.WebDriverUtility;
	
	import com.ObjectRepository.User_HomePage;
import com.ObjectRepository.User_MyAccountPage;
import com.ObjectRepository.User_MyCartPage;
import com.ObjectRepository.User_MyWishListPage;
import com.ObjectRepository.User_PaymentMethodpage;
import com.ObjectRepository.User_ProductCategoryPage;
import com.ObjectRepository.User_ProductDetailsPage;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class User_TC extends BaseClass{

		@Test
		public void checkOut() throws Throwable{
			User_HomePage hp=new User_HomePage(driver);
		    hp.SearchProductTF(eLib);
		    
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
		
		@Test
		public void wishList() {
			User_HomePage hp=new User_HomePage(driver);
			hp.clkCategory();
			User_ProductCategoryPage pcp=new User_ProductCategoryPage(driver);
			pcp.clkSubCategoryTshirts();

			pcp.clkProduct();
			User_ProductDetailsPage pdp=new User_ProductDetailsPage(driver);
			pdp.clkWislistBtn();
			 }
		
		@Test
		public void wishListToAddToCart() throws Throwable {
		User_HomePage hp=new User_HomePage(driver);
		hp.SearchProductTF(eLib);
		User_ProductCategoryPage pcp=new User_ProductCategoryPage(driver);
		pcp.clkWishlistBtn();
		User_MyWishListPage wp=new User_MyWishListPage(driver);
		wp.clkAddToCartBtn();
		hp.MyCartBtn();
		}
		
		
		@Test
		public void searchProduct() throws Throwable {

			User_HomePage hp=new User_HomePage(driver);
			hp.SearchProductTF(eLib);
			}
		
		@Test
		public void product() {
			User_HomePage hp=new User_HomePage(driver);
			hp.clkCategory();
			User_ProductCategoryPage pcp=new User_ProductCategoryPage(driver);
		pcp.clkSubCategoryTshirts();
		pcp.clkProduct();
		}
		
		@Test
		public void updateShipBillAddress() throws Throwable {
			
			
			User_HomePage hp=new User_HomePage(driver);
			hp.clickOnMyAccountLink();
			
			User_MyAccountPage mp=new User_MyAccountPage(driver);
			mp.clkShipBillAddressbtn();
			mp.UpdateAddress(wLib, eLib, driver);
			wLib.acceptAlert(driver);
		}
		@Test
		public void payment() {
			User_HomePage hp=new User_HomePage(driver);
			User_ProductCategoryPage pcp=new User_ProductCategoryPage(driver);
			hp.clkCategory();
			pcp.clkSubCategoryTshirts();

			pcp.clkProduct();
			
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

