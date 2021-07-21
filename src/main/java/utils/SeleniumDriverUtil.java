package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriverUtil {
	
	private static WebDriver driver;
	private static FileInputStream fs;
	public static Properties config = new Properties();
	public static WebDriverWait wait;
	
	public SeleniumDriverUtil() {
		
		try {
			fs = new FileInputStream("./src/test/resources/config/config.properties");
			config.load(fs);
		}catch(IOException e) {
			
		}
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		wait =  new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicitWait")));
	}
	
	public static void setUpDriver() {
		if(driver==null) {
			SeleniumDriverUtil su = new SeleniumDriverUtil();
		}
	}
	
	public static WebDriver getDriver() {
		 return driver;
	}
	
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
		driver=null;
	}
	
	public static void launchApplication() {
		driver.get(config.getProperty("appUrl"));
	}
	
	public static int getTimer() {
		return Integer.parseInt(config.getProperty("timer"));
	}


}
