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

public class TS23_Administration_Verify_Remove_User_From_Store extends BaseTest {
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
		Log.info("Clicking on Remove Button from Store ");
		userAdminPage.remove_user_on_Store(driver);
		
		userAdminPage.click_on_ok_user_confirmation(driver);
		homePage.logout(driver);
		closebrowser();
	}
	
	@Test
	public void TS01_Verifying_the_remove_user_into_the_Store() throws Exception {
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
		Log.info("Clicking on Add User Button on  User Administration ");
		userAdminPage.click_on_add_users_button_on_users_administration_page(driver);
		Log.info("Searching User on  User Administration ");
		userAdminPage.search_user_on_user_administration(driver,admin_pfl_bd_amit_user);
		Log.info("Selecting User after searching user on  User Administration ");
		userAdminPage.select_user_to_add_in_store(driver);
		Log.info("Adding User in Store User Administration ");
		userAdminPage.click_add_user_button_in_store(driver);
		Log.info("Confirmation ok Button clicked ");
		userAdminPage.click_on_ok_user_confirmation(driver);
		homePage.logout(driver);
		closebrowser();
	}
}
