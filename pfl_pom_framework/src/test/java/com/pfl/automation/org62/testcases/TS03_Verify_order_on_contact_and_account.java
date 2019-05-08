package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;

public class TS03_Verify_order_on_contact_and_account extends BaseTest{
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
	public void TS03_DataSet_Creation() throws Exception {
		//create_setup_program
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_program_admin_tile();
		adminpage.set_new_program(driver, program_name);
		adminpage.set_product_details(driver, product_count, admin_bd_auto_product_1, product_qty);
		adminpage.add_user_in_program(product_count, user_name_program);
		adminpage.activate_program();
		homePage.logout(driver);
	}
	
	@Test(priority=1, dependsOnMethods = { "TS03_DataSet_Creation" })
	public void TS03_01_verifying_contact_address_send_swag() throws Exception {
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
		homePage.logout(driver);
	}
	
	@Test(priority=2, dependsOnMethods = { "TS03_DataSet_Creation" })
	public void TS03_02_verifying_account_address_end_swag() throws Exception {
		loginPage.logintoapplication(Constants.sfnuer, Constants.sfnpass);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_account_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name, admin_bd_auto_product_1);
		salsesforcePage.click_program_on_send_swag_screen(program_name, admin_bd_auto_product_1);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
		homePage.logout(driver);
	}
	
	@Test(priority=3, dependsOnMethods = { "TS03_DataSet_Creation" })
	public void TS03_DataReset() throws Exception {
		//delete_order_send_swag
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		homePage.logout(driver);
	}
}
