package bidinnUserWebAppTestScript;

import static org.testng.Assert.assertNotEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// in this we try to to first search a particular city and then their hotel are been displayed ,now i try to change the city 
//name and get 
//31-03-25
public class VerifyHotelListPage {
	
	WebDriver driver;

	
	
 
	  
	
    //28-05-25---Updated Hotel List Page--
    
   
	@BeforeMethod
	void entercityintput() throws InterruptedException
	{       

	    driver=new ChromeDriver();
		driver.get("https://www.bidinn.in/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  // City Name insertion.
        String city = "Haridwar";
        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
        cityInput.sendKeys(city);

        WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Haridwar']")));
        cityOption.click();

        // Calendar choose - Check-in
        WebElement checkIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-in']")));
        checkIn.click();
        
        //click on the next month calender
        WebElement nextmonthclick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")));
        nextmonthclick.click();
        
        

        WebElement checkInDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[3]")));
        checkInDate.click();

        
        WebElement checkOutDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[8]")));
        checkOutDate.click();

        // Guest choose
        WebElement guestIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cc-1x4xm cc-sdm9t']")));
        guestIcon.click();

        WebElement roomGuestDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='No. of Room/Guest']")));
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
	
	
	
	   @AfterMethod
	    void teardown() {
	        if (driver != null) {
	            driver.quit(); // Ensures the session is fully terminated
	        }
	    }
////----------------------------------- New City Case
	
	@Test
	void verifychangelocationgivenewlocationhotel() throws InterruptedException
	{  
	
		Thread.sleep(2000);
	
		// new  city insertion
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  // City Name insertion.
      String city = "Delhi";
      WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
      cityInput.sendKeys(city);
    
      
      WebElement clearbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
      clearbtn.click();
      
      Thread.sleep(2000);
      WebElement cityInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
      cityInput1.sendKeys(city);
      
      WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Delhi']")));
      cityOption.click();

    
        
         
         Thread.sleep(2000);
         
         
         
         boolean ans=true;
      //------------------let check the verification of send city
         
         //get the list address--
         
       List<WebElement>ls=driver.findElements(By.xpath("//p[@class='text-sm text-gray-600 flex items-center']"));
       
       for(WebElement ele:ls)
       {
    	   System.out.println("The address is "+" "+ele.getText());
    	    String name=ele.getText();
    	   if(name.contains(city))
           {
        	   continue;
           }
           else
           {
        	   ans=false;
           }
        	  
       }
         
       Assert.assertTrue(ans);
       
       driver.quit();
   
	
	}
	
	
	//------------------------------------------ New Hotel name
	@Test
	void verifyhotelnamedetail() throws InterruptedException
	{
		
		String pc="Hotel Shyam";
		Thread.sleep(2000);
		
		// new hotel name   insertion
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  // hotel Name insertion.
      String hotelname = "Hotel Shyam";
      WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
      cityInput.sendKeys(hotelname);
    
      
      WebElement clearbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
      clearbtn.click();
      
      Thread.sleep(2000);
      WebElement cityInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
      cityInput1.sendKeys(hotelname);
      
      WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Hotel Shyam Krishna(Test_Hotel)']")));
      cityOption.click();
         

      Thread.sleep(2000);
      WebElement elem   =driver.findElement(By.xpath("//h2[text()='Hotel Shyam Krishna(Test_Hotel)']"));
      System.out.println("The hotel name is "+elem.getText());
         
      Assert.assertTrue(elem.getText().contains(pc));

		
		
		
		
	}
	
	
	//--------------------------------
	
	
	

	
	//-------------------------Filtering task checking
	
	//case 1 budget 299-1499
	@Test
	void verifyfilterbox() throws InterruptedException
	{  int val1=299;
	   int val2=1499;
	
		
		Thread.sleep(3000);
		
		//clicking the budget button
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		
		Thread.sleep(2000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
       
        for(WebElement em:elem)
		{
			String price=em.getText();
			//trim the ruppes sigm
			String newpr=price.substring(1);
			Double prc=Double.parseDouble(newpr);
			
			System.out.println("The new price is"+prc);
			
			if(prc>=val1 && prc<=val2)
			{
				continue;
			}
			else
			{
				ans=false;
				break;
			}
		}
        
        Assert.assertTrue(ans);
        driver.quit();
			
		
	}
	
	
//case 2
//budget 1499 2999
	@Test
	void verifyfilterbox2() throws InterruptedException
	{  int val1=1499;
	   int val2=2999;
	
		
		Thread.sleep(1000);
		
		//clicking the budget button
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		
		Thread.sleep(1000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
       
        for(WebElement em:elem)
		{
			String price=em.getText();
			//trim the ruppes sigm
			String newpr=price.substring(1);
			Double prc=Double.parseDouble(newpr);
			
			System.out.println("The new price is"+prc);
			
			if(prc>=val1 && prc<=val2)
			{
				continue;
			}
			else
			{
				ans=false;
				break;
			}
		}
        
        Assert.assertTrue(ans);
        driver.quit();
			
		
	}
	
	
//case 3
//budget 2999 5999
	
	@Test
	void verifyfilterbox3() throws InterruptedException
	{  int val1=2999;
	   int val2=5999;
	
		
		Thread.sleep(1000);
		
		//clicking the budget button
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		
		Thread.sleep(1000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
       
        for(WebElement em:elem)
		{
			String price=em.getText();
			//trim the ruppes sigm
			String newpr=price.substring(1);
			Double prc=Double.parseDouble(newpr);
			
			System.out.println("The new price is"+prc);
			
			if(prc>=val1 && prc<=val2)
			{
				continue;
			}
			else
			{
				ans=false;
				break;
			}
		}
        
        Assert.assertTrue(ans);
        driver.quit();
			
		
	}
	
//case 4
//budget 5999 9999
	
	@Test
	void verifyfilterbox4() throws InterruptedException
	{  int val1=5999;
	   int val2=9999;
	
		
		Thread.sleep(2000);
		
		//clicking the budget button
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		
		Thread.sleep(1000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
       
        for(WebElement em:elem)
		{
			String price=em.getText();
			//trim the ruppes sigm
			String newpr=price.substring(1);
			Double prc=Double.parseDouble(newpr);
			
			System.out.println("The new price is"+prc);
			
			if(prc>=val1 && prc<=val2)
			{
				continue;
			}
			else
			{
				ans=false;
				break;
			}
		}
        
        Assert.assertTrue(ans);
        driver.quit();
			
		
	}
	
	

//---------------------------------Testing Slider Case
	
	
	void verifypricingrange(int min,int max) throws InterruptedException
	{  int val1=min;
	   int val2=max;
	
		
		Thread.sleep(1000);
		
//		//clicking the budget button
//		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
//		
		Thread.sleep(2000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
       
        for(WebElement em:elem)
		{
			String price=em.getText();
			//trim the rupees sign
			String newpr=price.substring(1);
			Double prc=Double.parseDouble(newpr);
			
			System.out.println("The new price is"+prc);
			
			if(prc>=val1 && prc<=val2)
			{
				continue;
			}
			else
			{
				ans=false;
				break;
			}
		}
        
        Assert.assertTrue(ans);
//        driver.quit();
			
		
	}
	
	
	
	@Test
	void testsliderPriceRange() throws InterruptedException
	{  
		Thread.sleep(1000);
		
		//making an actionclass for drap and dropby
		Actions act=new Actions(driver);
	
		 WebElement min_slider= driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabel mui-4hxr18'])[1]"));
		
	 //s-2 getting the coordinate to do slide operation---using getlocation
		System.out.println("The coordinate default is "+ min_slider.getLocation());  //184,187--(x y)
		
	//then move the minimum slider---using a method called draganddropby
		act.dragAndDropBy(min_slider, 30, 187).perform();
		
		
		System.out.println("The coordinate moving after is "+ min_slider.getLocation());
		
		
	//maximum slider----
		 Thread.sleep(1000);
		 WebElement max_slider= driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabel mui-4hxr18'])[2]"));
			
		 //s-2 getting the coordinate to do slide operation---using getlocation
			System.out.println("The coordinate default is "+ max_slider.getLocation());// x=298,y=187
			
//		moving the pointer
			
			act.dragAndDropBy(max_slider,-10 , 187).perform();
			
			
			System.out.println("The coordinate moving after is "+ max_slider.getLocation());
			
			
			Thread.sleep(1000);
			
			
	//---checking the same price hotel we get or not
			
		//s-1 get price value after moving
			
			WebElement nmv=driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabel mui-4hxr18'])[1]"));
			System.out.println("the mini price"+nmv.getText());
			
			
			int minipric=Integer.parseInt(nmv.getText());
			
			WebElement mmv=driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabel mui-4hxr18'])[2]"));
			System.out.println("the maxi price"+mmv.getText());
			int maxipric=Integer.parseInt(mmv.getText());
			
			verifypricingrange(minipric,maxipric);
			
			
			
			
			
		
		
		driver.quit();
		 
	
	}
	
	
	
	//-------------verify actual price is same after applying discount
	@Test
	void verifyactualpriceafterapplyingdiscount() throws InterruptedException
	{  
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> discountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-root MuiTypography-h5 mui-tvfgd6')]")));
        List<WebElement> displayprice = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
        List<WebElement> priceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h4[contains(@class,'MuiTypography-root MuiTypography-h4 line-through text-gray-500 mui-cbnxiq')]")));
           System.out.println("The elem size "+ discountElements.size());
           
          boolean ans=true;
           int size = Math.min(priceElements.size(), discountElements.size());

           for (int i = 0; i < size; i++) 
             {
                   // Get original price and remove currency symbol
                   String priceTet = priceElements.get(i).getText();
                   String priceText=priceTet.substring(1);
                   double originalPrice = Double.parseDouble(priceText);
                   
                   
                   
                   
                   // Get display price and remove currency symbol
                   String displaypce = displayprice.get(i).getText();
                   String displayprice1=displaypce.substring(1);
                   double displayprie = Double.parseDouble(displayprice1);

                   // Get discount percentage and remove non-numeric characters
                   String discountTxt = discountElements.get(i).getText().replaceAll("[^0-9.]", "");
                   String discountText=discountTxt.substring(0, 4);
                   double discountPercent = Double.parseDouble(discountText);

                   // Calculate discounted price
                   int discountedPrice = (int) (originalPrice - (originalPrice * (discountPercent / 100)));

                   System.out.println("Original Price: " + originalPrice + ", Discount: " + discountPercent + "%, Final Price: " + discountedPrice + "Display price "+ displayprie);
                   
                   if(0<=(discountedPrice-displayprie) &&(discountedPrice-displayprie) <=9)
                   {
                	   continue;
                   }
                   else
                   {
                	   ans=false;
                	   break;
                   }

               }
	
	
	
	
	
	
	
	
	
}
	
	
	
	
//---------verify 12% displayed or not-----------------
	
@Test
void twelevepercrating() throws InterruptedException
{
	Thread.sleep(1000);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	 List<WebElement> dataget = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'Medium MuiButton-textSizeMedium MuiButton-colorSecondary MuiButton-disableElevation mui-jas1qx')]")));
    List<WebElement> displayprice = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
 
      boolean ans=true;    
        int j=0;
     for (int i = 0; i < displayprice.size(); i++) 
  {
    
            String displaypce = displayprice.get(i).getText();
             String displayprice1=displaypce.substring(1);
              double displayprie = Double.parseDouble(displayprice1);
      
  	   String displaypce1 = dataget.get(j).getText();
  	   String off=displaypce1.substring(12, 15);
//    	   
    	   int am=Integer.parseInt(off);
//    	   
    	   int twper = (int) Math.round((displayprie * 12) / 100.0);
    	   
    	   System.out.println("The display is "+am+" we calcul "+twper);
              
    	   if(am!=twper)
    	   {
    		   ans=false;
    		   break;
    	   }
//    	   
//    	   
              j+=1;

           }


 Assert.assertTrue(ans);
 
}

  //--------------share concept understanding---

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
  
  
  //---------------changing calender date is possible or not-->
  
  @Test
  void changecheckinoutdatepsbleworkornot() throws InterruptedException
  {      Thread.sleep(2000);

  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  // Capture the previous (old) check-in and check-out dates
  WebElement oldCheckInElement = driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-root')])[1]"));
  WebElement oldCheckOutElement = driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-root')])[2]"));

  String oldCheckInDate = oldCheckInElement.getText();
  String oldCheckOutDate = oldCheckOutElement.getText();

  System.out.println("Old Check-in Date: " + oldCheckInDate);
  System.out.println("Old Check-out Date: " + oldCheckOutDate);

  // Open the calendar by clicking "Check-in"
  WebElement checkInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-in']")));
  checkInButton.click();

  // Click next month button
  WebElement nextMonthButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")));
  nextMonthButton.click();

  // Select new check-in and check-out dates
  WebElement newCheckInDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[3]")));
  newCheckInDateElement.click();

  WebElement newCheckOutDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[8]")));
  newCheckOutDateElement.click();

  // Capture the updated (new) check-in and check-out dates
  Thread.sleep(1000); // small wait for UI update

  WebElement newCheckInElement = driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-root')])[1]"));
  WebElement newCheckOutElement = driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-root')])[2]"));

  String newCheckInDate = newCheckInElement.getText();
  String newCheckOutDate = newCheckOutElement.getText();

  System.out.println("New Check-in Date: " + newCheckInDate);
  System.out.println("New Check-out Date: " + newCheckOutDate);

  // Assert that the dates have changed
  assertNotEquals("Check-in date did not change!", oldCheckInDate, newCheckInDate);
  assertNotEquals("Check-out date did not change!", oldCheckOutDate, newCheckOutDate);

  System.out.println("Dates successfully updated — Calendar is working!");
	
	  
	  
	  
	  
	  
  }
  
  
  
  @Test
  
  void changeRoomandGuestworkornot() throws InterruptedException
  {   
	  Thread.sleep(2000);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Capture previous Room/Guest value
	    WebElement previousRoomGuestElement = driver.findElement(By.xpath("//h5[contains(@class,'MuiTypography-h5')]"));
	    String previousRoomGuestText = previousRoomGuestElement.getText();
	    System.out.println("Previous Room/Guest value: " + previousRoomGuestText);

	    Thread.sleep(1000);

	    // Click to open Room/Guest dropdown
	    WebElement roomGuestDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='No. of Room/Guest']")));
	    roomGuestDropdown.click();
	    Thread.sleep(1000);

	    // Click increment buttons (room, adult, child)
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[2]"))).click(); // Room +
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[4]"))).click(); // Adult +
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='text-gray-400 focus:outline-none'])[6]"))).click(); // Child +

	    // Close the dropdown
	    roomGuestDropdown.click();
	    Thread.sleep(1000);

	    // Capture updated Room/Guest value
	    WebElement updatedRoomGuestElement = driver.findElement(By.xpath("//h5[contains(@class,'MuiTypography-h5')]"));
	    String updatedRoomGuestText = updatedRoomGuestElement.getText();
	    System.out.println("Updated Room/Guest value: " + updatedRoomGuestText);

	    // Assert that previous and updated values are not equal
	    assertNotEquals("Room/Guest value did not update!", previousRoomGuestText, updatedRoomGuestText);

	    System.out.println("Room and Guest update successful — Test Passed!");
	  
  }
  
  @Test
  void checkLoginButtonworkornot() throws InterruptedException
  {   
	  Thread.sleep(2000);
	  String val="For security, please sign in to access your information";
	  String ans="";
	  Thread.sleep(1000);
	  WebElement lo=driver.findElement(By.xpath("//a[text()='Login']"));
	  if(lo.isDisplayed())
	  {
		  lo.click();
		  Thread.sleep(1000);
		  WebElement li=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 mui-jbw5gj']"));
		  ans=li.getText();
		  System.out.println("the text is "+ans);
		  
		  Assert.assertTrue(val.contains(ans));
		  
	  }
	  else
	  {
		  System.out.println("User Already Login");
		  
	  }
	  
	
  }
  
  
  
  
  
  
  
  
  





	
}
