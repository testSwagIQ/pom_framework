package com.pfl.automation.pages;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pfl.automation.base.BasePage;
import com.pfl.automation.utils.Constants;

public class SwagIQPage extends BasePage {

	SalesforcePage sf = new SalesforcePage(driver);
	
	By next_send_swag_button = By.xpath("(//button[contains(text(), 'Next >')])[1]");
	By send_marketing_confirmation_checkbox = By.cssSelector("input[id='confirmation']");
	By send_marketing_materials_button  = By.cssSelector("button[id='sendButton'][type = 'submit']");
	By send_swag_confirmation_msg_text = By.xpath("//div[contains(text(),'You will receive a follow-up task once it has been delivered')]");
	By send_swag_confirmation_ok_button  = By.xpath("//div/button[contains(.,'OK')]");
	
	By allTabs_image_xpath = By.xpath("//img[@title='All Tabs']");
	By swagiqOrders_link_xpath = By.xpath("//a[text()='SwagIQ Orders']");
	By swagiqTools_link_xpath = By.xpath("//a[text()='SwagIQ Tools']");
	By switchToLightning_link_xpath = By.xpath("//text()[.='Switch to Lightning Experience']/ancestor::a[1]");
	By licenses_link_xpath = By.xpath("//a[text()='Licenses']");
	By administration_link_xpath = By.xpath("//a[text()='Administration']");
	By storeSettings_xpath = By.xpath("//div[contains(text(),'Store Settings')]");
	By programAdministration_xpath = By.xpath("//div[contains(text(),'Program Administration')]");
	By productAdministration_xpath = By.xpath("//div[contains(text(),'Product Administration')]");
	By userAdministration_xpath = By.xpath("//div[contains(text(),'User Administration')]");
	By viewAndUpdate_xpath = By.xpath("//li[text()='View and update Company Information']");
	By createAndEdit_xpath = By.xpath("//li[text()='Create and edit programs']");
	
	By viewPrograms_xpath = By.xpath("//li[text()='View programs']");
	By activateAndInactivateProducts_xpath = By.xpath("//li[text()='Activate and inactivate products']");
	By editProductBudget_xpath = By.xpath("//li[text()='Edit product budget amounts']");
	By viewProducts_xpath = By.xpath("\"//li[text()='View products']");
	By activateAndInactivateUsers_xpath = By.xpath("//li[text()='Activate and inactivate users']");
	By addAndEdit_xpath = By.xpath("//li[text()='Add and edit users']");
	
	By Element_image_xpath = By.xpath("//img[@src='/content/images/pfllogo128.png']");
	By StoreIcon_xpath = By.xpath("//*[@class='pmc-aside-section-icon fa fa-cog']");
	By ProgramsIcon_link_xpath = By.xpath("//text()[contains(.,'Programs')]/ancestor::a[1]");
	By productsIcon_link_xpath = By.xpath("//*[@class='pmc-aside-section-icon fa fa-file-alt']");
	By UsersIcon_link_xpath = By.xpath("//*[@class='pmc-aside-section-icon fa fa-file-alt']");
	By AdminIcon_link_xpath = By.xpath("//*[@class='pmc-aside-section-icon fa fa-users']");
	By ToggleSideBarIcon_xpath = By.xpath("//*[@class='pmc-aside-section-icon fa fa-users']");
	
	public SwagIQPage(WebDriver driver) {
		this.driver = driver;
	}
			
	public void click_next_button_send_swag() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("I am going to click on next button");
		boolean visibility = findElement(driver, next_send_swag_button).isDisplayed();
		System.out.println("visibility of the element is " +visibility);
		findElement(driver, next_send_swag_button).click();
		System.out.println("clicked on next button during send marketing materials");
	}
		
	public void click_send_marketing_confirmation_msg() {
		findElement(driver, send_marketing_confirmation_checkbox).click();
		System.out.println("clicked on send marketing materials checkbox during send swag");
	}
	
	public void click_send_marketing_materials_button() {
		findElement(driver, send_marketing_materials_button).click();
		System.out.println("clicked on send marketing materials button during send swag");
	}
	
	public void order_confirmation_msg() {
		//WebElement searched_element = findElement(driver, send_swag_confirmation_msg_text);
		Boolean result = isElementVisible(driver, send_swag_confirmation_msg_text);
		sf.assert_value_n_report_result(true, result, Constants.validation_message);
		findElement(driver, send_swag_confirmation_ok_button).click();
	}
	
	public void verifyTilesAdministration(WebDriver driver) {
		
		assertTrue(isElementVisible(driver, allTabs_image_xpath));
		assertTrue(isElementVisible(driver, swagiqOrders_link_xpath));
		assertTrue(isElementVisible(driver, swagiqTools_link_xpath));
		assertTrue(isElementVisible(driver, switchToLightning_link_xpath));
		assertTrue(isElementVisible(driver, licenses_link_xpath));
		assertTrue(isElementVisible(driver, administration_link_xpath));
		
		switchToFrame(driver);
		
		assertTrue(isElementVisible(driver, storeSettings_xpath));
		assertTrue(isElementVisible(driver, programAdministration_xpath));
		assertTrue(isElementVisible(driver, productAdministration_xpath));
		assertTrue(isElementVisible(driver, userAdministration_xpath));
		assertTrue(isElementVisible(driver, viewAndUpdate_xpath));
		assertTrue(isElementVisible(driver, createAndEdit_xpath));
		assertTrue(isElementVisible(driver, viewPrograms_xpath));
		assertTrue(isElementVisible(driver, activateAndInactivateProducts_xpath));
		assertTrue(isElementVisible(driver, editProductBudget_xpath));
		assertTrue(isElementVisible(driver, viewProducts_xpath));
		assertTrue(isElementVisible(driver, activateAndInactivateUsers_xpath));
		assertTrue(isElementVisible(driver, addAndEdit_xpath));
		assertTrue(isElementVisible(driver, viewPrograms_xpath));
		assertTrue(isElementVisible(driver, activateAndInactivateProducts_xpath));
		assertTrue(isElementVisible(driver, addAndEdit_xpath));
		assertTrue(isElementVisible(driver, Element_image_xpath	));
		assertTrue(isElementVisible(driver, StoreIcon_xpath));
		assertTrue(isElementVisible(driver, ProgramsIcon_link_xpath));
		assertTrue(isElementVisible(driver, productsIcon_link_xpath));
		assertTrue(isElementVisible(driver, UsersIcon_link_xpath));
		assertTrue(isElementVisible(driver, AdminIcon_link_xpath));
		
		driver.switchTo().defaultContent();
	}
	
	public void Click_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, userAdministration_xpath);
		waitForPageToLoad();
		driver.switchTo().defaultContent();
	}
	
	public void Click_ProductAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, productAdministration_xpath);
		waitForPageToLoad();
		driver.switchTo().defaultContent();
	}
	
	public void Click_ProgramAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, programAdministration_xpath);
		waitForPageToLoad();
		driver.switchTo().defaultContent();
	}
	
	public void Click_StoreSetting(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, storeSettings_xpath);
		waitForPageToLoad();
		driver.switchTo().defaultContent();
	}	
	
	public void Click_License(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, storeSettings_xpath);
		waitForPageToLoad();
		driver.switchTo().defaultContent();
	}	
}
