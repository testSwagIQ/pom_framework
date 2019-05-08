package com.pfl.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LicensePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.utils.Constants;

public class TS_08_verify_changes_when_swagig_license_assign extends BaseTest {

	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	LicensePage licensepage;
	HomePage homePage;
	

	@BeforeMethod
	public void testtUp() throws Exception {
		openBrowser();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		salsesforcePage = new SalesforcePage(driver);
		
		licensepage = new LicensePage(driver);

		loginPage.logintoapplication(Constants.username, Constants.password);

	}

	@Test
	public void TS_01_Verify_the_header_SwagIQ_Licenses_Administration_of_License_tab() throws Exception {

		homePage.click_all_tab(driver);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		licensepage.click_licsensetab(driver);
		licensepage.get_license_user_value(driver);
		licensepage.assign_license_to_user(driver, Constants.un_license_user);
		licensepage.verify_modified_user_count(driver);
		licensepage.click_save_button(driver);
		licensepage.verify_license_check_box_checked(driver, Constants.un_license_user);
		licensepage.verify_license_user_count(driver);
		licensepage.get_license_count_difference(driver);
		homePage.logout(driver);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		
		loginPage.logintoapplication(Constants.username, Constants.password);
		homePage.click_all_tab(driver);
		salsesforcePage.open_tab(Constants.tab_swagiq_tools);
		licensepage.click_licsensetab(driver);
		licensepage.remove_license_from_user(driver, Constants.un_license_user);
		licensepage.click_save_button(driver);
		homePage.logout(driver);
		closebrowser();
	}

}
