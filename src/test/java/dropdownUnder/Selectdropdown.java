package dropdownUnder;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selectdropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		//now command for drop down that have select as an option
		
//step-1 capture select and store 
WebElement drpdwnCountry=driver.findElement(By.xpath("//select[@id=\"country\"]"));
//step-2 making a select class

   Select drpdwn=new Select(drpdwnCountry);   // upar capture wala ko neeche pass krenge
   
   
   
   //select option from dropdown--using three method
   //selectbyvisibletext,selectbyvalue, selectbyindex
   //upar object bngya h uska hi use krenge
   
//   drpdwn.selectByVisibleText("Brazil");     //method 1
//   drpdwn.selectByValue("japan");              //method 2 
//   drpdwn.selectByIndex(2);                     method 3
   
  // to get total no of count---
   
   List<WebElement>option=drpdwn.getOptions();
   
   System.out.println("The total of option is:"+option.size());
   
   
   
   
   Thread.sleep(500);
		
		driver.quit();

	}

}
