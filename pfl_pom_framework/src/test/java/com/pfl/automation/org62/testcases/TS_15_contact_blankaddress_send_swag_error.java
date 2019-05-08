package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS_15_contact_blankaddress_send_swag_error extends BaseTest {

	@Test(priority=0, alwaysRun = true)
	public void TS_15_01_Verify_that_validation_message_displayed_to_user_if_no_program_is_associated_to_user_on_send_swag_screen()
			throws Exception {
		Log.startTestCase("TS_15_01_Verify_that_validation_message_displayed_to_user_if_no_program_is_associated_to_user_on_send_swag_screen");
		loginPage.logintoapplication(Constants.username, Constants.password);
		
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.create_new_contact(driver, first_n_value, last_n_value, mailing_address_street,
				mailing_address_zipcode, mailing_country_value);
		contactpage.click_on_send_marketing_button();

		Boolean assert_address = adminpage.verify_xpath_on_page(driver, Constants.con_send_swag_select_address);
		salsesforcePage.assert_value_n_report_result(true, assert_address, tstMsg + " contact address icon");
		contactpage.select_contact_address();
		contactpage.use_this_address();

		Boolean assert_city = adminpage.verify_xpath_on_page(driver, Constants.con_error_city_is_required);
		salsesforcePage.assert_value_n_report_result(true, assert_city, tstMsg + " city is required");

		Boolean assert_state = adminpage.verify_xpath_on_page(driver, Constants.con_error_state_is_required);
		salsesforcePage.assert_value_n_report_result(true, assert_state, tstMsg + " address is required");

		Boolean assert_phone = adminpage.verify_xpath_on_page(driver, Constants.con_error_phone_is_required);
		salsesforcePage.assert_value_n_report_result(true, assert_phone, tstMsg + " phone is required");

		contactpage.fill_other_address(driver, city, state, phone_no);
		contactpage.click_custom_use_this_address(driver);
		contactpage.click_program_on_contact_send_marketing_page(driver, admin_bd_auto_program_1, admin_bd_auto_product_1);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
		//homePage.logout(driver);
		Log.endTestCase("TS_15_01_Verify_that_validation_message_displayed_to_user_if_no_program_is_associated_to_user_on_send_swag_screen");
	}
}
