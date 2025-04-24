package annotundersBATest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*  Understanding Beforetest and aftertest method
 * 
 * 
 */
public class AnnoBefTest {
       
	@Test
	void f1()
	{
		System.out.println("The is the first test before test");
	}
	
	@BeforeTest
	void bft()
	{
		System.out.println(" This is execute before test");
	}
	
	
}
