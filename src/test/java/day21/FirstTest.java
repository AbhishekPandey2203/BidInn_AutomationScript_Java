package day21;

import org.openqa.selenium.chrome.ChromeDriver;   //import the chromedriver
import org.openqa.selenium.WebDriver;

/*
 * It is the first java program that is used to create the basic first test case
 * now the test case is 
 * 1.launch the browser(chrome)
 * 2.open url
 * 3.validate title 
 * 4.close the browser
 * 
 * 
 */

public class FirstTest {

	public static void main(String[] args) {
	
		//performing the step one---launch the browser using the chromedriver class
//		ChromeDriver driver=new ChromeDriver();
	    //but we can use the parent class ----------Webdriver and then also launch it
		WebDriver driver=new ChromeDriver();
		
		// now open the url----it will open the url of the opencart
		driver.get("https://www.bidinn.in/");
		
		
		//3.validate
		// for this first we get title of the opencart
		
		String gettile= driver.getTitle();
		System.out.println(gettile);
		
//		
//		if(gettile.equals("OpenCart - Open Source Shopping Cart Solution"))
//		{
//			System.out.println("Test Passed");
//		}else
//		{
//			System.out.println("Test Failed");
//		}
		
		//now close the browser
		
		driver.close();  
		
		//or we can also use driver.quit
		
		
		
		

	}

}
