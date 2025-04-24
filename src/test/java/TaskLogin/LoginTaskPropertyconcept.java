package TaskLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Understand login task functionality---end to end
 */

public class LoginTaskPropertyconcept {
	WebDriver driver;
	

	
	
	
	
	@Test()
	void verifyuser() throws InterruptedException, IOException
	{     
		//read ke liye bhi property chye
		Properties properties=new Properties();
		//path 
		String filepath=System.getProperty("user.dir")+"\\data\\example.properties";
		
		//for read
		
		FileInputStream filene=new FileInputStream(filepath);
		
		//load
		properties.load(filene);
		
		filene.close();
		
		//now getting the data
		String ph=properties.getProperty("phone");
		
		
		
		
		String expectedName="Shyam";
		 driver=new EdgeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bidinn.in/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		//click 
		driver.findElement(By.xpath("//a[text()=\"Login / Signup\"]")).click();
		Thread.sleep(200);
		
		//sending number
		driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys(ph);
		
		//click
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
		Thread.sleep(500);
		
		//sending otp
		
		driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).sendKeys("1");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[2]")).sendKeys("2");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[3]")).sendKeys("3");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[4]")).sendKeys("4");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[5]")).sendKeys("5");
		driver.findElement(By.xpath("(//input[@type=\"number\"])[6]")).sendKeys("6");
		
//		Thread.sleep(300);
		
		//click
		driver.findElement(By.xpath("//button[text()=\"Verify OTP\"]")).click();
		
//		Thread.sleep(300);
//		
//		Thread.sleep(500);
		
		driver.findElement(By.xpath("//img[@alt=\"User Avatar\"]")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//a[@href=\"/user-dashboard\"]")).click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@class=\"flex items-center gap-2 font-medium text-dark \"]")).click();
		WebElement actualName = driver.findElement(By.xpath("//span[@class=\"block font-medium text-dark \"]"));
		System.out.println(actualName.getText()); 
		Assert.assertTrue(expectedName.equals(actualName.getText()));
	
//		
//		WebElement element= driver.findElement(By.class("block font-medium text-dark"));
//		String innertext=element.getText();
//		System.out.println(" The inner text "+innertext);
		
//		driver.quit();
		   
	}
	
	@Test()
	void Logout() throws InterruptedException
	{    
		
		LoginTasknew1 obj=new LoginTasknew1();
		obj.verifyuser();
//		driver.findElement(By.xpath("//span[@class=\"flex items-center gap-2 font-medium text-dark \"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Logout\"]")).click();
		
	}
	
	
	
	

}
