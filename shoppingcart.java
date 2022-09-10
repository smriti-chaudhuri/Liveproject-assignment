package AMAZONLIVE;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class shoppingcart {
	WebDriver driver;
    @BeforeSuite
	public void driversetup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	}
    @BeforeMethod
	public void before() {
		driver= new FirefoxDriver();
		driver.get("https://www.amazon.ca/");
   		driver.navigate().to("https://www.amazon.ca/");
   		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
   	   	driver.findElement(By.id("ap_email")).sendKeys("orkutc14@gmail.com");
           driver.findElement(By.id("continue")).click();
       	driver.findElement(By.id("ap_password")).sendKeys("neilsmriti");
          	driver.findElement(By.id("signInSubmit")).click();
          	        	
		 driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
}
    @Test
    public void itemaddtocart() throws InterruptedException {
	   driver.findElement(By.id("twotabsearchtextbox")).clear();
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tshirt for boys 7 years adidas");
	   driver.findElement(By.id("nav-search-submit-button")).click();
	   driver.findElement(By.partialLinkText("Boys Short Sleeve Logo Tee Shirt")).click();
	   Select size= new Select(driver.findElement(By.id("native_dropdown_selected_size_name")));
	   size.selectByIndex(1);
	   Thread.sleep(3000);
	   driver.findElement(By.id("add-to-cart-button")).click();
	   driver.findElement(By.id("nav-cart-count-container")).click();
	   String fromcartpage = driver.findElement(By.id("sc-subtotal-label-activecart")).getText().split(" ")[1];
		//String finalcount=fromcartpage.split("(");
	   char arr[]= fromcartpage.toCharArray();
	   char expectedvalue=1;
	   char actualvalue=arr[1];
	   System.out.println("the count fetched from webpage is" +actualvalue);
	   Assert.assertEquals(expectedvalue, actualvalue);
 }
 
   @Test
   public void cartpricematch() throws InterruptedException {
	   driver.findElement(By.id("twotabsearchtextbox")).clear();
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tshirt for boys 7 years adidas");
	   driver.findElement(By.id("nav-search-submit-button")).click();
	   driver.findElement(By.partialLinkText("Boys Short Sleeve Logo Tee Shirt")).click();
	   Select size= new Select(driver.findElement(By.id("native_dropdown_selected_size_name")));
	   size.selectByIndex(1);
	   Thread.sleep(3000);
	   String itemprice=driver.findElement(By.id("corePrice_feature_div")).getText().split("$")[0];
	   driver.findElement(By.id("add-to-cart-button")).click();
	   driver.findElement(By.id("nav-cart-count-container")).click();
	   String cartprice = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText().split("$")[0];
		//String finalcount=fromcartpage.split("(");
	   	   System.out.println("the price from item webpage is" +itemprice);
	   	System.out.println("the price from cart webpage is" +cartprice);
	   Assert.assertEquals(itemprice, cartprice);
}

}
