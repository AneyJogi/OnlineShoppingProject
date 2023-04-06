package Practice_Package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathICCDataPresentOrNot {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String teamsName="India";
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		boolean flag=false;
		for(WebElement name:teams)
		{
			String text= name.getText();
			if(text.equals(teamsName))
			{
				flag=true;
				break;
			}
			

		}
			if(!flag)
			{
				System.out.println("data not present");
			}
				else
					
			{
			   System.out.println("data present in table");
			}

}
}