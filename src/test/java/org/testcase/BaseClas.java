package org.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.utilities.ReadConfig;

public class BaseClas {
	ReadConfig readconfig=new ReadConfig();
	public String URL=readconfig.getURLofthePAge();
	public String userName1=readconfig.userNamePage();
	public String passWord1=readconfig.passWordPage();
	public static WebDriver driver;
	
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
			
		
		logger=logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.pathDriver());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			driver.quit();

		}
		
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.get(URL);
		
		
		
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}

}
