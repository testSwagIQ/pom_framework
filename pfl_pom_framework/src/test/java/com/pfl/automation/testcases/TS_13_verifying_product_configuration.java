package com.pfl.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.AdminPage;
import com.pfl.automation.pages.ContactPage;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LicensePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.utils.Constants;

public class TS_13_verifying_product_configuration extends BaseTest {

	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	LicensePage licensepage;
	HomePage homePage;
	ContactPage contactpage;
	AdminPage adminpage;
	
	static String program_string = "Random_auto_program";
	static long time = get_timestamp();
	static String program_name = program_string + time;

	@BeforeMethod
	public void testtUp() throws Exception {
		openBrowser();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		salsesforcePage = new SalesforcePage(driver);
		contactpage = new ContactPage(driver);
		adminpage = new AdminPage(driver);

		loginPage.logintoapplication(Constants.username, Constants.password);

	}

	@Test
	public void TS_01_Verify_Product_Configuration_Display_Name_or_Quantity_Under_Product_Administration()
			throws Exception {
		homePage.click_all_tab(driver);
		salsesforcePage.open_tab(Constants.tab_swag_iq_tool);
		adminpage.click_on_product_admin_tile(driver);
		adminpage.click_on_product_search_bar_on_Pro_Administration(driver, Constants.product_name);
		adminpage.click_product_detail_section(driver, Constants.product_name);
		adminpage. get_unallocated_product_quantity(driver);
		adminpage.click_active_product(driver);
		salsesforcePage.open_tab(Constants.tab_swag_iq_tool);
		adminpage.click_program_admin_tile(driver);
		adminpage.click_new_program_button(driver);
		adminpage.set_program_name(driver, program_name);
		//adminpage.click_on_program_ok(driver);
		adminpage.add_program_product(driver, Constants.product_count, Constants.product_name);
		adminpage.click_on_available_budget_refresh_button(driver, Constants.product_count);
		adminpage.get_product_count_on_program_page(driver);
		adminpage.compare_value();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		homePage.logout(driver);
		closebrowser();
	}

}
