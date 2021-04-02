package com.lumens.design;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lumens.constants.BaseClass;

public class LogoutPage extends BaseClass{
	
	
	@FindBy(xpath = "//span[text()='Account']")
	WebElement accountBtn;
	@FindBy(xpath="//a[text()='Sign Out']") WebElement logout;
	
	public LogoutPage() {

		PageFactory.initElements(driver, this);
		
	}

	
	public void logut() throws InterruptedException {
		
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = accountBtn;
		actions.moveToElement(mainMenu).build().perform();;

		Thread.sleep(2000);
		WebElement subMenu = logout;
		actions.moveToElement(subMenu).click().build().perform();
	
		
		/*driver.findElement(By.xpath("//div[@class='_28p97w']/div/div/div[text()='My Account']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("document.getElementByXpath(//li[10]//a[@class='_2kxeIr']).click()");
		*/
		
			}

}
