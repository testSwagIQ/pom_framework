package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;
import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS01_Administration_AssertTiles extends BaseTest {
		
		@Test(priority=0, alwaysRun = true)
		public void TS_01_01_Verify_administration_tiles() throws Exception {
			Log.startTestCase("TS1_Verify_administration_tiles");
			System.out.println("logging in TS01 first @test method");
			loginPage.logintoapplication(Constants.username, Constants.password);
			swagiq.verifyTilesAdministration(driver);
			homePage.logout(driver);
			System.out.println("logging out from TS01 first @test method");
			Log.endTestCase("TS1_Verify_administration_tiles");
		}
		
		//@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
		@Test(priority=1, alwaysRun = true)
		public void TS_01_02_Verify_presence_of_different_components_on_Program_administration_page() throws Exception {
			Log.startTestCase("TS2_Verify_presence_of_different_components_on_Program_administration_page");
			System.out.println("logging in TS01 second @test method");
			loginPage.logintoapplication(Constants.username, Constants.password);
			swagiq.Click_ProgramAdministration(driver);
			programAdminPage.verifyProgramAdministration(driver);
			homePage.logout(driver);
			System.out.println("logging out from TS01 second @test method");
			Log.endTestCase("TS2_Verify_presence_of_different_components_on_Program_administration_page");
		}
		
		//@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
		@Test(priority=2, alwaysRun = true, enabled=false)
		public void TS_01_03_Verify_presence_of_different_components_on_User_administration_page() throws Exception {
			Log.startTestCase("TS3_Verify_presence_of_different_components_on_User_administration_page");
			loginPage.logintoapplication(Constants.username, Constants.password);
			swagiq.Click_UserAdministration(driver);
			userAdminPage.verifyUserAdministration(driver);
			homePage.logout(driver);
			Log.endTestCase("TS3_Verify_presence_of_different_components_on_User_administration_page");
		}
		
		//@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
		@Test(priority=3, alwaysRun = true, enabled=false)
		public void TS_01_04_Verify_presence_of_different_components_on_Product_administration_page() throws Exception {
			Log.startTestCase("TS4_Verify_presence_of_different_components_on_Product_administration_page");
			loginPage.logintoapplication(Constants.username, Constants.password);
			swagiq.Click_ProductAdministration(driver);
			productAdministrationPage.verifyProductAdministration(driver);
			homePage.logout(driver);
			Log.endTestCase("TS4_Verify_presence_of_different_components_on_Product_administration_page");
			
		}
}