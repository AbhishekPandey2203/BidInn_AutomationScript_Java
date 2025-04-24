package day22;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//understanding about the id name linktest partiallinktest class and tag
public class SecondTest {

	public static void main(String[] args) {
         
		
		//again import the webdriver
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.geeksforgeeks.org/");
		driver.manage().window().maximize();  // this command is used to get the maximize window in the browser
		
		
		//let understand that ki hmre pass ek search tab h and hume ushme search krna toh krenge
		//understand about the name locator
		
//		driver.findElement(By.name("Search...")).sendKeys("DSA");  //using the name only when we have a name attribute
		
		 
		//understanding id--------concept By.id and we have to pass id with the id value
		
		//let understand basically humne kya kiya ki id locator ko test kiya ye simple test tha basically div m id tha uske sath value thi
		// id="comp"  now generally id ke andaar m ek img thi ab hum usse img ko check kr rhe vo display hogi ya nhi---yhi tha isme testing m
	
	//-------------------------------	
//		boolean logoDisplaystatus=driver.findElement(By.id("comp")).isDisplayed();  
	 
	 //isdisplayed will return true or false depend agr img dekhegi ya nhi
//	 System.out.println(logoDisplaystatus);//
		
	 
	 //-------------------------------------------
		
			
	 //linktext and partiallinktext--------Now understand that the linktext is the way
		
//		driver.findElement(By.linkText("Python")).click();  // ye h link text and isme hume linktext m pura linktext pass krte h 
		
		// the above code help to check the linktext of python and also .click() ensure that the particular function is to be open
		
	//partiallinktext only partial value can be passed--------mtlb mane Django m se only Dja pass kiya
		//ye automatically identify krlega match keyword ko then uspe click kr dega
//		driver.findElement(By.partialLinkText("Dja")).click();
		
		
	
//----------Understanding about the class in Locators ..generally they are used to get when we want multiple things at once
	//---as if there are links we have to count the link...so it can be possible using the class---
		// let understand
		
//   List<WebElement>headerlines=driver.findElements(By.className("link"));  ------------------> 
   
   // the above code help to get all the class name having link as a value----
   //now let print
//   System.out.println("The total no of link is"+headerlines.size());
		
		
		
		
//--------------------- Understanding about the tag name concept----
		
		List<WebElement>tagundertsanding=driver.findElements(By.tagName("a"));
		
// the above code help us to understand how many anchor tag is present in the website of gfg
		System.out.println("The no of anchor tag is"+tagundertsanding.size());
		
		
		
		
		
		
		
		
		
		
		
	}

}
