package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;

public class TS06_Administration_role_based_program extends BaseTest {

	static String program_string = "Random_auto_program";
	String admin_bd_auto_product_1 = "PFL_Auto_Product1";
	String product_qty = "2";
	String product_count = "1";
	String p_count = "1";
	String order_status = "Submitted";
	String assignment_type = "Role";
	String role_name = "Marketing Manager";
	
	static long time = get_timestamp();
	static String program_name = program_string + time;
	
	@Test(priority=0, alwaysRun = true)
	public void TS06_DataSet_Creation() throws Exception {
		loginPage.logintoapplication(Constants.username, Constants.password);
		System.out.println("initialize chromerdriver within salesforce page ");
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_program_admin_tile();
		adminpage.set_new_program(driver, program_name);
		adminpage.set_product_details(driver, product_count, admin_bd_auto_product_1, product_qty);
		adminpage.set_assignment_type(product_count, assignment_type);
		adminpage.add_user_by_role(role_name);
		adminpage.activate_program();
		homePage.logout(driver);
	}
	
	@Test (priority = 1, dependsOnMethods = { "TS06_DataSet_Creation" })
	public void TS06_01_verifying_send_swag_with_campaign_association() throws Exception {
		loginPage.logintoapplication(Constants.sfsuser, Constants.sfspass);
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
	
	@Test (priority = 2, dependsOnMethods = { "TS06_DataSet_Creation" })
	public void TS06_DataSet_Reset() throws Exception {
		//delete_order_send_swag
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		homePage.logout(driver);
	}
}
