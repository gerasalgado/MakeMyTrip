package com.hexaware.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver web;
	public static Properties properties;
	public static Logger logger;
	
	public Base() {
		properties = new Properties();
		String configPath = "./src/main/java/com/hexaware/config/Config";
		try {
			FileInputStream fis = new FileInputStream(configPath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Can not find the properties file");
		}
		catch (IOException e) {
			System.out.println("Can not read the properties file");
		}
	}
	
	public void setUp() {
		logger = Logger.getLogger(Base.class); 
		String driver = properties.getProperty("driver");
		 
		if (driver.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			web = new ChromeDriver();
			web.manage().window().maximize();
			web.get(properties.getProperty("URL"));
			logger.info("Identified and launched Chrome Browser!!!");
		
		}
		if(driver.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			web = new EdgeDriver();
			web.manage().window().maximize();
			web.get(properties.getProperty("URL"));
			logger.info("Identified and launched Edge Browser!!!");
		}
	}


	public void CloseWebPage() {
		web.quit();
		logger.info("Close the web!");
	}
	
	public void screenShot(String type){
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		    String formattedDate = formatter.format(new Date());
		    formattedDate = formattedDate.replaceAll("/", "_").replaceAll(":", "_") + ".png";
			TakesScreenshot scr = (TakesScreenshot)web;
			File srcFile = scr.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File(".\\Screenshots\\"+type+formattedDate));
				logger.info("Screenshot attached");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
