package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS12_Verfying_license_tab_enable_checkbox extends BaseTest {
	
	@Test(priority=0, alwaysRun = true)
	public void TS12_01_Verify_clicking_select_all_enabled_checkbox_on_Licenses_page_functionality() throws Exception {
		Log.startTestCase("TS12_01_Verify_clicking_select_all_enabled_checkbox_on_Licenses_page_functionality");
		loginPage.logintoapplication(Constants.username, Constants.password);
		licensepage.click_licsensetab(driver);
		licensepage.disable_license_to_all_user(driver);
		licensepage.enabale_license_to_all_user(driver);
		licensepage.metch_lic_total_count(driver);
		homePage.logout(driver);
		Log.endTestCase("TS12_01_Verify_clicking_select_all_enabled_checkbox_on_Licenses_page_functionality");
	}
}
