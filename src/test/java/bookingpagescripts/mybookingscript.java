package bookingpagescripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
        System.out.println("the checkin " + checkin);

        WebElement checkoutElem = driver.findElement(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 mui-quwrhc'])[2]"));
        String checkout = checkoutElem.getText();
        System.out.println("the checkout " + checkout);

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
            hotelNameBefore.equals(hotelNameAfter);
           
           
           
        // Final assertion
        Assert.assertTrue(isAllCorrect, "One or more booking details do not match.");
    }

	

}
