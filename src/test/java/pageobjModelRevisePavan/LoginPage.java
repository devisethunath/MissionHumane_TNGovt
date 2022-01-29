package pageobjModelRevisePavan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//input[@id='txtUsername']")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	@CacheLookup
	WebElement btnLogin;
	
	
	public void setUsername(String uname)
	{
		txtusername.clear();
		txtusername.sendKeys(uname);
	}
	
	public void setpassword(String pwd)
	{
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}
	
	public void click()
	{
		btnLogin.click();
	}
}
