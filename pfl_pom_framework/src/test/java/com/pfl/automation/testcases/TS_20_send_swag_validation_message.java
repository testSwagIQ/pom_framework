package com.pfl.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.pages.ContactPage;
import com.pfl.automation.pages.HomePage;
import com.pfl.automation.pages.LicensePage;
import com.pfl.automation.pages.LoginPage;
import com.pfl.automation.pages.SalesforcePage;
import com.pfl.automation.pages.SwagIQPage;
import com.pfl.automation.utils.Constants;

public class TS_20_send_swag_validation_message extends BaseTest {
	
	SalesforcePage salsesforcePage;
	SwagIQPage swagiq;
	LoginPage loginPage;
	LicensePage licensepage;
	HomePage homePage;
	ContactPage contactpage;

	@BeforeMethod
	public void testtUp() throws Exception {
		openBrowser();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		salsesforcePage = new SalesforcePage(driver);
		contactpage = new ContactPage(driver);	
		
		

		loginPage.logintoapplication(Constants.sfauser, Constants.sfapass);

	}

	@Test
	public void TS_01_Verify_that_validation_message_displayed_to_user_if_no_program_is_associated_to_user_on_send_swag_screen() throws Exception
	{
	
		
		homePage.click_all_tab(driver);
		salsesforcePage.open_tab(Constants.tab_contacts);
		contactpage.opencontact(Constants.first_name, Constants.lasr_name);
		contactpage.click_on_send_marketing_button();
		contactpage.select_contact_address();
		contactpage.use_this_address();
		contactpage.verify_error_message();		
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		homePage.logout(driver);
		closebrowser();
	}

	

}
