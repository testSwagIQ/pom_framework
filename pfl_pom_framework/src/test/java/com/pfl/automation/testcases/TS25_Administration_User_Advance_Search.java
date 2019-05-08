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

public class TS25_Administration_User_Advance_Search extends BaseTest {
	SwagIQPage swagiq;
	LoginPage loginPage;
	HomePage homePage;
	UserAdministrationPage userAdminPage;
	String admin_pfl_bd_auto_user_first_name = "PFL_Auto";
	String admin_user_advance_search_first_name_id = "advSearch_firstName";
	String admin_user_advance_search_role_id = "advSearch_role";
	String admin_pfl_bd_auto_user_role = "Marketing Manager";
	String admin_user_advance_search_last_name_id = "advSearch_lastName";
	String admin_pfl_bd_auto_user_last_name = "Standard_User";
	String admin_user_advance_search_profile_id = "advSearch_profile";
	String admin_pfl_bd_auto_user_profile = "Standard User";	
	String admin_pfl_bd_auto_user_email = "deepak.sharma1@metacube.com";
	String admin_pfl_bd_auto_user_access_level = "Admin";
	
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
	}
	
	@Test
	public void TS01_Verifying_the_advanced_search_functionality() throws Exception {
		Log.info("Clicking on User Administration ");
		swagiq.Click_UserAdministration(driver);
		Log.info("Clicking on Advanced Search Button ");
		userAdminPage.click_on_advanced_search_button(driver);
		Log.info("Verifying the Advance search First Name ");
		userAdminPage.advance_search_using_id_and_value(driver,admin_user_advance_search_first_name_id,admin_pfl_bd_auto_user_first_name);
		userAdminPage.verify_value_using_advance_search(driver, admin_pfl_bd_auto_user_first_name);
		Log.info("Verifying the Advance search Last Name ");
		userAdminPage.advance_search_using_id_and_value(driver,admin_user_advance_search_last_name_id,admin_pfl_bd_auto_user_last_name);
		userAdminPage.verify_value_using_advance_search(driver, admin_pfl_bd_auto_user_last_name);
		Log.info("Verifying the Advance search Role ");
		userAdminPage.advance_search_using_id_and_value(driver,admin_user_advance_search_role_id,admin_pfl_bd_auto_user_role);
		userAdminPage.verify_value_using_advance_search(driver, admin_pfl_bd_auto_user_role);
		Log.info("Verifying the Advance search Profile ");
		userAdminPage.advance_search_using_id_and_value(driver,admin_user_advance_search_profile_id,admin_pfl_bd_auto_user_profile);
		userAdminPage.verify_value_using_advance_search(driver, admin_pfl_bd_auto_user_profile);
		Log.info("Verifying the Advance search Email ");
		userAdminPage.search_email_Advance_Search(driver,admin_pfl_bd_auto_user_email);
		userAdminPage.verify_value_using_advance_search(driver, admin_pfl_bd_auto_user_email);
		Log.info("Verifying the Advance search Access Level ");
		userAdminPage.search_access_level_Advance_Search(driver);
		userAdminPage.verify_value_using_advance_search(driver, admin_pfl_bd_auto_user_access_level);
		
		Log.info("Completed the Searching functionality ");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		homePage.logout(driver);
		closebrowser();
	}
}
