package UserLogin_Modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntegrationTC_WishListToAddToCart {

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
		//------------------------------------------------------------------------//
		driver.findElement(By.name("product")).sendKeys("SEVENTY EIGHT");
		driver.findElement(By.xpath("//button[@name='search']")).click();
		driver.findElement(By.xpath("//a[@title='Wishlist']/i")).click();
		driver.findElement(By.xpath("//a[.='Add to cart']")).click();
		driver.findElement(By.xpath("//a[text()='My Cart']")).click();
		String result = driver.findElement(By.xpath("//td[3]/h4/a[text()='seventy eight']")).getText();
		System.out.println(result);
		if(result.contains("SEVENTY EIGHT")) {
			System.out.println(result+" product successfully added to my cart list"+" TC Pass");
		}
	}

}