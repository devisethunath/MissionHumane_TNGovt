package pageObjModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	WebDriver ldriver;

	LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(name="txtUsername")
	@CacheLookup
	WebElement txtusername;
	
	//@FindBy(How.NAME,using="txtUsername")
	//WebElement txtusername;
	
	
	@FindBy(name="txtPassword")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement btnsignin;
	
	
	public void setUserName(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnsignin.click();
	}
}
