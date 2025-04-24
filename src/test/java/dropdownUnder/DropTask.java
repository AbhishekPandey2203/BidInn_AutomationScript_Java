package dropdownUnder;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DropTask {
    
    @Test
    void droptask() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bidinn.in/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the "Contact & Support" link
        WebElement contactLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact & Support']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contactLink);
        
        //first cut the pop up
        
        driver.findElement(By.xpath("//span[@class=\"cc-1x4xm cc-sdm9t\"]")).click();
        
         Thread.sleep(100);
         
         
      driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Abhishek");
      driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
      driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9988776655");
         
         
         
         WebElement searchButton = driver.findElement(By.xpath("//p[text()='C-58 ground floor sector 65 noida 201301']"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);
         searchButton.isDisplayed();
         
         Thread.sleep(500);
         
       //click on the "Select reason"
         // Click on the "Contact & Support" link
        
        
        WebElement selectreason = driver.findElement(By.xpath("//div[@aria-haspopup=\"listbox\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectreason);
        selectreason.click();
       
        driver.findElement(By.xpath("//li[@data-value='accomodation Assistance']")).click();
        
        
        //sending the message
        
        driver.findElement(By.xpath("//textarea[@rows=\"4\"]")).sendKeys("The room is good");
        
        
        //click the submit button
        
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
         
         
         
         
         
         
         
         
         

        
       
		
        
    }
}
