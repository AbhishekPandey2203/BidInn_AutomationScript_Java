package testNGLear;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*  Bidinn testing
 * Here we try to learn how to use testNG actually for website working 
 * Login and signup
 * open website
 * login
 * check
 * logout
 */

public class LoginTest {
	  
//	WebDriver driver;
//	@Test(priority=1)
//	void openweb()
//	{  
//		 driver=new ChromeDriver();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.bidinn.in/");
//		driver.manage().window().maximize();
//		
//	}
//	
//	@Test(priority=2)
//	void testlogin() throws InterruptedException
//	{     
//		driver.findElement(By.xpath("//a[text()=\"Login / Signup\"]")).click();
//		Thread.sleep(500);
//		// sending the number
//		driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys("9988776655");
//		
//		// click the otp button functionality
//		
//		driver.findElement(By.xpath("//button[text()=\"Send OTP\"]")).click();
//		
//		//sending the otp manually 
//		 
//		Thread.sleep(500); //generally thread is used to pause the time 
//		
//		// generally thread help krta like click kr diya aur click ke baad hume kuch time chye 
//		//toh thread ushe time ko laane m---this is the role of thread
//		driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).sendKeys("1");
//		driver.findElement(By.xpath("(//input[@type=\"number\"])[2]")).sendKeys("2");
//		driver.findElement(By.xpath("(//input[@type=\"number\"])[3]")).sendKeys("3");
//		driver.findElement(By.xpath("(//input[@type=\"number\"])[4]")).sendKeys("4");
//		driver.findElement(By.xpath("(//input[@type=\"number\"])[5]")).sendKeys("5");
//		driver.findElement(By.xpath("(//input[@type=\"number\"])[6]")).sendKeys("6");
//		
//		
//		//clicking the verifyotp button
//		driver.findElement(By.xpath("//button[text()=\"Verify OTP\"]")).click();
//		Thread.sleep(300);
//		
//		Thread.sleep(500);
//		
//	}
//	
//	@Test(priority=3)
//	void verifyuser() throws InterruptedException
//	{  
//		//now avoid the pop this time----now let verify the user 
//		
//	//again checking the avatar
//	driver.findElement(By.xpath("//img[@alt=\"User Avatar\"]")).click();
//				
//				//click the profile section
//		driver.findElement(By.xpath("//a[@href=\"/user-dashboard\"]")).click();
//				
//				
//				
//		// now at last validating the
//		Thread.sleep(400);
//		boolean havedisplayed=!(driver.findElement(By.xpath("//*[text()=\"Shyam\"]")).isDisplayed());
//				
//				
//				System.out.println("The user is"+havedisplayed+" displayed and it ");
//		
//	}
//	
//	
//	@Test(priority=4)
//	void logout() {
//		
//		
//		driver.quit();
//	}
	
	

	// making all under one method------
	
	WebDriver driver;
	@Test
	
	void verifyUser() throws InterruptedException
	{
		
		
		
		
		
		 driver=new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.bidinn.in/");
			driver.manage().window().maximize();
			
		    
			driver.findElement(By.xpath("//a[text()=\"Login / Signup\"]")).click();
			Thread.sleep(500);
			// sending the number
			driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys("9988776655");
			
			// click the otp button functionality
			
			driver.findElement(By.xpath("//button[text()=\"Send OTP\"]")).click();
			
			//sending the otp manually 
			 
			Thread.sleep(500); //generally thread is used to pause the time 
			
			// generally thread help krta like click kr diya aur click ke baad hume kuch time chye 
			//toh thread ushe time ko laane m---this is the role of thread
			driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).sendKeys("1");
			driver.findElement(By.xpath("(//input[@type=\"number\"])[2]")).sendKeys("2");
			driver.findElement(By.xpath("(//input[@type=\"number\"])[3]")).sendKeys("3");
			driver.findElement(By.xpath("(//input[@type=\"number\"])[4]")).sendKeys("4");
			driver.findElement(By.xpath("(//input[@type=\"number\"])[5]")).sendKeys("5");
			driver.findElement(By.xpath("(//input[@type=\"number\"])[6]")).sendKeys("6");
			
			
			//clicking the verifyotp button
			driver.findElement(By.xpath("//button[text()=\"Verify OTP\"]")).click();
			Thread.sleep(300);
			
			Thread.sleep(500);
			
		 
			//now avoid the pop this time----now let verify the user 
			
		//again checking the avatar
		driver.findElement(By.xpath("//img[@alt=\"User Avatar\"]")).click();
					
					//click the profile section
			driver.findElement(By.xpath("//a[@href=\"/user-dashboard\"]")).click();
					
					
					
			// now at last validating the
			Thread.sleep(400);
			boolean havedisplayed=!(driver.findElement(By.xpath("//*[text()=\"Shyam\"]")).isDisplayed());
					
					
					System.out.println("The user is"+havedisplayed+" displayed and it ");
			
	
			
			
			driver.quit();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
