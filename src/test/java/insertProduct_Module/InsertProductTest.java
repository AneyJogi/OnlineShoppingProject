package insertProduct_Module;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertProductTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
			
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME=fLib.readDataFromPropertyFile("username");
		String PASSWORD=fLib.readDataFromPropertyFile("password");
		    
		   
		WebDriverManager.chromedriver().setup();
	    WebDriver driver= new ChromeDriver();
		
		wLib.maximizeWindow(driver);					//		driver.manage().window().maximize();
		wLib.waitForPageLoad(driver);					//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get(URL);                                //driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);;
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[.='Insert Product ']")).click();
		WebElement categorydropdown = driver.findElement(By.xpath("//select[@name='category']"));
		
        wLib.select("Umbrella676", categorydropdown);     //		Select s = new Select(categorydropdown);
                                                          //		s.selectByVisibleText("Umbrella676");
		
		WebElement subcategorydropdown = driver.findElement(By.xpath("//select[@name='subcategory']"));
		
		wLib.select(subcategorydropdown,"303");			  //		Select s1 = new Select(subcategorydropdown);
														  //		s1.selectByValue("303");
		
//		driver.findElement(By.name("productName")).sendKeys("Fendo");
//		driver.findElement(By.name("productCompany")).sendKeys("EF COMPANY LTD");
//		driver.findElement(By.name("productpricebd")).sendKeys("1250");
//		driver.findElement(By.name("productprice")).sendKeys("950");
//		driver.findElement(By.name("productDescription")).sendKeys("Stay dry & Stay stylish with our high quality umbrella");
//		driver.findElement(By.name("productShippingcharge")).sendKeys("100");
		
		HashMap<String, String> map = eLib.readMultipleData("Organisation");
		
		for(Entry<String, String> set:map.entrySet()) 	
		{
			if(set.getKey().equalsIgnoreCase("productName"))
			{
		     driver.findElement((By.name(set.getKey()))).sendKeys(set.getValue()+jLib.random());
			}
			else
			{
				driver.findElement((By.name(set.getKey()))).sendKeys(set.getValue());
			}
			
		}
		
		
		WebElement availabilitydropdown = driver.findElement(By.id("productAvailability"));
		 wLib.select(availabilitydropdown, "In Stock");  //Select s3= new Select(availabilitydropdown);
		                                                 //s3.selectByValue("In Stock");
		
		
		
		File f1=new File("./PdtImg/Img1.png");
		String path1 = f1.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='productimage1']")).sendKeys(path1);
		
		File f2=new File("./PdtImg/Img2.png");
		String path2 = f2.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys(path2);
		
		File f3=new File("./PdtImg/Img3.png");
		String path3 = f3.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys(path3);
		
		driver.findElement(By.xpath("//button[.='Insert']")).click();
		
	}

}
