package webElement.textbox;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtils.FileUtility;

public class ToRegisterUserAndLoginTest {

	public static void main(String[] args) throws IOException {

		WebDriver driver=null;
		//Test Data
		FileUtility fUtils = new FileUtility();
		
		
		String browser = fUtils.fetchFromPropertyFile("browser");
		String url = fUtils.fetchFromPropertyFile("url");

		String name = fUtils.fetchStringDataFromExcelSheet("Register", 1, 0);
		String email = fUtils.fetchStringDataFromExcelSheet("Register", 1, 1);
		String password = fUtils.fetchStringDataFromExcelSheet("Register", 1, 2);

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
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		
		if(driver.findElement(By.xpath("//div[text()='Registered successfully")).isDisplayed()){
			System.out.println("Pass: the user has registered");
		}
		
		else {
			System.out.println("Fail: the user has not registered");
		}
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		
		if(driver.findElement(By.xpath("//div[text()='Signin successful")).isDisplayed()) {
			System.out.println("Pass: the user has logged in");

		}
		else
			System.out.println("Fail: the user has not logged in");


	}

}
