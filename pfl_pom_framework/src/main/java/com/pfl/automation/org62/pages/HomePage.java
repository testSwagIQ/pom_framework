package com.pfl.automation.org62.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pfl.automation.base.BasePage;

public class HomePage extends BasePage {
	
	By all_tabs = By.xpath("//img[contains(@title, 'All Tabs')]");
	By list_view_drop_down = By.xpath("//select[@name='fcf']");
	By go_button = By.xpath("//input[@name='go']");
	By logout_dropdown = By.cssSelector("span[id='userNavLabel']");
	By logout_link = By.cssSelector("a[title='Logout']");
	
	By all_tab = By.xpath("//img[contains(@title, 'All Tabs')]");
	
	//*************************Initilize Constructor *********************************
	
		public HomePage(WebDriver driver1) {
			this.driver = driver1;
		}
		
	//*************************Declare Page Methods*********************************
		
		public void logout(WebDriver driver) throws Exception {
			driver.switchTo().defaultContent();
			wait_min();
			clickElement(driver, logout_dropdown);
			clickElement(driver, logout_link);
			
			waitForPageToLoad1(driver);
			System.out.println("Logged out successfully");			
		}
		
		
		//***********************Rani****************
		public void popup_blocker() {
			driver.switchTo().alert().dismiss();
		}
		
		
		public void click_all_tab(WebDriver driver)throws Exception {
			clickElement(driver, all_tab);
		}
		
		//*************Deepak Sharma*****************//
		
		public void logout_sflt() throws Exception
		{
			driver.switchTo().defaultContent();
			wait_min();
			clickElement(driver, sflt_logout_button_image);
			clickElement(driver, sflt_logout_link_text);
		}
}
