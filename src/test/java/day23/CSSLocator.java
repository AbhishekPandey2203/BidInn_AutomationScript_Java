package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// this will help us to understand about the css selectors
public class CSSLocator {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();  //import the webdriver for test
		// now understand that driver maxmize the window
		
		//import the website
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//first type of css selector is tag id---------
//		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirt");   
		
	// the above code identify the search box and sendKeys help to fill the value their
		
		// we also used only #idvalue for search box 
		
//		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Books");------
		
		
		//---------tag class name---------------------
		
//		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Jewellery");
		
// tag attribute ----
		
//		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-Shirts");
//tag class attribute----
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-Shirts");
		
// the above code help to put the T shirts in search box using the tag class attribute
		

	}

}
