package dependencymethunder;

import org.testng.Assert;
import org.testng.annotations.Test;

//  Understanding about the dependency understanding
//mtlb agar openapp() nhi hua toh aage ke bhi nhi chlne chye so asa krne ke liye 
//hum use krenege dependency concept ka


public class DependencyUndersta {
	 
	@Test(priority=1)
	void openapp()
	{   
		Assert.assertTrue(false);  //smje agr openapp fail toh vo uspe depend wale ko skip krdega
		System.out.println(" The app is open");
	}
	
	@Test(priority=2,dependsOnMethods= {"openapp"})
	void login()
	{
		System.out.println(" If app open please login");
	}
	
	
	@Test(priority=3,dependsOnMethods= {"login"})
	void search()
	{
		System.out.println(" If login you can search");
	}
	
	
	@Test(priority=4,dependsOnMethods= {"login"})
	void advsearch()
	{
		System.out.println(" If login you can advance search");
	}
	
	@Test(priority=5)
	void logout()
	{
		System.out.println("Let do logout");
	}

}
