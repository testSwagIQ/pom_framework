package com.pfl.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.ProductAdministrationPage;
import com.pfl.automation.pages.ProgramAdministrationPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.pages.UserAdministrationPage;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;
import com.pfl.automation.utils.reruntest.DynamicRetryAnalyzer;

public class TS01_Administration_AssertTiles extends BaseTest {
		SalesforcePage salsesforcePage;
		SwagIQPage swagiq;
		LoginPage loginPage;
		HomePage homePage;
		ProgramAdministrationPage programAdminPage;
		UserAdministrationPage userAdminPage;
		ProductAdministrationPage productAdministrationPage;
	
		//@Parameters("browser")
		@BeforeMethod
		public void setUp() throws Exception {
			log4j_config();
			readxmlDataFile();
			
			openBrowser();
			//testngBrowserlaunch(browserName);
			loginPage = new LoginPage(driver);
			homePage = new HomePage(driver);
			
			Log.info("Username picked from Constants Class is "+ Constants.username );
			Log.info("Password picked from Constants Class is "+ Constants.password );
			loginPage.logintoapplication(Constants.username, Constants.password);
		}
		
		@Test
		public void TS1_Verify_administration_tiles() throws Exception {
			swagiq.verifyTilesAdministration(driver);
		}
		
		//@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
		@Test
		public void TS2_Verify_presence_of_different_components_on_Program_administration_page() throws Exception {
			swagiq.Click_ProgramAdministration(driver);
			programAdminPage.verifyProgramAdministration(driver);
		}
		
		@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
		public void TS3_Verify_presence_of_different_components_on_User_administration_page() throws Exception {
			swagiq.Click_UserAdministration(driver);
			userAdminPage.verifyUserAdministration(driver);
		}
		
		@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
		public void TS4_Verify_presence_of_different_components_on_Product_administration_page() throws Exception {
			swagiq.Click_ProductAdministration(driver);
			productAdministrationPage.verifyProductAdministration(driver);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			homePage.logout(driver);
			closebrowser();
		}
}