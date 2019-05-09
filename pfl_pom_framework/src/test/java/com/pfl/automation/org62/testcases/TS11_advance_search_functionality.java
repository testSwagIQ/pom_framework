package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS11_advance_search_functionality extends BaseTest {

	// @BeforeMethod(groups = { "smoke", "regression"})
	// @Parameters("browser")
	// @Test (retryAnalyzer=DynamicRetryAnalyzer.class)
	// @TestRailCase(automationId="testA1")

	@Test(priority = 0, alwaysRun = true)
	public void TS11_01_Verify_license_page() throws Exception {
		Log.startTestCase("TS1_Verify_license_UI");
		loginPage.logintoapplication(Constants.username, Constants.password);
		licensepage.click_licsensetab(driver);
		licensepage.verifyLicenseTabs(driver);
		homePage.logout(driver);
		Log.endTestCase("TS1_Verify_license_UI");

		writeResults_File(driver, "TS1_Verify_license_UI", "Pass");
		System.out.println(prop.getProperty("testRail.url"));
	}

	@Test(priority = 1, alwaysRun = true)
	public void TS11_02_Verify_simple_search_and_advance_search_on_license_page() throws Exception {
		Log.startTestCase("TS2_Verify_simple_search_and_advance_search_on_license_page");
		loginPage.logintoapplication(Constants.username, Constants.password);
		licensepage.click_licsensetab(driver);
		licensepage.Searchbyname(driver, licensename);
		licensepage.getNameText(driver, "  user_4, Automation");
		homePage.logout(driver);
		Log.endTestCase("TS2_Verify_simple_search_and_advance_search_on_license_page");
	}
}
