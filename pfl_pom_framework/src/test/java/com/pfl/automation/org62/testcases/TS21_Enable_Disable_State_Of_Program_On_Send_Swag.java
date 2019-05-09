package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS21_Enable_Disable_State_Of_Program_On_Send_Swag extends BaseTest {
	
	static String program_string = "Enable-disable_auto_program";
	static String admin_bd_auto_product_1 = "PFL_Auto_Product1";
	static String product_qty = "2";
	static String product_count = "1";
	static String p_count = "1";
	static String user_name_program = "Automation";
	static String order_status = "Submitted";
	
	static long time = get_timestamp();
	static String program_name = program_string + time;
	
	@Test(priority=0, alwaysRun = true)
	public void TS21_DataSet_Creation() throws Exception {		
		loginPage.logintoapplication(Constants.username, Constants.password);
		System.out.println("initialize chromerdriver within salesforce page ");
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_program_admin_tile();
		adminpage.set_new_program(driver, program_name);
		adminpage.set_product_details(driver, product_count, admin_bd_auto_product_1, product_qty);
		adminpage.add_user_in_program(product_count, user_name_program);
		adminpage.activate_program();
		homePage.logout(driver);
	}
	
	@Test(priority=1, dependsOnMethods = { "TS21_DataSet_Creation" })
	public void TS21_01_Verifying_the_activation_of_program_by_sending_swag() throws Exception {
		Log.startTestCase("TS21_01_Verifying_the_activation_of_program_by_sending_swag");
		loginPage.logintoapplication(Constants.sfruser, Constants.sfrpass);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name,admin_bd_auto_product_1);
		salsesforcePage.click_program_on_send_swag_screen(program_name,admin_bd_auto_product_1);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
		homePage.logout(driver);
		Log.endTestCase("TS21_01_Verifying_the_activation_of_program_by_sending_swag");
	}
	
	@Test(priority=2, dependsOnMethods = { "TS21_DataSet_Creation" })
	public void TS21_02_Verifying_the_deactivation_of_program_by_sending_swag() throws Exception {
		Log.startTestCase("TS21_02_Verifying_the_deactivation_of_program_by_sending_swag");
		loginPage.logintoapplication(Constants.sfruser, Constants.sfrpass);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_program_admin_tile();
		adminpage.verify_program_on_admin_page(driver,program_name);
		adminpage.click_on_program_from_search_result(driver,program_name);
		adminpage.inactivate_program(driver);
		
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_inactiveprogram_on_contact_send_marketing_page(driver,program_name);
		homePage.logout(driver);
		Log.endTestCase("TS21_02_Verifying_the_deactivation_of_program_by_sending_swag");
	}
	
	@Test(priority=3, dependsOnMethods = { "TS21_DataSet_Creation" })
	public void TS21_DataSet_Reset() throws Exception {
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		homePage.logout(driver);
	}
}
