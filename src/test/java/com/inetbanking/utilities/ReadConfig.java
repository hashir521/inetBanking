package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() {
		File src = new File("./Confiuration\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e){
			System.out.println("Exception is:"+ e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUserName() {
		String userName = pro.getProperty("userName");
		return userName;
	}
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
}
