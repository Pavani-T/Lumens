package lumens.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lumens.com.tests.TestBase;

public class CreateAccountPage extends TestBase{

	@FindBy(name = "dwfrm_profile_customer_firstname")
	public WebElement firstName;
	
	@FindBy(name = "dwfrm_profile_customer_lastname")
	public WebElement lastName;
	
	@FindBy(name = "dwfrm_profile_customer_email")
	public WebElement email;
	
	@FindBy(name = "dwfrm_profile_customer_emailconfirm")
	public WebElement emailConfirm;
	
	@FindBy(name = "dwfrm_profile_login_password")
	public WebElement password;
	
	
	@FindBy(name = "dwfrm_profile_login_passwordconfirm")
	public WebElement passwordConfirm;
	
	@FindBy(name = "dwfrm_profile_confirm")
	public WebElement createAccountButton;
	
	public CreateAccountPage()
	{	
		PageFactory.initElements(driver, this);
	}
	
}
