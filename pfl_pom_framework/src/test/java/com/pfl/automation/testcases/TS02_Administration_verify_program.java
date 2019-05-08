//************ This test case will perform send swag functionality*************** //

package com.pfl.automation.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.reruntest.DynamicRetryAnalyzer;

//import practice.pfl_framework.lib.product_lib.Salesforce;

public class TS02_Administration_verify_program extends BaseTest{
	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	HomePage homePage;
	public String admin_bd_auto_program_1 = "PFL_Auto_Program_Deepak";


	@BeforeMethod
	public void testUp() throws Exception
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		openBrowser();
		loginPage.logintoapplication(Constants.username, Constants.password);
	}
	
	@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
	public void TC01() {
		System.out.println("TC01");
		
		salsesforcePage = new SalesforcePage(driver);
		System.out.println("successfully initialized ");
		swagiq = new SwagIQPage(driver);
		salsesforcePage.open_tab(Constants.tab_contacts);
		salsesforcePage.selectview(Constants.pfl_contact_view);
		salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.select_contact_address();
		salsesforcePage.use_this_address();
		salsesforcePage.verify_program_on_contact_send_marketing_page(admin_bd_auto_program_1);
		salsesforcePage.click_program_on_send_swag_screen(salsesforcePage.admin_bd_auto_program_1);
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
}
