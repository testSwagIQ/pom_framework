package com.pfl.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.AdminPage;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.utils.Constants;

public class TS05_Administration_Multiple_product extends BaseTest {

	
	AdminPage admin;
	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	HomePage homePage;

	static String program_string = "Random_auto_program";
	String admin_bd_auto_product_1 = "PFL_Auto_Product1";
	String admin_bd_auto_product_2 = "PFL_Auto_Product5";
	String product_qty = "2";
	String product_count = "1";
	String product_count2 = "2";
	String p_count = "1";
	String admin_pfl_bd_auto_user_first_name = "Testing";
	String user_name_program = "Testing";
	String order_status = "Submitted";
	String campaign_name = "PFL_auto_Test_campaign";
	String campaign_status_sent = "Sent";
	
	static long time = get_timestamp();
	static String program_name = program_string + time;
	
	@BeforeMethod
	public void testUp() throws Exception
	{
		openBrowser();
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		salsesforcePage = new SalesforcePage(driver);
		admin = new AdminPage(driver);
		swagiq = new SwagIQPage(driver);
		loginPage.logintoapplication(Constants.username, Constants.password);
	}
	
	@Test (priority = 1)
	public void create_setup_program()
	{
		System.out.println("initialize chromerdriver within salesforce page ");
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		admin.click_program_admin_tile();
		admin.set_new_program(driver, program_name);
		admin.set_product_details(driver, product_count, admin_bd_auto_product_1, product_qty);
		admin.add_user_in_program(product_count, user_name_program);
		
		admin.add_program_product();
		admin.set_product_details(driver, product_count2, admin_bd_auto_product_2, product_qty);
		admin.add_user_in_program(product_count2, user_name_program);
		admin.activate_program();
	}
	
	@Test (priority = 2, enabled = true)
	public void verifying_send_swag_with_campaign_association()
	{
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name);
		salsesforcePage.click_program_on_send_swag_screen(admin_bd_auto_product_1, program_name);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
		
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name);
		salsesforcePage.click_program_on_send_swag_screen(admin_bd_auto_product_2, program_name);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
	}
	
	@Test (priority = 3, enabled = true)
	public void delete_order_send_swag()
	{
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		salsesforcePage.delete_order(admin_bd_auto_product_2, program_name, order_status);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		homePage.logout(driver);
		closebrowser();
	}

	
}
