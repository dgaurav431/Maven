package webElement.textbox;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.RegisterPage;
import genericUtils.FileUtility;

public class ToRegisterUserAndLoginTest2 extends BaseClass {

	@Test(priority=1)
	public  void toRegisterUser() throws InterruptedException, EncryptedDocumentException, IOException  {

		WebDriver driver=null;
		FileUtility fUtils=new FileUtility();
		
		String name = fUtils.fetchStringDataFromExcelSheet("Register", 1, 0);
		String email = fUtils.fetchStringDataFromExcelSheet("Register", 1, 1);
		String password = fUtils.fetchStringDataFromExcelSheet("Register", 1, 2);
		
		RegisterPage register = new RegisterPage(driver);
		LoginPage login = new LoginPage(driver);
		
		register.registerUser(name, email, password);
		Thread.sleep(2000);

		if(login.verifyRegisterSuccessfullMsg()) {
			System.out.println("Pass: the user has registered");
		}
		else
			System.out.println("Fail: the user has not registered");
	}
	
	@Test(priority=2)
	public void loginUser() throws EncryptedDocumentException, IOException	{
		
		String email = fUtils.fetchStringDataFromExcelSheet("Register", 1, 1);
		String password = fUtils.fetchStringDataFromExcelSheet("Register", 1, 2);
		String browser = fUtils.fetchFromPropertyFile("browser");
		String url = fUtils.fetchFromPropertyFile("url");
		
		LoginPage login = new LoginPage(driver);		
				
		login.loginUser(email, password);
		
		if(login.verifySigninSuccessfullMsg()) {
			System.out.println("Pass: the user has logged In");
		}
		else
			System.out.println("Fail: the user has not logged In");

	}	

}
