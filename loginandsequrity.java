package AMAZONLIVE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class loginandsequrity {
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
		// driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
    }
    @Test
   	public void namechange()   {

          	driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
          	driver.findElement(By.cssSelector("div.ya-card-row:nth-child(2) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > img:nth-child(1)")).click();
           driver.findElement(By.id("auth-cnep-edit-name-button")).click();
           driver.findElement(By.id("ap_customer_name")).clear();
           driver.findElement(By.id("ap_customer_name")).sendKeys("Orkut Chaudhuri");
           driver.findElement(By.id("cnep_1C_submit_button")).click();
           String expectedURL="https://www.amazon.ca/ap/cnep";
           String actualURL= driver.getCurrentUrl();
           Assert.assertEquals(expectedURL, actualURL);
           
    }
}
