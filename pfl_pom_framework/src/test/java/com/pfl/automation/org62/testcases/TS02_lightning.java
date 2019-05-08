package com.pfl.automation.org62.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.base.BaseTest;

public class TS02_lightning extends BaseTest{
	
static String admin_bd_auto_product_1 = "PFL_Auto_Product1";
static By sflt_lightning_icon = By.cssSelector("a.switch-to-lightning");

	
	@Test(priority=0, alwaysRun = true)
	public void TC01() throws Exception {
		loginPage.logintoapplication(Constants.username1, Constants.password1);	
		salsesforcePage.sflt_verify_lightning_page(Constants.sflt_app_launcher, Constants.sflt_lightning_icon);	
		salsesforcePage.open_tab_lightng(Constants.tab_contacts);
		salsesforcePage.sflt_select_view(Constants.pfl_contact_view);
		salsesforcePage.sflt_open_contact(Constants.con_bd_auto_contact_first_name, Constants.con_bd_auto_contact_last_name);
		salsesforcePage.click_sendswagbutton();
		salsesforcePage.sflt_select_contact_address();
		salsesforcePage.sflt_use_this_address();
		salsesforcePage.sflt_verify_program_on_contact_send_marketing_page(admin_bd_auto_program_1, admin_bd_auto_product_1);
		homePage.logout_sflt();

	}
}