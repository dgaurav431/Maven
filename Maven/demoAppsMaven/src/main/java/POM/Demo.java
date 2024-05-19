package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/?scenario=1");
		
		RegisterPage register = new RegisterPage(driver);
		
		register.registerUser("Akash", "akash@gmail.com" , "qwerty");
		
		Thread.sleep(2000);
		
		LoginPage login = new LoginPage(driver);
		
		login.loginUser("akash@gmail.com" , "qwerty");

	}

}
