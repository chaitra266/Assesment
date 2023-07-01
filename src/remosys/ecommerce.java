package remosys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ecommerce {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Login to an e-commerce website
	driver.get("https://amazon.com");
    driver.findElement(By.id("nav-link-accountList")).click();
	driver.findElement(By.name("email")).sendKeys("chaitabpatil@gmail.com");
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.id("ap_password")).sendKeys("8867855572");
	driver.findElement(By.id("auth-signin-button")).click();
	
	//Search an item

	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Jeans");
	Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@aria-label='jeans for women']")).click();
    driver.findElement(By.linkText("Amazon Essentials Women's Skinny Jean")).click();

    // Print all the products on the first page.
    List<WebElement> link = driver.findElements(By.tagName("a"));
	System.out.println(link.size());
	
	for(WebElement tags:link) {
		System.out.println(tags.getText());
	}
	
	//Add a product

    driver.findElement(By.name("submit.add-to-cart")).click();
    
    //Update a product and Delete product
   driver.findElement(By.xpath("//input[@type='submit']")).click();
   driver.findElement(By.id("nav-link-accountList")).click();
   Thread.sleep(2000);

   //Logout
   driver.findElement(By.id("nav-item-signout")).click();
    
	}
}
