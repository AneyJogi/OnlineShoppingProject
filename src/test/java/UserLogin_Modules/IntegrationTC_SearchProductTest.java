package UserLogin_Modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntegrationTC_SearchProductTest {
	
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
		driver.findElement(By.name("product")).sendKeys("seventy eight");
		driver.findElement(By.xpath("//button[@name='search']")).click();
		String result = driver.getTitle();
		System.out.println(result);
		if(result.contains("Product")) {
		System.out.println(result+" page displayed successfully" +" TC Pass");
	}
	}

}
