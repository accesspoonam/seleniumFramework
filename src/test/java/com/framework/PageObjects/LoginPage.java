package com.framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Driver;
	
	public LoginPage(WebDriver lDriver){
		Driver = lDriver;
		PageFactory.initElements(lDriver, this);		
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement btnLogout;
	
	public void setUserName(String uname){
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String password){
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit(){
		btnLogin.click();
	}
	
	public void clickLogout(){
		btnLogout.click();
	}
	
}
