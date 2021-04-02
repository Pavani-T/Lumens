package lumens.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import lumens.com.tests.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//div[@class='logo']")
	public WebElement logo;
	
	@FindBy(xpath="//span[@title='furniture']")
	public WebElement furnitureLink;
	
	@FindBy(xpath="//span[text()='Dining Room Tables']")
	public WebElement diningRoomTables;
	
	
	@FindBy(xpath="//span[text()='Dining Room & Kitchen Furniture']")
	public WebElement diningRoomKitchenFurniture;
	
	
	public WebElement diningRoomTableProduct(String product)
	{
		return driver.findElement(By.xpath("//a[@class='name-link' and @title='"+product+"']"));
		//a[@class='name-link' and @title='Invisible Table']
	}
	
	@FindBy(xpath="//a[@title='Dining Room Tables']")
	public WebElement diningRoomTableProdus;
	
	
	@FindBy(xpath="(//button[@id='add-to-cart' and @type='submit'])[1]")
	public WebElement addToCard;
	
	@FindBy(xpath="//a[@title='View Cart' and text()='CHECKOUT']")
	public WebElement checkOut;
	
	@FindBy(xpath="//a[@id='mcBookMark']/span[text()='Cart']")
	public WebElement cart;
	
	@FindBy(xpath="//table[@class='carttable']//..//button[@value='Remove']")
	public WebElement remove;
	
	@FindBy(xpath="//div[@class='cartempty']")
	public WebElement cartEmpty;
	
	@FindBy(xpath="//input[@name='dwfrm_cart_couponCode']")
	public WebElement promocode;
	
	@FindBy(xpath="//button[@name='dwfrm_cart_addCoupon']")
	public WebElement applycoupon;
		
	
	@FindBy(xpath="//div[@class='errormessage']/span")
	public WebElement promoerrormsg;
	
	
	
	
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addProdct() throws Exception
	{
	
		furnitureLink.click();
		Thread.sleep(5000);
		diningRoomKitchenFurniture.click();
		Thread.sleep(5000);
		diningRoomTables.click();
		Thread.sleep(5000);
		diningRoomTableProduct(prop.getProperty("product")).click();
		Thread.sleep(2000);
		addToCard.click();
		Thread.sleep(3000);
		checkOut.click();
		Thread.sleep(3000);
		
	}
	
	public void removeProduct() throws Exception
	{
		addProdct();	
		cart.click();
		Thread.sleep(3000);
		remove.click();
		Thread.sleep(3000);

	}
	
	public void applyPromoCode() throws Exception
	{
		addProdct();
		promocode.sendKeys(prop.getProperty("promocode"));
		applycoupon.click();
		Thread.sleep(2000);
		
		
	}
	
}
