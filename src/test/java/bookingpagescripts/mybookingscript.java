package bookingpagescripts;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

// 7-05-25

public class mybookingscript {
	
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
	
//	
    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit(); // Ensures the session is fully terminated
        }
    }

   //My booking---
    
    @Test
    void mybookingsdetailsissameornotincompletedcase() throws InterruptedException {
        Thread.sleep(1000);

        LoginButtonclick();

        String expectedTabs = "AllUpcomingCompletedCancelled";
        Thread.sleep(1000);

        // Click on 'My Bookings'
        driver.findElement(By.xpath("//button[text()='My Bookings']")).click();
        Thread.sleep(1000);

        // Collect tab names
        String actualTabs = "";
        List<WebElement> tabs = driver.findElements(By.xpath("//button[contains(@class,'inline-flex items-center justify-center whitespace-nowrap')]"));
        for (WebElement tab : tabs) {
            actualTabs += tab.getText();
        }
        System.out.println("the ans " + actualTabs);

        // Click on 'Completed' tab
        WebElement completedBtn = driver.findElement(By.xpath("(//button[contains(@class,'inline-flex items-center justify-center whitespace-nowrap')])[3]"));
        completedBtn.click();

        // Booking summary info
        WebElement bookIdElem = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle2 mui-11wd9et']"));
        String bookIdBefore = bookIdElem.getText();
        System.out.println("the book-id " + bookIdBefore);

        WebElement hotelNameElem = driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-ula612']"));
        String hotelNameBefore = hotelNameElem.getText();
        System.out.println("the hotelname is " + hotelNameBefore);

        WebElement addressElem = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle2 mui-uvxmsl']"));
        String addressBefore = addressElem.getText();
        System.out.println(addressBefore);

        WebElement dateElem = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle2 mui-f820d1']"));
        String dateSummary = dateElem.getText();
        System.out.println("the date is " + dateSummary);

        WebElement amountElem = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 mui-6v8orq']"));
        String amountBefore = amountElem.getText().replace("₹", "").trim();
        System.out.println("the amount is " + amountBefore);

        Thread.sleep(1000);

        // Navigate to booking detail page
        hotelNameElem.click();

        WebElement detailedBookIdElem = driver.findElement(By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4 mui-1u3kw4h']"));
        String bookIdAfter = detailedBookIdElem.getText().replace("Booking ID - ", "");
        System.out.println("the id is " + detailedBookIdElem.getText());

        WebElement hotelNameDetailElem = driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-9uskk0']"));
        String hotelNameAfter = hotelNameDetailElem.getText();
        System.out.println("The hotel name is " + hotelNameAfter);

        WebElement locationElem = driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k']"));
        String fullLocation = locationElem.getText();
        System.out.println("The location is " + fullLocation);

        WebElement checkinElem = driver.findElement(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-quwrhc'])[1]"));
        String checkin = checkinElem.getText();
        
        
        //extracting the date part---
        //code is java
    	String res="";
        String []date=checkin.split("-"); //kis basis pe split krna h
        if(date.length>=3)
        {
        	res=date[2];
        }
        
        
        
        
        System.out.println("the checkin " + res);

        WebElement checkoutElem = driver.findElement(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-quwrhc'])[2]"));
        String checkout = checkoutElem.getText();
        
        //extracting the date part---
        //code is java
    	String res1="";
        String []dae=checkout.split("-"); //kis basis pe split krna h
        if(dae.length>=3)
        {
        	res1=dae[2];
        }
        
        
        
        System.out.println("the checkout " + res1);
        
        
        
        
     

        WebElement totalAmountElem = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 mui-czk095'])[5]"));
        String amountAfter = totalAmountElem.getText().replace("₹", "").trim();
        System.out.println("the amount is " + amountAfter);

        WebElement userNameElem = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 mui-czk095'])[9]"));
        String username = userNameElem.getText();
        System.out.println("the username is " + username);

        WebElement profileNameElem = driver.findElement(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1 mui-sn9l5b']"));
        String profileName = profileNameElem.getText();
        System.out.println("the profile name " + profileName);

        Thread.sleep(1000);

        // Final validation
        boolean isAllCorrect =
            actualTabs.equals(expectedTabs) &&
            bookIdAfter.equals(bookIdBefore) &&
            hotelNameBefore.equals(hotelNameAfter) &&
            dateSummary.contains(res1) &&
            dateSummary.contains(res) &&
            amountAfter.contains(amountBefore) &&
            fullLocation.contains(addressBefore)
            ;
      
           
           
        // Final assertion
        Assert.assertTrue(isAllCorrect, "One or more booking details do not match.");
    }
    
   //***check each tab contains their specific tab contains cards or not--
    
    @Test
    void completedtabcase() throws InterruptedException
    {  
        Thread.sleep(1000);

        LoginButtonclick();
        
        // Click on 'My Bookings'
        driver.findElement(By.xpath("//button[text()='My Bookings']")).click();
        
        Thread.sleep(1000);
        
        // Click on 'Completed' tab
        WebElement completedBtn = driver.findElement(By.xpath("(//button[contains(@class,'inline-flex items-center justify-center whitespace-nowrap')])[3]"));
        completedBtn.click();

        String wewant="Completed";
        
      List<WebElement>lisel= driver.findElements(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-1a82urx']"));
        
      for(WebElement el:lisel)
      {
    	  String gett=el.getText();
    	  System.out.println("The text is "+gett);
    	  Assert.assertTrue(gett.contains(wewant));
      }
    	
    }
    
    
    //*******cancelled case********
    
    @Test
    void cancelledtabcase() throws InterruptedException
    {  
        Thread.sleep(1000);

        LoginButtonclick();
        
        // Click on 'My Bookings'
        driver.findElement(By.xpath("//button[text()='My Bookings']")).click();
        
        Thread.sleep(1000);
        
        // Click on 'Completed' tab
        WebElement completedBtn = driver.findElement(By.xpath("(//button[contains(@class,'inline-flex items-center justify-center whitespace-nowrap')])[4]"));
        completedBtn.click();

        String wewant="Cancelled";
        
      List<WebElement>lisel= driver.findElements(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-zevmup']"));
        
      for(WebElement el:lisel)
      {
    	  String gett=el.getText();
    	  System.out.println("The text is "+gett);
    	  Assert.assertTrue(gett.contains(wewant));
      }
    	
    }
    
    
//   ***** 8-May-25  ******//
    
   //checking the upcoming booking scenario--
    
    @Test
    void checkupcomingbookscenariocase() throws InterruptedException
    {   
    	 Thread.sleep(1000);
     
         LoginButtonclick();

         // Click on 'My Bookings'
         driver.findElement(By.xpath("//button[text()='My Bookings']")).click();
         Thread.sleep(1000);

         // Click on 'Upcoming' tab
         WebElement upcomingbtn = driver.findElement(By.xpath("(//button[contains(@class,'inline-flex items-center justify-center whitespace-nowrap')])[2]"));
         upcomingbtn.click();
  
    	Thread.sleep(1000);  
    	
    	//click on the card-to go into booking details
    	
    	driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-ula612']")).click();
    	
    	// retrieve the dates
    	
    	  WebElement checkinElem = driver.findElement(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-quwrhc'])[1]"));
          String checkin = checkinElem.getText();
          
          
          //extracting the date part---
          //code is java
      	String res="";
          String []date=checkin.split("-"); //kis basis pe split krna h

              	res+=date[1]+date[2];
              	
         int checkin1=Integer.parseInt(res);
     
          
//          System.out.println("the checkin " + res);
//
//          WebElement checkoutElem = driver.findElement(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-quwrhc'])[2]"));
//          String checkout = checkoutElem.getText();
//          
//          //extracting the date part---
//          //code is java
//      	String res1="";
//          String []dae=checkout.split("-"); //kis basis pe split krna h
//        
//        	  
//              	res1+=dae[1]+dae[2];

          
      // --- getting local date--
          LocalDate today = LocalDate.now();
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd"); 
          String formattedDate = today.format(formatter);
          
          System.out.println("The date is "+formattedDate);
          
          int currdate=Integer.parseInt(formattedDate);
          
         Assert.assertTrue(checkin1>currdate);

     //---let check the upcoming date should be greater then current date
         System.out.println("The upcoming date is higher than next to current date");
  
	
    }
    
 //-----------------checking view Policy work or not---  
    
   @Test 
  void viewhotelpoliciesbuttonworkornot() throws InterruptedException
  {     
	   String hp="Hotel Polices";
	   
	   checkupcomingbookscenariocase();
	   
	   ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700);");
	   
	   // click on the button
	   Thread.sleep(1000);
	   
	   driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
	   
	   driver.findElement(By.xpath("//button[text()='View Hotel Policies']")).click();
	   Thread.sleep(1000);
	  //--now
	   WebElement txt=driver.findElement(By.xpath("//h2[@id='room-amenities-modal-title']"));
	   System.out.println("the text is "+txt.getText());
	    
	    Assert.assertTrue(hp.equals(txt.getText()));
	    
	    //close button is click or not
	    
	    WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));

	 // Assert that the close button is displayed and enabled (clickable)
	 Assert.assertTrue(closeButton.isDisplayed());
	 Assert.assertTrue(closeButton.isEnabled());

	 // Click the close button
	 closeButton.click();
	 
	 //print the statement
	 System.out.println("The close button is working properly");

	  
    }
    
   
   //---cancel booking --
   
   @Test
   void cancelbuttonworkornot() throws InterruptedException
   {    
	   String txtis="Submit your Cancellation request for the booking on";
	   //---working on cancel button working
	   checkupcomingbookscenariocase();
	   
	   //cancel button click
	   driver.findElement(By.xpath("//button[text()=' Cancel Booking']")).click();
	   
	   // check form open
	   
	   WebElement formtxt=driver.findElement(By.xpath("//p[@class='font-serif text-xl font-semibold tracking-wider']"));
	   System.out.println("the txt is "+formtxt.getText());
	   
	   Assert.assertTrue(txtis.equals(formtxt.getText()));
	   
	   System.out.println("The form is opening");
	   
	   
	   
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	

}
