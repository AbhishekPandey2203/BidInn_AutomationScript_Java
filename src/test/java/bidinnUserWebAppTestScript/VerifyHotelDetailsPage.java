package bidinnUserWebAppTestScript;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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


//-----****Updating the Hotel Detail Page--29-05-25****
// 2APRIL-2025
public class VerifyHotelDetailsPage {
	  
	WebDriver driver;
	
	
 @BeforeTest
void enterHotelname() throws InterruptedException
{       

		    driver=new ChromeDriver();
			driver.get("https://www.bidinn.in/");
			driver.manage().window().maximize();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  // City Name insertion.
	        String dumy = "test";
	        WebElement HotelInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
	        HotelInput.sendKeys(dumy);

	        WebElement HotelOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Hotel Shyam Krishna(Test_Hotel)']")));
	        HotelOption.click();

	        // Calendar choose - Check-in
	        WebElement checkIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-in']")));
	        checkIn.click();
	        
	        //click on the next month calender
//	        WebElement nextmonthclick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")));
//	        nextmonthclick.click();
	        
	        

	        WebElement checkInDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[3]")));
	        checkInDate.click();

	        
	        WebElement checkOutDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[8]")));
	        checkOutDate.click();

	        // Guest choose
	        WebElement guestIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")));
	        guestIcon.click();

	        WebElement roomGuestDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='No. of Rooms/Guests']")));
	        roomGuestDropdown.click();

	        // Increment buttons (room, adult, child)
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[2]"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[4]"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[6]"))).click();

	        // Click again to close the dropdown
	        roomGuestDropdown.click();

	        // Click the search button
	        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
	        searchBtn.click();


			
}
	
	
	
	 @AfterClass
	  void tearDown() {
	        if (driver != null) {
	            driver.quit(); // Ensure the browser closes after the test
	            System.out.println("Driver quit successfully");
	        }
	    }
//	    
	 
//---------
	     
	    
	 @Test(priority=1)
	void verifySearchedHotelNameDateGuestNoAndRoomNo() throws InterruptedException
	{  
		 Thread.sleep(2000); // Allow time for page to load

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // --- Retrieve hotel name from search section ---
		    WebElement hotelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//input[@aria-autocomplete='list']")
		    ));
		    String searchedHotelName = hotelElement.getAttribute("value").trim(); // use getAttribute for input fields
		    System.out.println("Searched Hotel Name: " + searchedHotelName);

		    // --- Retrieve check-in and check-out dates ---
		    String checkInDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("(//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')])[1]"))
		    ).getText().trim();
		    System.out.println("Check-in Date: " + checkInDate);

		    String checkOutDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("(//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')])[2]"))
		    ).getText().trim();
		    System.out.println("Check-out Date: " + checkOutDate);

		    // --- Retrieve guest and room info from search section ---
		    String guestsAndRoom = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//h5[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-noWrap mui-h3uw92')]"))
		    ).getText().trim();
		    System.out.println("Guest and Room Info (Search Section): " + guestsAndRoom);

		    // --- Retrieve hotel name from details page ---
		    WebElement hotelNameElementOnDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//h2[@class='MuiTypography-root MuiTypography-h4 mui-gaxl7d']")
		    ));
		    String displayedHotelName = hotelNameElementOnDetail.getText().trim();
		    System.out.println("Displayed Hotel Name (Details Page): " + displayedHotelName);

		    // --- Retrieve guest, child, and room info from details page ---
		    String guestCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[1]"))
		    ).getText().trim();
		    String childCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[2]"))
		    ).getText().trim();
		    String roomCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[4]"))
		    ).getText().trim();

		    System.out.println("Guests (Detail Page): " + guestCountDetail);
		    System.out.println("Children (Detail Page): " + childCountDetail);
		    System.out.println("Rooms (Detail Page): " + roomCountDetail);
//
//		    // --- Assertions ---
		    Assert.assertEquals(displayedHotelName, searchedHotelName, "Hotel name does not match!");
		    Assert.assertTrue(guestsAndRoom.contains(guestCountDetail), "Guest count does not match!");
		    Assert.assertTrue(guestsAndRoom.contains(childCountDetail), "Child count does not match!");
		    Assert.assertTrue(guestsAndRoom.contains(roomCountDetail), "Room count does not match!");

		    System.out.println("All values match as expected.");
	   
		
	}
	 
	 
//-------------Verify Sharing Button workornot Hotel Detail Page-----------------
	 

	  @Test
	  void shareButtonworkfb() throws InterruptedException
	  {      
		  String name="Facebook";
		  // Wait for the page to load
		    Thread.sleep(3000);
	    
		    // Click on the composition button
		    WebElement compositionButton = driver.findElement(By.xpath("//button[@id='composition-button']"));
		    compositionButton.click();
		    Thread.sleep(500);

		    // Click on the first share button (Facebook)
		    WebElement shareButton = driver.findElement(By.xpath("(//button[@class='react-share__ShareButton'])[1]"));
		    shareButton.click();

		    // Store the current window handle
		    String parentWindow = driver.getWindowHandle();
		    Set<String> allWindows = driver.getWindowHandles();

		    System.out.println("Parent Window Handle: " + parentWindow);
		    System.out.println("All Window Handles: " + allWindows);

		    Thread.sleep(1000);
		    String wegetas="";
		    // Switch to the newly opened window
		    for (String windowId : allWindows) {
		        if (!windowId.equals(parentWindow)) {
		            driver.switchTo().window(windowId);
		           wegetas=   driver.getTitle();
		            // Add any further steps inside the new window here
		            break; // Exit loop after switching
		        }
		    }
		    
		    
		    Assert.assertTrue(name.equals(wegetas));
	  }

	  
	  
	  
	  
	  @Test
	  void shareButtonworkwhatsapp() throws InterruptedException
	  {      
		  String name="WhatsApp";
		  // Wait for the page to load
		    Thread.sleep(3000);
	    
		    // Click on the composition button
		    WebElement compositionButton = driver.findElement(By.xpath("//button[@id='composition-button']"));
		    compositionButton.click();
		    Thread.sleep(500);

		    // Click on the first share button (Facebook)
		    WebElement shareButton = driver.findElement(By.xpath("(//button[@class='react-share__ShareButton'])[2]"));
		    shareButton.click();

		    // Store the current window handle
		    String parentWindow = driver.getWindowHandle();
		    Set<String> allWindows = driver.getWindowHandles();

		    System.out.println("Parent Window Handle: " + parentWindow);
		    System.out.println("All Window Handles: " + allWindows);

		    Thread.sleep(1000);
		    String wegetas="";
		    // Switch to the newly opened window
		    for (String windowId : allWindows) {
		        if (!windowId.equals(parentWindow)) {
		            driver.switchTo().window(windowId);
		           wegetas=   driver.getTitle();
		           System.out.println("the ans"+wegetas);
		            // Add any further steps inside the new window here
		            break; // Exit loop after switching
		        }
		    }
		    
		    
		    Assert.assertTrue(name.contains(wegetas));
	  }
	  
	  
	  @Test
	  void shareButtonworktwitter() throws InterruptedException
	  {      
		  String name="Title: X";
		  // Wait for the page to load
		    Thread.sleep(3000);
	    
		    // Click on the composition button
		    WebElement compositionButton = driver.findElement(By.xpath("//button[@id='composition-button']"));
		    compositionButton.click();
		    Thread.sleep(500);

		    // Click on the first share button (Facebook)
		    WebElement shareButton = driver.findElement(By.xpath("(//button[@class='react-share__ShareButton'])[3]"));
		    shareButton.click();

		    // Store the current window handle
		    String parentWindow = driver.getWindowHandle();
		    Set<String> allWindows = driver.getWindowHandles();

		    System.out.println("Parent Window Handle: " + parentWindow);
		    System.out.println("All Window Handles: " + allWindows);

		    Thread.sleep(1000);
		    String wegetas1="";
		    // Switch to the newly opened window
		    for (String windowId : allWindows) {
		        if (!windowId.equals(parentWindow)) {
		            driver.switchTo().window(windowId);
		            // Wait until the title is non-empty
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                wait.until(driver -> !driver.getTitle().isEmpty());

	                // Now get the title
	                 wegetas1 = driver.getTitle();
	                System.out.println("New Window Title: " + wegetas1);

	                // Add any more actions here after getting the title

	                break; // Exit loop after switching
		        
		        }
		    }
		    
		    
		    Assert.assertTrue(name.contains(wegetas1));
	  }
	  
	  
     
   
  //------------verify links--
  
     
   @Test  (priority=6)
 void verifyDisplayFacilityofHotel() throws InterruptedException
  {  
        String name="Facilities";
       Thread.sleep(2000);
       
       
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
       WebElement elem=driver.findElement(By.xpath("//button[text()='Rooms']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
       elem.click();
       
       WebElement elem1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom mui-15nrmjw']"));
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
        
        WebElement elem1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-1hkh2ij']"));
        System.out.println("The name is "+elem1.getText());
        
        Assert.assertTrue(name.equals(elem1.getText()));
        
        
        
        Thread.sleep(1000);

          
      
   }
     
   
   @Test(priority=8)
   void verifyAddressandMAPisdisplayornot() throws InterruptedException
   {  
         String name="Address";
        Thread.sleep(2000);
        
        WebElement elem=driver.findElement(By.xpath("//button[text()='Map']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
        elem.click();
        
        Thread.sleep(2000);
        
        WebElement elem1=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 mui-1urunfo']"));
        System.out.println("The name is "+elem1.getText());
        Thread.sleep(2000);
        Assert.assertTrue(name.equals(elem1.getText()));
    
     // Step 1: Switch to the iframe using the title attribute
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='201301']"));
        driver.switchTo().frame(iframeElement);
        
        
     // Step 2: Wait for the element with aria-label="Map"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mapElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@aria-label='Map']")
        ));

        // Step 3: Assert it is visible
        Assert.assertTrue(mapElement.isDisplayed());
        System.out.println("Map is displayed!!");

        // Step 4: Switch back to default content---mean back to original one
        driver.switchTo().defaultContent();
        
        
        
        
      
      
   }
 
   
   @Test(priority=9)
   void verifyDisplayPolicyVisible() throws InterruptedException
   {  
         String name="Policies";
        Thread.sleep(2000);
        
        WebElement elem=driver.findElement(By.xpath("//button[text()='Policy']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
        elem.click();
        
        WebElement elem1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-18pdkuj']"));
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
        
        WebElement elem1=driver.findElement(By.xpath("//h4[@class='MuiTypography-root MuiTypography-h4 mui-4rpz18']"));
        System.out.println("The name is "+elem1.getText());
        
        Assert.assertTrue(name.equals(elem1.getText()));
        
        
        
        Thread.sleep(1000);
          
      
   }
   
   
   
   
  //------------------Payment verify--------
   
	void enterLoginCredential() throws InterruptedException
	{  
		
		
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
		
	
	

		   
	}
   @Test
   
  void verifyBookNowButtonwork() throws InterruptedException
  {  
	   Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	 
	   WebElement elem=driver.findElement(By.xpath("(//button[text()='Book Now'])[1]"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
       elem.click();
       
       
       enterLoginCredential();  //function calling
       
      System.out.println("the login case done");
      
      
   Thread.sleep(1000);
//  
//      //-------------------
//      
//      
      try {
          WebElement elem1 = driver.findElement(By.xpath("//button[text()='Pay Now']"));
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem1);

          // Click the button and check if it was clicked successfully
          elem1.click();
          System.out.println("Pay Now Button Clickable,mean BookNow Buttonwork");

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
   void roomClickpricechange() throws InterruptedException
   {    
	   String name="Selected";
	   Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	  
	   WebElement elem = driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-1hkh2ij']"));
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
	   
	  Thread.sleep(3000);
	  WebElement elem2=driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Select Room'])[1]"));
	  elem2.click();
	  
	  
	  

//	  WebElement elem3=driver.findElement(By.xpath("//button[@type='button'][29]"));
	
	  
	  String disp=elem2.getText();
            //	button [contains(@class,'MuiButton-colorPrimary MuiButton-disableElevation mui-154hm4')]
	
	  System.out.println("The Button change is "+disp);
//	  String displ=displapri.getText();
//	  
	  Assert.assertTrue(name.contains(disp));
//	  
	
	  
	   
   }
   
   
   //--------------View More and view less---------
	  
   
   @Test(priority=14)
   void verifyViewmoreandless() throws InterruptedException
   {  
	   String name="View Less";
	   Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   Thread.sleep(3000);
	   WebElement viewpart = driver.findElement(By.xpath("//button[normalize-space()='All Reviews']"));

       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewpart);
      
	   Thread.sleep(3000);
       WebElement button = driver.findElement(By.xpath("(//button[contains(@class, 'MuiButton-containedPrimary') and contains(@class, 'mui-1rnjsvl')])[1]"));

       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
       button.click();
       
       WebElement buttonchange = driver.findElement(By.xpath("(//button[contains(@class, 'MuiButton-containedPrimary') and contains(@class, 'mui-1rnjsvl')])[1]"));
       System.out.println("The name is "+buttonchange.getText());
    
       
       Assert.assertTrue(name.equals(buttonchange.getText()));
	   
       
	   
   }
   
   
   
   
 // Image display or Not------------------------------------
   
  @Test(priority=15)
 void verifyImgaedisplayornot() throws InterruptedException
 {  
	  String shouldbe="All Media (7)";
	  Thread.sleep(1000);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 WebElement img=driver.findElement(By.xpath("//p[@class='text-white text-sm font-medium text-center px-3 py-1 rounded-md']"));
	 img.click();
	 
	 Thread.sleep(1000);

 WebElement allmedia=driver.findElement(By.xpath("(//button[normalize-space()='All Media (7)'])[1]"));
	System.out.println("The text is "+allmedia.getText());

// 
	Assert.assertTrue(shouldbe.equals(allmedia.getText()));

	 System.out.println("The View Image Button is working properly");
	 
 }
  
  
  
  
 //*****************************BidNow Option Verification********************************
  
  @Test
  void verifyBidNowOptionAfterLogin() throws InterruptedException
  {   
	  
	  String n2m="Make Your Bid Here!";
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebElement bidButtonClick = driver.findElement(By.xpath("(//button[text()='Bid Now'])[1]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick);
      bidButtonClick.click();
	  
	  Thread.sleep(2000);
	  
	  //function calling
	  enterLoginCredential();
	  
	  Thread.sleep(2000);
	  
	  
	  WebElement bidButtonClick1 = driver.findElement(By.xpath("(//button[text()='Bid Now'])[1]"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bidButtonClick1);
      bidButtonClick1.click();
      
      
      Thread.sleep(2000);
	  
	  
      //--------------
      
     WebElement elem =driver.findElement(By.xpath("//p[contains(@class,'MuiTypography-root MuiTypography-body1 mui-i5b67l')]"));
    String name= elem.getText();
     Thread.sleep(2000);
     
   
     Assert.assertTrue(n2m.equals(name));

     
     System.out.println("Bid Now Button Work Properly");
     
     
  }
  
  //************* Recommended Hotel*********************
  

	@Test
	void verifyRecommendHotelStartBidBeforeLogin() throws InterruptedException
	{  
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		
		 Thread.sleep(1000);
		 
		 
		WebElement elem1 =driver.findElement(By.xpath("//h4[normalize-space()='Recommended Hotels']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem1);

     
      Thread.sleep(1000);
      
      driver.findElement(By.xpath("(//h6[text()='Start Bid @ '])[1]")).click();
      
      Thread.sleep(1000);

		  String val=driver.getTitle();
	     System.out.println("The title is"+val);
	     
//	     Assert.assertTrue(value.equals(val));
//		  
		
	}
	
	@Test
	void verifyRecommendHotelBidNowBeforeLogin() throws InterruptedException
	{  
		
		
		String value="Auth screen : Bidinn - Bidinn";
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 Thread.sleep(1000);
		 WebElement elem1 =driver.findElement(By.xpath("//h4[normalize-space()='Recommended Hotels']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem1);

	     
	      Thread.sleep(1000);
   
      
      
      driver.findElement(By.xpath("(//a[text()='Bid Now'])[1]")).click();
      
      
          Thread.sleep(3000);
		  String val=driver.getTitle();
	     System.out.println("The title is"+val);
	     
	  Assert.assertTrue(val.equals(value));
		
	}
	
	
	
	//-------See More Review Work or not---------------
	
	@Test
	void seeMoreReviewworkornot() throws InterruptedException
	{    
		String ans="All Reviews";
       Thread.sleep(2000);
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2500);");

      
        Thread.sleep(1000);
        
        WebElement allrev=driver.findElement(By.xpath("//button[normalize-space()='See More Reviews']"));
        allrev.click();
       
        
        Thread.sleep(1000);
		
        
        WebElement answeget=driver.findElement(By.xpath("(//h2[normalize-space()='All Reviews'])[1]"));
        System.out.println("the ans we get "+answeget.getText());
        Thread.sleep(1000);
        
        Assert.assertTrue(ans.equals(answeget.getText()));
        
        
        
        WebElement cls=driver.findElement(By.xpath("(//button[text()='Close'])[3]"));
        cls.click();
        Thread.sleep(1000);
       
        System.out.println("The close button is working");
        	
		
	}
  
  
  @Test
	void allReviewworkornotinOverviewSection() throws InterruptedException
	{    
		String ans="All Reviews";
       Thread.sleep(2000);
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

      
        Thread.sleep(1000);
        
        WebElement allrev=driver.findElement(By.xpath("//button[normalize-space()='All Reviews']"));
        allrev.click();
       
        
        Thread.sleep(1000);
		
        
        WebElement answeget=driver.findElement(By.xpath("(//h2[normalize-space()='All Reviews'])[1]"));
        System.out.println("the ans we get "+answeget.getText());
        Thread.sleep(1000);
        
        Assert.assertTrue(ans.equals(answeget.getText()));
        
        
        
        WebElement cls=driver.findElement(By.xpath("(//button[text()='Close'])[3]"));
        cls.click();
        Thread.sleep(1000);
       
        System.out.println("The close button is working");
        	
		
	}
  
  
  //**********More Option**************
  
  @Test
  void moreOptionornot() throws InterruptedException
	{    
		String teststring="Room With Free Cancellation";
     Thread.sleep(2000);
     
      WebElement moreoption=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 underline-offset-3 underline text-end w-full mui-to2i5k']"));
      moreoption.click();
     
      
      Thread.sleep(1000);
		
      
      WebElement answeget=driver.findElement(By.xpath("//h6[normalize-space()='Room With Free Cancellation | Breakfast only']"));
    String ansget=answeget.getText();
      Thread.sleep(1000);
   
     Assert.assertTrue(ansget.contains(teststring));
      System.out.println("More Option Link is Working and when click direct to Room Types");
      	
		
	}
  
  
  //-------***Footer********
  
  @Test
  void foooteriscorrectlydisplaydataornotguestroomchildtotalnight() throws InterruptedException
  { 
	  Thread.sleep(2000); // Allow time for page to load

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      // --- Detail Page Data ---
      String checkInDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')])[1]"))
      ).getText();

      String checkOutDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')])[2]"))
      ).getText();

      String guestCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[1]"))
      ).getText().substring(0,1);

      String childCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[2]"))
      ).getText().substring(0,1);

      String totalNightCount = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[3]"))
      ).getText().substring(0,1);

      String roomCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[4]"))
      ).getText().substring(0,1);

      // --- Print detail page values ---
      System.out.println("DETAIL PAGE DATA:");
      System.out.println("Check-in Date: " + checkInDate);
      System.out.println("Check-out Date: " + checkOutDate);
      System.out.println("Guests: " + guestCountDetail);
      System.out.println("Children: " + childCountDetail);
      System.out.println("Rooms: " + roomCountDetail);
      System.out.println("Total Nights: " + totalNightCount);

      // --- Footer Data ---
      WebElement elem = driver.findElement(By.xpath("//button[text()='Rooms']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
      elem.click();
      Thread.sleep(1000);

      String guestCountFooter = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-1pbdpw4'])[1]"))
      ).getText().trim();

      String childCountFooter = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-1pbdpw4'])[2]"))
      ).getText().trim();

      String roomCountFooter = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-1pbdpw4'])[3]"))
      ).getText().trim();

      String checkInFooter = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-12hfmzg'])[2]"))
      ).getText().substring(5,6);

      String checkOutFooter = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-12hfmzg'])[3]"))
      ).getText().substring(6,7);

      String totalNightFooter = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 mui-em7kzi']"))
      ).getText().trim();

      Thread.sleep(2000);

      // --- Print footer values ---
      System.out.println("\nFOOTER PAGE DATA:");
      System.out.println("Check-in Date: " + checkInFooter);
      System.out.println("Check-out Date: " + checkOutFooter);
      System.out.println("Guests: " + guestCountFooter);
      System.out.println("Children: " + childCountFooter);
      System.out.println("Rooms: " + roomCountFooter);
      System.out.println("Total Nights: " + totalNightFooter);

      // --- Assertion using contains and AND logic ---
      boolean allMatch =
          guestCountFooter.contains(guestCountDetail) &&
          childCountFooter.contains(childCountDetail) &&
          roomCountFooter.contains(roomCountDetail) &&
          checkInDate.contains(checkInFooter) &&
          checkOutDate.contains(checkOutFooter) &&
          totalNightFooter.contains(totalNightCount);

      Assert.assertTrue(allMatch);

      System.out.println(" All values match as expected.");
  }
  
  
  //********Price Segment Matching Original,Display and discount*******
  
  
  @Test
  void checkingpriceiscorrectornot() throws InterruptedException
  {
	  
	  
	  Thread.sleep(1000);

	// --- Original Price ---
	WebElement originalPriceElement = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 line-through mui-m6y0y0']"));
	String originalPriceText = originalPriceElement.getText().replaceAll("[^\\d]", ""); // Remove ₹, comma
	int originalPrice = Integer.parseInt(originalPriceText);
	System.out.println("Original Price (int): " + originalPrice);

	// --- Discounted Price ---
	WebElement discountedPriceElement = driver.findElement(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3 mui-12yubrm']"));
	String discountedPriceText = discountedPriceElement.getText().replaceAll("[^\\d]", "");
	int discountedPrice = Integer.parseInt(discountedPriceText);
	System.out.println("Discounted Price (int): " + discountedPrice);
    
	Thread.sleep(1000);	// --- Discount Percentage ---
	WebElement discountPercentElement = driver.findElement(By.xpath("//h6[@class=\"MuiTypography-root MuiTypography-subtitle1 font-normal text-[18px] mui-150bnhz\"]"));
	String discountPercentText = discountPercentElement.getText().substring(0,5); // e.g., "25% OFF" → "25"
	double discountPercent = Double.parseDouble(discountPercentText);

	System.out.println("Discount Percentage (double): " + discountPercent);

	Thread.sleep(1000);

	// --- Calculate Expected Discounted Price ---
	int expectedDiscountedPrice = (int) (originalPrice - (originalPrice * discountPercent / 100));
	System.out.println("Expected Discounted Price: " + expectedDiscountedPrice);
	
	
	// --- Assertion ---
	Assert.assertEquals(expectedDiscountedPrice, discountedPrice);
	System.out.println(" Discount calculation is correct.");  
	
	
	//calculation 12%
	
	WebElement elm=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-czvi0f']"));
	System.out.println(elm.getText());
	
	String disp=elm.getText().substring(11);
	int disc12Price = Integer.parseInt(disp);
	System.out.println(disc12Price);
	
	int outp=(int)((discountedPrice*12)/100);
   
	Assert.assertTrue(outp==disc12Price);
	System.out.println("the 12% of display price is correct");
	
  }

  
  
  
  //***********Price checking at footer*********
  
  
  @Test
  void foooteriscorrectlydisplaydataornotPricestage() throws InterruptedException
  { 
	  Thread.sleep(2000); // Allow time for page to load

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // --- Price on Detail Page ---

	    // Original Price
	    WebElement originalPriceElement = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 line-through mui-m6y0y0']"));
	    String originalPriceText = originalPriceElement.getText().replaceAll("[^\\d]", "");
	    int originalPrice = Integer.parseInt(originalPriceText);
	    System.out.println("Detail Page - Original Price: " + originalPrice);

	    // Discounted Price
	    WebElement discountedPriceElement = driver.findElement(By.xpath("//h3[@class='MuiTypography-root MuiTypography-h3 mui-12yubrm']"));
	    String discountedPriceText = discountedPriceElement.getText().replaceAll("[^\\d]", "");
	    int discountedPrice = Integer.parseInt(discountedPriceText);
	    System.out.println("Detail Page - Discounted Price: " + discountedPrice);

	    // --- Scroll to Footer ---
	    WebElement elem = driver.findElement(By.xpath("//button[text()='Rooms']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
	    elem.click();
	    Thread.sleep(1000);

	    // Footer - Discounted Price
	    WebElement footerDiscountedPriceElement = driver.findElement(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 mui-1ywbpq']"));
	    String footerDiscountedText = footerDiscountedPriceElement.getText().replaceAll("[^\\d]", "");
	    int footerDiscountedPrice = Integer.parseInt(footerDiscountedText);
	    System.out.println("Footer - Discounted Price: " + footerDiscountedPrice);

	    // Footer - Original Price
	    WebElement footerOriginalPriceElement = driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 mui-jcrdv5']"));
	    String footerOriginalText = footerOriginalPriceElement.getText().replaceAll("[^\\d]", "");
	    int footerOriginalPrice = Integer.parseInt(footerOriginalText);
	    System.out.println("Footer - Original Price: " + footerOriginalPrice);

	 // --- Assertions to Compare Prices ---
	    Assert.assertEquals(originalPrice, footerOriginalPrice, "Original price does not match between detail page and footer.");
	    Assert.assertEquals(discountedPrice, footerDiscountedPrice, "Discounted price does not match between detail page and footer.");
	    
	    
	    Thread.sleep(1000);
    
  }
  
  
  
  //*****01-may-25******---BidNow Button each work---
  

  //-------------check bidin button working or not-------------------
  
  @Test
  void checkBidCounteroptionworkornot() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // --- Retrieve hotel name from search section ---
	        WebElement hotelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//input[@aria-autocomplete='list']")
	        ));
	        String searchedHotelName = hotelElement.getAttribute("value").trim();
	        System.out.println("Searched Hotel Name: " + searchedHotelName);
             
	        Thread.sleep(1000);	        // --- Retrieve check-in and check-out dates ---
	        String checkInDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("(//button[contains(@class,'MuiButton-disableElevation')])[1]"))
	        ).getText().trim();
	        
	      
	        System.out.println("Check-in Date: " + checkInDate);

	        String checkOutDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("(//button[contains(@class,'MuiButton-disableElevation')])[2]"))
	        ).getText().trim();
	       
	        System.out.println("Check-out Date: " + checkOutDate);
	        

	        // --- Click Bid Now ---
	        verifyBidNowOptionAfterLogin(); // Likely causes page refresh or DOM update

	        // --- Retrieve room type and address (after bid page loads) ---
	        WebElement roomType = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("(//h4[contains(@class,'MuiTypography-h4')])[6]")));
	        System.out.println("Room type: " + roomType.getText());

	        WebElement hotelAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//p[contains(@class,'MuiTypography-body1 mui-to2i5k')]")));
	      
	        
	        String hoteladd=hotelAddress.getText();
	        
	        String hotelfinal=hoteladd.split(",")[1].trim();
	        System.out.println("Hotel address: " + hotelfinal);
	        
	        
	        System.out.println("The Bid page is open");

	        // --- Get display price ---
	        WebElement priceElem = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-fyswvn')])[1]")));
	        int dispPrice = Integer.parseInt(priceElem.getText().substring(1));
	        System.out.println("Original price: " + dispPrice);

	        // --- Hotel details on bid page ---
	        WebElement hotelNameBid = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-1h37nj2')])[1]")));
	        WebElement checkInOutBid = driver.findElement(
	            By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-1h37nj2')])[2]"));
	        WebElement roomTypeBid = driver.findElement(
	            By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-1h37nj2')])[3]"));

	        System.out.println("Bid Page Details -> Name: " + hotelNameBid.getText()
	            + ", Dates: " + checkInOutBid.getText()
	            + ", Room Type: " + roomTypeBid.getText());

	        // --- Move the slider ---
	        WebElement minSlider = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[@class='MuiSlider-valueLabelCircle']")));
	        System.out.println("Slider initial position: " + minSlider.getLocation());

	        Actions act = new Actions(driver);
	        act.dragAndDropBy(minSlider, -200, 0).perform();

	        // Wait briefly for price update
	        Thread.sleep(1500); // One of the few safe uses of sleep to allow for animation completion

	        // --- Retrieve updated price and discount ---
	        WebElement updatedPriceElem = driver.findElement(
	            By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-fyswvn')])[2]"));
	        int updatedPrice = Integer.parseInt(updatedPriceElem.getText().substring(1));
	        System.out.println("Price after sliding: " + updatedPrice);

	        WebElement discountElem = driver.findElement(
	            By.xpath("(//p[contains(@class,'MuiTypography-body1 mui-fyswvn')])[3]"));
	        double discount = Double.parseDouble(discountElem.getText().substring(0,5));
	        System.out.println("Discount applied: " + discount + "%");
	        
	        
	        
	        //compute the price---
	        

	     // Compute the discounted price
	     int discountedPrice =(int) (dispPrice - (dispPrice * discount / 100));
	     System.out.println("Calculated discounted price: " + discountedPrice);
	        
	        
	        
	      
	     
	     //checking the hotel name ,address same display or not
	     
	     
	     Assert.assertTrue(hotelNameBid.getText().contains(searchedHotelName) && hotelNameBid.getText().contains(hotelfinal) && roomType.getText().contains( roomTypeBid.getText()));

	        
	        System.out.println("Hotel name and address are correct!! also Room type is same");
	        
	        if(discountedPrice==updatedPrice)
	        	System.out.println("The discountedPrice is same as UpdatedPrice");
	        
	        
	//---------------------Place Bid Button case-------------------------
	        
	        
	        driver.findElement(By.xpath("(//button[text()='Place Bid'])[1]")).click();
	        
	        WebElement elm=driver.findElement(By.xpath("//h5[normalize-space()='Offer Sent']"));
	        if(elm.isDisplayed())
	        System.out.println("The Place Bid Button is working");
	        
	        
	        

	    } catch (StaleElementReferenceException se) {
	        System.err.println("Stale element encountered. Consider re-checking element reference before use.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

  
  
  
  
  
  
  
  
 
  
   
}
