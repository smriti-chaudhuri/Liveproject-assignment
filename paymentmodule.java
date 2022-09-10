package AMAZONLIVE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class paymentmodule {
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
          	driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
          	driver.findElement(By.cssSelector("div.ya-card-row:nth-child(3) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1)")).click();
		// driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
    }
    
    @Test
      public void addpayment() {
    	
     	driver.findElement(By.partialLinkText("Add a payment method")).click();
    	driver.findElement(By.id("apx-add-credit-card-action-test-id")).click();
    	driver.findElement(By.id("pp-zgG7Ow-15")).sendKeys("5123456789012346");
    	driver.findElement(By.id("pp-zgG7Ow-17")).sendKeys("Neil Chaudhuri");
    	driver.findElement(By.cssSelector("#pp-DwrQrh-21 > span:nth-child(1) > i:nth-child(2)")).click();
		driver.findElement(By.id("pp-DwrQrh-18_4")).click();
		driver.findElement(By.cssSelector("#pp-4waXVV-22 > span:nth-child(1) > i:nth-child(2)")).click();
		driver.findElement(By.id("pp-4waXVV-20_2")).click();
		driver.findElement(By.id("pp-DwrQrh-24-announce")).click();
		
		String expectedtext="MasterCard";
    	String actualtext=driver.findElement(By.id("pp-1CcAsu-16")).getText();
    	Assert.assertEquals(expectedtext, actualtext);
		
		
	}
    }
    
    
    
    
    
    
    
    
    
    

