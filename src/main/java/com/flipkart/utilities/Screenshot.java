package com.flipkart.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

public static void screenShot(WebDriver driver, String name) throws Exception {
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\JavaPractice\\AmazonExample\\screenshot"+name+".png"));
		
	}
}
