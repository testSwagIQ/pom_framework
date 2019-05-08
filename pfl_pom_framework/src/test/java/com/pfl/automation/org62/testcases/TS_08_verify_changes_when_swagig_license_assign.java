package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS_08_verify_changes_when_swagig_license_assign extends BaseTest {

	@Test(priority=0, alwaysRun = true)
	public void TS_08_01_Verify_the_header_SwagIQ_Licenses_Administration_of_License_tab() throws Exception {
		Log.startTestCase("TS_08_01_Verify_the_header_SwagIQ_Licenses_Administration_of_License_tab");
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		licensepage.click_licsensetab(driver);
		licensepage.get_license_user_value(driver);
		licensepage.assign_license_to_user(driver, Constants.un_license_user);
		licensepage.verify_modified_user_count(driver);
		licensepage.click_save_button(driver);
		licensepage.verify_license_check_box_checked(driver, Constants.un_license_user);
		licensepage.verify_license_user_count(driver);
		licensepage.get_license_count_difference(driver);
		homePage.logout(driver);
		Log.endTestCase("TS_08_01_Verify_the_header_SwagIQ_Licenses_Administration_of_License_tab");
	}

	@Test(priority=1, alwaysRun = true)
	public void TS_08_DataReset() throws Exception {
		Log.startTestCase("TS_08_DataReset");
		Log.info("Removing License from License Page");
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		licensepage.click_licsensetab(driver);
		licensepage.remove_license_from_user(driver, Constants.un_license_user);
		licensepage.click_save_button(driver);
		//homePage.logout(driver);
		Log.endTestCase("TS_08_DataReset");
	}
}
