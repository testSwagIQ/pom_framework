package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;

public class TS05_Administration_Multiple_product extends BaseTest {

	static String program_string = "Random_auto_program";
	static String admin_bd_auto_product_1 = "PFL_Auto_Product1";
	static String admin_bd_auto_product_2 = "PFL_Auto_Product5";
	static String product_qty = "2";
	static String product_count = "1";
	static String product_count2 = "2";
	static String p_count = "1";
	static String admin_pfl_bd_auto_user_first_name = "Testing";
	static String user_name_program = "Nishant";
	static String order_status = "Submitted";
	static String campaign_name = "PFL_auto_Test_campaign";
	static String campaign_status_sent = "Sent";
	
	static long time = get_timestamp();
	static String program_name = program_string + time;
	
	@Test(priority=0, alwaysRun = true)
	public void TS05_DataSet_Creation() throws Exception {
		//create_setup_program
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_program_admin_tile();
		adminpage.set_new_program(driver, program_name);
		adminpage.set_product_details(driver, product_count, admin_bd_auto_product_1, product_qty);
		adminpage.add_user_in_program(product_count, user_name_program);
		adminpage.add_program_product();
		adminpage.set_product_details(driver, product_count2, admin_bd_auto_product_2, product_qty);
		adminpage.add_user_in_program(product_count2, user_name_program);
		adminpage.activate_program();
		homePage.logout(driver);
	}
	
	@Test(priority=1, dependsOnMethods = { "TS05_DataSet_Creation" })
	public void TS05_01_verifying_send_swag_with_campaign_association() throws Exception {
		loginPage.logintoapplication(Constants.sfnuer, Constants.sfnpass);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name, admin_bd_auto_product_1);
		salsesforcePage.click_program_on_send_swag_screen(program_name, admin_bd_auto_product_1);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
		
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name, admin_bd_auto_product_2);
		salsesforcePage.click_program_on_send_swag_screen(program_name, admin_bd_auto_product_2);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
		homePage.logout(driver);
	}
	
	@Test(priority=2, dependsOnMethods = { "TS05_DataSet_Creation" })
	public void TS05_DataSet_Reset() throws Exception {
		//delete_order_send_swag
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		salsesforcePage.delete_order(admin_bd_auto_product_2, program_name, order_status);
		homePage.logout(driver);
	}
}
