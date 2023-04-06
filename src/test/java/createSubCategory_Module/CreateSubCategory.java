package createSubCategory_Module;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSubCategory {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");;
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[.='Sub Category ']")).click();
		
		WebElement dropdown = driver.findElement(By.name("category"));
		
		Select s = new Select(dropdown);
		s.selectByVisibleText("Umbrella676");
		
		driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("5 Folds");
		driver.findElement(By.xpath("//button[.='Create']")).click();
		
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
