package com.pfl.automation.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.*;
import com.pfl.automation.utils.Constants;


public class TS03_Verify_order_on_contact_and_account extends BaseTest{

	AdminPage ad1;
	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	HomePage homePage;

	static String program_string = "Random_auto_program";
	String admin_bd_auto_product_1 = "PFL_Auto_Product1";
	String product_qty = "2";
	String product_count = "1";
	String p_count = "1";
	String admin_pfl_bd_auto_user_first_name = "Testing";
	String order_status = "Submitted";
	
	
	static long time = get_timestamp();
	static String program_name = program_string + time;
	
	@BeforeMethod
	public void testUp() throws Exception
	{
		openBrowser();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		//openBrowser();
		loginPage.logintoapplication(Constants.username, Constants.password);
	}
	
	@Test (priority = 1)
	//(retryAnalyzer=DynamicRetryAnalyzer.class)
	public void create_setup_program()
	{
		System.out.println("TC02");
		salsesforcePage = new SalesforcePage(driver);
		System.out.println("initialize chromerdriver within salesforce page ");
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
//		long time = get_timestamp();
//		String program_name = program_string + time;
		ad1 = new AdminPage(driver);
		ad1.click_program_admin_tile();
		System.out.println("initialize chromerdriver within admin page ");
		ad1.create_new_program(program_name, admin_bd_auto_product_1, product_qty, product_count, admin_pfl_bd_auto_user_first_name);		
	}
	
	@Test (priority = 2)
	//(retryAnalyzer=DynamicRetryAnalyzer.class)
	public void verifying_contact_address_send_swag()
	{
		salsesforcePage = new SalesforcePage(driver);
		System.out.println("successfully initialized ");
		swagiq = new SwagIQPage(driver);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name);
		salsesforcePage.click_program_on_send_swag_screen(program_name);
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
	}
	
	@Test (priority = 3, enabled = true)
	//(retryAnalyzer=DynamicRetryAnalyzer.class)
	public void verifying_account_address_send_swag()
	{
		salsesforcePage = new SalesforcePage(driver);
		System.out.println("successfully initialized ");
		swagiq = new SwagIQPage(driver);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_account_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(program_name);
		salsesforcePage.click_program_on_send_swag_screen(program_name);
		//salsesforcePage.go_inside_iframe();
		swagiq.click_next_button_send_swag();
		swagiq.click_send_marketing_confirmation_msg();
		swagiq.click_send_marketing_materials_button();
		swagiq.order_confirmation_msg();
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		homePage.logout(driver);
		closebrowser();
	}
	
	@Test (priority = 4)
	public void delete_order_send_swag()
	{
		salsesforcePage = new SalesforcePage(driver);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
		salsesforcePage.delete_order(admin_bd_auto_product_1, program_name, order_status);
	}
	
	
}
