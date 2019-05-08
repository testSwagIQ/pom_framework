package com.pfl.automation.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LicensePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS11_advance_search_functionality extends BaseTest {
		HomePage homePage;
		LoginPage loginPage;
		LicensePage licensePage;	
		
		//@BeforeMethod(groups = { "smoke", "regression"})
		//@Parameters("browser")
		
		@BeforeMethod
		public void Setup() throws Exception {
			openBrowser();

			loginPage = new LoginPage(driver);
			homePage = new HomePage(driver);
			licensePage = new LicensePage(driver);
			
			loginPage.logintoapplication(Constants.username, Constants.password);
		}
		
		//@Test (retryAnalyzer=DynamicRetryAnalyzer.class)
		//@TestRailCase(automationId="testA1")
		@Test
		public void test() throws Exception {
			Log.startTestCase("TS1_Verify_license_UI");
			licensePage.click_licsensetab(driver);
			licensePage.verifyLicenseTabs(driver);
			Log.endTestCase("TS1_Verify_license_UI");
			
			System.out.println("Test Case Pass !");
			writeResults_File(driver, "TS1_Verify_license_UI", "Pass");
			System.out.println(prop.getProperty("testRail.url"));
		}
		
		/*//@Test (groups = {"regression"})
		@Test
		public void TS2_Verify_simple_search_and_advance_search_on_license_page() throws Exception {
			Log.startTestCase("TS2_Verify_simple_search_and_advance_search_on_license_page");
			
			licensePage.click_licsensetab(driver);
			licensePage.Searchbyname(driver, search_name);
			licensePage.getNameText(driver, "user_4, Automation");	
			
			System.out.println("Test Case Pass !");
			Log.endTestCase("TS2_Verify_simple_search_and_advance_search_on_license_page");
		}*/
		
		@AfterMethod
		public void tearDown(ITestResult result) throws Exception {
			//Call Program to Capture screenshot in selenium for failed test cases
			taketestCaseScreenshot(driver, result.getMethod().getMethodName());
			
			homePage.logout(driver);
			Log.info("Logout Successfully");
			closebrowser();
	        Log.info("Browser closed");
		}
}
