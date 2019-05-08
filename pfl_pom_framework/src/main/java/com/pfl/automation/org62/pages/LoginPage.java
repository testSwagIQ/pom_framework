package com.pfl.automation.org62.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.pfl.automation.base.BasePage;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class LoginPage extends BasePage {
	
	//*************************Declare Locators*********************************
			
	By send_marketing_button = By.xpath("//*[contains(@title, 'Send Marketing Materials')]");
	By rememberme_checkbox = By.xpath("//input[@type='checkbox'][@name='rememberUn']");
	By tryForFree_link = By.xpath("//a[text()='Try for Free']");
	By useCustomDomain_link = By.xpath("//a[text()='Use Custom Domain']");
	By forgotYourPassword_link = By.xpath("//a[text()='Forgot Your Password?']");
	By login_button = By.xpath("//input[@type='submit'][@name='Login']");
	By password_textbox = By.xpath("//input[@type='password'][@name='pw']");
	By username_textbox = By.xpath("//input[@type='email'][@name='username']");
	By titleText =By.xpath("//title");
	By classic_home_tab = By.xpath("//a[(@title='Home Tab')]");
	By lighting_home_tab = By.xpath("//a[contains(@title,'Home')]");
	By invalid_login_message = By.xpath("//*[@id='error']");
	By programAdministration_xpath = By.xpath("//div[contains(text(),'Program Administration')]");
	By userAdministration_xpath = By.xpath("//div[contains(text(),'User Administration')]");
	
	//*************************Initilize Constructor *********************************
	
	public LoginPage(WebDriver driver1) {
		this.driver = driver1;
		//this.test = test;
	}
	
	//*************************Declare Page Methods*********************************
	
	public void insertusername(String uid) {
		WebElement username_textbox_element =driver.findElement(username_textbox);
		if(username_textbox_element.isDisplayed())
			driver.findElement(username_textbox).sendKeys(uid);
			Log.info("Username text box found");
	}
	
	public void insertpassword(String pwd) {
		WebElement password_textbox_element =driver.findElement(password_textbox);
		if(password_textbox_element.isDisplayed())
			driver.findElement(password_textbox).sendKeys(pwd);
			Log.info("Password text box found");
	}
	
	public void loginbutton() {
		WebElement login_button_element = driver.findElement(login_button);
		if(login_button_element.isDisplayed())
			driver.findElement(login_button).click();
			Log.info("Login button found");
	}

	public void logintoapplication(String userName, String password) throws Exception  {
		wait_min();
		
		enterText(driver, username_textbox, userName);
		Log.info("Username entered in the Username text box");
		enterText(driver, password_textbox, password);
		Log.info("Password entered in the Username text box");
		Log.info("Click action performed on Submit button");
		clickElement(driver, login_button);
		
		waitForPageToLoad1(driver);
		WaitForCompleteLoad(driver);
	}
	
	public boolean verifySignIn() throws Exception {
		enterText(driver, username_textbox, Constants.username);
		enterText(driver, password_textbox, Constants.password);
		clickElement(driver, login_button);
		
		return getErrorMessage().contains(Constants.errorMsgTxt);
	}
	
	public String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(invalid_login_message);
		if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	}
}
