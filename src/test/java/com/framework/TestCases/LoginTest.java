package com.framework.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.PageObjects.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test
	public void loginTest() throws IOException{
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals( "Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("Home Page");
		}else{
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
	}
}
