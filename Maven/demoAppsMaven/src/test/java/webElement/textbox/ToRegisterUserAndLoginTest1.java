package webElement.textbox;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.LoginPage;
import POM.RegisterPage;

public class ToRegisterUserAndLoginTest1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/?scenario=1");
		
		RegisterPage register = new RegisterPage(driver);
		LoginPage login = new LoginPage(driver);
		
		register.registerUser("Akash", "akash@gmail.com", "qwerty");
		Thread.sleep(2000);
		
		login.loginUser("akash@gmail.com", "qwerty");

	}

}
