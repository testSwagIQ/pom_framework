package com.pfl.automation.testcases;

import org.testng.annotations.BeforeMethod;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.AdminPage;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.utils.Constants;

public class TS21_Enable_Disable_State_Of_Program_On_Send_Swag extends BaseTest {
	AdminPage ad1;
	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void testUp() throws Exception
	{
		log4j_config();
		readxmlDataFile();
		
		openBrowser();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		//openBrowser();
		loginPage.logintoapplication(Constants.username, Constants.password);
	}
	
}
