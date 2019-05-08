package com.pfl.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			findElement(driver, logout_dropdown).click();
			findElement(driver, logout_link).click();
			try {
				WebDriverWait wait = new WebDriverWait(driver, 2);
			    wait.until(ExpectedConditions.alertIsPresent());
			    Alert alert = driver.switchTo().alert();
			    System.out.println(alert.getText());
			    alert.dismiss();
				//driver.switchTo().alert().dismiss();
			} catch(Exception e){
				System.out.println("No alert");	
			}
			
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
}
