package UserLogin_Modules;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProceedPaymentPOMTest {
	
	public static void main(String[] args) throws Throwable {
	
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();


	String BROWSER=fLib.readDataFromPropertyFile("browser");
	String URL=fLib.readDataFromPropertyFile("url1");
	String USERNAME=fLib.readDataFromPropertyFile("username1");
	String PASSWORD=fLib.readDataFromPropertyFile("password1");
   
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();

	wLib.maximizeWindow(driver);					
	wLib.waitForPageLoad(driver);					

	driver.get(URL); 
	
	
	

	}
}
