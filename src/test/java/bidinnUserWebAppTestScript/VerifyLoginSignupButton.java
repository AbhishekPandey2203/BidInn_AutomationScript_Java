package bidinnUserWebAppTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Understand login task functionality---end to end
 */

//Updated 21-04-25

//new task--check notification,booking and name check---23-04-25

//Update the Task Login--as using property to send data and number


public class VerifyLoginSignupButton {
	
	public WebDriver driver;
	
	
	Properties property;
	
	
//	🔹 Purpose in Your Code---
//	This constructor:
//	Initializes the properties object
//	Loads the .properties file containing the credentials
//	Makes it easier to call getUsername(), getPassword(), and getUrl() without loading the file manually every time

	//***this is constructor smje---islye koi return type nhi h-- logically dekho--aur ek chej
	//isko obj bnane pe call hoga automatically and help krega invoke krne m
	// properties ko--
	public VerifyLoginSignupButton() throws IOException
	{  
		property = new Properties();
		//Getting file Path--user.dir point always to the current repo--
		
				String filepath=System.getProperty("user.dir")+"\\data\\example.properties";
				//Read the file
				
				FileInputStream filen=new FileInputStream(filepath);
				
			//--Load the file call the property object
				property.load(filen);
				
		    // close the file--
				filen.close();
		
	}
	
	//-----------
	public String getphoneno()
	{
		
	
	 return property.getProperty("mobileno");
	 
	}
	
	public String a()
	{
		
	
	 return property.getProperty("otpa");
	 
	}
	
	public String b()
	{
		
	
	 return property.getProperty("otpb");
	 
	}
	public String c()
	{
		
	
	 return property.getProperty("otpc");
	 
	}
	public String d()
	{
		
	
	 return property.getProperty("otpd");
	 
	}
	public String e()
	{
		
	
	 return property.getProperty("otpe");
	 
	}
	public String f()
	{
		
	
	 return property.getProperty("otpf");
	 
	}
	


	public WebDriver getDriver()
	{
		return driver;
	}

	public void verifyLoginButtonisworkornot() throws InterruptedException, IOException
	{       
		//making an object of class--
		
		VerifyLoginSignupButton h1=new VerifyLoginSignupButton();
			
		
	/*	When you use inside it in a function
		
		//Using Properties concept--It is used to read the data from file
		Properties property=new Properties();
		
		//Getting file Path--user.dir point always to the current repo--
		
		String filepath=System.getProperty("user.dir")+"\\data\\example.properties";
		//Read the file
		
		FileInputStream filen=new FileInputStream(filepath);
		
	//--Load the file call the property object
		property.load(filen);
		
    // close the file--
		filen.close();
		
		
// getting data from file-- passing the key
		String phone=property.getProperty("mobileno");
		String a=property.getProperty("otpa");
		String  b=property.getProperty("otpb");
		String c=property.getProperty("otpc");
		String d=property.getProperty("otpd");
		String e=property.getProperty("otpe");
		String f=property.getProperty("otpf");
		
		When you inside it
		
		
		
		*/	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bidinn.in/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		String expectedName="Shyam";
//		 driver=new ChromeDriver();
		 
		
		
		//click 
		driver.findElement(By.xpath("//button[normalize-space()='Login / Sign-up']")).click();
		Thread.sleep(200);
		
		//click on first
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart mui-1ooubvk']")).click();
		
		Thread.sleep(1000);
		//sending number
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart mui-1ooubvk']")).sendKeys(h1.getphoneno());
		
		//click
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		Thread.sleep(500);
		
		//sending otp
		
		driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).sendKeys(h1.a());
		driver.findElement(By.xpath("(//input[@type=\"number\"])[2]")).sendKeys(h1.b());
		driver.findElement(By.xpath("(//input[@type=\"number\"])[3]")).sendKeys(h1.c());
		driver.findElement(By.xpath("(//input[@type=\"number\"])[4]")).sendKeys(h1.d());
		driver.findElement(By.xpath("(//input[@type=\"number\"])[5]")).sendKeys(h1.e());
		driver.findElement(By.xpath("(//input[@type=\"number\"])[6]")).sendKeys(h1.f());
		
//		Thread.sleep(300);
		
		//click
		driver.findElement(By.xpath("//button[text()=\"Verify OTP\"]")).click();
		
//		Thread.sleep(300);
//		
//		Thread.sleep(500);
		
		WebElement elem=driver.findElement(By.xpath("//span[contains(@style, 'padding-left: 6px')]"));
		Thread.sleep(100);
		
		System.out.println("the name is "+elem.getText());
		
	   
	}
	
	
    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit(); // Ensures the session is fully terminated
        }
    }
//    
	
	
	@Test
	void afterLogincheckNotificationisworkornot() throws InterruptedException, IOException
	{     
		
		verifyLoginButtonisworkornot();
		Thread.sleep(500);
		String name="Notifications";
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[contains(@class, 'border-stroke bg-gray-2 text-dark hover:text-primary mui-mfslm7')]")).click();
		
		Thread.sleep(1000);
		
		WebElement elem=driver.findElement(By.xpath("//h4[@class='text-sm font-semibold text-gray-700']"));
		
		System.out.println("the name is "+elem.getText());
		
		Assert.assertTrue(name.equals(elem.getText()));
		

		
	}
	
	
	//my booking
	
	@Test
	void mybookingsButtonworkornot() throws InterruptedException, IOException
	{     
		
		verifyLoginButtonisworkornot();
		Thread.sleep(500);
		
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
	void checkProfileButtonworkornot() throws InterruptedException, IOException
	{   
		verifyLoginButtonisworkornot();
		Thread.sleep(500);
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
	
	
	
	

		@Test
	void verifyRecommendHotelStartBidAfterLogin() throws InterruptedException, IOException
	{     
			
			Thread.sleep(1000);
			verifyLoginButtonisworkornot();
			Thread.sleep(500);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 
		
		 String value="Hotel Banz | Hotel Detail Page | bidinn.in";
		 driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
         
		
		 
		 
		WebElement elem1 =driver.findElement(By.xpath("(//h6[text()='Welcome Offer!'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem1);

       
        
        
        driver.findElement(By.xpath("(//h6[text()='Start Bid @ ₹'])[1]")).click();
        
        Thread.sleep(1000);

		  String val=driver.getTitle();
	     System.out.println("The title is"+val);
	     
	     Assert.assertTrue(value.equals(val));
		  
		
	}
	
	@Test
	void verifyRecommendHotelBidNowAfterLogin() throws InterruptedException, IOException
	{    
		
		String text="Make Your Bid Here!";
		verifyLoginButtonisworkornot();
		Thread.sleep(500);
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 driver.findElement(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")).click();
           
		 
		   ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 900);");
//	
			WebElement elem1 =driver.findElement(By.xpath("(//h6[text()='Welcome Offer!'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem1);

        
        driver.findElement(By.xpath("(//button[text()='Bid Now'])[1]")).click();
    
            Thread.sleep(3000);
		
         WebElement elem= driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 mui-i5b67l']"));
            System.out.println(" the heading is "+elem.getText());
            
            
            Assert.assertTrue(text.equals(elem.getText()));
	}
	
	
//new task--check notification full working, scroll read and delete---
	
	@Test
	void checkNotificationscrollworkingornot() throws InterruptedException, IOException
	{ 
        Thread.sleep(1000);
		verifyLoginButtonisworkornot();
		Thread.sleep(500);
	   // Click the notification button
	    driver.findElement(By.xpath("//button[contains(@class, 'border-stroke bg-gray-2 text-dark hover:text-primary mui-mfslm7')]")).click();

	    Thread.sleep(2000);

	    // Get the list of notification elements
	    List<WebElement> elements = driver.findElements(By.xpath("//p[@class='text-sm font-medium text-gray-900']"));
	    System.out.println("The size is " + elements.size());
	    
	    if(!elements.isEmpty() && elements.size()<=2)
	    {
	      System.out.println("The notification are shown up but scroll not visible");
	    }
	    

	    // Scroll to the last notification element if it exists
	    else if (!elements.isEmpty() && elements.size()>2 ) {
	    	
	    	// It is is a standard Java way of getting the last element from a list.
	        WebElement lastElement = elements.get(elements.size() - 1);
	        //usko view m lena ke liye use this--
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);
	        //view m aagya mtlb scroll working
	        System.out.println("Scrolled to the last notification.");
	    } else {
	        System.out.println("No notifications found.");
	    }
	   
	    Thread.sleep(1000);
	
	  
	}
	
	//check Read------
	
	@Test
	void checkReadButtonisworkornotofNotification() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		verifyLoginButtonisworkornot();
		Thread.sleep(500);
		
		  // Click the notification button
         driver.findElement(By.xpath("//button[contains(@class, 'border-stroke bg-gray-2 text-dark hover:text-primary mui-mfslm7')]")).click();
		// Get the initial unread count
        WebElement badgeBefore = driver.findElement(By.xpath("//span[contains(@class,'absolute -right-1 -top-1 flex h-5 w-5 items-center')]"));
        int initialCount = Integer.parseInt(badgeBefore.getText().trim());
        System.out.println("Initial unread count: " + initialCount);

//        // Click the notification button
//        driver.findElement(By.xpath("//button[contains(@class, 'border-stroke bg-gray-2 text-dark hover:text-primary mui-mfslm7')]")).click();
//        Thread.sleep(1000);

        
        // Get the list of notification elements
	    List<WebElement> elements = driver.findElements(By.xpath("//p[@class='text-sm font-medium text-gray-900']"));
	    System.out.println("The size is " + elements.size());
	    
	    if(elements.isEmpty())
	    {
	      System.out.println("No new Notifications");
	    }
	    
        
        
        
        // Open the 3-dot menu (ellipsis icon)
        driver.findElement(By.xpath("//a[1]//div[1]//div[2]//button[1]//*[name()='svg']")).click();
        Thread.sleep(500);

        // Click the "Read" button
        driver.findElement(By.xpath("//button[normalize-space()='Read']")).click();
        Thread.sleep(1000);
        
        
        if(elements.size()==1)
        {
        	System.out.println(" As only one notification is there and it is successfully read!!");
        	
        }
        else {

        // Get the updated unread count
        WebElement badgeAfter = driver.findElement(By.xpath("//span[contains(@class,'absolute -right-1 -top-1 flex h-5 w-5 items-center')]"));
        int updatedCount = Integer.parseInt(badgeAfter.getText().trim());
        System.out.println("Unread count after marking as read: " + updatedCount);

        // Assert the count decreased by 1
        Assert.assertEquals(updatedCount, initialCount - 1, "Unread count did not decrease by 1 after marking as read.");
        Assert.assertTrue(updatedCount==(initialCount - 1));
//        )
        }
		
	}
	
	
	//check Delete------
	
	//Updating delete task---
	
	//case-1:When not read direct delete
	@Test
	void checkDeleteButtonisworkornotwhennotreadofNotification() throws InterruptedException, IOException
	{
		 Thread.sleep(1000);
			verifyLoginButtonisworkornot();
			Thread.sleep(500);
	
	        // Click the notification bell icon to open the panel
	        driver.findElement(By.xpath("//button[contains(@class, 'border-stroke bg-gray-2 text-dark hover:text-primary mui-mfslm7')]")).click();
	        Thread.sleep(1000);

 
	        // Get the initial unread notification count
	        WebElement badgeBefore = driver.findElement(By.xpath("//span[contains(@class,'absolute -right-1 -top-1 flex h-5 w-5 items-center')]"));
	        int initialCount = Integer.parseInt(badgeBefore.getText().trim());
	        System.out.println("Initial Unread count: " + initialCount);

	        
	        
	        // Get the list of notification elements
		    List<WebElement> elements = driver.findElements(By.xpath("//p[@class='text-sm font-medium text-gray-900']"));
		    System.out.println("The size is " + elements.size());
		    
		    if(elements.isEmpty())
		    {
		      System.out.println("No new Notifications");
		    }
	
	        
	        // Click on the 3-dot (ellipsis) icon to open the notification options
	        driver.findElement(By.xpath("//a[1]//div[1]//div[2]//button[1]//*[name()='svg']")).click();
	        Thread.sleep(500);

	        // Click the "Delete" button
	        driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
	        Thread.sleep(1000); // Wait for UI update
	        
	        
	        if(elements.size()==1)
	        {
	        	WebElement elem=driver.findElement(By.xpath("//p[text()='No new notifications']"));
	        	Assert.assertTrue(elem.isDisplayed());
	        	System.out.println("Notification Delete Successfully!!");
	        }
	        else {
	        // Get the updated unread notification count
	        WebElement badgeAfter = driver.findElement(By.xpath("//span[contains(@class,'absolute -right-1 -top-1 flex h-5 w-5 items-center')]"));
	        int updatedCount = Integer.parseInt(badgeAfter.getText().trim());
	        System.out.println("Unread count after deleting: " + updatedCount);

	        // Assert that the unread count decreased by 1
	        //Assert.assertEquals(actual, expected, message)  message if  assertion fail
	     
	      
	        if((initialCount== updatedCount+1) )System.out.println(" NotifyCount decrease by 1 after deleting the notification.");
	      
	       }
	}
	
	
	

	//case 2 when read then delete---
	
	@Test
	void checkDeleteButtonWorksAfterRead() throws InterruptedException, IOException {
	    Thread.sleep(1000); // Wait for the page to fully load

		verifyLoginButtonisworkornot();
		Thread.sleep(500);
	    // Open the notification panel
	    driver.findElement(By.xpath("//button[contains(@class, 'border-stroke bg-gray-2 text-dark hover:text-primary mui-mfslm7')]")).click();
	    Thread.sleep(1000);
	

	    // Click the 3-dot icon to open options for the first notification
	    driver.findElement(By.xpath("//a[1]//div[1]//div[2]//button[1]//*[name()='svg']")).click();
	    Thread.sleep(500);
	    
	    
	    // Get the initial unread notification count
	    WebElement badgeBefore = driver.findElement(By.xpath("//span[contains(@class,'absolute -right-1 -top-1 flex h-5 w-5 items-center')]"));
	    int initialCount = Integer.parseInt(badgeBefore.getText().trim());
	    System.out.println("Initial unread count: " + initialCount);

	    // Mark the notification as Read
	    driver.findElement(By.xpath("//button[normalize-space()='Read']")).click();
	    Thread.sleep(1000); // Wait for the UI update
	    

	    // Open the 3-dot menu again to delete
	    driver.findElement(By.xpath("//a[1]//div[1]//div[2]//button[1]//*[name()='svg']")).click();
	    Thread.sleep(500);

	    
	    // Open the 3-dot menu again to delete
	    driver.findElement(By.xpath("//a[1]//div[1]//div[2]//button[1]//*[name()='svg']")).click();
	    Thread.sleep(500);

	    
	   
	   
	    // Click "Delete"
	    driver.findElement(By.xpath("(//button[normalize-space()='Delete'])[1]")).click();
	    Thread.sleep(1000); // Wait for UI update
   if(initialCount==1)
   {
	    
      
       	WebElement elem=driver.findElement(By.xpath("//p[text()='No new notifications']"));
       	Assert.assertTrue(elem.isDisplayed());
       	System.out.println("Notification Delete Successfully!!");
       
   }
   else
   {
	    // Get the updated unread notification count
	    WebElement badgeAfter = driver.findElement(By.xpath("//span[contains(@class,'absolute -right-1 -top-1 flex h-5 w-5 items-center')]"));
	    int updatedCount = Integer.parseInt(badgeAfter.getText().trim());
	    System.out.println("Unread count after deleting: " + updatedCount);

	    // Check if count decreased only once (when marked as read)
	    if (initialCount == updatedCount+1 ) {
	        System.out.println("Notification count decreased by 1 after marking as read, and stayed same after delete.");
	    } else {
	        System.out.println("Notification count did not update correctly after delete.");
	    }
	}
   
	}

	
	
	
	
	
	
	
	


}
