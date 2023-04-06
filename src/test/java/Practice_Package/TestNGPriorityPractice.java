package Practice_Package;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPriorityPractice {
	
	@Test()
	public void create()
	{
		Assert.fail();
		System.out.println("create customer");
	}
	
	@Test(dependsOnMethods="create")
	public void insert()
	{
		System.out.println("Insert customer");
	}
	
	@Test(invocationCount=2)
	public void delete()
	{
		System.out.println("delete Customer");
	}

}
