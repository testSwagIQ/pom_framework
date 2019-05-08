//XPATH and Page related Methods

package com.pfl.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pfl.automation.base.BasePage;

public class AdminPage extends BasePage {
	String quantity, product_value = null;

	// public WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	SalesforcePage tb = new SalesforcePage(driver);

	public By admin_program_admin_tile = By.cssSelector("div[title='Program Administration']");
	public By new_program_button = By.cssSelector("button[title='New Program']");
	public By program_name_textbox = By.cssSelector("input[placeholder='New Program Name']");
	public By program_creation_ok_button = By.cssSelector("button[type='submit']");
	public By add_program_button = By.xpath("//button[contains(.,'Add Program Product')]");
	public By add_users_search_bar = By.xpath("//input[@placeholder='Search Users']");
	public By search_bar_on_users_page = By.xpath("//input[@id='inputSearch']");
	public By select_all_checkbox_add_user = By.xpath("//input[@id='ckBxAll']");
	public By add_user_button_on_users_page = By.xpath("//span[@class='input-group-btn']/button/i");
	public By add_users_confirm_button_ok = By.xpath("//button[contains(text(),'Ok')]");
	public By active_program_toggle = By.xpath("//span[@class='fa fa-lg fa-toggle-off']");
	public By product_label = By.xpath("(//label[contains(text(),'Product')])[1]");
	// public By product_edit_button =
	// By.xpath("(//label[contains(text(),'Product')]/../div//div/p)[1]");
	public String product_edit_button = "(//label[contains(text(),'Product')]/../div//div/p)[$$product_count$$]";
	public By product_name_search_bar = By.xpath("(//input[@placeholder='Search Product Name'])[1]");
//	public By budget_qty = By.xpath("(//label[contains(text(), 'Budget Quantity')]/..//div//p)[$$product_count$$]");
	public String budget_qty = "(//label[contains(text(), 'Budget Quantity')]/..//div//p)[$$product_count$$]";
	public String product_qty_input = "(//label[contains(text(), 'Budget Quantity')]/..//div//input)[$$product_count$$]";
	public String refresh_button = "(//i[@class='far fa-sync-alt text-success'])[$$product_count$$]";
	public String add_user_button_prg = "(//button[contains(text(),'Add Users')])[$$product_count$$]";
	public String product_apperance = "//div/p[contains(.,'$$product_name$$')]";
	public String product_name_search_bar1 = "(//input[@placeholder='Search Product Name'])[$$product_count$$]";
	public String campaign_field = "(//label[contains(text(),'Campaign Lookup')]/..//p)[$$product_count$$]";
	public String campaign_field_input = "(//label[contains(text(),'Campaign Lookup')]/..//input)[$$product_count$$]";
	public String campaign_member_status_field = "(//label[contains(text(),'Campaign Member Status')]/..//p)[$$product_count$$]";
	public By add_program_product_button = By.xpath("//button[contains(.,'Add Program Product')]");

	// *********************rani***************
	By admin_product_admin_tile = By.xpath("//div[@title='Product Administration']/ancestor::div[2]");
	By admin_product_search_bar = By.xpath("//input[@placeholder='Search Products']");
	By admin_product_display_label = By.xpath("//div/strong[contains(.,'Display Name')]");
	By admin_product_unallocated_qty = By.xpath("//label[contains(.,'Unallocated ')]/./following-sibling::p");
	By admin_activate_product_toggle = By.xpath("//span[@class='fa fa-lg fa-toggle-off']");
	By admin_product_save_button = By.xpath("//button[@class='btn btn-primary']");
	By admin_new_program_button = By.xpath("//button[@title = 'New Program']");
	By admin_program_cancel_button = By.xpath("//div[@class='modal-footer']/button[contains(text(), 'Cancel')]");
	By admin_program_set_program_name = By.cssSelector("input[placeholder='New Program Name']");
	By admin_program_ok_button = By.xpath("//div[@class='modal-footer']/button[contains(text(),'OK')]");
	By admin_add_program_product = By.xpath("//button[contains(.,'Add Program Product')]");
	// By admin_add_program_product =
	// By.xpath("//div[@class='text-right']/button[contains(text(),'Add Program
	// Product')]");
	By admin_available_product_qty = By
			.xpath("//label[contains(text(),'Available Budget (Qty/$)')]/ancestor::div[1]//p");

	By admin_product_active_toggle = By.xpath("//span[@class='fa fa-lg text-success fa-toggle-on']");
	// By program_creation_ok_button = By.cssSelector("button[type='submit']");

	public void create_new_program(String program_name, String product_name, String product_qty, String product_count,
			String admin_pfl_bd_auto_user_first_name) {
		driver.findElement(By.xpath("//div/h3")).click();
		System.out.println("clicked on  header successfully");

		// clicking on new program button and creating new program
		findElement(driver, new_program_button).click();
		findElement(driver, program_name_textbox).sendKeys(program_name);
		findElement(driver, program_creation_ok_button).click();
		findElement(driver, add_program_button).click();

		// adding product by name during program creation
		findElement(driver, product_label).click();
		System.out.println("Clicked on product label");
		driver.findElement(By.xpath(product_edit_button.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on product edit button");
		findElement(driver, product_name_search_bar).sendKeys(product_name);

		driver.findElement(By.xpath("//a[contains(@title,'" + product_name + "')]")).click();
		System.out.println("selected product successfully");

		// adding product quantity during program creation
		driver.findElement(By.xpath(budget_qty.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on budget qty label successfully");
		driver.findElement(By.xpath(product_qty_input.replace("$$product_count$$", product_count)))
				.sendKeys(product_qty);
		System.out.println("entered product qty successfully");

		// refreshing the program creation section during program creation
		driver.findElement(By.xpath(refresh_button.replace("$$product_count$$", product_count))).click();
		wait_max();

		// clicking on add users button during program creation
		driver.findElement(By.xpath(add_user_button_prg.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on add users button successfully");

		boolean search_bar = waittillinvisibility(driver, add_users_search_bar);
		System.out.println("search bar appears: " + search_bar);
		findElement(driver, search_bar_on_users_page).sendKeys(admin_pfl_bd_auto_user_first_name);
		boolean user_displayed = driver.findElement(By.xpath(
				"//td[contains(@title, '" + admin_pfl_bd_auto_user_first_name + "')]/..//input[@type = 'checkbox']"))
				.isDisplayed();
		System.out.println("User displayed successfully: " + user_displayed);

		findElement(driver, select_all_checkbox_add_user).click();
		System.out.println("clicked on select all checkbox successfully");
		findElement(driver, add_user_button_on_users_page).click();

		boolean confirmation_msg = driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).isDisplayed();
		System.out.println("confirmation message popup appears: " + confirmation_msg);
		findElement(driver, add_users_confirm_button_ok).click();
		System.out.println("cliked on confirmation popup successfully");

		wait_max();
		boolean selected_product_visible = driver
				.findElement(By.xpath(product_apperance.replace("$$product_name$$", product_name))).isDisplayed();
		System.out.println("selected product appears: " + selected_product_visible);

		boolean prg_activate_toggle = driver.findElement(By.xpath("//span[@class='fa fa-lg fa-toggle-off']"))
				.isDisplayed();
		System.out.println("prg_activate_toggle appears: " + prg_activate_toggle);

		wait_min();

		findElement(driver, active_program_toggle).click();
		System.out.println("clicked on prg_active toggle successfully");

		wait_min();

		boolean confirmation_msg1 = driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).isDisplayed();
		System.out.println("confirmation message popup appears: " + confirmation_msg1);
		findElement(driver, add_users_confirm_button_ok).click();

		System.out.println("created program successfully");
	}

	public void click_program_admin_tile() {
		WebElement iframe_outer = driver.findElement(By.xpath(tb.canvas_outerframe));
		driver.switchTo().frame(iframe_outer);
		System.out.println("I am within outer iframe");
		driver.switchTo().frame(driver.findElement(By.xpath(tb.canvas_innerframe)));
		System.out.println("I am inside the inner iframe");
		driver.findElement(admin_program_admin_tile).click();
		System.out.println("clicked on program admin tile");
	}

	/// *** Deepak Sharma ***///

	public void set_new_program(WebDriver driver, String program_name) {
		wait_min();
		switchToFrame(driver);
		findElement(driver, new_program_button).click();
		findElement(driver, program_name_textbox).sendKeys(program_name);
		findElement(driver, program_creation_ok_button).click();
		findElement(driver, add_program_button).click();
		driver.switchTo().defaultContent();
	}

	public void set_product_details(WebDriver driver, String product_count, String product_name, String product_qty) {
		wait_min();
		switchToFrame(driver);
		// adding product by name during program creation
		// driver.findElement(By.xpath(product_label_n.replace("$$product_count$$",
		// product_count))).click();

		// findElement(driver, product_label).click();
		// System.out.println("Clicked on product label");
		driver.findElement(By.xpath(product_edit_button.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on product edit button");
		driver.findElement(By.xpath(product_name_search_bar1.replace("$$product_count$$", product_count)))
				.sendKeys(product_name);

		// findElement(driver, product_name_search_bar).sendKeys(product_name);
		wait_min();
		driver.findElement(By.xpath("//a[contains(@title,'" + product_name + "')]")).click();
		System.out.println("selected product successfully");
		wait_min();

		// adding product quantity during program creation
		driver.findElement(By.xpath(budget_qty.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on budget qty label successfully");
		driver.findElement(By.xpath(product_qty_input.replace("$$product_count$$", product_count)))
				.sendKeys(product_qty);
		System.out.println("entered product qty successfully");
		wait_min();

		// refreshing the program creation section during program creation
		driver.findElement(By.xpath(refresh_button.replace("$$product_count$$", product_count))).click();
		wait_min();
		driver.switchTo().defaultContent();
	}

	public void set_program_campaign(String product_count, String campaign_name) {
		switchToFrame(driver);
		driver.findElement(By.xpath(campaign_field.replace("$$product_count$$", product_count))).isDisplayed();
		driver.findElement(By.xpath(campaign_field.replace("$$product_count$$", product_count))).click();

		driver.findElement(By.xpath(campaign_field_input.replace("$$product_count$$", product_count))).isDisplayed();
		driver.findElement(By.xpath(campaign_field_input.replace("$$product_count$$", product_count)))
				.sendKeys(campaign_name);
		wait_min();
		driver.findElement(By.xpath("(//a[contains(@title, '" + campaign_name + "')])['" + product_count + "']"))
				.click();
		// wait_min();
		driver.switchTo().defaultContent();

	}

	public void set_campaign_member_status(String product_count, String campaign_member_status) {
		switchToFrame(driver);
		driver.findElement(By.xpath(campaign_member_status_field.replace("$$product_count$$", product_count)))
				.isDisplayed();
		driver.findElement(By.xpath(campaign_member_status_field.replace("$$product_count$$", product_count))).click();
		wait_min();
		driver.findElement(
				By.xpath("(//label[contains(text(),'Campaign Member Status')]/..//select//option[contains(text(), '"
						+ campaign_member_status + "')])['" + product_count + "']"))
				.click();
		// wait_min();
		driver.switchTo().defaultContent();
	}

	public void add_user_in_program(String product_count, String user_name) {
		switchToFrame(driver);
		// clicking on add users button during program creation
		driver.findElement(By.xpath(add_user_button_prg.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on add users button successfully");

		findElement(driver, search_bar_on_users_page).sendKeys(user_name);
		boolean user_displayed = driver
				.findElement(By.xpath("//td[contains(@title, '" + user_name + "')]/..//input[@type = 'checkbox']"))
				.isDisplayed();
		System.out.println("User displayed successfully: " + user_displayed);
		wait_min();

		findElement(driver, select_all_checkbox_add_user).click();
		System.out.println("clicked on select all checkbox successfully");
		findElement(driver, add_user_button_on_users_page).click();
		wait_min();

		boolean confirmation_msg = driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).isDisplayed();
		System.out.println("confirmation message popup appears: " + confirmation_msg);
		findElement(driver, add_users_confirm_button_ok).click();
		System.out.println("cliked on confirmation popup successfully");
		wait_min();
		driver.switchTo().defaultContent();
	}

	public void activate_program() {
		switchToFrame(driver);
		boolean prg_activate_toggle = driver.findElement(active_program_toggle).isDisplayed();
		System.out.println("prg_activate_toggle appears: " + prg_activate_toggle);
		wait_min();

		findElement(driver, active_program_toggle).click();
		System.out.println("clicked on prg_active toggle successfully");
		wait_min();

		boolean confirmation_msg = driver.findElement(add_users_confirm_button_ok).isDisplayed();
		System.out.println("confirmation message popup appears: " + confirmation_msg);
		findElement(driver, add_users_confirm_button_ok).click();

		System.out.println("created program successfully");
		wait_min();
		driver.switchTo().defaultContent();
	}

	public void add_program_product() {
		switchToFrame(driver);
		findElement(driver, add_program_product_button).click();
		driver.switchTo().defaultContent();
	}

	//// ***************************Rani******************************//////

	public void click_program_admin_tile(WebDriver driver) throws Exception {
		waitForPageToLoad1(driver);
		switchToFrame(driver);
		findElement(driver, admin_program_admin_tile).click();
		driver.switchTo().defaultContent();

	}

	public void click_on_product_admin_tile(WebDriver driver) throws Exception {
		System.out.println("user available on product admin tile");
		waitForPageToLoad1(driver);
		switchToFrame(driver);
		System.out.println("user entering within frame");
		findElement(driver, admin_product_admin_tile).click();
		driver.switchTo().defaultContent();

	}

	public void click_on_product_search_bar_on_Pro_Administration(WebDriver driver, String product_name)
			throws Exception {
		waitForPageToLoad1(driver);
		switchToFrame(driver);
		waitForPageToLoad();
		findElement(driver, admin_product_search_bar).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Products']")).sendKeys(product_name);
		driver.switchTo().defaultContent();
	}

	public void click_product_detail_section(WebDriver driver, String product_name) throws Exception {
		switchToFrame(driver);
		driver.findElement(By.xpath("(//span[contains(.,'" + product_name + "')])[1]")).click();
		boolean product_label = findElement(driver, admin_product_display_label).isDisplayed();
		System.out.println(product_label);
		driver.switchTo().defaultContent();

	}

	public void get_unallocated_product_quantity(WebDriver driver) throws Exception {
		switchToFrame(driver);
		quantity = findElement(driver, admin_product_unallocated_qty).getText();
		System.out.println("Value of unallocated quantity is:" + quantity);
		driver.switchTo().defaultContent();

	}

	public void click_active_product(WebDriver driver) throws Exception {
		switchToFrame(driver);
		doubleclickElement(driver, admin_product_active_toggle);
		findElement(driver, admin_product_save_button).click();
		driver.switchTo().defaultContent();

	}

	public void click_new_program_button(WebDriver driver) throws Exception {
		waitForPageToLoad1(driver);
		switchToFrame(driver);
		findElement(driver, admin_new_program_button).click();
		boolean cancel_button = findElement(driver, admin_program_cancel_button).isDisplayed();
		//System.out.println("cancel button visible on page:" + cancel_button);
		driver.switchTo().defaultContent();

	}

	public void set_program_name(WebDriver driver, String program_name) throws Exception {
		switchToFrame(driver);
		driver.findElement(By.cssSelector("input[placeholder='New Program Name']")).sendKeys(program_name);
		findElement(driver, program_creation_ok_button).click();
		findElement(driver, add_program_button).click();
		driver.switchTo().defaultContent();

	}

	/*
	 * public void click_on_program_ok(WebDriver driver) throws Exception {
	 * findElement(driver, admin_program_ok_button).click(); wait_min();
	 * 
	 * }
	 * 
	 * public void click_on_add_program_product_button(WebDriver driver) throws
	 * Exception { findElement(driver, admin_add_program_product).click();
	 * wait_min();
	 * 
	 * }
	 */
	public void add_program_product(WebDriver driver, String product_count, String product_name) throws Exception {
		switchToFrame(driver);
		driver.findElement(By.xpath("(//label[contains(text(),'Program Asset Id')])['" + product_count
				+ "']/../following-sibling::div[1]//p")).click();
		waitForPageToLoad1(driver);
		// driver.findElement(By.xpath("(//input[@placeholder='Search Product
		// Name'])['"+product_count+"']")).sendKeys(product_name);
		driver.findElement(By.xpath("(//a[contains(@title,'" + product_name + "')])")).click();
		driver.switchTo().defaultContent();

	}

	public void click_on_available_budget_refresh_button(WebDriver driver, String product_count) throws Exception {
		switchToFrame(driver);
		driver.findElement(By.xpath("(//i[@class='far fa-sync-alt text-success'])['" + product_count + "']")).click();
		waitForPageToLoad();
		driver.switchTo().defaultContent();
	}

	public void get_product_count_on_program_page(WebDriver driver) throws Exception {
		switchToFrame(driver);
		product_value = findElement(driver, admin_available_product_qty).getText();
		System.out.println("Value of budget quantity is:" + product_value);
		driver.switchTo().defaultContent();
	}

	public void compare_value() {
		if (product_value.equals(quantity)) {

			System.out.println("Unallocated budget quantity is same");
		} else
			System.out.println("Product value not found");

	}

}
