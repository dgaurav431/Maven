package webElement.textbox;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericUtils.FileUtility;

public class BaseClass {

	WebDriver driver;
	FileUtility fUtils=new FileUtility();
	
	@BeforeSuite
	public void bs() {
		System.out.println("Data base connection is achieved");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("This is before test");
	}
	
	@BeforeClass
	public void bc() throws IOException {
		String browser = fUtils.fetchFromPropertyFile("browser");
		String url = fUtils.fetchFromPropertyFile("url");
		
		if(browser.equals("chrome")) {
		driver= new ChromeDriver();
		}
		
		else if(browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		
		else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		System.out.println("Launch the browser");
		System.out.println("Navigate to the URL");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("Login to the application");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("Logout from the application");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("Close the browser");
	}
	
	@AfterTest
	public void at() {
		System.out.println("This is after test");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("Close the Data base connectivity");
	}
	
	@Test
	public void test1() {
		System.out.println("This is test script1");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test script2");
	}
}
