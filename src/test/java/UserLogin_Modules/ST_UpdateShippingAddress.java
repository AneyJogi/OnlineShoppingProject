package UserLogin_Modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ST_UpdateShippingAddress {

	public static void main(String[] args) throws Throwable {
		
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		wLib.maximizeWindow(driver);  		//driver.manage().window().maximize();
		wLib.waitForPageLoad(driver);       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url1");
		String USERNAME=fLib.readDataFromPropertyFile("username1");
		String PASSWORD=fLib.readDataFromPropertyFile("password1");
		
		String expectedTilte = "FENDO";
		
		//Login To App
		
		
		driver.get(URL);                                               //	driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
        driver.findElement(By.xpath("//a[.='Login']")).click();
        driver.findElement(By.name("email")).sendKeys(USERNAME);       //driver.findElement(By.name("email")).sendKeys("tester@gmail.com");
        driver.findElement(By.name("password")).sendKeys(PASSWORD);    //driver.findElement(By.name("password")).sendKeys("tester@123");;
        driver.findElement(By.name("login")).click();
		
		
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li/following-sibling::li/a[.='My Account']")).click();
		driver.findElement(By.xpath("//a[.='Shipping / Billing Address']")).click();
		
		driver.findElement(By.name("billingaddress")).clear();
		driver.findElement(By.name("billingaddress")).sendKeys("FlatNo:1");
		
		driver.findElement(By.name("bilingstate")).clear();
		driver.findElement(By.name("bilingstate")).sendKeys("karnataka");
		
		driver.findElement(By.name("billingcity")).clear();
		driver.findElement(By.name("billingcity")).sendKeys("banglore");
		
		driver.findElement(By.name("billingpincode")).clear();
		driver.findElement(By.name("billingpincode")).sendKeys("560000");
		
		driver.findElement(By.name("update")).click();	
		wLib.acceptAlert(driver);      //driver.switchTo().alert().accept();
		
		
		
		
		driver.findElement(By.xpath("//a[.='Shipping / Billing Address']")).click();
		
		driver.findElement(By.xpath("//textarea[@name='billingaddress']")).clear();
		driver.findElement(By.xpath("//textarea[@name='billingaddress']")).sendKeys("FlatNo:1");
		
		driver.findElement(By.name("bilingstate")).clear();
		driver.findElement(By.name("bilingstate")).sendKeys("karnataka");
		
		driver.findElement(By.name("billingcity")).clear();
		driver.findElement(By.name("billingcity")).sendKeys("banglore");
		
		driver.findElement(By.name("billingpincode")).clear();
		driver.findElement(By.name("billingpincode")).sendKeys("560000");
		
		driver.findElement(By.name("update")).click();
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.xpath("//a[contains(.,'Shipping Address')]")).click();
		
		driver.findElement(By.xpath("//textarea[@name='shippingaddress']")).clear();
		driver.findElement(By.xpath("//textarea[@name='shippingaddress']")).sendKeys("FlatNo:2");
		
		driver.findElement(By.name("shippingstate")).clear();
		driver.findElement(By.name("shippingstate")).sendKeys("karnataka");
		
		driver.findElement(By.name("shippingcity")).clear();
		driver.findElement(By.name("shippingcity")).sendKeys("banglore");
		
		driver.findElement(By.name("billingpincode")).clear();
		driver.findElement(By.name("billingpincode")).sendKeys("560000");
		
		driver.findElement(By.name("update")).click();
		driver.switchTo().alert().accept();
		
		//logout
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	}

}
