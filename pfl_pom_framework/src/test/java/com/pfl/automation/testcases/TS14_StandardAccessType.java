package com.pfl.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.pages.UserAdministrationPage;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS14_StandardAccessType extends BaseTest {

	SwagIQPage swagiq;
	LoginPage loginPage;
	HomePage homePage;
	UserAdministrationPage userAdminPage;
	String admin_pfl_bd_amit_user = "Amit";
	
	@BeforeMethod
	public void testUp() throws Exception {
		log4j_config();
		readxmlDataFile();
		
		openBrowser();
		swagiq = new SwagIQPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		userAdminPage = new UserAdministrationPage(driver);
		
		Log.info("Username picked from Constants Class is "+ Constants.username );
		Log.info("Password picked from Constants Class is "+ Constants.password );
		loginPage.logintoapplication(Constants.username, Constants.password);
		//Assert.assertTrue(loginPage.verifySignIn(), Constants.errorMsgTxt);
		
		Log.info("Clicking on User Administration ");
		swagiq.Click_UserAdministration(driver);
		Log.info("Searching the User Name ");
		userAdminPage.search_user_on_user_administration(driver,admin_pfl_bd_amit_user);
		Log.info("Clicking on User detail ");
		userAdminPage.open_user_detail_section(driver);
		Log.info("Changing access type for user Admin to Standard Type ");
		userAdminPage.change_user_access_to_standard(driver);
		Log.info("Saving the changes ");
		userAdminPage.save_user_on_Store(driver);	
		homePage.logout(driver);
		closebrowser();
	}
	
	@Test
	public void TS01_Verifying_that_access_level_satndard_cannot_access_admin_tab() throws Exception {
		openBrowser();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.logintoapplication(Constants.sfauser, Constants.sfapass);
		userAdminPage.verify_unauthorized_message_on_administrator_page_on_classic(driver);
		homePage.logout(driver);
		closebrowser();
		
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		openBrowser();
		swagiq = new SwagIQPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		userAdminPage = new UserAdministrationPage(driver);
		
		Log.info("Username picked from Constants Class is "+ Constants.username );
		Log.info("Password picked from Constants Class is "+ Constants.password );
		loginPage.logintoapplication(Constants.username, Constants.password);
		
		Log.info("Clicking on User Administration ");
		swagiq.Click_UserAdministration(driver);
		Log.info("Searching User on  User Administration ");
		userAdminPage.search_user_on_user_administration(driver,admin_pfl_bd_amit_user);
		Log.info("Clicking on User detail ");
		userAdminPage.open_user_detail_section(driver);
		Log.info("Adding User in Store User Administration ");
		userAdminPage.change_user_access_to_admin(driver);
		Log.info("Saving the changes ");
		userAdminPage.save_user_on_Store(driver);	
		homePage.logout(driver);
		closebrowser();
	}
	
}
