package ncl.BasePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BasePage {

	public static WebDriver driver = null; 
	public static Properties properties_obj;
	public static int Page_Load_TimeOut = 50;
	private static String chromeDriver = "\\src\\main\\resources\\Driver\\chromedriver.exe";
	private static String ieDriver = "\\src\\main\\resources\\Driver\\IEDriverServer.exe";
	private String properties = "\\src\\main\\resources\\PropertiesFile\\config.properties";
	
	
	public BasePage() {
		try {
			String properties_path = System.getProperty("user.dir") + properties;
			properties_obj = new Properties();
			FileInputStream file_input = new FileInputStream(properties_path);
			properties_obj.load(file_input);
		}
		catch(IOException ex) {
			ex.getStackTrace();
		}
	}
	
	public static String readProperties(String propertiesName) {
		String propertiesValue=null;
		propertiesValue = properties_obj.getProperty(propertiesName);
		return propertiesValue;
	}
	
	public static void initialition(String browser) {
		//String browser = properties_obj.getProperty("browser"); //Get properties from properties file.
		String path_chromeDriver = System.getProperty("user.dir") + chromeDriver;
		String path_IEDriver = System.getProperty("user.dir") + ieDriver;
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path_chromeDriver);
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			// Set desired capabilities to Ignore IEDriver IGNORING_SECURITY_DOMAINS.
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
			// Set desired capabilities to Ignore IEDriver zoom level settings and disable native events.
			capabilities.setCapability("EnableNativeEvents", false);
			capabilities.setCapability("ignoreZoomSetting", true);
			System.setProperty("webdriver.ie.driver", path_IEDriver);
			driver = new InternetExplorerDriver(capabilities);
		}
		driver.manage().window().maximize();  //Windows will maximize.
		driver.manage().deleteAllCookies();		//Delete all cookies.
		driver.manage().timeouts().pageLoadTimeout(Page_Load_TimeOut, TimeUnit.SECONDS); //Wait untile page are fully loeaded.
		driver.get(readProperties("NCL_URI")); //Lunch the url.		
		
	}



}
