package com.lumens.design;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lumens.constants.BaseClass;

public class LightingPage extends BaseClass{
	
	Actions action;
	
	@FindBy(xpath="(//a[@class='tier-1'])[1]") WebElement light;
	@FindBy(xpath=" //li[@class='child department-listing']//div//span//a[text()='Ceiling Lights']") WebElement celling_light;
	@FindBy(xpath="//img[@alt='Ceiling Lights']") WebElement celling_light_category;
	@FindBy(xpath="//a/span[text()='Chandeliers']") WebElement Chandeliers;
	@FindBy(xpath="//a/span[text()='Large Chandeliers']") WebElement largeChandeliers;
	@FindBy(xpath="//input[@class='fa-check-wc']") WebElement filter_business;
	@FindBy(xpath="//span[@class='fa-check-square-o mr-2']") WebElement filter_style;
	@FindBy(xpath="//a[@title='Click to Refine By Under 12 inches']/span") WebElement filter_width;
	@FindBy(xpath="//a[@title='Click to Refine By Under 12 inches']/span") WebElement filter_font;
	
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
		action = new Actions(driver);
		action.moveToElement(light).click().build().perform();
		
		action.moveToElement(celling_light).click().build().perform();
		celling_light_category.click();
		Chandeliers.click();
		largeChandeliers.click();
		filter_business.click();
		filter_style.click();
		filter_width.click();
		filter_font.click();
		
	}
	
	
	
	
	
}
