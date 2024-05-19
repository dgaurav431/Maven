package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {

	WebDriver driver;
	//2. Constructor
	public LoginPage1(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//1. Element identification
	@FindBy(id = "email")
	private WebElement emailTextField;
	
	@FindBy(name = "pwd")
	private WebElement passwordTextField;
	
	@FindBy(tagName = "button")
	private WebElement login1Button;
	
	@FindBy(xpath = "//div[text()='Akash Registered successfully']")
	private WebElement registeredSuccessfullMsg;
	
	@FindBy(xpath = "//div[text()='Signin successfull']")
	private WebElement signinSuccessfullMsg;
	

	//4. getter methods
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLogin1Button() {
		return login1Button;
	}
	
	public WebElement getLoginButton() {
		return login1Button;
	}
	
	public WebElement getRegisterSuccessfullMsg() {
		return registeredSuccessfullMsg;
	}

	public WebElement getSigninSuccessfullMsg() {
		return signinSuccessfullMsg;
	}

	//3. Business Logic
	public void loginAction(String email, String password) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		login1Button.click();
		
	}
	
	public boolean verifyRegisterSuccessfullMsg() {
		return registeredSuccessfullMsg.isDisplayed();
	}

	public boolean verifySigninSuccessfullMsg() {
		return signinSuccessfullMsg.isDisplayed();
	}

	public void verifyDynamicRegistration(String name) {
		driver.findElement(By.xpath("//div[text()='"+name+" Registered successfully']")).isDisplayed();
	}
}
