package org.testcase;

import java.io.IOException;

import org.pageobject.AddCusPage;
import org.pageobject.LoginPage1;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AddCusPageTest extends BaseClas{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage1 lp=new LoginPage1(driver);
		lp.setUsername(userName1);
		
		logger.info("User name is provided");
		lp.setPassword(passWord1);
		logger.info("Passsword is provided");
		lp.loginbutton();
		
		Thread.sleep(3000);
		
		AddCusPage addcust=new AddCusPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

}
