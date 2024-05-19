package webElement.textbox;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.RegisterPage;

public class ToRegisterUserAndLoginTest0 extends BaseClass {
	@Test(priority=1)
	public void toRegisterUser() throws InterruptedException, EncryptedDocumentException, IOException {
	String name = fUtils.fetchStringDataFromExcelSheet("Register", 1, 0);
	String email = fUtils.fetchStringDataFromExcelSheet("Register", 1, 1);
	String password = fUtils.fetchStringDataFromExcelSheet("Register", 1, 2);
	
	RegisterPage register = new RegisterPage(driver);
	LoginPage login = new LoginPage(driver);
	
	register.registerUser(name, email, password);
	Thread.sleep(2000);

	Assert.assertTrue(login.verifyRegisterSuccessfullMsg());
		System.out.println("Pass: the user has registered");
	}
	
	@Test(priority=2)
	public void loginUser() throws EncryptedDocumentException, IOException	{
		
		String email = fUtils.fetchStringDataFromExcelSheet("Register", 1, 1);
		String password = fUtils.fetchStringDataFromExcelSheet("Register", 1, 2);
		
		LoginPage login = new LoginPage(driver);						
		login.loginUser(email, password);
		
		Assert.assertTrue(login.verifySigninSuccessfullMsg());
			System.out.println("Pass: the user has logged In");
		
	}	
}

