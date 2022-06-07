package org.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	public WebDriver ldriver;
	public LoginPage1(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginbtn;
	
	
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement logoutbtn;
	
	
	
	public void setUsername(String user) {
		username.sendKeys(user);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void loginbutton() {
		loginbtn.click();
	}
	public void logoutbutton() {
		logoutbtn.click();
	}
	
	
	
	

}
