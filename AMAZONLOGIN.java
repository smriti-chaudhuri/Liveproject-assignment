package AMAZONLIVE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AMAZONLOGIN {
	WebDriver driver;
    @BeforeSuite
	public void driversetup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	}
    @BeforeMethod
	public void before() {
		driver= new FirefoxDriver();
		// driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		 
    }
    @Test
	public void Mousehover()   {
		driver.get("https://www.amazon.ca/");
		driver.navigate().to("https://www.amazon.ca/");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	   	driver.findElement(By.id("ap_email")).sendKeys("orkutc14@gmail.com");
        driver.findElement(By.id("continue")).click();
    	driver.findElement(By.id("ap_password")).sendKeys("neilsmriti");
       	driver.findElement(By.id("signInSubmit")).click();
    	String expectedUrl="https://www.amazon.ca/?ref_=nav_ya_signin";
    	String actualUrl=driver.getCurrentUrl();
    	Assert.assertEquals(expectedUrl, actualUrl);
    	
}
    @Test
    	public void Invalidlogin()   {
    		driver.get("https://www.amazon.ca/");
    		driver.navigate().to("https://www.amazon.ca/");
    		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    	   	driver.findElement(By.id("ap_email")).sendKeys("orkutc14@gmail.com");
            driver.findElement(By.id("continue")).click();
        	driver.findElement(By.id("ap_password")).sendKeys("neilsmriti1");
           	driver.findElement(By.id("signInSubmit")).click();
        	String expectedUrl="https://www.amazon.ca/?ref_=nav_ya_signin";
        	String actualUrl=driver.getCurrentUrl();
        	Assert.assertEquals(expectedUrl, actualUrl);
    }
    @Test
    public void BlankID()   {
		driver.get("https://www.amazon.ca/");
		driver.navigate().to("https://www.amazon.ca/");
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	   	driver.findElement(By.id("ap_email")).sendKeys("");
        driver.findElement(By.id("continue")).click();
    	driver.findElement(By.id("ap_password")).sendKeys("neilsmriti1");
       	driver.findElement(By.id("signInSubmit")).click();
    	String expectedmsg=" Enter your e-mail address or mobile phone number ";
    	String actualmsg=driver.findElement(By.id("auth-email-missing-alert")).getText();
    	System.out.println(actualmsg);
    	Assert.assertEquals(expectedmsg, actualmsg);
}
}
