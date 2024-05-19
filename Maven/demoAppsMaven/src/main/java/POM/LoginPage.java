package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//2. Constructor
		public LoginPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//1. Element identification
		
		@FindBy(id = "email")
		private WebElement emailTextField;
		
		@FindBy(id = "password")
		private WebElement passwordTextField;
		
		@FindBy(tagName = "button")
		private WebElement loginButton;
		

		//4. getter methods
		
		
		public WebElement getEmailTextField() {
			return emailTextField;
		}

		public WebElement getPasswordTextField() {
			return passwordTextField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}


		//3. Business Logic
		public void loginUser(String email, String password) {
			emailTextField.sendKeys(email);
			passwordTextField.sendKeys(password);
			loginButton.click();
			
		}

		public boolean verifyRegisterSuccessfullMsg() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean verifySigninSuccessfullMsg() {
			// TODO Auto-generated method stub
			return false;
		}
}
