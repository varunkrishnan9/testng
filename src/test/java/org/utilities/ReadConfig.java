package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);			
		}
		catch(Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}		
		
	}
	public String getURLofthePAge() {
		String url=pro.getProperty("baseURL");
		return url;		
	}
	public String userNamePage() {
		String userN=pro.getProperty("username");
		return userN;
	}
	public String passWordPage() {
		String passN=pro.getProperty("password");
		return passN;
	}
	public String pathDriver() {
		String path=pro.getProperty("chromepath");
		return path;
	}
	

}
