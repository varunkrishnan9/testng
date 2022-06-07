package org.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.pageobject.LoginPage1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utilities.XLUtils;

public class LoginPageTest2 extends BaseClas{
	
	@Test(dataProvider="LoginData")
	
	public void loginDDT(String user, String pwd) throws InterruptedException {		
		LoginPage1 lp=new LoginPage1(driver);
		lp.setUsername(user);
		logger.info("user name enter");
		lp.setPassword(pwd);
		logger.info("password enter");
		lp.loginbutton();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.logoutbutton();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}			
	}	
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path="C:/Users/RAJESH/eclipse-workspace/enetBanking/src/test/java/org/data/LoginData.xlsx";
		//String path=System.getProperty("user.dir")+"/src/test/java/com/inetBankingV1/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colnum=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j); //i=1 j=0
			}
		}
		return logindata;				
	}

}
