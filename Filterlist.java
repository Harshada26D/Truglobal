import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filterlist {

	public static void main(String[] args) {

		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		//SearchBox and submit Button
		WebElement searchBox= driver.findElement(By.name("field-keywords"));
	    searchBox.sendKeys("phone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button' and  @value='Go']")).click();

		//Here I have used the Filter called Brand and applied the filter
	     WebElement brand = driver.findElement(By.xpath("//span[contains(text(),'Redmi')]/ancestor::li"));
	     brand.click();
	     
	     
	     //I have used the Redmi text to validate the filter and then printed the number of Redmi brand phones.
	     List <WebElement> RedmiList = driver.findElements(By.xpath("//span[contains(text(),'Redmi')]/ancestor::div"));
	     System.out.println("No of items = "+RedmiList.size());
	}

}
