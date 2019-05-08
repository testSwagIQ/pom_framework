package com.pfl.automation.org62.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pfl.automation.base.BasePage;

public class ProgramAdministrationPage extends BasePage {
	
		//*************************Declare Locators*********************************
		
		By licenses_link_xpath = By.xpath("//a[text()='Licenses']");
		By administration_link_xpath = By.xpath("//a[text()='Administration']");
		By admin_program_name_column  = By.xpath("//th[@title='Name']");
		By admin_program_product_column = By.xpath("//th[@title='Product']");
		By admin_program_campaign_name_column = By.xpath("//th[@title='Campaign Name']");
		By admin_program_budget_column  = By.xpath("//th[@title='Total Budget']");
		By admin_program_created_column  = By.xpath("//th[@title='Created']");
		By admin_program_updated_column  = By.xpath("//th[@title='Updated']");
		By admin_program_active_column  = By.xpath("//th[@title='Active']");
		By admin_program_New_Program  = By.xpath("//text()[contains(.,'New Program')]/ancestor::button[1]");
		By admin_program_input_textbox  = By.xpath("//input[@type='text'][@name='inputSearch']");
		By admin_program_product_name  = By.xpath("//a[text()='Metacube1']");
	
	    
		//*************************Initilize Constructor *********************************
		
		public ProgramAdministrationPage(WebDriver driver1) {
			this.driver = driver1;
		}
	    
	    //*************************Declare Page Methods *********************************
	    
	    public void verifyProgramAdministration(WebDriver driver) throws Exception {
			assertTrue(isElementVisible(driver, licenses_link_xpath));
			assertTrue(isElementVisible(driver, administration_link_xpath));
			
			switchToFrame(driver);
			
			assertTrue(isElementVisible(driver, admin_program_name_column));
			assertTrue(isElementVisible(driver, admin_program_product_column));
			assertTrue(isElementVisible(driver, admin_program_campaign_name_column));
			assertTrue(isElementVisible(driver, admin_program_budget_column));
			assertTrue(isElementVisible(driver, admin_program_created_column));
			assertTrue(isElementVisible(driver, admin_program_updated_column));
			assertTrue(isElementVisible(driver, admin_program_active_column));
			assertTrue(isElementVisible(driver, admin_program_New_Program));
			assertTrue(isElementVisible(driver, admin_program_input_textbox));
			
			driver.switchTo().defaultContent();
		}
		
		public void Click_NewProgram_ProgramAdministration(WebDriver driver) throws Exception {
			switchToFrame(driver);
			clickElement(driver, admin_program_New_Program);
			driver.switchTo().defaultContent();
		}
		
		public void Click_ProductName_ProgramAdministration(WebDriver driver) throws Exception {
			switchToFrame(driver);
			clickElement(driver, admin_program_product_name);
			driver.switchTo().defaultContent();
		}
		
		public void Click_NameColumn_ProgramAdministration(WebDriver driver) throws Exception {
			switchToFrame(driver);
			clickElement(driver, admin_program_name_column);
			driver.switchTo().defaultContent();
		}
		
		public void Click_CreatedColumn_ProgramAdministration(WebDriver driver) throws Exception {
			switchToFrame(driver);
			clickElement(driver, admin_program_created_column);
			driver.switchTo().defaultContent();
		}
		
		public void Click_UpdatedColumn_ProgramAdministration(WebDriver driver) throws Exception {
			switchToFrame(driver);
			clickElement(driver, admin_program_updated_column);
			driver.switchTo().defaultContent();
		}
		
		public void Click_ActiveColumn_ProgramAdministration(WebDriver driver) throws Exception {
			switchToFrame(driver);
			clickElement(driver, admin_program_active_column);
			driver.switchTo().defaultContent();
		}
		
		public void Search_ProgramAdministration(WebDriver driver, String text) throws Exception {
			switchToFrame(driver);
			enterText(driver, admin_program_input_textbox,"text");
			driver.switchTo().defaultContent();
		}				
}
