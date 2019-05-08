package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS16_Contact_length_validation_on_custom_address extends BaseTest {
	
	static String program_string = "Random_auto_program";
	static String admin_bd_auto_product_1 = "PFL_Auto_Product1";
	static String product_qty = "2";
	static String product_count = "1";
	static String p_count = "1";
	static String user_name_program = "Nishant";
	static String order_status = "Submitted";
	static long time = get_timestamp();
	static String program_name = program_string + time;

	
	@Test(priority=0, alwaysRun = true)
	public void TS_16_DataSet_Creation() throws Exception {
		//01_create_setup_program
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_program_admin_tile();
		adminpage.set_new_program(driver, program_name);
		adminpage.set_product_details(driver, product_count, admin_bd_auto_product_1, product_qty);
		adminpage.add_user_in_program(product_count, user_name_program);
		adminpage.activate_program();
		homePage.logout(driver);
	}

	@Test(priority=1, dependsOnMethods = { "TS_16_DataSet_Creation" })
	public void TS_16_01_Contact_length_validation_on_custom_address() throws Exception {
		loginPage.logintoapplication(Constants.sfnuer, Constants.sfnpass);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_other_address();

		salsesforcePage.fill_other_address(Constants.con_other_address_line1, Constants.con_other_address_line1_value);
		salsesforcePage.fill_other_address(Constants.con_other_address_line2, Constants.con_other_address_line2_value);
		salsesforcePage.fill_other_address(Constants.con_other_city_field, Constants.con_other_city_field_value);
		salsesforcePage.fill_other_address(Constants.con_other_state_field, Constants.con_other_state_field_value);
		salsesforcePage.fill_other_address(Constants.con_other_postal_code, Constants.con_other_postal_code_value);
		salsesforcePage.fill_other_address(Constants.con_other_postal_country, Constants.con_other_postal_country_value);
		salsesforcePage.fill_other_address(Constants.con_other_phone_number, Constants.con_other_phone_number_value);		
		salsesforcePage.fill_other_address(Constants.con_other_company_name, Constants.con_con_other_company_name_value);
		
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_address1+"')]");
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_address2+"')]");
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_city+"')]");
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_state+"')]");
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_country+"')]");
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_phone_name+"')]");
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_company_name+"')]");
		salsesforcePage.verify_content_on_Page(driver,"//div/span[contains(.,'"+Constants.con_error_other_name_postal_code+"')]");

		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_other_address();
		
		salsesforcePage.fill_other_address(Constants.con_other_address_line1, Constants.con_other_address_line1_valid_value);
		salsesforcePage.fill_other_address(Constants.con_other_address_line2, Constants.con_other_address_line2_valid_value);
		salsesforcePage.fill_other_address(Constants.con_other_city_field, Constants.con_other_city_field_valid_value);
		salsesforcePage.fill_other_address(Constants.con_other_state_field, Constants.con_other_state_field_valid_value);
		salsesforcePage.fill_other_address(Constants.con_other_postal_code, Constants.con_other_postal_code_valid_value);
		salsesforcePage.fill_other_address(Constants.con_other_postal_country, Constants.con_other_postal_country_valid_value);
		salsesforcePage.fill_other_address(Constants.con_other_phone_number, Constants.con_other_phone_number_valid_value);
		salsesforcePage.fill_other_address(Constants.con_other_company_name, Constants.con_con_other_company_name_valid_value);
		
		salsesforcePage.use_this_address_on_other_address_page();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name, admin_bd_auto_product_1);
		salsesforcePage.click_program_on_send_swag_screen(program_name, admin_bd_auto_product_1);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
		homePage.logout(driver);
	}

	@Test(priority=2, dependsOnMethods = { "TS_16_DataSet_Creation" })
	public void TS_16_DataSet_Reset() throws Exception {
		//Delete_order_send_swag
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		homePage.logout(driver);
		Log.endTestCase("TS16_Contact_length_validation_on_custom_address");
	}
}
