package annotunders;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Today at 20-03 we here to understand about the annotation of TestNG which include understanding of 

// Login logout and other thing also
/*
 * Login---@BeforeClass
 * Search----@Test
 * AdvanceSearc---@Test
 * Logout----@AfterClass
 */

public class AnnotationDemo2 {
	
	@BeforeClass        // @beforeClass is used to avoid multiple time write and it execute always once
	                       // before exceution of all main test case
     void login()
     {
    	 System.out.println(" The user is login in the system once");
     }
     
     @Test(priority=1)            //Main test method
     void search()
     {
    	 System.out.println("The user is try to search in the system");
     }
     
     @AfterClass              //exceute after only all the main @test method execution and only once it
                              //exceute
     void logout()
     {
    	 System.out.println(" The user is try to logout from the system after all the testcase execute");
     }
     
     @Test(priority=2)                            //second main method
     void userprofile()
     {
    	 System.out.println("The user is try to get their profile");
     }
     
     
	
     
     

}
