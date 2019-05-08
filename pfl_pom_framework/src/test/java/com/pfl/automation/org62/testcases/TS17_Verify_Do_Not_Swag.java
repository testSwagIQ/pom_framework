package com.pfl.automation.org62.testcases;
	
	
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;
	
public class TS17_Verify_Do_Not_Swag extends BaseTest  {
	
		@Test(priority=0, alwaysRun = true)
		public void TC17_01_Verify_User_not_able_Send_Swag_Do_Not_Swag_field_enabled_for_Contact() throws Exception {
			Log.startTestCase("TC17_01_Verify_User_not_able_Send_Swag_Do_Not_Swag_field_enabled_for_Contact");
			loginPage.logintoapplication(Constants.username, Constants.password);
			salsesforcePage.open_tab(Constants.tab_contacts);
			salsesforcePage.selectview(Constants.pfl_contact_view);
			System.out.println("selected view successfully");
			salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
			System.out.println("open contact successfully");
			salsesforcePage.set_do_not_swag_checkbox_as_checked(driver);
			salsesforcePage.click_sendswagbutton();
			Assert.assertEquals("Send Swag not available", salsesforcePage.con_send_swag_not_avbl_message(driver));
			salsesforcePage.click_send_swag_back_pop_up(driver);
			salsesforcePage.set_do_not_swag_checkbox_as_unchecked(driver);
			homePage.logout(driver);
			Log.endTestCase("TC17_01_Verify_User_not_able_Send_Swag_Do_Not_Swag_field_enabled_for_Contact");	
		}
	}
