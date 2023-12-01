import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class iphone {
	WebDriver driver;
	@Test(priority = 0)
	public void LaunchingSite() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		//SearchBox and submit Button
		WebElement searchBox= driver.findElement(By.name("field-keywords"));
	    searchBox.sendKeys("iphone");
	    
	    //For selecting the "iphone" option I have found out the xpath of list and then selected
	    driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction' and text()='iphone'])[3]"));
	   
	   	
	   	
	   	WebElement IPhone = driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction' and text()='iphone'])[3]"));
	   	IPhone.click();
	   
	   	
		JavascriptExecutor js = (JavascriptExecutor)driver;
	   	js.executeScript("window.scrollBy(0,500)","");
	   	
	   	driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys("51999");
	   	driver.findElement(By.xpath("//span[@id='a-autoid-1']")).click();
	   	
	    driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone 13 (128GB) - Midnight')]/parent::a)[1]")).click(); 
	    //driver.navigate().to("https://www.amazon.in/Apple-iPhone-13-128GB-Starlight/dp/B09G9D8KRQ/ref=sr_1_1_sspa?crid=2B0AD16O432WO&keywords=iphone&qid=1700753606&refinements=p_36%3A5199900-&rnid=1318502031&sprefix=iphone%2Caps%2C1068&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
	   
	    Set <String> windowIDs=driver.getWindowHandles();
	    Iterator<String> It= windowIDs.iterator();
	    String parentwindowID= It.next();
	    String childwindowID= It.next();
	    
	    System.out.println("parentID"+parentwindowID);
	    System.out.println("childID"+childwindowID);

	    driver.switchTo().window(childwindowID);
	    
	}
		@Test(priority=1)
		public void addToCart() {
			
		System.out.println("In test 2");
		JavascriptExecutor js = (JavascriptExecutor)driver;
	   	js.executeScript("window.scrollBy(0,200)","");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='add-to-cart-button'])[2]"))).click();
		   	

	   	//add to cart
	    driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
	   
	}

	   	@Test (priority=2)
	   	public void SignIn(){
	   System.out.println("In test 3");
	   	driver.findElement(By.xpath("//span[contains(text(),' Sign in to your account')]")).click();
	   	//registration 
	  driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ABC@gmail.com");
	 driver.findElement(By.xpath("//input[@id='continue']")).click();
	 driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("abcd");
	 driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	   	
	}
	
	  
	}	


