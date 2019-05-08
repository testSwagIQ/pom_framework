package com.pfl.automation.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS17_Verify_Do_Not_Swag extends BaseTest  {
	
	SalesforcePage salsesforcePage;
	HomePage homePage;
	LoginPage loginPage;
	

	@BeforeMethod
	public void setUp() throws Exception {
		log4j_config();
		readxmlDataFile();
		
		openBrowser();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		salsesforcePage = new SalesforcePage(driver);
		
		Log.info("Username picked from Constants Class is "+ Constants.username );
		Log.info("Password picked from Constants Class is "+ Constants.password );
		loginPage.logintoapplication(Constants.username, Constants.password);
	}
	
	   @Test
		public void TC17() throws Exception 
		{
			System.out.println("TC17");
			
			System.out.println("initialize chromerdriver within salesforce page ");
			salsesforcePage.open_tab(Constants.tab_contacts);
			salsesforcePage.selectview(Constants.pfl_contact_view);
			System.out.println ("selected view successfully");
			salsesforcePage.opencontact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
			System.out.println ("open contact successfully");
			salsesforcePage.set_do_not_swag_checkbox_as_checked(driver);			
			salsesforcePage.click_sendswagbutton();
			Assert.assertEquals("Send Swag not available", salsesforcePage.con_send_swag_not_avbl_message(driver));
			salsesforcePage.click_send_swag_back_pop_up(driver);
			salsesforcePage.set_do_not_swag_checkbox_as_unchecked(driver);
			
		}
	   
		@AfterMethod
		public void tearDown() throws Exception {
			homePage.logout(driver);
			Log.info("Logout Successfully");
			closebrowser();
	        Log.info("Browser closed");
		}
}
