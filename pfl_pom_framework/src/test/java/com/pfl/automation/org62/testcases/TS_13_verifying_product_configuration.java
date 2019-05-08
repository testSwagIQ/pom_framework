package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS_13_verifying_product_configuration extends BaseTest {

	static String program_string = "Random_auto_program";
	static long time = get_timestamp();
	static String program_name = program_string + time;

	@Test(priority=0, alwaysRun = true)
	public void TS_13_01_Verify_Product_Configuration_Display_Name_or_Quantity_Under_Product_Administration()
			throws Exception {
		Log.startTestCase("TS_13_01_Verify_Product_Configuration_Display_Name_or_Quantity_Under_Product_Administration");
		loginPage.logintoapplication(Constants.username, Constants.password);
		salsesforcePage.open_tab(Constants.tab_swag_iq_tool);
		adminpage.click_on_product_admin_tile(driver);
		adminpage.click_on_product_search_bar_on_Pro_Administration(driver, Constants.product_name);
		adminpage.click_product_detail_section(driver, Constants.product_name);
		adminpage.get_unallocated_product_quantity(driver);
		adminpage.click_active_product(driver);
		salsesforcePage.open_tab(Constants.tab_swag_iq_tool);
		adminpage.click_program_admin_tile(driver);

		adminpage.set_program_name(driver, program_name);

		adminpage.add_program_product(driver, Constants.product_count, Constants.product_name);
		adminpage.click_on_available_budget_refresh_button(driver, Constants.product_count);
		adminpage.get_product_count_on_program_page(driver);
		adminpage.compare_value();
		//homePage.logout(driver);
		Log.endTestCase("TS_13_01_Verify_Product_Configuration_Display_Name_or_Quantity_Under_Product_Administration");
	}
}
