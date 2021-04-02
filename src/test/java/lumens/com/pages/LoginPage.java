package lumens.com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lumens.com.tests.TestBase;

public class LoginPage extends TestBase {
	
	// All login page webelment identified
	
	
	@FindBy(name = "dwfrm_login_username")
	public WebElement loginemail;
	
	@FindBy(name = "dwfrm_login_password")
	public WebElement loginpassword;
	
	@FindBy(name = "dwfrm_login_login")
	public WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='Account']")
	public WebElement account;
	
	@FindBy(xpath = "//a[text()='Sign In']")
	public WebElement singIn;
	
	@FindBy(xpath = "//a[text()='My Account']")
	public WebElement myAccount;
	
	@FindBy(id = "createAccountBtn")
	public WebElement createAccount;
	
	@FindBy(xpath = "//a[@class='user']")
	public WebElement loggedInUser;
	
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	public WebElement logOut;
	
	@FindBy(xpath = "//a[@class='ltkpopup-close']")
	public WebElement popUpClose;
	

	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void signIn() throws Exception
	{
		//account.click();
		Actions action = new Actions(driver);
		action.moveToElement(account).clickAndHold().click(myAccount).build().perform();
		//action.moveToElement(singIn).click().build().perform();
		Thread.sleep(2000);
	}
	
	public void signOut() throws Exception
	{
		Actions action = new Actions(driver);
		action.moveToElement(account).clickAndHold().click(logOut).build().perform();
		Thread.sleep(2000);
	}
		
	public void loginIntoApp() throws Exception
	{
		loginemail.sendKeys(prop.getProperty("email"));
		loginpassword.sendKeys(prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginButton);
		Thread.sleep(6000);
		//js.executeScript("arguments[0].click();", popUpClose);
		//driver.switchTo().alert().dismiss();
		//popUpClose.click();
	}
	
}
