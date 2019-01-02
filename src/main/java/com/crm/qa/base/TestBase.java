package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
public static WebDriver driver;
public static Properties prop;
	// Constructor to read and load the config file
	public TestBase()  {
		 prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					"C:\\workspacesO\\SeleniumPractice\\PracticePOM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Properties getProp() {
		return prop;
	}
	
	public void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Files\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Files\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
	}

}
