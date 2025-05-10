package bidinnUserWebAppTestScript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//verification of prime and exculsive hotel price

//31-03-25

//Updation at 21-04-25



public class VerifyHomePagePrimeExclusiveButton {
	
	WebDriver driver;
	@BeforeTest
	void commoncode() throws InterruptedException
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
	
	
//PrimeButton Work--------------------
	 
	@Test
	void verifyBidinnPrimeButtonworkornot() throws InterruptedException
	{    
		
		Thread.sleep(1000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement clickableElement = driver.findElement(By.xpath("(//span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium mui-cveorv'])[2]"));
    	clickableElement.click();
    	
    	Thread.sleep(2000);
    	System.out.println("Element is clickable.");

		
		String valu="Haridwar | Hotel Detail Page | bidinn.in";
	     
		String datechecout="April 22, 2025";
		String datechecin="April 21, 2025";
		
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Haridwar");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//p[text()='Haridwar']")).click();
        Thread.sleep(500);
        
      //verify calendar value display---
  
	    WebElement checkin=driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][1]"));
		String checkin1=checkin.getText();
	    System.out.println(" the val "+checkin1);
	
	 
	    Assert.assertTrue(checkin1.contains(datechecin));
	  
	  WebElement checkout1=  driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][2]"));
	  String checkout=checkout1.getText();
	  System.out.println("the val "+checkout);
	  
	  
	  Assert.assertTrue(checkout.contains(datechecout));
	  
	  
     // no of rooms and guest displayed---------
		boolean gut=driver.findElement(By.xpath("(//h5[normalize-space()='1 Room/ 2 Guests'])[1]")).isDisplayed();
		
		Assert.assertTrue(gut);
		
		driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
		Thread.sleep(1000);
		String valm=driver.getTitle();
		System.out.println("the title name is "+valm);
		
		Assert.assertTrue(valu.equals(valm));
		
	

		
		int val1=2001;
		int val2=5000;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(500);
		//click the know more task
	
		// move to prime hotel page then fetch the price data;
	      boolean ans=true;
		
		
		List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
	   
		System.out.println("the size is"+elem.size());
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
	
		
	}
	
	
	
//Exclusive Button work--------------------------
	
	@Test
	void verifyBidinnExclusiveButtonworkornot() throws InterruptedException
	{
		
		
		Thread.sleep(1000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement clickableElement = driver.findElement(By.xpath("(//span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium mui-cveorv'])[3]"));
    	clickableElement.click();
    	
    	Thread.sleep(2000);
    	System.out.println("Element is clickable.");

		
		String valu="Haridwar | Hotel Detail Page | bidinn.in";
	     
		String datechecout="April 22, 2025";
		String datechecin="April 21, 2025";
		
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Haridwar");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//p[text()='Haridwar']")).click();
        Thread.sleep(500);
        
      //verify calendar value display---
  
	    WebElement checkin=driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][1]"));
		String checkin1=checkin.getText();
	    System.out.println(" the val "+checkin1);
	
	 
	    Assert.assertTrue(checkin1.contains(datechecin));
	  
	  WebElement checkout1=  driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][2]"));
	  String checkout=checkout1.getText();
	  System.out.println("the val "+checkout);
	  
	  
	  Assert.assertTrue(checkout.contains(datechecout));
	  
	  
     // no of rooms and guest displayed---------
		boolean gut=driver.findElement(By.xpath("(//h5[normalize-space()='1 Room/ 2 Guests'])[1]")).isDisplayed();
		
		Assert.assertTrue(gut);
		
		driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
		Thread.sleep(1000);
		String valm=driver.getTitle();
		System.out.println("the title name is "+valm);
		
		Assert.assertTrue(valu.equals(valm));
		
	

		
		int val1=5000;
		int val2=25000;
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(500);
		//click the know more task
	
		// move to prime hotel page then fetch the price data;
	      boolean ans=true;
		
		
		List<WebElement> elem = wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
	   
		System.out.println("the size is"+elem.size());
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
		
	}
	
//Regular Work-----------------------------------
	
	@Test
	void verifyBidinnRegularButtonworkornot() throws InterruptedException
	{
		
		
		Thread.sleep(1000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement clickableElement = driver.findElement(By.xpath("(//span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium mui-cveorv'])[1]"));
    	clickableElement.click();
    	
    	Thread.sleep(2000);
    	System.out.println("Element is clickable.");

		
		String valu="Haridwar | Hotel Detail Page | bidinn.in";
	     
		String datechecout="April 22, 2025";
		String datechecin="April 21, 2025";
		
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Haridwar");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//p[text()='Haridwar']")).click();
        Thread.sleep(500);
        
      //verify calendar value display---
  
	    WebElement checkin=driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][1]"));
		String checkin1=checkin.getText();
	    System.out.println(" the val "+checkin1);
	
	 
	    Assert.assertTrue(checkin1.contains(datechecin));
	  
	  WebElement checkout1=  driver.findElement(By.xpath("//button[contains(@class,'MuiButton-disableElevation MuiButton-fullWidth mui-mt3fnc')][2]"));
	  String checkout=checkout1.getText();
	  System.out.println("the val "+checkout);
	  
	  
	  Assert.assertTrue(checkout.contains(datechecout));
	  
	  
     // no of rooms and guest displayed---------
		boolean gut=driver.findElement(By.xpath("(//h5[normalize-space()='1 Room/ 2 Guests'])[1]")).isDisplayed();
		
		Assert.assertTrue(gut);
		
		driver.findElement(By.xpath("//button[text()=\"Search\"]")).click();
		Thread.sleep(1000);
		String valm=driver.getTitle();
		System.out.println("the title name is "+valm);
		
		Assert.assertTrue(valu.equals(valm));
		
	

		
		int val1=299;
		int val2=2000;
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(500);
		//click the know more task
	
		// move to prime hotel page then fetch the price data;
	      boolean ans=true;
		
		
		List<WebElement> elem = wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h1[contains(@class,'MuiTypography-root MuiTypography-h1 mui-1puvpyx')]")));
	   
		System.out.println("the size is"+elem.size());
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
		
	}
	

	
	
}
