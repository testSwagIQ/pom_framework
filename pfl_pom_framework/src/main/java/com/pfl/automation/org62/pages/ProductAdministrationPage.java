package com.pfl.automation.org62.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pfl.automation.base.BasePage;

public class ProductAdministrationPage extends BasePage {
	
			//*************************Declare Locators*********************************
	
			By licenses_link_xpath = By.xpath("//a[text()='Licenses']");
			By administration_link_xpath = By.xpath("//a[text()='Administration']");
			By admin_Product_product_column = By.xpath("//th[@title='Product']/span");
			By admin_Product_budget_column  = By.xpath("//th[@title='Budgeted Quantity / Amount ($)']/span");
			By admin_Product_allocated_column = By.xpath("//th[@title='Allocated Quantity / Amount ($)']/span");
			By admin_Product_active_column = By.xpath("//th[@title='Active']");
			By admin_Product_input_textbox = By.xpath("//input[@type='text'][@id='inputSearchAssetsLg']");
			By admin_Product_product_name = By.xpath("//a[text()='Metacube1']"); 
		
		    
			//*************************Initilize Constructor *********************************
			
			public ProductAdministrationPage(WebDriver driver1) {
				this.driver = driver1;
			}
		    
		    //*************************Declare Page Methods *********************************
		    
		    public void verifyProductAdministration(WebDriver driver) throws Exception {
				assertTrue(isElementVisible(driver, licenses_link_xpath));
				assertTrue(isElementVisible(driver, administration_link_xpath));
				
				switchToFrame(driver);
		
				assertTrue(isElementVisible(driver, admin_Product_product_column));
				assertTrue(isElementVisible(driver, admin_Product_budget_column));
				assertTrue(isElementVisible(driver, admin_Product_allocated_column));
				assertTrue(isElementVisible(driver, admin_Product_active_column));
				assertTrue(isElementVisible(driver, admin_Product_input_textbox));
				assertTrue(isElementVisible(driver, admin_Product_product_name));
				
				driver.switchTo().defaultContent();
			}
		    
		    public void Click_ProductName_ProductAdministration(WebDriver driver) throws Exception {
				switchToFrame(driver);
				clickElement(driver, admin_Product_product_column);
				driver.switchTo().defaultContent();
			}
			
			public void Click_BudegetedColumn_ProductAdministration(WebDriver driver) throws Exception {
				switchToFrame(driver);
				clickElement(driver, admin_Product_budget_column);
				driver.switchTo().defaultContent();
			}
			
			public void Click_AllocatedColumn_ProductAdministration(WebDriver driver) throws Exception {
				switchToFrame(driver);
				clickElement(driver, admin_Product_allocated_column);
				driver.switchTo().defaultContent();
			}
			
			public void Click_ActiveColumn_ProductAdministration(WebDriver driver) throws Exception {
				switchToFrame(driver);
				clickElement(driver, admin_Product_active_column);
				driver.switchTo().defaultContent();
			}
			
			public void Search_ProductAdministration(WebDriver driver, String text) throws Exception {
				switchToFrame(driver);
				enterText(driver, admin_Product_product_name,"text");
				driver.switchTo().defaultContent();
			}
}
