package com.lumens.design;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lumens.constants.BaseClass;

public class LightingPage extends BaseClass{
	
	
	@FindBy(xpath="(//a[@class='tier-1'])[1]") WebElement light;
	@FindBy(xpath="//div[@class='mm-col-5']/span/a[@title='Ceiling Lights'][1]") WebElement celling_light;
	public LightingPage() {

		PageFactory.initElements(driver, this);
		
	}

	public void clickOnLight() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		action.moveToElement(light).click().build().perform();
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(celling_light).click().build().perform();
	}
	
}
