package hotelpagelogincheckup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyloginhotelpage {
	
	WebDriver driver;
	
	
	//*******************---------logincheck at hotel page-----***********************************
	
	
	
	
	
//	
	@BeforeTest
	void verifyuser() throws InterruptedException
	{  
		
		 driver=new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bidinn.in/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		//click 
		driver.findElement(By.xpath("//a[text()=\"Login / Signup\"]")).click();
		Thread.sleep(200);
		
		//sending number
		driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys("9988776655");
		
		//click
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
		Thread.sleep(500);
		
		//sending otp
		
		driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).sendKeys("1");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[2]")).sendKeys("2");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[3]")).sendKeys("3");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[4]")).sendKeys("4");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[5]")).sendKeys("5");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[6]")).sendKeys("6");
		
		Thread.sleep(300);
		
		//click
		driver.findElement(By.xpath("//button[text()=\"Verify OTP\"]")).click();
		
		
		Thread.sleep(2000);
	}
	
	
	
	void searchfirst() throws InterruptedException
	{
				//--------------- searchbox
		//hotel name insertion
				driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Noida");
				  Thread.sleep(500);
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"MuiAutocomplete-endAdornment mui-mxlkbn\"]")));
			     element.click();
			        
		         driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Noida");
				  
		         Thread.sleep(1000);
		       
		         driver.findElement(By.xpath("(//p[text()='Noida'])[3]")).click();
		         

		         

//		           //calender chose
		           driver.findElement(By.xpath("//div[@class='MuiBox-root mui-1jke4yk']")).click();
		           driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
//		           
//		           //now choose the date start--by default end also select 
		           driver.findElement(By.xpath("(//span[@class='rdrDayNumber'])[5]")).click();
//
//		           //------guest choose
//		           //first click
//		           
		           driver.findElement(By.xpath("//p[text()='2 Guests, 1 Room']")).click();
//		           
//		             //set the guest count---
//		           
		           driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[1]")).click();           
		           driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[2]")).click(); 
		           driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[3]")).click(); 
		           
		           Thread.sleep(1000);
		           
		           driver.findElement(By.xpath("//button[text()='Done']")).click();
		           
		           
		           //click the search button
		           driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
		            
		           
		           
		           
	//----------------------new page open-----
		           	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
		void loginverify() throws InterruptedException {   
		
		    Thread.sleep(1000);
	        searchfirst();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        try {
	            WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'MuiButton-disableElevation')]")));
	            String buttonText = loginButton.getText();

	            if ("Login".equals(buttonText)) {  
	                loginButton.click();
	                System.out.println("User needs to log in.");
	            } else {
	                System.out.println("User is already logged in.");
	            }
	        } catch (Exception e) {
	            // If the login button is not found, print another available attribute
	            try {
	                WebElement userProfile = driver.findElement(By.xpath("//a[contains(@href, '/user-dashboard')]"));
	                  userProfile.click();
	                  Thread.sleep(1000);
	                   WebElement usern=driver.findElement(By.xpath("//span[@class='hidden lg:block']"));
	                System.out.println("User is already logged in and user name is "+ usern.getText());
	            } catch (Exception ex) {
	                System.out.println("Could not determine login status.");
	            }
	        }

	        driver.quit();
	    }

}
