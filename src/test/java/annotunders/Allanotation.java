package annotunders;

/*
 *  the specified class is used to understand all TestNG annotation
 */
// importing all testing
 import org.testng.annotations.*;

public class Allanotation {
	
	@BeforeSuite
	void bs()
	{
		System.out.println("This is execute before suite");
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("This is execute after suite");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("This is execute before test");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("This is execute after test");
	}
	
	
	@BeforeClass
	void bc()
	{
		System.out.println("This is execute before class");
	}
	
	@AfterClass
	void ac()
	{
		System.out.println("This is execute after class");
	}
	
	
	@BeforeMethod
	void bm()
	{
		System.out.println("This is execut before method");
	}
	
	@AfterMethod
	void am()
	{
		System.out.println("This is execute after method");
	}
	
	
	// main test 
	
	@Test(priority=1)
	void test1()
	{
		System.out.println(" The test1 method");
	}
	
	@Test(priority=2)
	void test2()
	{
		System.out.println(" The test2 method");
	}
	
	

}
