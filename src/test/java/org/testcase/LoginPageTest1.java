package org.testcase;

import java.io.IOException;

import org.pageobject.LoginPage1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest1 extends BaseClas {
	
	@Test
	public void enterDetails() throws IOException {
		LoginPage1 lp=new LoginPage1(driver);
		driver.get(URL);
		logger.info("url opened");
		lp.setUsername(userName1);
		lp.setPassword(passWord1);
		logger.info("username name ans password entered ");
		lp.loginbutton();
		logger.info("login button click");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else {
			captureScreen(driver,"enterDetails");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
	
	
}
