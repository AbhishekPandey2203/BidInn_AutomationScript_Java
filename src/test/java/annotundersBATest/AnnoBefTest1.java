package annotundersBATest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AnnoBefTest1 {
	
	@Test
	void f2()
	{
		System.out.println(" The is another class");
	}
	
	
	@AfterTest
	void aft()
	{
		System.out.println(" This is exceute after test");
	}

}
