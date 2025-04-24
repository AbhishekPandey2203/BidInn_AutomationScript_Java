package annotunders;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Today at 20-03 we here to understand about the annotation of TestNG which include understanding of 

// Login logout and other thing also
/*
 * Login---@BeforeMethod
 * Search----@Test
 * Logout----@AfterMethod
 */

public class AnnotationDemo1 {
	
	@BeforeMethod        // @beforemethod is used to avoid multiple time write and it execute always 
	                       // before main test method
     void login()
     {
    	 System.out.println(" The user is login in the system");
     }
     
     @Test(priority=1)            //Main test method
     void search()
     {
    	 System.out.println("The user is try to search in the system");
     }
     
     @AfterMethod               //exceute after every main @test method execution
     void logout()
     {
    	 System.out.println(" The user is try to logout from the system");
     }
     
     @Test(priority=2)                            //second main method
     void userprofile()
     {
    	 System.out.println("The user is try to get their profile");
     }
     
     
	
     
     

}
