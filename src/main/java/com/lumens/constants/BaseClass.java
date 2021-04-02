package com.lumens.constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lumens.utilities.Waits;

public class BaseClass {

	
	public static WebDriver driver;
	public static Properties prop;
	//static PopupWindow popup;
	
	public BaseClass() {
		 
			prop = new Properties();
			FileInputStream file;
			try {
				file = new FileInputStream("E:\\JavaPractice\\Lumens\\src\\main\\java\\com\\lumens\\config\\config.properties");
				prop.load(file);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public static void initialization() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\JavaPractice\\Lumens\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Waits.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//a[@class='ltkpopup-close']")).click();
		
		String parent= driver.getWindowHandle();
		System.out.println("Parent id is:  "+parent);
		
		Set<String>  allWindows= driver.getWindowHandles();
		System.out.println("No of windows  "+allWindows.size());
		
		for(String child:allWindows) {
			
			if(!parent.equalsIgnoreCase(child)) {
				
				driver.switchTo().window(child);
				System.out.println("Title of child window"+driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		Thread.sleep(1000);
			//popup.clickLater();
	}

	/*public static void main(String[] args) throws InterruptedException {
		
		BaseClass b = new BaseClass();
		BaseClass.initialization();
		
	}*/
}
