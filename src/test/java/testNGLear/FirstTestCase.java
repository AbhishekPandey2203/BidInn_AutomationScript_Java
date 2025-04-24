package testNGLear;

import org.testng.annotations.Test;

// Now this is help us to learn the TestNG---a library used to write test case
/*
 * now we dont use main method here--public void main we dont use here
 * 
 * Let make a simple method just to understand about the TestNG
 * 
 * 
 *  By default testng exceute all in alphabetical order to avoid it we use priority numbering 
 *  @Test(priority=1)
 * 
 */

public class FirstTestCase {
	
	//open an app/website
	
	//void app(){}== is a method
	
	@Test(priority=1)                 //mandatory to add this bcz it is a procedure we need to follow
	void openapp()
	{
		System.out.println("The application is open");
		
	}
	
     @Test(priority=2)
	void login() {
		
    	 System.out.println("The application is login");
	}
     
     @Test(priority=3)
     void logout() {
    	 
    	 System.out.println("The application is logout");
    	 
     }
	
	
	

}
