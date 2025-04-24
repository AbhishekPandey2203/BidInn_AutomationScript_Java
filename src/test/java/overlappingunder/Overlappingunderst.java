package overlappingunder;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Overlappingunderst {

	public static void main(String[] args) {
	  
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("file:///C:/Users/Abhishek%20Pandey/Downloads/first.html");
		
		driver.manage().window().maximize();
		//understanding to get first coordinate using getRect()---a method to get coordinate of a particular element
		
		WebElement namefn=driver.findElement(By.id("name"));
		
		//getting coordinate
		Rectangle namerect=namefn.getRect();
		
		
		System.out.println("The width of name is "+namerect.getWidth());
		System.out.println("The height of name is "+namerect.getHeight());
		System.out.println("The x coordinate is for name "+namerect.getX());
		System.out.println("The y coordinate is for name"+namerect.getY());
		
		
		//similarly get it for the email ---
		WebElement emailfn =driver.findElement(By.id("email"));
		
		Rectangle emailrect=emailfn.getRect();
		
		
		System.out.println("The width of name is "+emailrect.getWidth());
		System.out.println("The height of name is "+emailrect.getHeight());
		System.out.println("The x coordinate is email"+emailrect.getX());
		System.out.println("The y coordinate is email"+emailrect.getY());
		
		int a=emailrect.getY();
		int b=namerect.getY();
		int c=namerect.getWidth();
		if(a>b+c)
		{
			System.out.println("The div is not overlap");
		}
		else
		{
			System.out.println(" The div is overlapped");
		}
		
		
		
		
		
		
		

	}

}
