package training;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		



public class FirstSeleniumJavaTest {

	private WebDriver driver;		
	@Test				
	public void testEasy() {

		driver.get("https://testautomationu.applitools.com/"); 
		driver.manage().window().maximize();

		String title = driver.getTitle();
		AssertJUnit.assertTrue(title.equals("Test Automation University | Applitools"));
	}	

	@Test				
	public void testTwo() {	

		driver.get("https://www.google.co.uk/"); 
		driver.manage().window().maximize();

		String title1 = driver.getTitle();
		System.out.println("title is "+title1);
		AssertJUnit.assertTrue(title1.equals("Google"));

	}	

	@BeforeTest
	public void beforeTest() {	
	    driver = new ChromeDriver();  
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	
}
