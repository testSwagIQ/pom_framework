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

public class TS12_Verfying_license_tab_enable_checkbox extends BaseTest {

	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	LicensePage licensepage;
	HomePage homePage;

	@BeforeMethod
	public void testUp() throws Exception {
		openBrowser();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		licensepage = new LicensePage(driver);

		loginPage.logintoapplication(Constants.username, Constants.password);

	}

	@Test
	public void TS_01_Verify_clicking_select_all_enabled_checkbox_on_Licenses_page_functionality() throws Exception {
		// homePage.popup_blocker();
		licensepage.click_licsensetab(driver);
		licensepage.disable_license_to_all_user(driver);
		licensepage.enabale_license_to_all_user(driver);
		licensepage.metch_lic_total_count(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		homePage.logout(driver);
		closebrowser();
	}

}
