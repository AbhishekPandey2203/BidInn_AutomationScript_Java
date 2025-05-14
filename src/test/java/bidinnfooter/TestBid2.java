
package bidinnfooter;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//task to check the footer

public class TestBid2 {
	    
    WebDriver driver;
        @BeforeMethod(alwaysRun=true)   //mean humsa chlega
        void commoncode() throws InterruptedException
        {
        	 driver=new ChromeDriver();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             driver.get("https://www.bidinn.in/");
      
             driver.manage().window().maximize();
              
//             driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
             
             Thread.sleep(500);             
             WebElement searchfooter = driver.findElement(By.xpath("//a[text()='How to Bid']"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchfooter);
             searchfooter.isDisplayed();  
             
             
        }
    
	    @Test(priority=1)
        void footer() throws InterruptedException
        {      String val="About - Bidinn";  
               Thread.sleep(500);
                WebElement aboutbid = 	driver.findElement(By.xpath("//a[text()='About Bidinn']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutbid);
                aboutbid.click(); 
   	         
               String name=driver.getTitle();
               System.out.println("The title is"+name);
               
               Assert.assertTrue(val.equals(name));

   	    	
                
        }
	    
	    @Test(priority=2)
	    void contactus() throws InterruptedException
	    {
	    	String val="ContactUs - Bidinn";  
	    	   
//         
               Thread.sleep(500);
               
               WebElement contacttus = 	driver.findElement(By.xpath("//a[text()='Contact & Support']"));
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contacttus);
               contacttus.click(); 
  	         
              String name=driver.getTitle();
              System.out.println("the title name is"+name);
              
              Assert.assertTrue(val.equals(name));

	    }
	    
	    @Test
	    void whychooseus() throws InterruptedException
	    {
	    	String val="Bidinn | why choose us - Bidinn";  
	    	   

               
               Thread.sleep(500);
               
               WebElement whychooseus = 	driver.findElement(By.xpath("//a[text()='Why Choose Us']"));
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whychooseus);
               whychooseus.click(); 
  	         
              String name=driver.getTitle();
              System.out.println("the title name is"+name);
              
              Assert.assertTrue(val.equals(name));
              driver.quit();

	    }
	    
	    
	    @Test
	    void verifyterms() throws InterruptedException
	    {
	    	String val="Terms & Conditions - bidinn.in - Bidinn";  
	    	   
 
               
               Thread.sleep(500);
               
               WebElement term = 	driver.findElement(By.xpath("//a[text()='Terms and conditions']"));
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", term);
               term.click(); 
  	         
              String name=driver.getTitle();
              System.out.println("the title name is"+name);
              
              Assert.assertTrue(val.equals(name));
              driver.quit();

	    }
	    
	    @Test
	    void verifyprivacy() throws InterruptedException
	    {
	    	String val="Privacy Policy - bidinn.in - Bidinn";  
	    	   
 
               
               Thread.sleep(500);
               
               WebElement privacy = 	driver.findElement(By.xpath("//a[text()='Our Privacy Policy']"));
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacy);
               privacy.click(); 
  	         
              String name=driver.getTitle();
              System.out.println("the title name is"+name);
              
              Assert.assertTrue(val.equals(name));
              driver.quit();

	    }
	    
	    @Test
	    void verifycancel() throws InterruptedException
	    {
	    	String val="Refund Policy - bidinn.in - Bidinn";  
	    	   
       
               Thread.sleep(500);
               
               WebElement cancell = 	driver.findElement(By.xpath("//a[text()='Cancellation & Refund']"));
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancell);
               cancell.click(); 
  	         
              String name=driver.getTitle();
              System.out.println("the title name is"+name);
              
              Assert.assertTrue(val.equals(name));
              driver.quit();

	    }
	    
	    
	    @Test
	    void verifycookies() throws InterruptedException
	    {
	    	String val="Bidinn - Your Top Choice for the Best Online Hotel Booking Platform";  
	    	   
               Thread.sleep(500);
               
               WebElement privacy = 	driver.findElement(By.xpath("//a[text()='Cookies policy']"));
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacy);
               privacy.click(); 
  	         
              String name=driver.getTitle();
              System.out.println("the title name is"+name);
              
              Assert.assertTrue(val.equals(name));
              driver.quit();

	    }
	    
	    @Test
	    void verifyfacelink() throws InterruptedException
	    {  
	    	String val="Bid Inn | Noida";
	    	
	    	Thread.sleep(500);	    	
	    	
	    	 WebElement verifyfacelink = 	driver.findElement(By.xpath("(//a[contains(@class,'mr-3 flex')])[1]"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", verifyfacelink);
             verifyfacelink.click(); 
             Thread.sleep(200);
             
             // ab logically ---new thing ki yaha pe ke new tab open hua mtlb facebook ka 
             //uscase m generally ye hoga ki ab uspe jana hoga--
             //yaha pe aate getwindowhandle aur handles ka concept
             
 
              String parenttab= driver.getWindowHandle();  //parent tab ki id 
                 
                System.out.println(parenttab);
              // now parent child dono ki liye
              
              Set<String>allpc = driver.getWindowHandles();
              
              System.out.println(allpc);
              
              for(String id:allpc)
              {
            	   if(!id.equals(parenttab))
            	   {
            		   //switch to driver to child one
            		   
            		   driver.switchTo().window(id);
            		  String nme=driver.getTitle();
           	    	System.out.println("the title name is"+nme);
           	 	Assert.assertTrue(val.equals(nme));
           	    	driver.close();  //only close the child or the current tab 
            		   
            	   }
              }
              
              
              

	    	driver.quit();   //close the lauch browser whole ----mtlb sab kuch baand
	    	
	    	
	    	
	    }
	    
	    @Test
	    void verifyinsta() throws InterruptedException
	    {  
	    	String expe="BID INN (@bidinnofficial) • Instagram photos and videos";
	    	
	    	Thread.sleep(500);	    	
	    	
	    	 WebElement verifyinsta = 	driver.findElement(By.xpath("(//a[contains(@class,'mr-3 flex')])[2]"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  verifyinsta);
             verifyinsta.click(); 
            
             
             String parenttab= driver.getWindowHandle();  //parent tab ki id 
             
             System.out.println(parenttab);
           // now parent child dono ki liye
           
           Set<String>allpc = driver.getWindowHandles();
           
           System.out.println(allpc);
           
           for(String id:allpc)
           {
         	   if(!id.equals(parenttab))
         	   {
         		   //switch to driver to child one
         		   
         		   driver.switchTo().window(id);
         		  Thread.sleep(400);
         		  driver.findElement(By.xpath("//svg[@class=\"x1lliihq x1n2onr6 x1roi4f4\"]")).click();         		 
         		  String nme=driver.getTitle();
        	    	System.out.println("the title name is"+nme);
        	    	Assert.assertTrue(expe.equals(nme));
        	    	driver.close();  //only close the child or the current tab 
         		   
         	   }
           }
           
           
           

	    	driver.quit();
	    	
	    	
	    	
	    }
	    
	    @Test
	    void verifytwit() throws InterruptedException
	    {  
	    	String expe="Profile / X";
	    	
	    	Thread.sleep(500);	    	
	    	
	    	 WebElement verifytwi = 	driver.findElement(By.xpath("(//a[contains(@class,'mr-3 flex')])[3]"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  verifytwi);
             verifytwi.click(); 
             Thread.sleep(200);
             
    String parenttab= driver.getWindowHandle();  //parent tab ki id 
             
             System.out.println(parenttab);
           // now parent child dono ki liye
           
           Set<String>allpc = driver.getWindowHandles();
           
           System.out.println(allpc);
           
           for(String id:allpc)
           {
         	   if(!id.equals(parenttab))
         	   {
         		   //switch to driver to child one
         		   
         		   driver.switchTo().window(id);
         		   Thread.sleep(400);
         		  String nme=driver.getTitle();
        	    	System.out.println("the title name is"+nme);
        	    	Assert.assertTrue(expe.equals(nme));
        	    	driver.close();  //only close the child or the current tab 
         		   
         	   }
           }
           
           
           

	    	driver.quit();
	    	
	    	
	    	
	    }
	    
	    @Test
	    void verifyyoutu() throws InterruptedException
	    {  
	    	String expe="Bidinn - YouTube";
	    	
	    	Thread.sleep(500);	    	
	    	
	    	 WebElement verifyyt = 	driver.findElement(By.xpath("(//a[contains(@class,'mr-3 flex')])[4]"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  verifyyt );
             verifyyt.click(); 
             Thread.sleep(200);
             
    String parenttab= driver.getWindowHandle();  //parent tab ki id 
             
             System.out.println(parenttab);
           // now parent child dono ki liye
           
           Set<String>allpc = driver.getWindowHandles();
           
           System.out.println(allpc);
           
           for(String id:allpc)
           {
         	   if(!id.equals(parenttab))
         	   {
         		   //switch to driver to child one
         		   
         		   driver.switchTo().window(id);
         		  String nme=driver.getTitle();
        	    	System.out.println("the title name is"+nme);
        	    	Assert.assertTrue(expe.equals(nme));
        	    	driver.close();  //only close the child or the current tab 
         		   
         	   }
           }
           
           
           

	    	driver.quit();
	    	
	    	
	    }
	    
	    
	    @Test
	    void verifll() throws InterruptedException
	    {  
	    	String expe="BidINN | LinkedIn";
	    	
	    	Thread.sleep(500);	    	
	    	
	    	 WebElement verifll = 	driver.findElement(By.xpath("(//a[contains(@class,'mr-3 flex')])[5]"));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  verifll );
             verifll.click(); 
             Thread.sleep(200);
             
    String parenttab= driver.getWindowHandle();  //parent tab ki id 
             
             System.out.println(parenttab);
           // now parent child dono ki liye
           
           Set<String>allpc = driver.getWindowHandles();
           
           System.out.println(allpc);
           
           for(String id:allpc)
           {
         	   if(!id.equals(parenttab))
         	   {
         		   //switch to driver to child one
         		   
         		   driver.switchTo().window(id);
         		  String nme=driver.getTitle();
        	    	System.out.println("the title name is"+nme);
        	    	Assert.assertTrue(expe.equals(nme));
        	    	driver.close();  //only close the child or the current tab 
         		   
         	   }
           }
           
           
           

	    	driver.quit();
	    	
	    	
	    }
	    
	    
	    
	

}
