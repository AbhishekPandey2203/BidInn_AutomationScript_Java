package actionunders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//understanding about the mouse hover action
public class Mouseoveraction {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
		
		WebElement desktop=  driver.findElement(By.xpath("//a[text()='Desktops']"));
		
		WebElement mac=driver.findElement(By.xpath("//a[text()='Mac (1)']"));
		
		
		
		
		driver.quit();
		

	}

}
