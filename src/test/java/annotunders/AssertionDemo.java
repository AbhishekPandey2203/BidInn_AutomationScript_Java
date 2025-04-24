package annotunders;

import org.testng.Assert;
import org.testng.annotations.Test;

//Understanding about the assertion in TestNG---
public class AssertionDemo {
	
	@Test
//	void testTitle()
//	{
//		  String exp_st="Bidinn";
//		  String actget="MakeMytrip";
//		  
//		  if(exp_st.equals(actget))
//		  {
//			  System.out.println(" The string is equal");
//		  }
//		  else
//		  {
//			  System.out.println(" The string is not equal");
//		  }
//	}
	
	// Logical agr string equal nhi h toh humara method fail hona chye but asa nhi hua 
	// yhi logically glt hua islye assertion ka use kiya
	
	
	
   //-----------------------------Assertion understanding ----------------
	
	
	void testtitle()
	{
		  
//		 String exp_st="Bidinn";
//		  String actget="MakeMytrip";
		  
		  //asert class importing
		  
//		  Assert.assertEquals(exp_st, actget);  //fail the testcase  : FAILED: annotunders.AssertionDemo.testtitle
//		
		
	// test case passing secenario-----------
		
		String exp_st="Bidinn";
		String actget="Bidinn";
		
		Assert.assertEquals(exp_st, actget);  //   PASSED: annotunders.AssertionDemo.testtitle
		  
		
		
	}
	
	
	
}
