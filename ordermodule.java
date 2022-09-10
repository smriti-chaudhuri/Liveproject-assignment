package AMAZONLIVE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ordermodule {
	WebDriver driver;
    @BeforeSuite
	public void driversetup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	}
    @BeforeMethod
	public void before() {
		driver= new FirefoxDriver();
		 driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		 driver.get("https://www.amazon.ca/");
	   		driver.navigate().to("https://www.amazon.ca/");
	   		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	   	   	driver.findElement(By.id("ap_email")).sendKeys("orkutc14@gmail.com");
	           driver.findElement(By.id("continue")).click();
	       	driver.findElement(By.id("ap_password")).sendKeys("neilsmriti");
	          	driver.findElement(By.id("signInSubmit")).click();
	          	driver.findElement(By.id("nav-link-accountList-nav-line-1")).click(); 
}
  
    @Test
   	public void orderpagenav() {
       driver.findElement(By.cssSelector("div.ya-card-row:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1)")).click();
       	String expectedURL= "https://www.amazon.ca/gp/your-account/order-history?ref_=ya_d_c_yo";
          String actualURL= driver.getCurrentUrl();
          Assert.assertEquals(expectedURL,actualURL);
    }
   
    @Test
   	public void buyagain() {
       driver.findElement(By.cssSelector("div.ya-card-row:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1)")).click();
       driver.findElement(By.partialLinkText("Buy Again")).click();
       	String expectedURL= "https://www.amazon.ca/gp/buyagain?ref_=nav_cs_buy_again";
          String actualURL= driver.getCurrentUrl();
          Assert.assertEquals(expectedURL,actualURL);
    }

 @Test
   	public void notyetshipped() {
       driver.findElement(By.cssSelector("div.ya-card-row:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1)")).click();
       driver.findElement(By.partialLinkText("Not Yet Shipped")).click();
       	String expectedURL= "https://www.amazon.ca/gp/your-account/order-history?ref_=ppx_yo2ov_dt_b_tb_open&orderFilter=open";
          String actualURL= driver.getCurrentUrl();
          Assert.assertEquals(expectedURL,actualURL);
    }
    
    
    
    @Test
   	public void cancelledorders() {
       driver.findElement(By.cssSelector("div.ya-card-row:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1)")).click();
       driver.findElement(By.partialLinkText("Cancelled Orders")).click();
       	String expectedURL= "https://www.amazon.ca/gp/your-account/order-history?ref_=ppx_yo2ov_dt_b_tb_cancel&orderFilter=cancelled";
          String actualURL= driver.getCurrentUrl();
          Assert.assertEquals(expectedURL,actualURL);
    }
  

}
    
    
    
    
    
    
    