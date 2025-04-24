package verifynavigationandhotellistdetail;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// in this we try to to first search a particular city and then their hotel are been displayed ,now i try to change the city 
//name and get 
//31-03-25
public class verifyhotellistdetail {
	
	WebDriver driver;
	

	void calenderchoose() throws InterruptedException
	{
		
		
		
		 //calender chose
        driver.findElement(By.xpath("//div[@class='MuiBox-root mui-1jke4yk']")).click();
        driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
        
        //now choose the date start--by default end also select 
        driver.findElement(By.xpath("(//span[@class='rdrDayNumber'])[6]")).click();

        //------guest choose
        //first click
        
        driver.findElement(By.xpath("//p[contains(@class,'text-gray-700 mui-1g36mgr')]")).click();
        
        
       
        
          //set the guest count---
        
        driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[1]")).click();           
        driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='-'])[2]")).click(); 
        driver.findElement(By.xpath("(//button[@class='text-gray-400 focus:outline-none'][normalize-space()='+'])[3]")).click(); 
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//button[text()='Done']")).click();
        
        
	}
	
	
//-----------------------------------------------------------	
	
   @BeforeTest
	
	void searchfirst() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://www.bidinn.in/");
		driver.manage().window().maximize();
		
		//--------------- searchbox
		//hotel name insertion
				driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Noida");
				  Thread.sleep(500);
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"MuiAutocomplete-endAdornment mui-mxlkbn\"]")));
			     element.click();
			        
		         driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Noida");
				  
		         Thread.sleep(1000);
		       
		         driver.findElement(By.xpath("(//p[text()='Noida'])[3]")).click();
		         

		         

		           //calender chose
		           driver.findElement(By.xpath("//div[@class='MuiBox-root mui-1jke4yk']")).click();
		           driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
	           
		           //now choose the date start--by default end also select 
		           driver.findElement(By.xpath("(//span[@class='rdrDayNumber'])[5]")).click();

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
		            
		           
		           
		           
//	//----------------------new page open-----
		           	
		
	}
	
//-----------------------------------
	
	@Test
	void verifychangelocationgivenewlocationhotel() throws InterruptedException
	{  
		String pc="Delhi";
		Thread.sleep(1000);
		calenderchoose();
		//hotel name insertion
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys(pc);
		  Thread.sleep(500);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"MuiAutocomplete-endAdornment mui-mxlkbn\"]")));
	     element.click();
	        
         driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys(pc);
		  
         Thread.sleep(1000);
       
         driver.findElement(By.xpath("(//p[text()='Delhi'])")).click();
         
         
         Thread.sleep(2000);
         
         
         
         boolean ans=true;
      //------------------let check the verification of send city
         
         //get the list address--
         
       List<WebElement>ls=driver.findElements(By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle1 mui-yjpxa8']"));
       
       for(WebElement ele:ls)
       {
    	   System.out.println("The address is "+" "+ele.getText());
    	    String name=ele.getText();
    	   if(name.contains(pc))
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
	
	
	//------------------------------------------
	@Test
	void verifyhotelnamedetail() throws InterruptedException
	{
		
		String pc="Hotel Shyam";
		//hotel name insertion
        Thread.sleep(1000);
        calenderchoose();
		//hotel name insertion
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys(pc);
		  Thread.sleep(500);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"MuiAutocomplete-endAdornment mui-mxlkbn\"]")));
	     element.click();
	        
         driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys(pc);
		  
         Thread.sleep(1000);
       
         driver.findElement(By.xpath("(//p[contains(text(),'Hotel Shyam')])")).click();
         
         Thread.sleep(2000);
         
         
      WebElement elem   =driver.findElement(By.xpath("//h2[text()='Hotel Shyam Krishna(Test_Hotel)']"));
      System.out.println("The hotel name is "+elem.getText());
         
      Assert.assertTrue(elem.getText().contains(pc));
   
       driver.quit();
		
		
		
		
	}
	
	
	//--------------------------------
	
	@Test
	void priceverifylowtohighcase() throws InterruptedException
	{
		//let try todo it
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='sortBy']")).click();
		
		// price xpath
	
         driver.findElement(By.xpath("//li[contains(@class,'mui-mlee68')][2]")).click();
         
         Thread.sleep(1000);
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
  	    
         double ans=0;
         boolean ini=true;
         boolean val=true;
 		System.out.println("the size is"+elem.size());
 		for(WebElement em:elem)
 		{
 			String price=em.getText();
 			//trim the ruppes sigm
 			String newpr=price.substring(1);
 			Double prc=Double.parseDouble(newpr);
 			
 			System.out.println("The new price is"+prc);
 			
 			if(ans==0 && ini )
 			{
 				ans=prc;
 				ini=false;
 			}
 			
 			else if(ans<=prc)
 			{
 				ans=prc;
 			}
 			else
 			{
 				val=false;
 				break;
 			}
		
		
	   }
 		
 		Assert.assertTrue(val);
 		driver.quit();
 		
 		
 	
	
	}
	
	//----------------------------------------
	
	@Test
	void priceverifyhightolowcase() throws InterruptedException
	{
		//let try todo it
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='sortBy']")).click();
		
		// price xpath
	
         driver.findElement(By.xpath("//li[contains(@class,'mui-mlee68')][3]")).click();
         
         Thread.sleep(1000);
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
  	    
         double ans=0;
         boolean ini=true;
         boolean val=true;
 		System.out.println("the size is"+elem.size());
 		for(WebElement em:elem)
 		{
 			String price=em.getText();
 			//trim the ruppes sigm
 			String newpr=price.substring(1);
 			Double prc=Double.parseDouble(newpr);
 			
 			System.out.println("The new price is"+prc);
 			
 			if(ans==0 && ini )
 			{
 				ans=prc;
 				ini=false;
 			}
 			
 			else if(ans>=prc)
 			{
 				ans=prc;
 			}
 			else
 			{
 				val=false;
 				break;
 			}
		
		
	   }
 		
 		Assert.assertTrue(val);
 		driver.quit();
 		
	
	}
	
	
	//--------------------------------------
	@Test
	void ratinghightolow() throws InterruptedException
	{
		//let try todo it
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='sortBy']")).click();
				// price xpath
		driver.findElement(By.xpath("//li[contains(@class,'mui-mlee68')][4]")).click();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle2 mui-4cbwqt']")));
 	    
        // now list up the hotel rating
        
        for(WebElement ele:elem)
        {
        	System.out.println("the rating is "+ele.getText());
        }
        
        driver.quit();
		
		
	}
	
	@Test
	void ratinglowtohigh() throws InterruptedException
	{
		//let try todo it
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='sortBy']")).click();
				// price xpath
		driver.findElement(By.xpath("//li[contains(@class,'mui-mlee68')][5]")).click();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle2 mui-4cbwqt']")));
 	    
        // now list up the hotel rating
        
        for(WebElement ele:elem)
        {
        	System.out.println("the rating is "+ele.getText());
        }
        
        driver.quit();
		
		
	}
	
	
	//-------------------------Filtering task checking
	
	//case 1 budget 299-1499
	@Test
	void verifyfilterbox() throws InterruptedException
	{  int val1=299;
	   int val2=1499;
	
		
		Thread.sleep(2000);
		
		//clicking the budget button
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		
		Thread.sleep(2000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
       
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
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
       
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
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
       
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
	
		
		Thread.sleep(1000);
		
		//clicking the budget button
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		
		Thread.sleep(1000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
       
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
	
	
// 1-April-25---------------------------------
	
	
	
	void verifypricingrange(int min,int max) throws InterruptedException
	{  int val1=min;
	   int val2=max;
	
		
		Thread.sleep(1000);
		
		//clicking the budget button
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		
		Thread.sleep(1000);
		boolean ans=true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
       
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
//        driver.quit();
			
		
	}
	
	
	// today task test the slider of Price range
	
	@Test
	void testslider() throws InterruptedException
	{  
		Thread.sleep(1000);
		
		//making an actionclass for drap and dropby
		Actions act=new Actions(driver);
	
		 WebElement min_slider= driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabel mui-1ym2qpd'])[1]"));
		
	 //s-2 getting the coordinate to do slide operation---using getlocation
		System.out.println("The coordinate default is "+ min_slider.getLocation());  //184,187--(x y)
		
	//then move the minimum slider---using a method called draganddropby
		act.dragAndDropBy(min_slider, 20, 187).perform();
		
		
		System.out.println("The coordinate moving after is "+ min_slider.getLocation());
		
		
	//maximum slider----
		 Thread.sleep(1000);
		 WebElement max_slider= driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabel mui-1ym2qpd'])[2]"));
			
		 //s-2 getting the coordinate to do slide operation---using getlocation
			System.out.println("The coordinate default is "+ max_slider.getLocation());// x=298,y=187
			
//		moving the pointer
			
			act.dragAndDropBy(max_slider,-10 , 187).perform();
			
			
			System.out.println("The coordinate moving after is "+ max_slider.getLocation());
			
			
			Thread.sleep(1000);
			
			
	//---checking the same price hotel we get or not
			
		//s-1 get price value after moving
			
			WebElement nmv=driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabelLabel'])[1]"));
			System.out.println("the mini price"+nmv.getText());
			
			
			int minipric=Integer.parseInt(nmv.getText());
			
			WebElement mmv=driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabelLabel'])[2]"));
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
        List<WebElement> discountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h6[contains(@class,'MuiTypography-subtitle2 mui-da191')]")));
        List<WebElement> displayprice = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
        List<WebElement> priceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h6[contains(@class,' MuiTypography-subtitle2 mui-nsxmjs')]")));
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
	
	
	
	
	
	
	
	driver.quit();
	
	}
	
	@Test
	void imageverify() throws InterruptedException
	{     
		String na="Bidinn - Your Top Choice for the Best Online Hotel Booking Platform";
		Thread.sleep(1000);	
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[contains(@alt, 'Logo')]")).click();
		
		Thread.sleep(1000);	
		String title=driver.getTitle();
		System.out.println("the title is"+title);
		
		Assert.assertTrue(na.equals(title));
		
		driver.quit();
	}
	
	
//---------verify 12% displayed or not-----------------
	
@Test
void twelevepercrating() throws InterruptedException
{
	Thread.sleep(1000);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	 List<WebElement> dataget = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h6[contains(@class,'MuiTypography-subtitle2 mui-15n4jo0')]")));
    List<WebElement> displayprice = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h5[contains(@class,'MuiTypography-h5 mui-1r4v64n')]")));
    
       System.out.println("The elem size "+ displayprice.size());
       
      boolean ans=true;
      
        int j=0;

       for (int i = 0; i < displayprice.size(); i++) 
         {

//                Get display price and remove currency symbol
               String displaypce = displayprice.get(i).getText();
               String displayprice1=displaypce.substring(1);
               double displayprie = Double.parseDouble(displayprice1);
//               
//             
               
               
    	   String displaypce1 = dataget.get(j).getText();
    	   String off=displaypce1.substring(11, 14);
    	   
    	   int am=Integer.parseInt(off);
    	   
    	   int twper = (int) Math.round((displayprie * 12) / 100.0);
    	   
    	   System.out.println("The display is "+am+" we calcul "+twper);
              
    	   if(am!=twper)
    	   {
    		   ans=false;
    		   break;
    	   }
    	   
    	   
              j+=2;

           }


 
Assert.assertTrue(ans);

driver.quit();


	
	
}
	



//---------------verify rating displayed or not-------------------
@Test
void ratingdisplayed() throws InterruptedException
{

	Thread.sleep(1000);
	
List<WebElement>elem=driver.findElements(By.xpath("//h6[contains(@class,'MuiTypography-subtitle2 mui-12rmkx8')]"));



List<WebElement>elem1=driver.findElements(By.xpath("//h6[contains(@class,'MuiTypography-subtitle2 mui-4cbwqt')]"));

Thread.sleep(1000);

boolean ans=true;


String nm="N";
for (int i = 0; i < elem.size(); i++) 
        
{   
	String pc=elem.get(i).getText();
	String m=pc.substring(1, 2);
	
	int no=Integer.parseInt(m);
	String pmc=elem1.get(i).getText();
	
	System.out.println("the text is "+m+" display is "+pmc);
	
	if(no>0)
	{
		String v=pmc.substring(0,1);
		int n=Integer.parseInt(v);
		if(n>0 && n<5)
		{
			continue;
		}
		else
		{
			ans=false;
			break;
		}
		
	}
	else
	{
		String v=pmc.substring(0,1);
//		System.out.println(v);
		if(v.equals(nm))
		{
			continue;
		}else
		{
			ans=false;
			break;
		}
	}
	
	
	
}
	

Assert.assertTrue(ans);
	driver.quit();
	
	
}
	
	
	
	
    
	  
	
	
	
}
