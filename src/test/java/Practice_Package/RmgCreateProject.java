package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgCreateProject {

	public static void main(String[] args) throws Throwable {
		
		
		DatabaseUtility dLib = new DatabaseUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility(); 
		WebDriverUtility wLib = new WebDriverUtility();
		
		Connection con = null;
		
		String expProj="Emart";
		//Resultset result=null;
		
		try
		{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver:8084/");
		
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("Emart");
		driver.findElement(By.name("createdBy")).sendKeys("ANEY");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select sel= new Select(ele);
		sel.selectByValue("Completed");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		 Driver driver1= new Driver();
		 DriverManager.registerDriver(driver1);
		 con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		 Statement state = con.createStatement();
		 String query = "select * from project;";
		ResultSet result = state.executeQuery(query);
		 
		 boolean flag= false;
		 while(result.next())
		 {
			 String actProj = result.getString(4);
			 System.out.println(actProj);
			 if(actProj.equalsIgnoreCase(expProj))
			 {
				 flag=true;
				 break;
			 }
		 }
		 
		 if(flag)
		 {
			 System.out.println("Project created");
		 }
		 
		 else 
		 {
			 System.out.println("Project not created");
		 }
		 
		}
	
		 catch(Exception e)
		 {
			 
		 }
		 
		 finally 
		 {
			con.close();
		 }
		 
		}
	}
	

	
		


