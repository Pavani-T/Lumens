package lumens.com.tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String currentProjectDirectory = System.getProperty("user.dir");
	
	public TestBase()
	{
		
		// Loading Property file for input data
		prop = new Properties();
		try {
			FileInputStream file= new FileInputStream(currentProjectDirectory+"//src//test//java//lumens//com//config//config.properties");
			prop.load(file);
			

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	// This method is used to inotialize the driver
	
	public static void intilization() {
		
		switch (prop.getProperty("browser")) {
		case "chrome":
			System.out.println("Open Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;
		case "firefox":
			System.out.println("Open Firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
			break;
		case "edge":
			System.out.println("Open Edge Browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;			

		default:
			break;
		}
		
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}

}
