package com.framework.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		File src = new File("./Configuration/config.properties");
		
		try{
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}catch (Exception e){
			System.out.println("Exception is: " +e.getMessage());
		}
	}
	
	public String getApplicationURL(){
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername(){
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getPassword(){
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath(){
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getEdgePath(){
		String edgePath = pro.getProperty("edgepath");
		return edgePath;
	}
	
	public String getFFPath(){
		String ffPath = pro.getProperty("firefox");
		return ffPath;
	}

	
}
