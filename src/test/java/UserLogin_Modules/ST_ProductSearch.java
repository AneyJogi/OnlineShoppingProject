package UserLogin_Modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ST_ProductSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.name("email")).sendKeys("tester@gmail.com");
		driver.findElement(By.name("password")).sendKeys("tester@123");;
		driver.findElement(By.name("login")).click();
		
		//click on home
		driver.findElement(By.xpath("//a[.='Home']")).click();
		
		//click on category
		driver.findElement(By.xpath("//a[contains(.,'Umbrella676')]")).click();
		
		//click on sub-category
		driver.findElement(By.xpath("//a[contains(.,' 5 Folds')]")).click();
		
		//click on pdt
		driver.findElement(By.xpath("//img[@src='admin/productimages/238/Img1.png']")).click();
		
		//logout
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();

	}

}