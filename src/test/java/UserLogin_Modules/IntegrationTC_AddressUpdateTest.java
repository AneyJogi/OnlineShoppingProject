package UserLogin_Modules;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntegrationTC_AddressUpdateTest {


		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String path = "http://rmgtestingserver/domain/Online_Shopping_Application/index.php";
			driver.get(path);
		    driver.findElement(By.xpath("//a[@href='login.php']")).click();
			driver.findElement(By.name("email")).sendKeys("krishnaskm326@gmail.com");
			driver.findElement(By.name("password")).sendKeys("1234567890");
			driver.findElement(By.name("login")).click();
			driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
			driver.findElement(By.xpath("//a[.='Shipping / Billing Address']")).click();
			driver.findElement(By.name("billingaddress")).clear();
			driver.findElement(By.name("billingaddress")).sendKeys("302,nspalaya");
			driver.findElement(By.name("bilingstate")).clear();
			driver.findElement(By.name("bilingstate")).sendKeys("chennai");
			driver.findElement(By.name("billingcity")).clear();
			driver.findElement(By.name("billingcity")).sendKeys("tamilnadu");
			driver.findElement(By.name("billingpincode")).clear();
			driver.findElement(By.name("billingpincode")).sendKeys("600002");
			driver.findElement(By.name("update")).click();
			int exe = 0;
			try {
		    driver.switchTo().alert().accept();
		    exe++;
			}
			catch (Exception e) {
			}
			if(exe==1) {
				System.out.println("address successfully updated"+ " TC Pass");
			}
			
		}

	}



