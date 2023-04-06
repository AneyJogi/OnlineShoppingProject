package Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGAnnotationPractice {
	
	@BeforeSuite
	public void DB_connection()
	{
		System.out.println("Before Suite---->Database connection established");
		
	}
	
	@AfterSuite
	public void DB_Disconnected()
	{
		System.out.println(" After Suite----->Database disconnected");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test");
		
	}
	
	@AfterTest
	public void afterSuite()
	{
		System.out.println("After Test");
		
	}
	
	@BeforeClass
	public void launch_Browser()
	{
		System.out.println("Launch Browser");
	}
	
	@AfterClass
	public void close_Browser()
	{
		System.out.println("close Browser");
	}
	
	@BeforeMethod
	public void loginToApp()
	{
		System.out.println("Login To App");
	}

	@AfterMethod
	public void logoutApp()
	{
		System.out.println("Logout of App");
	}
	
	@org.testng.annotations.Test
	public void Test()
	{
		System.out.println("Excetue TestScript");
	}
}
