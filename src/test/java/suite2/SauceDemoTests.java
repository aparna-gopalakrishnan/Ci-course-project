package suite2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;


public class SauceDemoTests {
	private WebDriver driver;
	private String url = "https://www.saucedemo.com/";
	private String header = "Swag Labs";

	//For demonstrating parameterized builds
	String browser = System.getProperty("browser");


	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	//Test to launch browser with url
	@Test(enabled = true, priority = 0)				
	public void open() {
		driver.get(url); 
		waitForPageLoaded();
		String title = driver.getTitle();
		System.out.println(title);
		//My Store
		AssertJUnit.assertTrue(title.equals(header ));

	}	

	//Login

	@Test(enabled = true, priority = 1)
	public void login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click();
		AssertJUnit.assertTrue(driver.findElement(By.className("product_label")).getText()
				.equals("Products"));
	}

	//Before test
	@BeforeTest
	public void beforeTest() {

		//Instantiate browser based on user input

		if(browser != "" && browser != null) {
			if(browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			else {
				System.out.println("Invalid option Selected hence defaulting to Chrome");
				browser = "Chrome";
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
		}
		else {
			browser = "Chrome";
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}	
	//hooks - to tear down after test is executed
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}
}
