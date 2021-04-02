package lumens.com.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import lumens.com.pages.CreateAccountPage;
import lumens.com.pages.HomePage;
import lumens.com.pages.LoginPage;
import lumens.com.tests.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestRunner extends TestBase{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public LoginPage loginPage;
	public CreateAccountPage createAccountPage;
	public HomePage homePage;
	public Actions action;
	

	@BeforeClass
	public void beforeClass() {

		// Initialize all extents report configurations here before run tests

		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Lumens Lights");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		TestBase.intilization();

	}
  
	@AfterClass
	public void afterClass() {
		
		// run after all tests are completed
		driver.close();
		extent.flush();
	}
	
// Test Cases 
	
	@Test(priority = 1,enabled = false)
	public void verifyAccountCreation() throws Exception {
		extentTest = extent.createTest("Verify  User is able to Create an account in Lumens application");
		loginPage = new LoginPage();
		loginPage.signIn();
		loginPage.createAccount.click();
		createAccountPage = new CreateAccountPage();
		createAccountPage.firstName.sendKeys(prop.getProperty("firstname"));
		createAccountPage.lastName.sendKeys(prop.getProperty("lastname"));
		createAccountPage.email.sendKeys(prop.getProperty("email"));
		createAccountPage.emailConfirm.sendKeys(prop.getProperty("email"));
		createAccountPage.password.sendKeys(prop.getProperty("password"));
		createAccountPage.passwordConfirm.sendKeys(prop.getProperty("password"));
		createAccountPage.createAccountButton.click();
		loginPage.account.click();
		Assert.assertTrue(loginPage.loggedInUser.isDisplayed());
		loginPage.signOut();
	}
	
	@Test(priority = 2,enabled = false)
	public void verifyLogin() throws Exception {
		extentTest = extent.createTest("Verify user is able to Login Lumens  application");
		loginPage = new LoginPage();
		loginPage.signIn();
		loginPage.loginIntoApp();
		homePage = new HomePage();
		Assert.assertTrue(homePage.logo.isDisplayed());
	}
	
	@Test(priority = 3)
	public void verifyRemoveProductFromCart() throws Exception {
		extentTest = extent.createTest("Verify the product able to remove from cart");
		loginPage = new LoginPage();
		loginPage.signIn();	
		loginPage.loginIntoApp();
		homePage = new HomePage();
		homePage.removeProduct(); // Remove Product From Cart
		Assert.assertTrue(homePage.cartEmpty.isDisplayed());
		loginPage.signOut();
	}

	@Test(priority = 4)
	public void verifyApplyPromoCodeToProduct() throws Exception {
		extentTest = extent.createTest("Verify user able to apply coupon code");
		loginPage = new LoginPage();
		loginPage.signIn();		
		homePage = new HomePage();
		homePage.applyPromoCode(); // Apply Copun Code
		Assert.assertTrue(homePage.promoerrormsg.isDisplayed());
	}
	
	@Test(priority = 5)
	public void verifyScrollUpAndDown() throws Exception {
		extentTest = extent.createTest("Verify scroll up, scroll down action");
		loginPage = new LoginPage();
		loginPage.signIn();		
		homePage = new HomePage();
		homePage.furnitureLink.click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");   // Scroll Down by 1000 pixel
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(1000,0)");   // Scroll Up by 1000 pixel
		Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void verifyNavigationBack() throws Exception {
		extentTest = extent.createTest("Verify Navigation Back");
		loginPage = new LoginPage();
		loginPage.signIn();		
		homePage = new HomePage();
		homePage.furnitureLink.click();
		Thread.sleep(5000);
		driver.navigate().back(); // Navigation Back
		Thread.sleep(5000);
		//Assert.assertTrue(driver.getTitle().equals("My Account")); // Validate once Navigated Back
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		// This will be execute after completed each test

		String methodName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

			extentTest.fail("<details><summary>" + "<b><font color =red>Exception occured, Click to see details:</font>"
					+ "</b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

			// adding screenshot if test case is failed
			String path = takeScreenshot(methodName);
			try {
				extentTest.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
						MediaEntityBuilder.createScreenCaptureFromPath(path).build());

			} catch (IOException e) {
				extentTest.fail("Test Failed, Cannot attach screenshot");
			}

			String logText = "<b>Test Method " + methodName + " Failed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			extentTest.log(Status.FAIL, m);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String logText = "<b>Test Method " + methodName + " Successfull</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extentTest.log(Status.PASS, m);

		} else if (result.getStatus() == ITestResult.SKIP) {
			String logText = "<b>Test Method " + methodName + " Skipped</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			extentTest.log(Status.SKIP, m);

		}

	}

	public String takeScreenshot(String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdir();
		String path = directory + fileName;

		try {
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File(path));
			System.out.println("================================");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("================================");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

}
