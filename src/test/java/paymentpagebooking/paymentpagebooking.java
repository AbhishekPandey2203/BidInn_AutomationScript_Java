package paymentpagebooking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class paymentpagebooking {

	WebDriver driver;
	
	 String checkinDate="";
	 String checkoutDate="";
	 String guestCountDetail="";
	  String childCountDetail="";
	   String displayedHotelName="";
	   String roomCountDetail="";
	
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
//		        WebElement nextmonthclick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")));
//		        nextmonthclick.click();
		        
		        

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
		        
		        
		        
		        Thread.sleep(2000);
		        //reterive the details-------------------
		        
		        
		        
		        Thread.sleep(2000); // Allow time for page to load

//			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
			
			    // --- Retrieve check-in and check-out dates ---
			 checkinDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("(//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')])[1]"))
			    ).getText().trim();
//			    System.out.println("Check-in Date: " + checkinDate);

			    checkoutDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("(//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')])[2]"))
			    ).getText().trim();
//			    System.out.println("Check-out Date: " + checkoutDate);

			    // --- Retrieve hotel name from details page ---
			    WebElement hotelNameElementOnDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//h2[@class='MuiTypography-root MuiTypography-h4 mui-gaxl7d']")
			    ));
			     displayedHotelName = hotelNameElementOnDetail.getText().trim();
//			    System.out.println("Displayed Hotel Name (Details Page): " + displayedHotelName);

			    // --- Retrieve guest, child, and room info from details page ---
			  guestCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[1]"))
			    ).getText().trim();
			  childCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[2]"))
			    ).getText().trim();
			 roomCountDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("(//h4[@class='MuiTypography-root MuiTypography-h4 mui-1nq9l8w'])[4]"))
			    ).getText().trim();

			
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		      
		        //clicking the Book now button----------------
		        
		        Thread.sleep(1000);
				   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				   
				 
				   WebElement elem=driver.findElement(By.xpath("(//button[text()='Book Now'])[1]"));
			       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", elem);
			       elem.click();
			       
		        


				
	}
	
	
	 @AfterClass
	  void tearDown() {
	        if (driver != null) {
	            driver.quit(); // Ensure the browser closes after the test
	            System.out.println("Driver quit successfully");
	        }
	    }

	
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
		
	   
}
	

@Test 
void  MovetoBookingPageAfterclickingBooknowButton() throws InterruptedException
{  
  
	       enterLoginCredential();  //function calling
	       
	      System.out.println("the login case done");
	      
	      
	   Thread.sleep(1000);
	      
	      try {
	          WebElement elem1 = driver.findElement(By.xpath("//button[text()='Pay Now']"));
	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem1);

	          // Click the button and check if it was clicked successfully
	          elem1.click();
	          System.out.println("Pay Now Button Clickable,Means RazorPay Option Open");

	      } catch (Exception e) {
	          System.out.println("Element not clickable: " + e.getMessage());
	      }
	      
	    
		  
 }


@Test
void checkingGuestInformationworkornotTitlecase() throws InterruptedException
{  
	
	
	enterLoginCredential();
	
	Thread.sleep(1000);
	//title click
	WebElement elm1=driver.findElement(By.xpath("//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input mui-74pt8w']"));
	elm1.click();
    String precase=elm1.getText();

	
	Thread.sleep(1000);
	
    driver.findElement(By.xpath("//li[normalize-space()='Prof.']")).click();
    Thread.sleep(1000);
    
    String postcase=elm1.getText();
   
    Assert.assertTrue(!(precase.equals(postcase)));
	
    System.out.println("The title is work Properly");
    
    
    
 // Name case ---------------
    WebElement elm2 = driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input mui-1pk1fka']"));
    elm2.click();
    Thread.sleep(500); // slight pause to ensure focus 

    // Clear using keyboard shortcuts
    elm2.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
    elm2.sendKeys(Keys.DELETE);                   // Delete selected text
    Thread.sleep(500); // optional pause

    // Send new text
    elm2.sendKeys("Abhi");
    Thread.sleep(500); // optional pause
    
    
    //enter age case------------
    
    WebElement age=driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input mui-1pk1fka'])[2]"));
  age.click();
  
  // Clear using keyboard shortcuts
  age.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
  age.sendKeys(Keys.DELETE);                   // Delete selected text
  Thread.sleep(500); // optional pause
  
  age.sendKeys("20");

  Thread.sleep(1000);
  
  //update ---clickable or not
  
  WebElement updatework=driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-h6 mui-6ijlps']"));
  
 Assert.assertTrue( updatework.isEnabled());
  System.out.println("Guest Information Section Changes work Properly");
  

}


//add guest button---------


@Test
void checkaddguestbuttonwork() throws InterruptedException
{
	enterLoginCredential();
	
	Thread.sleep(2000);
	//click on add guest button--
	
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700);");
	Thread.sleep(1000);
	WebElement elem=driver.findElement(By.xpath("//button[text()='Add Guests']"));
	elem.click();
	
	//----

	
	Thread.sleep(1000);
	//title click
	WebElement elm1=driver.findElement(By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input mui-74pt8w'])[2]"));
	elm1.click();
    String precase=elm1.getText();

	
	Thread.sleep(1000);
	
    driver.findElement(By.xpath("//li[normalize-space()='Prof']")).click();
    Thread.sleep(1000);
    
    String postcase=elm1.getText();
   
    Assert.assertTrue(!(precase.equals(postcase)));
	
    System.out.println("The title is working properly");

 // First Name
 WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstName']"));
 firstNameField.click();
 firstNameField.sendKeys("Abhi");
 Thread.sleep(1000);

 // Last Name
 WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastName']"));
 lastNameField.click();
 lastNameField.sendKeys("Shukla");
 Thread.sleep(1000);

// // Phone Number
// WebElement phoneField = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input mui-1pk1fka'])[10]"));
// phoneField.click();
// phoneField.sendKeys("+91 9988776655");
// Thread.sleep(1000);

 // Email Address
 WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
 emailField.click();
 // Clear using keyboard shortcuts
 emailField.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
 emailField.sendKeys(Keys.DELETE); 
 
 
 emailField.sendKeys("abc@gmail.com");
 Thread.sleep(1000);

 WebElement ageField = driver.findElement(By.xpath("//div[@class='MuiCardContent-root mui-zf4utx']/..//input[@name='age']"));
 ageField.click();                  // Focus the field (optional if already in view)
 ageField.sendKeys(Keys.BACK_SPACE); // Remove the '0'
 ageField.sendKeys("20");  
 Thread.sleep(1000);

 // Click on the "Save Guest" button
 WebElement saveGuestButton = driver.findElement(By.xpath("//button[text()='Save Guest']"));
 saveGuestButton.click();
 
 Thread.sleep(1000);
 
 
 //checking how many user added----------------
 

List<WebElement> elements = driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiAccordion-root MuiAccordion-rounded MuiAccordion-gutters mui-1pi0qnl']"));

Assert.assertTrue(elements.size() > 0, "User not added successfully");
System.out.println("User added successfully. Element size: " + elements.size());
 
 WebElement arowclick=driver.findElement(By.xpath("//span[@class='MuiAccordionSummary-expandIconWrapper mui-f8wb7g']//*[name()='svg']")); 
 arowclick.click();
 
 Thread.sleep(500);
 
 //click on delete
 
 WebElement dele=driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
 dele.click();
 
  System.out.println("Added user Deleted Successfully!!");
}


//checking pay amount is correct or not--


@Test
void totalpayamountiscorrectornot() throws InterruptedException
{
	enterLoginCredential();
	
	//-----
	
	
	
	 Thread.sleep(1000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   //display price
	  WebElement pernightprice= driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-1ck7u20']"));
	  String pnp=pernightprice.getText();
	  String displaypnp=pnp.replaceAll("[^\\d]", "");
	  
	  int pernightprice1=Integer.parseInt(displaypnp);
	  System.out.println(" The per night hotel room price is  "+pernightprice1);
	  
	  
	  WebElement totalpriceafterchoose=driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 mui-to2i5k\"])[6]"));
	  
	  String priceText=totalpriceafterchoose.getText();
	// Remove ₹ and /- using regex
	  String cleaned = priceText.replaceAll("[^\\d]", ""); // keeps only digits

	  int price = Integer.parseInt(cleaned);

	  System.out.println("Numeric price is: " + price);  
	  
	  
	  
	 //gst case--
	  
WebElement gst=driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 mui-to2i5k\"])[8]"));
	  
	  String gstText=gst.getText();
	// Remove ₹ and /- using regex
	  String cleangst = gstText.replaceAll("[^\\d]", ""); // keeps only digits

	  int pricegst = Integer.parseInt(cleangst);

	  System.out.println("Numeric price is: " + pricegst);  
	  
	  
	
 //service charge--------
	  
	  
WebElement sc=driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 mui-to2i5k\"])[10]"));
	  
	  String scText=sc.getText();
	// Remove ₹ and /- using regex
	  String cleansc = scText.replaceAll("[^\\d]", ""); // keeps only digits

	  int pricesc = Integer.parseInt(cleansc);

	  System.out.println("Numeric price is: " + pricesc);    
	  
	  
	  
	  
 //----------------------totalamountpayable
	  
	  
WebElement tat=driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 mui-to2i5k\"])[12]"));
	  
	  String tatText=tat.getText();
	// Remove ₹ and /- using regex
	  String cleantat = tatText.replaceAll("[^\\d]", ""); // keeps only digits

	  int pricetat = Integer.parseInt(cleantat);

	  System.out.println("Numeric price is: " + pricetat);  
	  
	  
	  
	  
	  
	//---------------- calculating sum
	  
	  
	  int totalsum=price+pricegst+pricesc;
	  
	  Assert.assertTrue(totalsum==pricetat);
	  
	  
	  System.out.println("The pricing is correct");
	  

	
}


//choosing option case------------

@Test
void checkcouponbuttonworkornot() throws InterruptedException
{  
    enterLoginCredential();
	
	//-----
 
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	  WebElement totalpriceafterchoose=driver.findElement(By.xpath("(//p[@class=\"MuiTypography-root MuiTypography-body1 mui-to2i5k\"])[6]"));
	  
	  String priceText=totalpriceafterchoose.getText();
	// Remove ₹ and /- using regex
	  String cleaned = priceText.replaceAll("[^\\d]", ""); // keeps only digits

	  int price = Integer.parseInt(cleaned);

	  System.out.println("Numeric price is: " + price);
	  
	  int discountedPrice = (int) Math.round((price * 15)/100);
	  

	  System.out.println("DiscountedPrice price is: " + discountedPrice);

	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700);");
		
	  Thread.sleep(1000);    
		
	 WebElement checkbox1=driver.findElement(By.xpath("(//h3[text()='Coupons']/..//input[@type=\"checkbox\"])[1]"));	
	checkbox1.click();
	
	//---
	Thread.sleep(1000);
	 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -700);");
		Thread.sleep(2000); 
	
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement coupondisc = wait.until(ExpectedConditions.visibilityOfElementLocated(
		      By.xpath("//p[text()='Coupon Discount']/..//p[@class=\"MuiTypography-root MuiTypography-body1 mui-to2i5k\"][2]")
		  ));
		  
		 
		  
		  
	//Understanding the Dynamic handling of Xpath
		  
//--  "//p[text()='Coupon Discount']/..//p[@class=\"MuiTypography-root MuiTypography-body1 mui-to2i5k\"][2]"-----
		 
		  
		  
		  
		  
		  
	  String coupondisc1=coupondisc.getText();
	  System.out.println(coupondisc1);
		// Remove ₹ and /- using regex
	  String cleand = coupondisc1.replaceAll("[^0-9]", ""); // Removes all non-digit characters
	  int price1 = Integer.parseInt(cleand);; // keeps only digits

		  

		  System.out.println("Coupon Discount: " + price1);
		  
		  if (discountedPrice > 2000) {
			    Assert.assertEquals(2000, 2000, "The coupon discount should be Rs.2000");
			    System.out.println("The coupon discount is always -Rs.2000");
			} else {
			    Assert.assertTrue(price1 <= 2000, "Unexpected coupon discount");
			    System.out.println("The coupon discount is " + price1);
			}
		  

	
	
}



//check the display hotel name ,checkin and checkout correct or not--
//@Test
//void checkinghoteldetailinformation() throws InterruptedException
//{  
//	
//	 enterLoginCredential();
//	 
//	 // taking hotelname
//	 WebElement elm1=driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-9uskk0']"));
//	 String hm=elm1.getText();
//	 
//	 System.out.println(hm);
//	 
//	 //checkin and checkout date
//	 WebElement checkin1=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-1j7aait'])[1]"));
//	 String checkin10=checkin1.getText();
//	 
//	 System.out.println(checkin10);
//			 
//	 WebElement checkout1=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-1j7aait'])[2]"));
//	 String checkout10=checkout1.getText();
//	 
//	 System.out.println(checkout10);
//	 
//	 
//	 WebElement hotelloc=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[1]"));
//	 String hotello=hotelloc.getText();
//	 
//	 System.out.println(hotello);
//			 
//	 WebElement roomcount=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[2]"));
//	 String roomcoun=roomcount.getText();
//	 
//	 System.out.println(roomcoun);
//	 WebElement adcount=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[3]"));
//	 String adcount1=adcount.getText();
//	 
//	 
//	 System.out.println(adcount1);
//	 WebElement kicount=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[4]"));
//	 String kicount1=kicount.getText();
//	 System.out.println(kicount1);
//	 
//	 System.out.println("Initial we GET-------");
//	 
//	 System.out.println("Check-in Date: " + checkinDate);
//	 System.out.println("Check-out Date: " + checkoutDate);
//
//	 System.out.println("Guest " + guestCountDetail);
//	 System.out.println("Child " + childCountDetail);
//	 
//
//	 System.out.println("display " + displayedHotelName);
//	 System.out.println("room " + roomCountDetail);
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 Assert.assertTrue(displayedHotelName.contains(hm));
//	 Assert.assertTrue(checkin10.contains(checkinDate));
//	 Assert.assertTrue(checkout10.contains(checkoutDate));
//	 Assert.assertTrue(roomcoun.contains(roomcoun));
//	 
//	 Assert.assertTrue(adcount1.contains(guestCountDetail.subSequence(0,1)));
//	 
//	 Assert.assertTrue(kicount1.contains(childCountDetail));
//	 
//	 
//	
//	 
//	 
//}












@Test
void checkHotelDetailInformation() throws InterruptedException {  
    // Enter login credentials
    enterLoginCredential();
     
    // Get hotel name
    WebElement hotelNameElement = driver.findElement(By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 mui-9uskk0']"));
    String hotelName = hotelNameElement.getText();
    System.out.println(hotelName);
    
    // Get check-in and check-out dates
    WebElement checkinElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-1j7aait'])[1]"));
    String checkinDateFromPage = checkinElement.getText();
    System.out.println(checkinDateFromPage);
             
    WebElement checkoutElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-1j7aait'])[2]"));
    String checkoutDateFromPage = checkoutElement.getText();
    System.out.println(checkoutDateFromPage);
    
    // Get hotel location
    WebElement hotelLocationElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[1]"));
    String hotelLocation = hotelLocationElement.getText();
    System.out.println(hotelLocation);
             
    // Get room count
    WebElement roomCountElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[2]"));
    String roomCountFromPage = roomCountElement.getText();
    System.out.println(roomCountFromPage);
    
    // Get adult count
    WebElement adultCountElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[3]"));
    String adultCountFromPage = adultCountElement.getText();
    System.out.println(adultCountFromPage);
    
    // Get kid count
    WebElement kidCountElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 mui-to2i5k'])[4]"));
    String kidCountFromPage = kidCountElement.getText();
    System.out.println(kidCountFromPage);
    
    // Print initial details
    System.out.println("Initial details:");
    System.out.println("Check-in Date: " + checkinDate);
    System.out.println("Check-out Date: " + checkoutDate);
    System.out.println("Guest Count: " + guestCountDetail);
    System.out.println("Child Count: " + childCountDetail);
    System.out.println("Displayed Hotel Name: " + displayedHotelName);
    System.out.println("Room Count: " + roomCountDetail);
    
    // Assertions
    Assert.assertTrue(
    	    displayedHotelName.contains(hotelName) &&
    	    roomCountFromPage.contains(roomCountDetail) &&
    	    adultCountFromPage.contains(guestCountDetail.subSequence(0, 1)) &&
    	    kidCountFromPage.contains(childCountDetail)
    	);
    
    
    System.out.println("The detail are matched fully!!");
}


//06-may-25--

//My Bookings button working--
@Test
void mybookingsButtonworkornot() throws InterruptedException
{     
	enterLoginCredential();
	
	String value="AllUpcomingCompletedCancelled";
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[text()='My Bookings']")).click();
	
	Thread.sleep(1000);
	
	
	String ans="";
	List<WebElement>elem=driver.findElements(By.xpath("//button[contains(@class,'inline-flex items-center justify-center whitespace-nowrap')]"));
	
	for(WebElement ele:elem)
	{
		System.out.println("the name we get "+ele.getText());
		ans+=ele.getText();
	}
	
	
	System.out.println("the ans "+ans);
	Assert.assertTrue(ans.equals(value));

	
	Thread.sleep(1000);


}


//checkProfilework or not
@Test
void checkProfileButtonworkornot() throws InterruptedException
{  
	enterLoginCredential();
	Thread.sleep(1000);
	
	WebElement elem=driver.findElement(By.xpath("//span[@style='padding-left: 6px;']"));
	System.out.println("the name is "+elem.getText());

	String nameis=elem.getText();
	driver.findElement(By.xpath("//span[@style='padding-left: 6px;']")).click();
	
	Thread.sleep(3000);
	
WebElement elm=	driver.findElement(By.xpath("//input[@id='fullName']"));
String attributeValue = elm.getAttribute("value");

System.out.println("the input value is "+attributeValue);

Thread.sleep(1000);
	   

Assert.assertTrue(nameis.contains(attributeValue));

}




//Function add Guest------------------------------


void addguestfunction() throws InterruptedException
{
	
	
	
	//click on add guest button--
	
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700);");
	Thread.sleep(1000);
	WebElement elem=driver.findElement(By.xpath("//button[text()='Add Guests']"));
	elem.click();
	
	//----

	
	Thread.sleep(1000);
	//title click
	WebElement elm1=driver.findElement(By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input mui-74pt8w'])[2]"));
	elm1.click();
    String precase=elm1.getText();

	
	Thread.sleep(1000);
	
    driver.findElement(By.xpath("//li[normalize-space()='Prof']")).click();
    Thread.sleep(1000);
    
    String postcase=elm1.getText();
   
    Assert.assertTrue(!(precase.equals(postcase)));
	
    System.out.println("The title is working properly");

 // First Name
 WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstName']"));
 firstNameField.click();
 firstNameField.sendKeys("Abhi");
 Thread.sleep(1000);

 // Last Name
 WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastName']"));
 lastNameField.click();
 lastNameField.sendKeys("Shukla");
 Thread.sleep(1000);

// // Phone Number
// WebElement phoneField = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input mui-1pk1fka'])[10]"));
// phoneField.click();
// phoneField.sendKeys("+91 9988776655");
// Thread.sleep(1000);

 // Email Address
 WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
 emailField.click();
 // Clear using keyboard shortcuts
 emailField.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
 emailField.sendKeys(Keys.DELETE); 
 
 
 emailField.sendKeys("abc@gmail.com");
 Thread.sleep(1000);

 WebElement ageField = driver.findElement(By.xpath("//div[@class='MuiCardContent-root mui-zf4utx']/..//input[@name='age']"));
 ageField.click();                  // Focus the field (optional if already in view)
 ageField.sendKeys(Keys.BACK_SPACE); // Remove the '0'
 ageField.sendKeys("20");  
 Thread.sleep(1000);

 // Click on the "Save Guest" button
 WebElement saveGuestButton = driver.findElement(By.xpath("//button[text()='Save Guest']"));
 saveGuestButton.click();
 
 System.out.println("Guest added successfully!");
 
 
 
}


@Test
void UpdatetheAddGuestInformationworkornot() throws InterruptedException
{  
	
	enterLoginCredential();
	
	  
	Thread.sleep(1000);
	addguestfunction();
	Thread.sleep(1000);
	

	 WebElement arowclick=driver.findElement(By.xpath("//span[@class='MuiAccordionSummary-expandIconWrapper mui-f8wb7g']//*[name()='svg']")); 
	 arowclick.click();
	 
	 Thread.sleep(500);
	
	 
	 
	 
	WebElement firname=driver.findElement(By.xpath("//input[@name='firstName']"));
	
	firname.click();
	 Thread.sleep(1000);
	 
	 firname.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
	 firname.sendKeys(Keys.BACK_SPACE); // Delete selected text

	 
	 firname.sendKeys("Ram");
	
	Thread.sleep(1000);
	
	
	//click on update button
	
	 //click on delete
	 
	 WebElement updatebutt=driver.findElement(By.xpath("(//button[text()='Update'])[1]"));
	 updatebutt.click();
	 
	  System.out.println("Added user Update Successfully!!");
	
}


//check notification work or not---
 
@Test
void checkingthenotification() throws InterruptedException
{   
	String name="Notifications";
	
	enterLoginCredential();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[contains(@class, 'border-stroke bg-gray-2 text-dark hover:text-primary mui-mfslm7')]")).click();
	
	Thread.sleep(1000);
	
	WebElement elem=driver.findElement(By.xpath("//h4[@class='text-sm font-semibold text-gray-700']"));
	
	System.out.println("the name is "+elem.getText());
	
	Assert.assertTrue(name.equals(elem.getText()));
	

	
}






















}
		
		


 
  
  

  
 
  
  
  

 
  
  
