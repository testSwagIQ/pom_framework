package com.pfl.automation.org62.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;


public class TS07_Administration_program_error_validation extends BaseTest{
	

	static String program_string = "Random_auto_program";
	String admin_bd_auto_product_1 = "PFL_Auto_Product4";
	String product_qty = "2";
	String product_count = "1";
	String p_count = "1";
	String admin_pfl_bd_auto_user_first_name = "Testing";
	String user_name_program = "Testing";
	String order_status = "Submitted";
	String assignment_type = "Role";
	String role_name = "Marketing Manager";
	String product_qty_zero = "0";
	
	static long time = get_timestamp();
	static String program_name = program_string + time;
	
	
	@Test (priority = 1, enabled = true)
	//(retryAnalyzer=DynamicRetryAnalyzer.class)
	public void program_error_validation() throws Exception
	{
		loginPage.logintoapplication(Constants.username, Constants.password);
		System.out.println("program name is: " +program_name);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		adminpage.click_program_admin_tile();
		adminpage.set_new_program(driver, program_name);
		String increased_p_qty = adminpage.get_product_quanity(product_count, admin_bd_auto_product_1);
		adminpage.add_product_n_qty(product_count, increased_p_qty);
		adminpage.add_user_in_program(product_count, user_name_program);
		adminpage.activate_program();
		String increased_user_bdgt = adminpage.get_user_increased_budget(increased_p_qty);
		adminpage.set_user_budget(increased_user_bdgt);
		adminpage.activate_program();
		adminpage.assert_errors_program_page();
		adminpage.add_product_n_qty(product_count, product_qty_zero);
		adminpage.set_user_budget(product_qty_zero);
		System.out.println("modified quantity again to zero");
	}
		
	@AfterMethod
	public void tearDown() throws Exception {
		homePage.logout(driver);
		closebrowser();	
	}


}
