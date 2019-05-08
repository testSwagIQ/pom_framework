package com.pfl.automation.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.pfl.automation.base.BasePage;

public class LicensePage extends BasePage {

	List<WebElement> list = null;
	int total_count = 0;
	int total_lic_count = 0;
	String disable_use_count, enable_use_count, modified_user_count, license_user_count_after_assignment,
			lic_count_before_assignment = null;

	
	By licenses_tab = By.xpath("//a[contains(text(),'Licenses')]");
	By licenses_page_header = By.xpath("//b[contains(text(),'SwagIQ - Licenses Administration')]");
	By save_button = By.xpath("//a[contains(text(), 'Save')]");
	By user_access_type = By
			.xpath("//td[contains(@title, 'Dayon Andrade, Rafael')]/..//select[@disabled = 'disabled']");
	By used_licenses = By.xpath("//span[contains(text(), 'Used Licenses')]");
	By licenses_settings_icon = By.xpath("//section[@id='toggle-settings']");
	By licenses_search_text_box = By.xpath("//*[@id='lookup-01']");
	By licenses_advance_text_box_for_name = By.xpath("//div/input[@placeholder='Search Users by Name']");
	By license_tab_text = By.xpath("//span/b[contains(.,'SwagIQ - Licenses Administration')]");
	By license_tab_user_list = By.xpath("//thead/following-sibling::tbody/tr[1]");
	By license_advance_search_button = By.xpath("//a[@id='advanced-search-button']");
	By license_clear_button = By.xpath("//a[contains(.,'Clear')]");
	By license_user_not_found_message = By.xpath("//h1[contains(.,'Users not found.')]");
	By license_check_box_checked = By.xpath("//span[text() = 'Profile']/..//input[(contains(@class, 'ng-not-empty'))]");
	By license_all_user_lic_enabled = By
			.xpath("//span[contains(@title , 'Enabled')]/..//input[(contains(@class, 'ng-not-empty'))]");
	By license_save_button = By.xpath("//a[@id='savebutton']");
	By license_tab_locator = By.xpath("//a[@href='#licenses']");
	By license_used_lic_count = By.xpath("//span[contains(text(), 'Used Licenses')]/..//span[2]/span");
	By license_status = By.xpath("//span[text()='License Status']");
	By license_Expiration = By.xpath("//span[text()='Licenses Expiration']");
	By license_TotalLicenses = By.xpath("//span[text()='Total Licenses']");
	By license_search_icon = By.xpath("//*[@class='slds-input__icon slds-icon-text-default']");
	By license_search_tabel = By.xpath(
			"//table[@class=\"slds-table slds-table--bordered slds-max-medium-table--stacked-horizontal slds-m-bottom--small\"]");

	By license_nameColumn = By.cssSelector("span[title='Name']");
	By license_titleColumn = By.cssSelector("span[title='title']");
	By license_profileColumn = By.cssSelector("span[title='Profile']");
	By license_roleColumn = By.cssSelector("span[title='Role']");
	By license_countryColumn = By.cssSelector("span[title='Country']");
	By license_regionColumn = By.cssSelector("span[title='Region']");
	By license_costcenterColumn = By.cssSelector("span[title='Cost Center']");
	By license_SwagIQAdminAccessColumn = By.cssSelector("span[title='SwagIQ Admin Access']");
	
	
	
	//***************Rani***********************
	
	By license_enable_tab = By.cssSelector("span[title='Enabled']");
	By license_check_box = By.xpath("//a[@class='slds-th__action slds-text-link--reset']//span[@class='slds-checkbox--faux']");
	By license_modified_user_count = By.xpath("//span[contains(text(), 'Modified Users')]/..//span[2]/span");
	By license_total_user_count = By.xpath(" //span[contains(text(), 'Used Licenses')]/..//span[2]/span");

	
	
	
	// *************************Initilize Constructor
	// *********************************

	public LicensePage(WebDriver driver1) {
		this.driver = driver1;
	}

	// *************************Declare Page
	// Methods*********************************

	public void click_licsensetab(WebDriver driver) throws Exception {
		clickElement(driver, licenses_tab);
		waitForPageToLoad1(driver);
	}

	public void Searchbyname(WebDriver driver, String SearchCriteria) throws Exception {
		// switchToFrame(driver);
		enterText(driver, licenses_search_text_box, SearchCriteria);
		clickElement(driver, license_search_icon);
		waitForPageToLoad1(driver);
		// driver.switchTo().defaultContent();
	}

	public void getNameText(WebDriver driver, String nameText) {
		List<WebElement> nameList = driver.findElements(By.xpath("//*[@id='usertable']//td[@data-label='Full Name']"));

		for (int i = 0; i < nameList.size(); i++) {
			assertEquals(nameList.get(i).getText(), nameText);
		}
	}

	public void verifyLicenseTabs(WebDriver driver) {
		try {
			assertTrue(isElementVisible(driver, licenses_page_header));
			assertTrue(isElementVisible(driver, licenses_settings_icon));
			assertTrue(isElementVisible(driver, licenses_search_text_box));
			assertTrue(isElementVisible(driver, license_used_lic_count));
			assertTrue(isElementVisible(driver, used_licenses));
			assertTrue(isElementVisible(driver, license_status));
			assertTrue(isElementVisible(driver, license_Expiration));
			assertTrue(isElementVisible(driver, license_TotalLicenses));

			assertTrue(isElementVisible(driver, license_nameColumn));
			assertTrue(isElementVisible(driver, license_titleColumn));
			assertTrue(isElementVisible(driver, license_profileColumn));
			assertTrue(isElementVisible(driver, license_roleColumn));
			assertTrue(isElementVisible(driver, license_countryColumn));
			assertTrue(isElementVisible(driver, license_regionColumn));
			assertTrue(isElementVisible(driver, license_costcenterColumn));
			assertTrue(isElementVisible(driver, license_SwagIQAdminAccessColumn));

			System.out.println("Verification of verifyLicenseTiles is Passed ! ");
		} catch (Error e) {
			// Following lines will be printed when the assert condition fails
			System.out.println("Verification of verifyLicenseTiles is FAILED ! ");
			System.out.println("Error message: " + e.toString());
		}
	}

//************************************************************************************
	// Rani
//*************************************************************************************

	public void verifyAllUserLicenseEnable(WebDriver driver) {
		assertTrue(isElementVisible(driver, license_all_user_lic_enabled));

	}

	public void disable_license_to_all_user(WebDriver driver) throws Exception {
		assertTrue(isElementVisible(driver, license_enable_tab));
		clickElement(driver, license_check_box);
		disable_use_count = findElement(driver, license_modified_user_count).getText();

	}

	public void enabale_license_to_all_user(WebDriver driver) throws Exception {
		assertTrue(isElementVisible(driver, license_enable_tab));
		clickElement(driver, license_check_box);
		enable_use_count = findElement(driver, license_modified_user_count).getText();

	}

	public void metch_lic_total_count(WebDriver driver) {
		System.out.println("Total disable user count:" + disable_use_count);
		// System.out.print(list);
		System.out.println("Total enable user count:" + enable_use_count);
		System.out.println(disable_use_count.equals(enable_use_count));

	}

	public void get_license_user_value(WebDriver driver) throws Exception {
		lic_count_before_assignment = findElement(driver, license_used_lic_count).getText();
		System.out.println("License User count before Assignment:" + lic_count_before_assignment);

	}

	public void assign_license_to_user(WebDriver driver, String lic_user_name) {

		driver.findElement(By.xpath("(//td[contains(text(),'" + lic_user_name + "')]/..//span)[1]")).click();
		boolean button_visible = findElement(driver, license_save_button).isDisplayed();
		System.out.println(button_visible);

	}

	public void verify_modified_user_count(WebDriver driver) throws Exception {
		modified_user_count = findElement(driver, license_modified_user_count).getText();
		System.out.println("Modified Users label exists and count is:" + modified_user_count);

	}

	public void click_save_button(WebDriver driver) throws Exception {
		findElement(driver, save_button).click();
		System.out.println("Save button clicked Successfully");
		waitForPageToLoad1(driver);

	}

	public void verify_license_check_box_checked(WebDriver driver, String lic_user_name) throws Exception {
		driver.findElement(By.xpath(
				"//td[contains(@title, '" + lic_user_name + "')]/..//input[(contains(@class, 'ng-not-empty'))]"));
		System.out.println("Check box checked already for assign license user");
	}

	public void verify_license_user_count(WebDriver driver) throws Exception {
		license_user_count_after_assignment = findElement(driver, license_total_user_count).getText();
		System.out.println("Total license use is :" + license_user_count_after_assignment);

	}

	public void get_license_count_difference(WebDriver driver) throws Exception {

		int final_lic_count = Integer.parseInt(license_user_count_after_assignment)
				- Integer.parseInt(lic_count_before_assignment);
		System.out.println("difference of license count before and after assignment is:" + final_lic_count);

	}

	public void remove_license_from_user(WebDriver driver, String lic_user_name) throws Exception {
		driver.findElement(By.xpath("(//td[contains(text(),'" + lic_user_name + "')]/..//span)[1]")).click();
		boolean button_visible = findElement(driver, license_save_button).isDisplayed();
		System.out.println("Save button is visible:" + button_visible);
		System.out.println("Automation user license remove sucessfully");

	}
}
