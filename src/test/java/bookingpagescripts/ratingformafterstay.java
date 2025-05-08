package bookingpagescripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


//8May2025**
public class ratingformafterstay {

	WebDriver driver;
	
	void LoginButtonclick() throws InterruptedException
	{  
		String expectedName="Shyam";
		 driver=new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bidinn.in/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		//click 
		driver.findElement(By.xpath("//button[normalize-space()='Login / Sign-up']")).click();
		Thread.sleep(200);
		
		//click on first
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart mui-1ooubvk']")).click();
		
		Thread.sleep(1000);
		//sending number
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart mui-1ooubvk']")).sendKeys("9988776655");
		
		//click
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		Thread.sleep(500);
		
		//sending otp
		
		driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).sendKeys("5");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[2]")).sendKeys("4");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[3]")).sendKeys("7");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[4]")).sendKeys("6");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[5]")).sendKeys("9");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[6]")).sendKeys("8");
		
//		Thread.sleep(300);
		
		//click
		driver.findElement(By.xpath("//button[text()=\"Verify OTP\"]")).click();
		
//		Thread.sleep(300);
//		
//		Thread.sleep(500);
		
		WebElement elem=driver.findElement(By.xpath("//span[contains(@style, 'padding-left: 6px')]"));
		Thread.sleep(100);
		

		   
	}
	
////	
    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit(); // Ensures the session is fully terminated
        }
    }

   //My booking---
    
 
    void mybookingsbutton() throws InterruptedException {
        Thread.sleep(1000);

        LoginButtonclick();

    
        driver.findElement(By.xpath("//button[text()='My Bookings']")).click();
        Thread.sleep(1000);

        // Click on 'Completed' tab
        WebElement completedBtn = driver.findElement(By.xpath("(//button[contains(@class,'inline-flex items-center justify-center whitespace-nowrap')])[3]"));
        completedBtn.click();
    
        Thread.sleep(1000);
         driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
         
        
         Thread.sleep(1000);
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
       
        //move to the hotel
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
        WebElement mvtohotel = driver.findElement(By.xpath("//h6[text()='1306242']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mvtohotel);

        
        mvtohotel.click();

    }
    
    
    
    @Test
    void RateHotelformisworkornot() throws InterruptedException
    {
    	
    	mybookingsbutton();
    	Thread.sleep(1000);
        
        //click on rate hotel
    	 driver.findElement(By.xpath("//button[text()='Rate Hotel']")).click();
    	
    	WebElement txtarea= driver.findElement(By.tagName("textarea"));
    	   txtarea.click();
    	 
    	   txtarea.sendKeys("My honest review");
    	 
    	List<WebElement>elm=  driver.findElements(By.xpath("//span[@class='MuiRating-root MuiRating-sizeMedium mui-r2qk9h']"));
    	
    	for(WebElement el:elm) {
    		
    		el.click();
    	}
    	
    	
    	WebElement subreview=driver.findElement(By.xpath("//button[text()='Submit Review']"));
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subreview);

     
    	 //click on it--
    	 if(subreview.isEnabled())
    		 System.out.println("Submit Review Button Work!!");
    	 
    	 
    	
    }
    
    
    
    
    

}
