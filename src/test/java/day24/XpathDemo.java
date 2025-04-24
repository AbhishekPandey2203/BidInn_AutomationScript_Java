package day24;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathDemo {

	public static void main(String[] args) {
		//Revision s-1 launch the browser
		
		WebDriver driver=new ChromeDriver();
		//link of website for test
		driver.get("https://demo.nopcommerce.com/");
		//maximize the window
		driver.manage().window().maximize();
		
		
		//xpath with single attribute
		
//		driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("Football");
		
		//xpath with multiple attribute
//		driver.findElement(By.xpath("//*[@id=\"small-searchterms\"][@name=\"q\"]")).sendKeys("Double Placeholder");
		
		
	
		//xpath with "and" attribute
//		driver.findElement(By.xpath("//*[@id=\"small-searchterms\" and @name=\"q\"]")).sendKeys("And Placeholder");
		
		
		//xpath with "Or" operator
//		driver.findElement(By.xpath("//*[@id=\"small-searchterms\" or @title=\"q\"]")).sendKeys("OR Placeholder");
		
		//xpath without having attribute ----how using the the concept of innnertext----
		//what is innertext---<a>desktop</a>  --here desktop is innertext
		
	//now understand that
		
		driver.findElement(By.xpath("//*[text()=\"Build your own computer\"]")).click();
		
		//the above code is used to click the Build your own computer text card of demo.nopcommerce website
		// simple word--- ye ek anchor tag tha isme link tha koi attribute nhi use case m ye work kr rha h ya nhi 
		//hum use krenge text() wale feature ko toenable xpath  and jab website load hogi toh click function se 
		//vo particular chej click ho jayegi
		

		
	}

}
