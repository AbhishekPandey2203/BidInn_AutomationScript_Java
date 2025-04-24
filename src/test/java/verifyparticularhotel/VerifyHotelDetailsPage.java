package verifyparticularhotel;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


// 2APRIL-2025
public class VerifyHotelDetailsPage {
	  
	WebDriver driver;
	
	
	@BeforeTest
	void searchfirst() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://www.bidinn.in/");
		driver.manage().window().maximize();
			
			//--------------- searchbox
			//hotel name insertion
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("test");
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"MuiAutocomplete-endAdornment mui-mxlkbn\"]")));
	    element.click();
				        
     driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("test");
					  
	   Thread.sleep(1000);
			       
	 driver.findElement(By.xpath("//p[text()='Hotel Eterna Primavera(Test_Hotel)']")).click();
			         

			         

		//calender chose
		 driver.findElement(By.xpath("//div[@class='MuiBox-root mui-1jke4yk']")).click();
	driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
		           
			           //now choose the date start--by default end also select 
      driver.findElement(By.xpath("(//span[@class='rdrDayNumber'])[6]")).click();

			           //------guest choose
		           //first click
		           
	 driver.findElement(By.xpath("//p[text()='2 Guests, 1 Room']")).click();
			           
	   //set the guest count---
  driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[1]")).click();           
		   driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[2]")).click(); 
			   driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[3]")).click(); 
			           
		  Thread.sleep(1000);
			           
		  driver.findElement(By.xpath("//button[text()='Done']")).click();
			           
			           
			           //click the search button
		  driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
			            
			           
			           
			           
//		//----------------------new page open-----
			           	
			
}
	
	
	
	 @AfterClass
	     void tearDown() {
	        if (driver != null) {
	            driver.quit(); // Ensure the browser closes after the test
	            System.out.println("Driver quit successfully");
	        }
	    }
	    
	 
//---------
	     
	    
	 @Test(priority=1)
	void verifySearchedHotelNameDateGuestNoAndRoomNo() throws InterruptedException
	{  
		//generally we if enter a hotel and then go to hotel page then the enter hotel name 
	   //must be same as display name	
	   Thread.sleep(2000);	
	   
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	   // Retrieve hotel name from details page
	    WebElement hotelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//h2[contains(@class,'MuiTypography-h4 mui-11jxq2l')]")
	    ));
	    String hotelName = hotelElement.getText().trim();
	    
	    // Retrieve check-in, check-out, guest, child, and room details
	    String checkIn = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-9l3uo3')])[2]"))
	    ).getText().trim();
	    
	    
	    System.out.println(" the date of "+checkIn);
	    
	    String checkOut = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-9l3uo3')])[4]"))
	    ).getText().trim();
	    
	    
	    System.out.println(" the date of "+checkOut);
	    
	    
	    String guests = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-9l3uo3')])[5]"))
	    ).getText().trim();
	    
	    String children = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-9l3uo3')])[6]"))
	    ).getText().trim();
	    
	    String rooms = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-9l3uo3')])[7]"))
	    ).getText().trim();
	    
	    // Retrieve hotel name from search box
	    String searchHotelName = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value").trim();
	    
	    // Retrieve calendar details
	    WebElement calendarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//p[@class='py-2 text-gray-700 flex-grow']")
	    ));
	    String calendarText = calendarElement.getText().trim();
	    
	    String checkInDate = calendarText.substring(0, 11).trim();
	    
	    String checkOutDate = calendarText.substring(13, 23).trim();
	    System.out.println("Check-in date: " + checkInDate + " | Check-out date: " + checkOutDate);
	    
	    // Retrieve guest details from UI
	    WebElement guestDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 mui-1na211y']")
	    ));
	    String guestDetails = guestDetailsElement.getText().trim();
	    
	    String adults = guestDetails.substring(0, 1);
	    String childrenCount = guestDetails.substring(10, 11);
	    String roomCount = guestDetails.substring(19, 20);
	    
	    System.out.println("Guest details: " + guestDetails + " | Adults: " + adults + " | Children: " + childrenCount + " | Rooms: " + roomCount);
	    
	    // Assertions to verify details match
	    Assert.assertTrue(searchHotelName.contains(hotelName), "Hotel name does not match");
	    Assert.assertTrue(guests.contains(adults), "Guest count does not match");
	    Assert.assertTrue(children.contains(childrenCount), "Children count does not match");
	    Assert.assertTrue(rooms.contains(roomCount), "Room count does not match");
	    Assert.assertTrue(checkIn.equals(checkInDate), "Check-in date does not match");
	    Assert.assertTrue(checkOut.equals(checkOutDate), "Check-out date does not match");
	   
	    
	    // Closing the driver
	    Thread.sleep(2000);
//	    driver.quit();
	
		
	}
	 
	 
//--------------verify sharing in Hotel Detail Page-----------------
	 
     @Test(priority=2)
	void verifyShareFB() throws InterruptedException
	{    
    	 String fb="Facebook";
    	 Thread.sleep(3000);
    	 
    	driver.findElement(By.id("composition-button")).click();
    	
    	driver.findElement(By.xpath("(//li[contains(@class,'MuiMenuItem-root MuiMenuItem-gutters mui-mlee68')])[1]")).click();
    	String nm="";
    	String pwh=driver.getWindowHandle();
    	Set<String> allw=driver.getWindowHandles();
    	 System.out.println("the window is "+driver.getWindowHandles());
    	for(String id:allw)
    	{  
    		if(!id.equals(pwh))
    		{
    			driver.switchTo().window(id);
    			Thread.sleep(1000);
    			 nm=driver.getTitle();
    			System.out.println("The title is "+nm);
    
    		}
    		
    	}
    	
    	
     Assert.assertTrue(fb.equals(nm));
    	Thread.sleep(500);
    	
    	
    	  
}
	 

  //case 2 whatsapp
     @Test(priority=3)
     void verifyShareWhatsapp() throws InterruptedException
 	{    
     	 String wp="WhatsApp";
     	 Thread.sleep(3000);
     	 
     	driver.findElement(By.id("composition-button")).click();
     	
     	driver.findElement(By.xpath("(//li[contains(@class,'MuiMenuItem-root MuiMenuItem-gutters mui-mlee68')])[2]")).click();
     	String nm="";
     	String pwh=driver.getWindowHandle();
     	Set<String> allw=driver.getWindowHandles();
     	 System.out.println("the window is "+driver.getWindowHandles());
     	for(String id:allw)
     	{  
     		if(!id.equals(pwh))
     		{
     			driver.switchTo().window(id);
     			Thread.sleep(1000);
     			 nm=driver.getTitle();
     			System.out.println("The title is "+nm);
     			
     			
     			
     			
     		}
     		
     	}
     	
     	
     	Assert.assertTrue(wp.equals(nm));
     	Thread.sleep(500);
     	
     	
     	  
 }
     
  //case 3 verifytwi
     @Test(priority=4)
     void verifySharetwitter() throws InterruptedException
 	{    
     	 String tw="Compose new post / X";
     	 Thread.sleep(3000);
     	 
     	driver.findElement(By.id("composition-button")).click();
     	
     	driver.findElement(By.xpath("(//li[contains(@class,'MuiMenuItem-root MuiMenuItem-gutters mui-mlee68')])[3]")).click();
     	String nm="";
     	String pwh=driver.getWindowHandle();
     	Set<String> allw=driver.getWindowHandles();
     	 System.out.println("the window is "+driver.getWindowHandles());
     	for(String id:allw)
     	{  
     		if(!id.equals(pwh))
     		{
     			driver.switchTo().window(id);
     			Thread.sleep(1000);
     			 nm=driver.getTitle();
     			System.out.println("The title is "+nm);
     			
     			
     			
     			
     		}
     		
     	}
     	
     	
      Assert.assertTrue(tw.equals(nm));
     	Thread.sleep(500);
     
     	  
 }
     
   
  //------------verify links--
     @Test(priority=5)
 void verifyHotelOverviewTestLink() throws InterruptedException
 {  
    	String name="About Hotel Shyam Krishna(Test_Hotel)"; 
   Thread.sleep(2000);
   
   WebElement elem=driver.findElement(By.xpath("//button[text()='OverView']"));
   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
   
   WebElement elem1=driver.findElement(By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4 mui-2dqhof']"));
   System.out.println("The name is "+elem1.getText());
   
   
   Assert.assertTrue(name.equals(elem1.getText()));
   
   Thread.sleep(1000);
 
    
 }

     
   @Test  (priority=6)
 void verifyDisplayFacilityofHotel() throws InterruptedException
  {  
        String name="Facilities";
       Thread.sleep(2000);
       
       
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
       WebElement elem=driver.findElement(By.xpath("//button[text()='Facility']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
       elem.click();
       
       WebElement elem1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom mui-t1nuxs']"));
       System.out.println("The name is "+elem1.getText());
       
       
     
       Assert.assertTrue(name.equals(elem1.getText()));
       
       
       
      
//       Thread.sleep(5000);
       
       
       
       
       
     
    
   
     
  }
   
   
   
   @Test(priority=7)
   void verifyDisplayRoomsshow() throws InterruptedException
   {  
         String name="Room Types";
        Thread.sleep(2000);
        
        WebElement elem=driver.findElement(By.xpath("//button[text()='Rooms']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
        elem.click();
        
        WebElement elem1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-pd8ovx']"));
        System.out.println("The name is "+elem1.getText());
        
        Assert.assertTrue(name.equals(elem1.getText()));
        
        
        
        Thread.sleep(1000);

          
      
   }
     
   
   @Test(priority=8)
   void verifyDisplayMAP() throws InterruptedException
   {  
         String name="Address";
        Thread.sleep(2000);
        
        WebElement elem=driver.findElement(By.xpath("//button[text()='Map']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
        elem.click();
        
        WebElement elem1=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 mui-vtr8r0']"));
        System.out.println("The name is "+elem1.getText());
        
        Assert.assertTrue(name.equals(elem1.getText()));
        
        
        
        Thread.sleep(1000);
      
      
   }
 
   
   @Test(priority=9)
   void verifyDisplayPolicyVisible() throws InterruptedException
   {  
         String name="Policies";
        Thread.sleep(2000);
        
        WebElement elem=driver.findElement(By.xpath("//button[text()='Policy']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
        elem.click();
        
        WebElement elem1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-y8jflg']"));
        System.out.println("The name is "+elem1.getText());
        
        Assert.assertTrue(name.equals(elem1.getText()));
        
        
        
        Thread.sleep(1000);
      
      
   }
   
   
   
   
   @Test(priority=10)
   void verifyDisplayReviewShow() throws InterruptedException
   {  
         String name="User Reviews & Rating";
        Thread.sleep(2000);
        
        WebElement elem=driver.findElement(By.xpath("//button[text()='Review']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
        elem.click();
        
        WebElement elem1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-cjetgs']"));
        System.out.println("The name is "+elem1.getText());
        
        Assert.assertTrue(name.equals(elem1.getText()));
        
        
        
        Thread.sleep(1000);
          
      
   }
   
   
   
   
  //------------------Payment verify--------
   
   void EnteringNoandOTP() throws InterruptedException
	{   Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
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
		
//		Thread.sleep(300);
		
		//click
		driver.findElement(By.xpath("//button[text()=\"Verify OTP\"]")).click();
		
   
   
	}
   
   @Test(priority=11)
   
  void verifyPaymentButtonAfterLogin() throws InterruptedException
  {  
	   Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	 
	   WebElement elem=driver.findElement(By.xpath("(//button[text()='Book Now'])[2]"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
       elem.click();
       
       
       EnteringNoandOTP();  //function calling
       
      
 
  
      //-------------------
      
      
      try {
          WebElement elem1 = driver.findElement(By.xpath("//button[text()='Pay Now']"));
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem1);

          // Click the button and check if it was clicked successfully
          elem1.click();
          System.out.println("Clickable");

      } catch (Exception e) {
          System.out.println("Element not clickable: " + e.getMessage());
      }
      
    
	  
  }
 
   
   
 //--------------------------------03-April-25----------------------
   
 
   @Test(priority=12)
   void verifyPriceShownwithDiscount() throws InterruptedException
   {  
	   
	   Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   //display price
	  WebElement elem= driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 mui-19rd5ty']"));
	  String acp=elem.getText();
	  String displaypr=acp.substring(1);
	  
	  double originalPrice=Double.parseDouble(displaypr);
	  System.out.println(" the price is who have cut over it "+displaypr);
	  
	  
	  WebElement elem1=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 mui-1h1gty3']"));
	  WebElement elem2=driver.findElement(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 mui-1uj5xs4']"));
	  
	  String disppr=elem2.getText();
	  String disppr1=disppr.substring(2);
	  
	  int dispprice=Integer.parseInt(disppr1);
	  
	  System.out.println("The price is that display large to user"+dispprice);
	  String dis=elem1.getText();
	  String discount=dis.substring(0, 5);
	  
	  System.out.println("The discount over it is "+discount);
	  
	  double discountPercent=Double.parseDouble(discount);
	  
	  
	  int discountedPrice = (int) (originalPrice - (originalPrice * (discountPercent / 100)));
	  System.out.println("The discount price is paid by user is"+discountedPrice);
	  
	  
	  int twelevepervalue=(dispprice*12)/100;
	  
	  System.out.println(" the tweleve price discount is "+twelevepervalue);
	  
	  
	  WebElement weget=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 mui-68o8xu'])[2]"));
	  System.out.println(" text is "+weget.getText());
	  String sp=weget.getText().substring(11,14);
	  System.out.println(" text is "+sp);
	  
	  int wegetofftwel=Integer.parseInt(sp);
	  
	  
	  
	  
	  Thread.sleep(1000);
	  Assert.assertTrue((twelevepervalue==wegetofftwel)&&(dispprice==discountedPrice));
//	  Assert.asserttrue(((twelevepervalue.equals(wegetofftwel))&&));
		
//	  Assert.assertEquals;
	
	   
   }
   
   
   
   @Test(priority=13)
   void roomclickpricechange() throws InterruptedException
   {  
	   Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	  
	   WebElement elem = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 mui-5r7gob']"));

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);

	   
	  Thread.sleep(1000);
	  WebElement elem2=driver.findElement(By.xpath("(//button [contains(@class,'MuiButton-colorPrimary MuiButton-disableElevation mui-154hm4')])[3]"));
	  elem2.click();
	  
	  
	  

	  WebElement dis=driver.findElement(By.xpath("(//h6[@class='MuiTypography-root MuiTypography-h6 mui-goiy6x'])[4]"));
	  System.out.println(" the price is "+dis.getText());
	  String disp=dis.getText();
            //	button [contains(@class,'MuiButton-colorPrimary MuiButton-disableElevation mui-154hm4')]
	  WebElement displapri=driver.findElement(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 mui-1ojxjbw']"));
	  
	  System.out.println("The price is "+displapri.getText());
	  String displ=displapri.getText();
	  
	  Assert.assertTrue(disp.contains(displ));
	  
	  
	  
	 
	  
	  
	 
	  
	   
   }
   
   
   //--------------View More and view less---------
	  
   
   @Test(priority=14)
   void verifyViewmoreandless() throws InterruptedException
   {  
	   String name="View Less";
	   Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
       WebElement elem=driver.findElement(By.xpath("//button[text()='Facility']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
      
       Thread.sleep(5000);
	   
       WebElement elem2=driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-colorPrimary MuiButton-disableElevation mui-12c3y5e')])[1]"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem2);
       elem2.click();
       
       WebElement elem3=driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-colorPrimary MuiButton-disableElevation mui-12c3y5e')])[1]"));
       System.out.println("The name is "+elem3.getText());
    
       
       Assert.assertTrue(name.equals(elem3.getText()));
	   
       
	   
   }
   
   
   
   
 // Image display or Not------------------------------------
   
  @Test(priority=15)
 void verifyImgaedisplayornot() throws InterruptedException
 {  
	  String shouldbe="ALL MEDIA";
	  Thread.sleep(1000);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 WebElement img=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium mui-1ogqmc6']"));
	 img.click();
	 
	 Thread.sleep(1000);

 WebElement allmedia=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary Mui-selected mui-11is3c3']"));
	System.out.println("The text is "+allmedia.getText());
	
	String op=allmedia.getText().substring(0,9);
	 
	System.out.println("The text string "+ op);
	
	String no1=allmedia.getText().substring(11,13);
	
	int no=Integer.parseInt(no1);
;	System.out.println("The text number "+ no);
	
	List<WebElement> imgclass=driver.findElements(By.xpath("//button[@class='image-gallery-thumbnail']"));
	System.out.println(" the size is "+imgclass.size());
    int disp=imgclass.size()+4;
    
    Assert.assertEquals(no, disp);
 
	Assert.assertTrue(shouldbe.equals(op));

	 
	 
 }
  
  
  
  
 //*****************************BidNow Option Verification********************************
  
  @Test
  void verifyBidNowOption() throws InterruptedException
  {   
	  
	  String n2m="Price Breakup";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick = driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick);
      bidButtonClick.click();
	  
	  Thread.sleep(2000);
	  
	  //function calling
	  EnteringNoandOTP();
	  
	  Thread.sleep(2000);
	  
	  
	  WebElement bidButtonClick1 = driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick1);
      bidButtonClick1.click();
      
      
      Thread.sleep(2000);
	  
	  
      //--------------
      
     WebElement elem =driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-inputSizeSmall mui-1o6z5ng')]"));
     elem.click();
     Thread.sleep(2000);
     
    //----------Understanding how to delete the existing keyword and enter new key
     
     //--the below is like a command it do generally ctrl+A then delete using backsapce
     Actions action=new Actions(driver);
     action.keyDown(Keys.CONTROL).sendKeys("a")
     .keyUp(Keys.CONTROL)
     .sendKeys(Keys.BACK_SPACE)
     .build().perform();
     
     
     
//     elem.clear(); 
     Thread.sleep(2000);
  
     elem.sendKeys("4");
     elem.sendKeys("4");
     elem.sendKeys("0");
     elem.sendKeys("8");
     

     Thread.sleep(2000);
     
     driver.findElement(By.xpath("//button[text()='Place Bid']")).click();
     
     
     
     // after place bid there are 
     
     Thread.sleep(2000);
     
   WebElement elm=  driver.findElement(By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1xvinid'])[2]"));
     
     System.out.println("The text is "+elm.getText());
     
     Thread.sleep(1000);
     
     Assert.assertTrue(n2m.equals(elm.getText()));
     
   WebElement elm2=  driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium mui-1ogqmc6'])[2]"));
     elm2.click();
     
     Thread.sleep(2000);
     
     
     
    
     
     
	  
  }
  
  
  //*************** verifyclickofhigherlesslower*****************************
  
  
  @Test
  void verifyClickofAlreadyGivenBidbuttonLowerchance() throws InterruptedException
  {  
	  String n2m="Price Breakup";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick = driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick);
      bidButtonClick.click();
	  
	  Thread.sleep(2000);
	  
	  //function calling
	  EnteringNoandOTP();
	  
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick1= driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick1);
      bidButtonClick1.click();
	  
      Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[contains(@class,'MuiButton-colorWarning MuiButton-disableElevation mui-147grm3')] ")).click();

      Thread.sleep(2000);
      
      WebElement elm=  driver.findElement(By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1xvinid'])[2]"));
      
      System.out.println("The text is "+elm.getText());
	  
	  //button[contains(@class,'MuiButton-colorWarning MuiButton-disableElevation mui-147grm3')]
	  
      Assert.assertTrue(n2m.equals(elm.getText()));
	  
	  
  }
  
  
  
  @Test
  void verifyClickofAlreadyGivenBidbuttonHigherchance() throws InterruptedException
  {  
	  String n2m="Price Breakup";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick = driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick);
      bidButtonClick.click();
	  
	  Thread.sleep(2000);
	  
	  //function calling
	  EnteringNoandOTP();
	  
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick1= driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick1);
      bidButtonClick1.click();
	  
      Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation animate-bounce mui-1m8qqgs')] ")).click();

	  
      Thread.sleep(2000);
      
      WebElement elm=  driver.findElement(By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1xvinid'])[2]"));
      
      System.out.println("The text is "+elm.getText());
	  
	  //button[contains(@class,'MuiButton-colorWarning MuiButton-disableElevation mui-147grm3')]
	  
      Assert.assertTrue(n2m.equals(elm.getText()));
	  
	  
  }
  
  
  @Test
  void verifyClickofAlreadyGivenBidbuttonLesschance() throws InterruptedException
  {  
	  String n2m="Price Breakup";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick = driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick);
      bidButtonClick.click();
	  
	  Thread.sleep(2000);
	  
	  //function calling
	  EnteringNoandOTP();
	  
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick1= driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick1);
      bidButtonClick1.click();
	  
      Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[contains(@class,' MuiButton-colorError MuiButton-disableElevation mui-c6gl0h')] ")).click();

	 
      Thread.sleep(2000);
      
      WebElement elm=  driver.findElement(By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1xvinid'])[2]"));
      
      System.out.println("The text is "+elm.getText());
	  
	  //button[contains(@class,'MuiButton-colorWarning MuiButton-disableElevation mui-147grm3')]
	  
      Assert.assertTrue(n2m.equals(elm.getText()));
	  
	  
  }
  
  
  //**********************************add and sub button click *******************************
  
  //04-APRIL-25
  //-------------verify subtract link------------------
  
  @SuppressWarnings("deprecation")
@Test
  void verifySubtractclick() throws InterruptedException
  {
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick = driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick);
      bidButtonClick.click();
	  
	  Thread.sleep(2000);
	  
	  //function calling
	  EnteringNoandOTP();
	  
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick1= driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick1);
      bidButtonClick1.click();
	  
      Thread.sleep(2000);
      
      
      WebElement elem =driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-inputSizeSmall mui-1o6z5ng')]"));
//      elem.();
      Thread.sleep(2000);
//      System.out.println("The price is "+elem.getAttribute("value"));
      
      String inval=elem.getAttribute("value");
      int invalm=Integer.parseInt(inval);
      
      System.out.println("The price is "+invalm);
      
      
      //subtract --pe click
      Thread.sleep(3000);
      
     WebElement elm2= driver.findElement(By.xpath("(//button[contains(@style, 'border: 1px solid rgb(96, 34, 131)')])[1]"));
      elm2.click();
      
      Thread.sleep(3000);
   
      //-----------after clicking subtract---let get the input text again
      
      
      
      WebElement elem3 =driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-inputSizeSmall mui-1o6z5ng')]"));

    Thread.sleep(2000);
//    System.out.println("The price is "+elem.getAttribute("value"));
    
    String suval=elem3.getAttribute("value");
    int suvalm=Integer.parseInt(suval);
    
    
    System.out.println("The price is "+suvalm);
   
      if(suvalm<invalm)
      {
    	  System.out.println("The subtractor is working ");
      }
      else
      {
    	  System.out.println("The click of subtractor is not correct");
      }
	  
	  
	  
	  
  }
  
  
  
  //------------verify Addition-------------------------------
  
  @Test
  void verifyAdditionclick() throws InterruptedException
  {
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick = driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick);
      bidButtonClick.click();
	  
	  Thread.sleep(2000);
	  
	  //function calling
	  EnteringNoandOTP();
	  
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick1= driver.findElement(By.xpath("(//button[text()='Bid Now'])[2]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick1);
      bidButtonClick1.click();
	  
      Thread.sleep(2000);
      
      
      WebElement elem =driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-inputSizeSmall mui-1o6z5ng')]"));
//      elem.();
      Thread.sleep(2000);
//      System.out.println("The price is "+elem.getAttribute("value"));
      
      String inval=elem.getAttribute("value");
      int invalm=Integer.parseInt(inval);
      
      System.out.println("The price is "+invalm);
      
      
      //subtract --pe click
      Thread.sleep(3000);
      
     WebElement elm2= driver.findElement(By.xpath("(//button[contains(@style, 'border: 1px solid rgb(96, 34, 131)')])[2]"));
      elm2.click();
      
      Thread.sleep(3000);
   
      //-----------after clicking subtract---let get the input text again
  
      WebElement elem3 =driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-inputSizeSmall mui-1o6z5ng')]"));

    Thread.sleep(2000);
//    System.out.println("The price is "+elem.getAttribute("value"));
    
    String adval=elem3.getAttribute("value");
    int advalm=Integer.parseInt(adval);
    
    
    System.out.println("The price after addition is "+advalm);
   
      if(advalm>invalm)
      {
    	  System.out.println("The addition is working ");
      }
      else
      {
    	  System.out.println("The click of Addition  is not correct");
      }
	  
	  
	  
	  
  }
  
  
   
}
