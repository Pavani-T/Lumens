package com.flipkart.design;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.constants.BaseClass;

public class LogoutPage extends BaseClass{
	
	
	@FindBy(xpath="//div[text()='My Account']") WebElement myAccount;
	@FindBy(xpath="//div[text()='Logout']") WebElement logout;
	
	public LogoutPage() {

		PageFactory.initElements(driver, this);
		
	}

	
	public void logut() throws InterruptedException {
		
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = myAccount;
		actions.moveToElement(mainMenu).build().perform();;

		Thread.sleep(2000);
		WebElement subMenu = logout;
		actions.click();
	
		
		/*driver.findElement(By.xpath("//div[@class='_28p97w']/div/div/div[text()='My Account']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("document.getElementByXpath(//li[10]//a[@class='_2kxeIr']).click()");
		*/
		
			}

}
