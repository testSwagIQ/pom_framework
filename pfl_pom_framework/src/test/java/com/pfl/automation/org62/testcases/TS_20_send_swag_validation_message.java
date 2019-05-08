package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS_20_send_swag_validation_message extends BaseTest {

	@Test(priority=0, alwaysRun = true)
	public void TS_20_01_Verify_validation_message_displayed_user_if_no_program_associated_to_user_on_send_swag_screen() throws Exception {
		Log.startTestCase("TS_20_01_Verify_validation_message_displayed_user_if_no_program_associated_to_user_on_send_swag_screen");
		loginPage.logintoapplication(Constants.sfauser, Constants.sfapass);
		salsesforcePage.open_tab(Constants.tab_contacts);
		contactpage.opencontact(Constants.first_name, Constants.lasr_name);
		contactpage.click_on_send_marketing_button();
		contactpage.select_contact_address();
		contactpage.use_this_address();
		contactpage.verify_error_message();		
		//homePage.logout(driver);
		Log.endTestCase("TS_20_01_Verify_validation_message_displayed_user_if_no_program_associated_to_user_on_send_swag_screen");	
	}
}
