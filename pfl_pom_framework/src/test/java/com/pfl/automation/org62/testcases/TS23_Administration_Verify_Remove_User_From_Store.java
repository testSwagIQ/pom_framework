package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS23_Administration_Verify_Remove_User_From_Store extends BaseTest {

	//UserAdministrationPage userAdminPage;
	String admin_pfl_bd_amit_user = "Amit";
	
	@Test(priority=0, alwaysRun = true)
	public void TS23_DataSet_Creation() throws Exception {
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
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
	}
	
	@Test(priority=1, alwaysRun = true)
	public void TS23_01_Verifying_the_remove_user_into_the_Store() throws Exception {
		loginPage.logintoapplication(Constants.sfauser, Constants.sfapass);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		userAdminPage.verify_unauthorized_message_on_administrator_page_on_classic(driver);
		homePage.logout(driver);
	}
	
	@Test(priority=2, alwaysRun = true)
	public void TS23_DataSet_Reset() throws Exception {
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
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
	}
}
