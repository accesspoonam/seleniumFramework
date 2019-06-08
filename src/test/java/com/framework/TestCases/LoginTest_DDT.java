package com.framework.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.PageObjects.LoginPage;
import com.framework.Utilities.XLUtils;

public class LoginTest_DDT extends BaseClass{
	
	@Test(dataProvider="Login")
	public void loginDDT(String uname, String pwd) throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();	
		
		Thread.sleep(3000);
		
		if(alertCheck()==true){
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warning("Login failed");
		}else{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login passed");
		}
	}
	
	public boolean alertCheck(){
		try{
		driver.switchTo().alert();
        return true;
		}catch(NoAlertPresentException e){
			return false;
		}
	}
	
	@DataProvider(name="Login")
	String [][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/framework/TestData/Login.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++){
			for(int j=0; j<colcount; j++){
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		return logindata;
	}

}
