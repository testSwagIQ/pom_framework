package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;

public class TS14_StandardAccessType extends BaseTest {
	
	String admin_pfl_bd_amit_user = "Amit";
	
	@Test(priority=0, alwaysRun = true)
	public void TS14_DataSet_Creation() throws Exception {
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);		
		swagiq.Click_UserAdministration(driver);
		userAdminPage.search_user_on_user_administration(driver,admin_pfl_bd_amit_user);
		userAdminPage.open_user_detail_section(driver);
		userAdminPage.change_user_access_to_standard(driver);
		userAdminPage.save_user_on_Store(driver);	
		homePage.logout(driver);
	}
	
	@Test(priority=1, dependsOnMethods = { "TS14_DataSet_Creation" })
	public void TS14_01_Verifying_that_access_level_satndard_cannot_access_admin_tab() throws Exception {
		loginPage.logintoapplication(Constants.sfauser, Constants.sfapass);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		userAdminPage.verify_unauthorized_message_on_administrator_page_on_classic(driver);
		homePage.logout(driver);
	}
	
	@Test(priority=2, dependsOnMethods = { "TS14_DataSet_Creation" })
	public void TS14_DataSet_Reset() throws Exception {
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		swagiq.Click_UserAdministration(driver);
		userAdminPage.search_user_on_user_administration(driver,admin_pfl_bd_amit_user);
		userAdminPage.open_user_detail_section(driver);
		userAdminPage.change_user_access_to_admin(driver);
		userAdminPage.save_user_on_Store(driver);			
		homePage.logout(driver);
	}
}
