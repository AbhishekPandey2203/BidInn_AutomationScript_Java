package bidinnfooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//task to check the footer

public class TestBidinnfooter {
	    
    WebDriver driver;
    
   
	@BeforeMethod
	void commancode()
	{  
		    driver=new ChromeDriver();
			driver.get("https://www.bidinn.in/");
			driver.manage().window().maximize();
			
		
	}
	
	
    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit(); // Ensures the session is fully terminated
        }
    }

	    @Test
        void FooterAboutus() throws InterruptedException
        {      String val="About - Bidinn";  
	    	   
                
                Thread.sleep(5000);               
                WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
                  
                
                
                
                Thread.sleep(1000);
                
                WebElement aboutbid = 	driver.findElement(By.xpath("//a[text()='About Us,']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutbid);
                aboutbid.click(); 
   	         
                
                Thread.sleep(1000);
               String name=driver.getTitle();
               
               Assert.assertTrue(val.equals(name));

   	    	
                
        }
	    
	    @Test
	    void contactus() throws InterruptedException
	    {
	    	String val="ContactUs - Bidinn";  
	    	   
	    	 Thread.sleep(5000);               
             WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
               
             
             
             
             Thread.sleep(1000);
             
             WebElement contactus= 	driver.findElement(By.xpath("//a[text()='Contact Us & Support,']"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactus);
             contactus.click(); 
	         
             
             Thread.sleep(1000);
            String name=driver.getTitle();
            
            Assert.assertTrue(val.equals(name));


	    }
	    
	    @Test
	    void whychooseus() throws InterruptedException
	    {
	    	String val="Bidinn | why choose us - Bidinn";  
	    	   
           
              
	    	 Thread.sleep(5000);               
             WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
               
             
             
             
             Thread.sleep(1000);
             
             WebElement whychos= 	driver.findElement(By.xpath("//a[text()='Why Choose Us?']"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whychos);
             whychos.click(); 
	         
             
             Thread.sleep(1000);
            String name=driver.getTitle();
            
            Assert.assertTrue(val.equals(name));

	    }
	    
	    
	    @Test
	    void VerifyTermscondition() throws InterruptedException
	    {
	    	String val="Terms & Conditions - bidinn.in - Bidinn";  
	    	   
	    	  
	    	 Thread.sleep(5000);               
            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
              
            
            
            
            Thread.sleep(1000);
            
            WebElement whychos= 	driver.findElement(By.xpath("//a[text()='Terms & Conditions,']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whychos);
            whychos.click(); 
	         
            
            Thread.sleep(1000);
           String name=driver.getTitle();
           
           Assert.assertTrue(val.equals(name));

	    }
	    
	    @Test
	    void Verifyprivacy() throws InterruptedException
	    {
	    	String val="Privacy Policy - bidinn.in - Bidinn";  
	    	   
	    	 Thread.sleep(5000);               
	            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
	              
	            
	            
	            
	            Thread.sleep(1000);
	            
	            WebElement privpol= 	driver.findElement(By.xpath("//a[text()='Privacy Policy,']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privpol);
	            privpol.click(); 
		         
	            
	            Thread.sleep(1000);
	           String name=driver.getTitle();
	           
	           Assert.assertTrue(val.equals(name));

	    }
	    
	    @Test
	    void Verifycancel() throws InterruptedException
	    {
	    	String val="Refund Policy - bidinn.in - Bidinn";  
	    	   
	    	  
	    	 Thread.sleep(5000);               
	            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
	              
	            
	            
	            
	            Thread.sleep(1000);
	            
	            WebElement cancella= 	driver.findElement(By.xpath("//a[text()='Cancellation & Refund Policy,']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancella);
	            cancella.click(); 
		         
	            
	            Thread.sleep(1000);
	           String name=driver.getTitle();
	           
	           Assert.assertTrue(val.equals(name));

	    }
	    
	    
	    @Test
	    void Verifycookies() throws InterruptedException
	    {
	    	String val="Bidinn - Your Top Choice for the Best Online Hotel Booking Platform";  
	    	   
	    	 Thread.sleep(5000);               
	            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
	              
	            
	            
	            
	            Thread.sleep(1000);
	            
	            WebElement cancella= 	driver.findElement(By.xpath("//a[text()='Cookies Policy']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancella);
	            cancella.click(); 
		         
	            
	            Thread.sleep(1000);
	           String name=driver.getTitle();
	           
	           Assert.assertTrue(val.equals(name));
	    }
	    
	    
//Verify SocialMediaLink------
	    
	    
	    @Test
	    void VerifyYoutube() throws InterruptedException
	    {
	    	 String val="Bidinn - YouTube";
	    	   
	    	 Thread.sleep(5000);               
	            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
	              
	            
	            
	            
	            Thread.sleep(1000);
	            
	            WebElement cancella= 	driver.findElement(By.xpath("(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium mui-yzntps'])[1]"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancella);
	            cancella.click(); 
		         
	            
	            Thread.sleep(1000);
	           String name=driver.getTitle();
	           
	           System.out.println("The val "+name);
	           
	           Assert.assertTrue(val.equals(name));
	    }
	    
	    
	    
	    @Test
	    void VerifyTwitter() throws InterruptedException
	    {
	    	 String val="Profile / X";
	    	   
	    	 Thread.sleep(5000);               
	            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
	              
	            
	            
	            
	            Thread.sleep(1000);
	            
	            WebElement cancella= 	driver.findElement(By.xpath("(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium mui-yzntps'])[2]"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancella);
	            cancella.click(); 
		         
	            
	            Thread.sleep(1000);
	           String name=driver.getTitle();
	           
	           System.out.println("The val "+name);
	           
	           Assert.assertTrue(val.equals(name));
	    }
	    
	    @Test
	    void VerifyInsta() throws InterruptedException
	    {
	    	 String val="BID INN (@bidinnofficial) • Instagram photos and videos";
	    	   
	    	 Thread.sleep(5000);               
	            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
	              
	            
	            
	            
	            Thread.sleep(3000);
	            
	            driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
	            
	            
	            Thread.sleep(3000);
	            WebElement insta= 	driver.findElement(By.xpath("(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium mui-yzntps'])[3]"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", insta);
	            insta.click(); 
		         
	            
	            Thread.sleep(1000);
	           String name=driver.getTitle();
	           
	           System.out.println("The val "+name);
	           
	           Assert.assertTrue(val.equals(name));
	    }
	    
	    
	    
	    @Test
	    void VerifyFb() throws InterruptedException
	    {
	    	 String val="Bid Inn | Noida | Facebook";
	    	   
	    	 Thread.sleep(5000);               
	            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
	              
	            
	            
	            
	            Thread.sleep(3000);
	            
	            driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
	            
	            
	            Thread.sleep(3000);
	            WebElement insta= 	driver.findElement(By.xpath("(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium mui-yzntps'])[4]"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", insta);
	            insta.click(); 
		         
	            
	            Thread.sleep(1000);
	           String name=driver.getTitle();
	           
	           System.out.println("The val "+name);
	           
	           Assert.assertTrue(val.equals(name));
	    }
	    
	    
	    @Test
	     void VerifyLinkedin() throws InterruptedException
	    {  String val="BidINN | LinkedIn";
	    	Thread.sleep(5000);               
            WebElement searchfooter = driver.findElement(By.xpath("//h5[text()='States of India']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
              
            
            
            
            Thread.sleep(3000);
            
            driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
            
            
            Thread.sleep(3000);
            WebElement insta= 	driver.findElement(By.xpath("(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium mui-yzntps'])[5]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", insta);
            insta.click(); 
	         
            
            Thread.sleep(1000);
           String name=driver.getTitle();
           
           System.out.println("The val "+name);
           
           Assert.assertTrue(val.equals(name));
	    }
	    
  
	

}
