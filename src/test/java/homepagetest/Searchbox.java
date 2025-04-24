package homepagetest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//it is specific to the search box functionlity
public class Searchbox {
	
	
	
	
	WebDriver driver;
	@BeforeMethod
	void commancode()
	{  
		    driver=new ChromeDriver();
			driver.get("https://www.bidinn.in/");
			driver.manage().window().maximize();
			
		
	}
	
	
    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit(); // Ensures the session is fully terminated
        }
    }
	  
	//27-05-25
    
   //We will Update it--- on 22-04-25
	@Test
	void VerifySearchinput() throws InterruptedException
	{     
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

        WebElement checkInDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[3]")));
        checkInDate.click();

        // Calendar choose - Check-out
        WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-out']")));
        checkOut.click();

        // Click again if needed
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-out']"))).click();

        WebElement checkOutDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[5]")));
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

   
      // getting the Hotel address--city name
 		Thread.sleep(5000);
 		List<WebElement>cityadd=driver.findElements(By.xpath("//p[@class='text-sm text-gray-600 flex items-center']"));
 	
 		for(WebElement ele:cityadd)
 		{
 			String getcity=ele.getText();
 			System.out.println("The Address is "+getcity);
 			Assert.assertTrue(getcity.contains(city));
 		}
		
	}
	
	
	@Test
	void VerifyHotelSearchisworkornot() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  // Hotel name insertion
      String HotelNamepassasinput = "Hotel Shyam Krishna(Test_Hotel)";
      WebElement HotelInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@spellcheck='false']")));
      HotelInput.sendKeys(HotelNamepassasinput);

      WebElement HotelOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Hotel Shyam Krishna(Test_Hotel)']")));
      HotelOption.click();

      // Calendar choose - Check-in
      WebElement checkIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-in']")));
      checkIn.click();

      WebElement checkInDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[3]")));
      checkInDate.click();

      // Calendar choose - Check-out
      WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-out']")));
      checkOut.click();

      // Click again if needed
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check-out']"))).click();

      WebElement checkOutDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='rdrDay'])[5]")));
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

 
    // getting the Hotel Name
		Thread.sleep(5000);
			
		
		WebElement hotelgetname=driver.findElement(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h4 mui-gaxl7d']"));
	    System.out.println("the hotel name is "+hotelgetname.getText());
		
		Assert.assertTrue(hotelgetname.getText().equals(HotelNamepassasinput));
		
		
	}
	
	
	
	
	

}
