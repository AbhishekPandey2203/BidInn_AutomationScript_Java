package bidinnUserWebAppTestScript;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyHomePage {
	WebDriver driver;
	@BeforeMethod
	void commancode()
	{  
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
			driver.get("https://www.bidinn.in/");
			
			
		
	}
	
	
    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit(); // Ensures the session is fully terminated
        }
    }
//    
    
    
    
    //Bidinn-Logo
    @Test(priority=1)
    void bidinnLogo() {
        WebElement imageElement = driver.findElement(By.xpath("(//img[@alt='Bidinn'])[1]"));
        Assert.assertTrue(imageElement.isDisplayed(), "Logo is not displayed.");
        System.out.println("Bidinn Logo is verified. ");
    }
    
    
    //Login Button--work
    
    @Test
    void logintextLink() throws InterruptedException
    {    
    	String value="Auth screen : Bidinn - Bidinn";
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login / Sign-up']")));
    	loginButton.click();
    	
    	Thread.sleep(1000);
    	
    	String val=driver.getTitle();
    	
    	System.out.println("the title "+val);
    	
    	Assert.assertTrue(value.equals(val));
    }
    
    
    
    //Bidinn Backgroud Image-------------
    
    @Test
    void backgroundImage() {
        WebElement imageElement = driver.findElement(By.xpath("(//img[@alt='Bidinn'])[2]"));
        Assert.assertTrue(imageElement.isDisplayed(), "Background image is not displayed.");
    }
   
    


	//Searching ----------------------Functionality
	
	@Test
	void verifySearch() throws InterruptedException
	{     
		String valu="Haridwar | Hotel Detail Page | bidinn.in";
		
		//get the value--through our local system
		
	//get current date
		LocalDate currentdate=LocalDate.now();
		 // Define the desired format: "April 24, 2025"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

        // Format the current date
        String formattedDate = currentdate.format(formatter);

        // Output the formatted date
        System.out.println("Formatted current date: " + formattedDate);
		
		
		String city="Haridwar";
		
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Haridwar");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//p[text()='Haridwar']")).click();
        Thread.sleep(500);
        
      //verify calendar value display---
  
	 WebElement checkin=driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][1]"));
	 String checkin1=checkin.getText();
	  System.out.println(" the val "+checkin1);
	
	  Assert.assertTrue(checkin1.contains(formattedDate));
	 
	  /*
	  WebElement checkout1=  driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][2]"));
	String checkout=checkout1.getText();
	  System.out.println("the val "+checkout);
	  
	  
	  Assert.assertTrue(checkout.contains(dateCheckout));
	  */
	  
     // no of rooms and guest displayed---------
		boolean gut=driver.findElement(By.xpath("(//h5[normalize-space()='1 Room/ 2 Guests'])[1]")).isDisplayed();
		
		Assert.assertTrue(gut);
		
		driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
		Thread.sleep(1000);
		String valm=driver.getTitle();
		System.out.println("the title name is "+valm);
		
		Assert.assertTrue(valu.equals(valm));
		
		
	// getting the Hotel address--city name
		
		Thread.sleep(3000);
		List<WebElement>cityadd=driver.findElements(By.xpath("//p[@class='text-sm text-gray-600 flex items-center']"));
		
		for(WebElement ele:cityadd)
		{
			String getcity=ele.getText();
			
			Assert.assertTrue(getcity.contains(city));
//			System.out.println("Search Button is verified. ");
		}
	

		
	}
	
	
	//Explore city around you working------------
	
	
	@Test
	void verifyExploreCityCardsWorkornot() throws InterruptedException
	{  
		//now check the slider
		   String value="Delhi";
		
		  WebElement elem1=driver.findElement(By.xpath("//h4[normalize-space()='Explore Cities Around You!']"));
		// Scroll into view using JavaScriptExecutor
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem1);
	
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h6[text()='Delhi'])[1]")));
	      element.click();
		
		  Thread.sleep(1000);
		
		  String val=driver.getTitle();
	     System.out.println("The title is"+val);
	     
	  
	     
	  // getting the Hotel address--city name
			
			Thread.sleep(3000);
			List<WebElement>cityadd=driver.findElements(By.xpath("//p[@class='text-sm text-gray-600 flex items-center']"));
			
			for(WebElement ele:cityadd)
			{
				String getcity=ele.getText();
				
				Assert.assertTrue(getcity.contains(value));
			}
		

		
		
		
	}
	

	//check slider for explore city around you!!-------------
	
	@Test
	void verifyExploreCitySliderworkornot() throws InterruptedException
	{     
		  Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 350);");
//		  Thread.sleep(1000);
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h6[@class='MuiTypography-root MuiTypography-h6 w-full pt-2 mui-1ke6op4'])[1]")));
		   System.out.println("the city is "+element.getText());
		    
		   Thread.sleep(1000);
	
		   
		  WebElement Arrowslide= driver.findElement(By.xpath("(//button[contains(@class,'MuiIconButton-sizeMedium h-12 w-12 mui-mfslm7')])[1]"));
//		   Thread.sleep(1000);
		   int count=10;
		   while (Arrowslide.isEnabled()) {
//			    Thread.sleep(1000);
			    count--;
                
			    if(count==0)break;
			    // Click the button
			    driver.findElement(By.xpath("(//button[contains(@class,'MuiIconButton-sizeMedium h-12 w-12 mui-mfslm7')])[1]")).click();

			    // Check if it will be disabled next iteration
			    if (!Arrowslide.isEnabled()) {
			        break;
			    }
			}
		   
		   
		   Thread.sleep(1000);
		   
		WebElement elem=driver.findElement(By.xpath("(//h6[@class='MuiTypography-root MuiTypography-h6 w-full pt-2 mui-1ke6op4'])[1]"));
//		System.out.println("the ans "+elem.isDisplayed());
		
		Assert.assertTrue(!elem.isDisplayed());
		System.out.println("Scroll Icon Button is Verified. ");    
	}
	
	
	
	
	
// Recommended Hotel Working----
	
//some change in hotel getting detail--
	
	@Test
	void verifyRecommendHotelNameOrImageLink() throws InterruptedException
	{  
		
		 String value="Evara Spa & Resort, Jim Corbett | Hotel Detail Page | bidinn.in";
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		WebElement elem1=driver.findElement(By.xpath("//h4[text()='Recommended Hotels(Sponsored)']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem1);

        Thread.sleep(1000);
        
        
        driver.findElement(By.xpath("//h6[text()='Jim Corbett']")).click();
        
        Thread.sleep(1000);

		  String val=driver.getTitle();
	     System.out.println("The title is"+val);
	     
	     Assert.assertTrue(value.equals(val));
		  
		
	}
	
	//sliderRecommedhotel
	
	@Test
	void verifyRecommendedHotelSliderworkornot() throws InterruptedException
	{      
		Thread.sleep(1000);
		//Scrolled case---------
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700);");
		
		
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")));
		     element.click();
		   Thread.sleep(1000);
	
		   
		  WebElement Arrowslide= driver.findElement(By.xpath("(//button[contains(@class,'MuiIconButton-sizeMedium h-12 w-12 mui-mfslm7')])[2]"));
		   Thread.sleep(1000);
		   int count=10;
		   while (Arrowslide.isEnabled()) {
			    Thread.sleep(1000);
			    count--;
			    
			    if(count==0)
			    	break;

			    // Click the button
			    driver.findElement(By.xpath("(//button[contains(@class,'MuiIconButton-sizeMedium h-12 w-12 mui-mfslm7')])[2]")).click();

			    // Check if it will be disabled next iteration
			    if (!Arrowslide.isEnabled()) {
			        break;
			    }
			}
		   
		   
		   Thread.sleep(1000);
//		   
//		   WebElement element1 = driver.findElement(By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle2 mui-11wd9et'][normalize-space()='Delhi']"));
		   System.out.println("Slider is working Properly");
		   
	}
	
	
	
	@Test
	void verifyRecommendHotelStartBidBeforeLogin() throws InterruptedException
	{  
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		
		 String value="Hotel Crystal Palace | Hotel Detail Page | bidinn.in";
		 Thread.sleep(1000);
			//Scrolled case---------
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700);");
			

				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")));
			     element.click();
			   Thread.sleep(1000);
		
        
        
        driver.findElement(By.xpath("(//h6[text()='Start Bid @ ₹'])[1]")).click();
        
        Thread.sleep(1000);

		  String val=driver.getTitle();
	     System.out.println("The title is"+val);
	     
	     Assert.assertTrue(value.equals(val));
		  
		
	}
	
	@Test
	void verifyRecommendHotelBidNowBeforeLogin() throws InterruptedException
	{  
		
		
		String value="Auth screen";
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 900);");
			
			
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")));
	     element.click();
	   Thread.sleep(1000);

        
        
        driver.findElement(By.xpath("(//button[text()='Bid Now'])[1]")).click();
        
        
            Thread.sleep(4000);
		  String val=driver.getTitle();
	     System.out.println("The title is"+val);
	     
	  Assert.assertTrue(val.contains(value));
		
	}
	

	
//Check GooglePlaystore----------
	
	@Test
    void verifyclicklink1gps() throws InterruptedException
    {    
		String vale="Bidinn - Apps on Google Play";
		
		
		  Thread.sleep(5000);
		  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1500);");
			
		  
		 
		  //click the function
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//h1[text()='Google Play']")).click();
//		  
		  Thread.sleep(1000);
		  String val=driver.getTitle();
		  System.out.println("The title is"+val);
		  Assert.assertTrue(vale.equals(val));
		  
		  
		 
 	
    }
	
	
	@Test
	void verifyclicklink2ios() throws InterruptedException
    {    
		String vale="App Store";
		
	
		
		 Thread.sleep(1000);
		  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1500);");
			
		  
		  //click the function
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//h1[text()=' App Store']")).click();
//		  
		  Thread.sleep(1000);
		  String val=driver.getTitle();
		  System.out.println("The title is"+val);
		  Assert.assertTrue(val.contains(vale));
		  
		  

    }
	
	
	
//Our Blogs-------------------
	
	
	@Test
	void verifyourBlogs() throws InterruptedException
	{
		//verify the blog
		  String val1="Show Less";
		
		
		Thread.sleep(4000);
		WebElement isdis=driver.findElement(By.xpath("//h2[text()='Our Blogs']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", isdis);

		Thread.sleep(1000);

		 WebElement elem=   driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-disableElevation underline underline-offset-2 mui-19zfvdp')])[4]"));
		 elem.click();
      

		 Thread.sleep(1000);
		 
		 
		 WebElement elem2=   driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-disableElevation underline underline-offset-2 mui-19zfvdp')])[4]"));
		 String value=elem.getText();
		 
		 Assert.assertTrue(val1.equals(value));
		
		
		
		
	}
	
	
	
	@Test
	void verifyDotsofOurBlog() throws InterruptedException
	{    
		
		String value="Monsoon Adventure in Kerala";
		
		Thread.sleep(4000);
		WebElement isdis=driver.findElement(By.xpath("//h2[text()='Our Blogs']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", isdis);
		
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='2']")).click();
		
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()=' Monsoon Adventure in Kerala']")));
	     element.isDisplayed();
	     
	     String val=element.getText();
	     
	     System.out.println("The name is "+val);
		   
	     Assert.assertTrue(value.equals(val));
		
		

			
		
	}
	
	
	//Top Cities-------------------
	
	@Test
	void topCitieswork() throws InterruptedException
	{  
		String titlehotel="Delhi";
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2000);");
		
		 Thread.sleep(1000);
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")));
	     element.click();
	     
	     
	     
	     //now clicking one link
	     
	     driver.findElement(By.xpath("(//h6[text()='Hotels In Delhi'])[1]")).click();
		//as it open in another tab
		
	     
	     
		String id1=driver.getWindowHandle();
		System.out.println(" the id "+id1);
		
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);

		String id11 = driver.getWindowHandle(); // Assuming you already have this

		for (String id : allid) {
		    if (!id.equals(id11)) {
		        driver.switchTo().window(id);
		        // Perform your actions on the new window
		        
		        Thread.sleep(3000);
				List<WebElement>cityadd=driver.findElements(By.xpath("//p[@class='text-sm text-gray-600 flex items-center']"));
				
				for(WebElement ele:cityadd)
				{
					String getcity=ele.getText();
					System.out.println("The address is "+getcity);
					
					Assert.assertTrue(getcity.contains(titlehotel));
				}
			
				
				
		    }
		}
			

		
	}
	
	
	//State in India--------------------
	
	@Test
	void statesofIndia() throws InterruptedException
	{  
		String titlehotel="Delhi";
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2800);");
			
		 Thread.sleep(1000);
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")));
	     element.click();
	     
	     
	     
	     //now clicking one link
	     
	     driver.findElement(By.xpath("(//h6[text()='Hotels In Delhi'])[2]")).click();
	     Thread.sleep(1000);
		 String tit=driver.getTitle();
		System.out.println("The title is "+tit);
		
		
		List<WebElement>cityadd=driver.findElements(By.xpath("//p[@class='text-sm text-gray-600 flex items-center']"));
		
		for(WebElement ele:cityadd)
		{
			String getcity=ele.getText();
			System.out.println("The address is "+getcity);
			
			Assert.assertTrue(getcity.contains(titlehotel));
		}

		
	}
	


}
