package com.pfl.automation.org62.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;

public class TS04_lightning extends BaseTest{
	
	static By sflt_lightning_icon = By.cssSelector("a.switch-to-lightning");
	static String program_string = "Random_auto_program";
	static String admin_bd_auto_product_1 = "PFL_Auto_Product1";
	static String product_qty = "2";
	static String product_count = "1";
	static String p_count = "1";
	static String admin_pfl_bd_auto_user_first_name = "Testing";
	static String user_name_program = "Testing";
	static String order_status = "Submitted";
	static String campaign_name = "PFL_auto_Test_campaign";
	static String campaign_status_sent = "Sent";
	
	static long time = get_timestamp();
	static String program_name = program_string + time;
	
	@Test(priority=0, alwaysRun = true)
	public void create_setup_program() throws Exception {
		
		loginPage.logintoapplication(Constants.username1, Constants.password1);	
		salsesforcePage.sflt_verify_lightning_page(Constants.sflt_app_launcher, Constants.sflt_lightning_icon);	
		salsesforcePage.open_tab_lightng(Constants.tab_swagiq_tools);
		adminpage.sflt_click_program_admin_tile();
		adminpage.sflt_set_new_program(driver, program_name);
		adminpage.sflt_set_product_details(driver, product_count, admin_bd_auto_product_1, product_qty);
		adminpage.sflt_set_program_campaign(product_count, campaign_name);
		adminpage.sflt_set_campaign_member_status(product_count, campaign_status_sent);
		adminpage.sflt_add_user_in_program(product_count, user_name_program);
		adminpage.sflt_activate_program();
		homePage.logout_sflt();
	}
	
	@Test(priority=1, alwaysRun = true)
	public void verifying_send_swag_with_campaign_association() throws Exception {
		loginPage.logintoapplication(Constants.username1, Constants.password1);	
		salsesforcePage.sflt_verify_lightning_page(Constants.sflt_app_launcher, Constants.sflt_lightning_icon);	
		salsesforcePage.open_tab_lightng(Constants.tab_contacts);
		salsesforcePage.sflt_select_view(Constants.pfl_contact_view);
		salsesforcePage.sflt_open_contact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.sflt_select_contact_address();
		salsesforcePage.sflt_use_this_address();
		salsesforcePage.sflt_verify_program_on_contact_send_marketing_page(program_name, admin_bd_auto_product_1);
		salsesforcePage.sflt_click_program_on_send_swag_screen(program_name, admin_bd_auto_product_1);
		swagiq.sflt_click_next_button_send_swag();
		swagiq.sflt_click_send_marketing_confirmation_msg();
		swagiq.sflt_click_send_marketing_materials_button();
		swagiq.sflt_order_confirmation_msg();
		homePage.logout_sflt();
	}
	
	@Test(priority=2, alwaysRun = true)
	public void delete_order_send_swag() throws Exception {
		loginPage.logintoapplication(Constants.username1, Constants.password1);	
		salsesforcePage.sflt_verify_lightning_page(Constants.sflt_app_launcher, Constants.sflt_lightning_icon);		
		salsesforcePage.open_tab_lightng(Constants.tab_contacts);
		salsesforcePage.sflt_select_view(Constants.pfl_contact_view);
		salsesforcePage.sflt_open_contact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.sflt_delete_order(admin_bd_auto_product_1, program_name, order_status);
		homePage.logout_sflt();
	}

}
