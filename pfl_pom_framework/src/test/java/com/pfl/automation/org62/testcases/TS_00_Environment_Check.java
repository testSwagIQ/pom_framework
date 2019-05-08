package com.pfl.automation.org62.testcases;

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;

public class TS_00_Environment_Check extends BaseTest {
	
	@Test(priority=0, alwaysRun = true)
	public void TS_08_01_Verify_the_header_SwagIQ_Licenses_Administration_of_License_tab() throws Exception {
		Log.startTestCase("TS_00_Environment_Check");
		loginPage.logintoapplication(Constants.username, Constants.password);

		//homePage.logout(driver);
		Log.endTestCase("TS_00_Environment_Check");
	}

}
