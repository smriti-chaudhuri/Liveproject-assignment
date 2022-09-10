package AMAZONLIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class paginationamazon {

	WebDriver driver;
	@BeforeSuite
	public void driversetup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	}
	@BeforeMethod
	public void Initialsetup() {
		driver= new FirefoxDriver();
		 driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);

}
	@Test
	public void handlingpagination() {
		driver.get("https://www.amazon.ca/s?k=t+shirt+for+boys7-8years&crid=YK0K3XGKN8D4&sprefix=t+shirt+for+boys%2Caps%2C90&ref=nb_sb_ss_ts-doa-p_3_16");
		List<WebElement> nameElements = driver.findElements(By.cssSelector("#example >tbody >tr >td:nth-child(1)"));
		List<String> names = new ArrayList<String>();
		
		for(WebElement namesElement : nameElements) {
			names.add(namesElement.getText());
			String nextButtonClass = driver.findElement(By.cssSelector("a.s-pagination-item:nth-child(4)")).getAttribute("class");
			
			while (!nextButtonClass.contains("disabled")) {
				driver.findElement(By.cssSelector("a.s-pagination-item:nth-child(4)")).click();
				nameElements = driver.findElements(By.cssSelector("#example >tbody >tr >td:nth-child(1)"));
				
				for(WebElement namesElement1 : nameElements) {
					names.add(namesElement.getText());
				}
				 nextButtonClass = driver.findElement(By.cssSelector("a.s-pagination-item:nth-child(4)")).getAttribute("class");
				
			}
			for (String name : names) {
				System.out.println(name);
			}
			
			int totalNames = names.size();
			System.out.println("Total no of names :" + totalNames);
			
			
			
			String displayedCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
			System.out.println("Total no of displayed names count:" + displayedCount);
			
			
			
			Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		}
	}
			
			
		}
	
	
	
	

