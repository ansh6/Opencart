package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
  
	
	public LoginPage (WebDriver driver)
	{
		super(driver) ;
		
	}
	
	// Element
	
	@FindBy(name="email")
	
	WebElement txtEmail ;
	
   @FindBy(name="password")
	
	WebElement txtPassword ; 
	

	@FindBy(xpath = "//button[@type='submit']")
	
	WebElement loginButton ;
	
	
	// Action
	
	public void setEmail(String Email)
	
	{
		txtEmail.sendKeys(Email);
	}
	

	public void setPassword(String pwd)
	
	{
		txtPassword.sendKeys(pwd);
		
	}
	

	public void click ()
	
	{
		loginButton.click();
	}
		
}
