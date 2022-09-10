package AMAZONLIVE;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class addressmodule {
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
		 driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
}
   
    @Test
    public void Address() throws InterruptedException {
    	driver.findElement(By.cssSelector("div.ya-card-row:nth-child(3) > div:nth-child(1)")).click();
    	driver.findElement(By.id("ya-myab-plus-address-icon")).click();
    	driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Neil Chaudhuri");
    	driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("1234567890");
    	driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("10 overlea dr");
    	driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("apt10");
    	driver.findElement(By.cssSelector("#address-ui-widgets-enterAddressStateOrRegion > span:nth-child(1) > span:nth-child(1)")).isDisplayed();
    	driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion")).click();
    	driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")).click();
    	driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("N2M5B8");
    	driver.findElement(By.cssSelector("#address-ui-widgets-form-submit-button > span:nth-child(1) > input:nth-child(1)")).click();
       String expectedURL="https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_post";
       String actualURL=driver.getCurrentUrl();
       Assert.assertEquals(actualURL, expectedURL);
    }

}






