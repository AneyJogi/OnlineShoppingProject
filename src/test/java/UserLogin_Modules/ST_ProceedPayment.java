package UserLogin_Modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ST_ProceedPayment {

	public static void main(String[] args) throws Throwable {
		
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		wLib.maximizeWindow(driver);  		//driver.manage().window().maximize();
		wLib.waitForPageLoad(driver);									//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String expectedTilte = "FENDO";
		
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url1");
		String USERNAME=fLib.readDataFromPropertyFile("username1");
		String PASSWORD=fLib.readDataFromPropertyFile("password1");
		
		//Login To App
		
        driver.get(URL);                                               //	driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
        driver.findElement(By.xpath("//a[.='Login']")).click();
        driver.findElement(By.name("email")).sendKeys(USERNAME);       //driver.findElement(By.name("email")).sendKeys("tester@gmail.com");
        driver.findElement(By.name("password")).sendKeys(PASSWORD);    //driver.findElement(By.name("password")).sendKeys("tester@123");;
        driver.findElement(By.name("login")).click();                       
		
		//click on home
		driver.findElement(By.xpath("//a[.='Home']")).click();
				
		//click on category
		driver.findElement(By.xpath("//a[contains(.,'Umbrella676')]")).click();
				
		//click on sub-category
		driver.findElement(By.xpath("//a[contains(.,' 5 Folds')]")).click();
				
	    //click on pdt
		driver.findElement(By.xpath("//img[@src='admin/productimages/238/Img1.png']")).click();
		
		//Add to cart
		driver.findElement(By.xpath("//a[.=' ADD TO CART']")).click();
		
		//handle alter popup
		wLib.acceptAlert(driver);                                   //driver.switchTo().alert().accept();
		
		//Click on My cart
		driver.findElement(By.xpath("//a[.='My Cart']")).click();
		
		//Payment proceeds and submit
		driver.findElement(By.xpath("//button[.='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.xpath("//input[@value='Internet Banking']")).click();
		driver.findElement(By.name("submit")).click();
		
		//validation
		String actualTitle = driver.findElement(By.xpath(("(//tr[last()])[2]"))).getText();
		
		if(actualTitle.contains(expectedTilte))
			
		{
			System.out.println(actualTitle);
			System.out.println("Order Placed successfully");
		}
		
			
			else
			{
				System.out.println("Failed to place order");
			}
				
		//logout
		//driver.findElement(By.xpath("//a[@href='logout.php']")).click();
				
	}
		
}


