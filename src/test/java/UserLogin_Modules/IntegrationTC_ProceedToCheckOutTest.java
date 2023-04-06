package UserLogin_Modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntegrationTC_ProceedToCheckOutTest {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	String path = "http://rmgtestingserver/domain/Online_Shopping_Application/index.php";
	driver.get(path);
	
       //1.verify navigate to apps 
    String title1 = driver.getTitle();
	if(title1.contains("Home")) {
	System.out.println("1.home page displayed");
	}

	driver.findElement(By.xpath("//a[@href='login.php']")).click();

		//2.verify navigate to apps 
			String title2 = driver.getTitle();
			if(title2.contains("Sign")) {
			System.out.println("2.signin page displayed");
			}
	driver.findElement(By.name("email")).sendKeys("krishnaskm326@gmail.com");
	driver.findElement(By.name("password")).sendKeys("1234567890");
	driver.findElement(By.name("login")).click();
	
		// 3.verify login
	String title3 = driver.getTitle();
	if(title3.contains("My Cart")) {
		System.out.println("3.my cart page displayed");
	}
	driver.findElement(By.xpath("//a[.=' womens']")).click();
	
		// 4.verify category
	String title4 = driver.getTitle();
	if(title4.contains("Product")) {
		System.out.println("4.product category page displayed");
	}
	driver.findElement(By.xpath("//a[contains(text(),'t-shirts')]")).click();
	
		// 5.verify sub-category
			String title5 = driver.getTitle();
			if(title5.contains("Product")) {
				System.out.println("5.product category page displayed");
			}
	driver.findElement(By.xpath("//a/img[1]")).click();
	
		//6.verify product details
	String title6 = driver.getTitle();
	if(title6.contains("Product")) {
		System.out.println("6.product page displayed");
	}
	
		//7.verify add to cart
	driver.findElement(By.xpath("//div[1]/div[3]/a")).click();
	driver.switchTo().alert().accept();
	String title7 = driver.getTitle();
	if(title7.contains("My cart")) {
		System.out.println("7.my cart page displayed");
	}
	
		// verify payment
	driver.findElement(By.xpath("//button[.='PROCCED TO CHEKOUT']")).click();
	String data = driver.getTitle();
	if(data.contains("ament")) {
		System.out.println("TC Result: "+data+" displayed successfully"+" TC Pass");
	}
	driver.findElement(By.xpath("//input[@value='COD']")).click();
	driver.findElement(By.name("submit")).click();
	
	
		//8.verify logout
	driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	String result = driver.getTitle();
	System.out.println(result);
	if(result.contains("Home")) {
		System.out.println(result+" displayed successfully"+" TC Pass");
	}
	Thread.sleep(300);
	driver.close();

}

}
