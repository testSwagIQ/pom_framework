package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS_22_product_verify_active_inactive_state extends BaseTest {

	static String program_string = "Random_auto_program";
	static long time = get_timestamp();
	static String program_name = program_string + time;

	@Test(priority=0, alwaysRun = true)
	public void TS_22_01_Verifying_Active_State_of_Product_on_Product_Administration() throws Exception {
		Log.startTestCase("TS_22_01_Verifying_Active_State_of_Product_on_Product_Administration");
		loginPage.logintoapplication(Constants.username, Constants.password);

		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_on_product_admin_tile(driver);
		adminpage.click_on_product_search_bar_on_Pro_Administration(driver, Constants.product_name_two);
		adminpage.click_product_detail_section(driver, Constants.product_name_two);
		adminpage.click_active_product(driver);

		salsesforcePage.open_tab(Constants.tab_swagiq_tools);

		adminpage.click_program_admin_tile(driver);
		//adminpage.click_new_program_button(driver);
		adminpage.set_program_name(driver, program_name);
		adminpage.add_program_product(driver, Constants.product_count, Constants.product_name_two);
		adminpage.verify_content_on_Page(driver, Constants.admin_program_page_product_xpath_after_selection);

		//homePage.logout(driver);
		Log.endTestCase("TS_22_01_Verifying_Active_State_of_Product_on_Product_Administration");

	}

	@Test(priority=1, alwaysRun = true)
	public void TS_22_02_Verifying_Inactive_State_of_Product_on_Product_Administration() throws Exception {
		Log.startTestCase("TS_22_02_Verifying_Inactive_State_of_Product_on_Product_Administration");

		loginPage.logintoapplication(Constants.username, Constants.password);

		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_on_product_admin_tile(driver);
		adminpage.click_on_product_search_bar_on_Pro_Administration(driver, Constants.product_name_two);
		adminpage.click_product_detail_section(driver, Constants.product_name_two);
		adminpage.deactive_product(driver);

		salsesforcePage.open_tab(Constants.tab_swagiq_tools);

		adminpage.click_program_admin_tile(driver);
		//adminpage.click_new_program_button(driver);
		adminpage.set_program_name(driver, program_name);
		adminpage.add_program_product(driver, Constants.product_count, Constants.product_name_two);
		adminpage.verify_content_on_Page(driver, Constants.admin_program_page_product_unavailable_text);

		//homePage.logout(driver);
		Log.endTestCase("TS_22_02_Verifying_Inactive_State_of_Product_on_Product_Administration");

	}
	
	@Test(priority=2, alwaysRun = true)
	public void TS_22_DataReset () throws Exception {
		loginPage.logintoapplication(Constants.username, Constants.password);
		homePage.click_all_tab(driver);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_on_product_admin_tile(driver);
		adminpage.click_on_product_search_bar_on_Pro_Administration(driver, Constants.product_name_two);
		adminpage.click_product_detail_section(driver, Constants.product_name_two);
		adminpage.active_product(driver);
		//homePage.logout(driver);
	}
}
