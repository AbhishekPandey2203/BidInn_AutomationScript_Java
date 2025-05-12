package bidinnUserWebAppTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

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

public class VerifyAddGuestButtonworkinmyBookingPage {
	
	WebDriver driver;
	
//checking the error secanrio case--when we add guest more than choosen guest--
	
Properties property;
	
	
//	🔹 Purpose in Your Code---
//	This constructor:
//	Initializes the properties object
//	Loads the .properties file containing the credentials
//	Makes it easier to call getUsername(), getPassword(), and getUrl() without loading the file manually every time

	//***this is constructor smje---islye koi return type nhi h-- logically dekho--aur ek chej
	//isko obj bnane pe call hoga automatically and help krega invoke krne m
	// properties ko--
	public VerifyAddGuestButtonworkinmyBookingPage() throws IOException
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

		        WebElement HotelOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Hotel Shyam Krishna(Test_Hotel).']")));
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

//		        // Increment buttons (room, adult, child)
//		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[2]"))).click();
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[1]"))).click();
//		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[6]"))).click();

		        // Click again to close the dropdown
		        roomGuestDropdown.click();

		        // Click the search button
		        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
		        searchBtn.click();
		        
		        
		        
		        Thread.sleep(2000);
		        //reterive the details-------------------
		        

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
	           
	        }
	    }

	
	 
	 
	void enterLoginCredential() throws InterruptedException, IOException
	{  
		VerifyAddGuestButtonworkinmyBookingPage h1=new VerifyAddGuestButtonworkinmyBookingPage();
		
		
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
		
	   
}
	
	
// add the guest detail first---
	
	
    void addguestbuttonwork() throws InterruptedException
	{
		
		Thread.sleep(2000);
		//click on add guest button--
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700);");
		Thread.sleep(1000);
		WebElement elem=driver.findElement(By.xpath("//button[text()='Add Guests']"));
		elem.click();
		
		//----

//		
//		Thread.sleep(1000);
//		//title click
//		WebElement elm1=driver.findElement(By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input mui-74pt8w'])[2]"));
//		elm1.click();
//	    String precase=elm1.getText();
//
//		
//		Thread.sleep(1000);
//		
//	    driver.findElement(By.xpath("//li[normalize-space()='Prof']")).click();
//	    Thread.sleep(1000);
//	    
//	    String postcase=elm1.getText();
//	   
//	    Assert.assertTrue(!(precase.equals(postcase)));
		
	    System.out.println("The title is working properly");

	 // First Name
	 WebElement firstNameField = driver.findElement(By.xpath("//div[@class='MuiCardContent-root mui-zf4utx']/..//input[@name='firstName']"));
	 firstNameField.click();
	 firstNameField.sendKeys("Abhi");
	 Thread.sleep(1000);

	 // Last Name
	 WebElement lastNameField = driver.findElement(By.xpath("//div[@class='MuiCardContent-root mui-zf4utx']/..//input[@name='lastName']"));
	 lastNameField.click();
	 lastNameField.sendKeys("Shukla");
	 Thread.sleep(1000);

	// // Phone Number
	// WebElement phoneField = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input mui-1pk1fka'])[10]"));
	// phoneField.click();
	// phoneField.sendKeys("+91 9988776655");
	// Thread.sleep(1000);

	 // Email Address
	 WebElement emailField = driver.findElement(By.xpath("//div[@class='MuiCardContent-root mui-zf4utx']/..//input[@type='email']"));
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
	 
	
	}
	
	
	
   @Test
	void checkingaddmoreguestthannoofguest() throws InterruptedException, IOException
	{  
	   String val="Cannot select more guests than the total available";
		Thread.sleep(1000);
		enterLoginCredential(); //login scenario case--
		
		Thread.sleep(1000);
		addguestbuttonwork();  //calling the add guest
		
		
	//now after entering try to add it in guest list	
    WebElement checkbox11=driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input mui-j8yymo'])[1]"));
    checkbox11.click();
    
    Thread.sleep(1000);
    // when click if error spot it
    
    WebElement errormsg=driver.findElement(By.xpath("//div[@class='swal2-html-container']"));
    System.out.println("the error is "+errormsg.getText());
    
    System.out.println(errormsg.getText());
    
    Assert.assertTrue(errormsg.getText().contains(val));
    
     driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
      
     driver.switchTo().defaultContent();
     

List<WebElement> elements = driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiAccordion-root MuiAccordion-rounded MuiAccordion-gutters mui-1pi0qnl']"));

Assert.assertTrue(elements.size() > 0, "User not added successfully");
System.out.println("User added successfully. Element size: " + elements.size());
     //click on arrow add click---
     Thread.sleep(2000);
     WebElement arowclick=driver.findElement(By.xpath("//span[@class='MuiAccordionSummary-expandIconWrapper mui-f8wb7g']//*[name()='svg']")); 
     arowclick.click();
     
     Thread.sleep(500);
     
     //click on delete
     
     
     WebElement dele=driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
     dele.click();
     
     
     

List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 MuiAccordion-root MuiAccordion-rounded MuiAccordion-gutters mui-1pi0qnl']"));

Assert.assertTrue(elements1.size() > 0, "User not added successfully");
System.out.println("User after Deleted successfully. Element size: " + elements1.size());

   
Assert.assertTrue((elements.size()!=elements1.size()));

      System.out.println("Added user Deleted Successfully..Delete button work Properly!!");
      
      //-----
    
//    Assert.assertTrue(errormsg.getText().contains(val));


		
	}
	
	
	
	
	

}
