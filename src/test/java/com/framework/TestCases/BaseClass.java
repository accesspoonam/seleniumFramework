package com.framework.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.framework.Utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURl = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;	
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
				
		logger = Logger.getLogger("framework");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		}else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", readConfig.getFFPath());
			driver = new FirefoxDriver();	
		}else if(br.equals("edge")){
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURl);
	}

	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE); 
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
}
