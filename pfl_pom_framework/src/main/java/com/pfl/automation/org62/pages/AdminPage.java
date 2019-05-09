//XPATH and Page related Methods

package com.pfl.automation.org62.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pfl.automation.base.BasePage;
import com.pfl.automation.utils.Constants;

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
	public By add_users_confirm_button_ok = By.xpath("//button[contains(text(),'Ok') or contains(text(),'Yes')]");
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
	
	// ***************** Deepak Sharma ************//
	public String assignment_type_field = "(//label[contains(text(),'Assignment Type')]/..//p)[$$product_count$$]";
	public String available_budget = "//label[contains(text(),'Available Budget (Qty/$)')]/ancestor::div[1]//p/span";
	public By role_name_search_bar = By.xpath("//input[contains(@placeholder, 'Role Name')]");
	public By add_role_button = By.xpath("//button[contains(text(), 'Add Role')]");
	public By add_user_b = By.xpath("(//button[contains(text(),'Add Users')])[1]");
	public By refresh_b = By.xpath("(//i[@class='far fa-sync-alt text-success'])[1]");
	public By admin_user_budget_quantity = By.xpath("(//td[contains(@title,'Available Quantity')]//p)[1]");
	public By admin_user_budget_quantity_text = By.xpath("//input[@placeholder='Quantity']");
	public By error_prg_budget_exceed = By.xpath("//div[@id='alert-area']//p[contains(.,'Program budget exceeds product budget')]");
	public By error_user_budget_exceed = By.xpath("//div[@id='alert-area']//p[contains(.,'User budget exceeds program budget')]");
	public By program_header = By.xpath("//h3[contains(.,'Program Details')]");
	public By add_user_btn = By.xpath("(//button[contains(text(),'Add Users')])[1]");


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

	By admin_product_deactive_toggle = By.xpath("//span[@class='fa fa-lg fa-toggle-off']");

	// By admin_add_program_product =
	// By.xpath("//div[@class='text-right']/button[contains(text(),'Add Program
	// Product')]");
	By admin_available_product_qty = By
			.xpath("//label[contains(text(),'Available Budget (Qty/$)')]/ancestor::div[1]//p");

	By admin_product_active_toggle = By.xpath("//span[@class='fa fa-lg text-success fa-toggle-on']");
	By admin_inactive_program_toggle = By.xpath("//span[contains(@class,'fa fa-lg fa-toggle-on')]");
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

	public void click_program_admin_tile() throws Exception {
		switchToFrame(driver);
		clickElement(driver, admin_program_admin_tile);
		System.out.println("clicked on program admin tile");
		driver.switchTo().defaultContent();
	}

	public void sflt_click_program_admin_tile() throws Exception 
	{
		waitForPageToLoad1(driver);
		System.out.println("going to click on program admin tile");
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		//wait_min();
		click_program_admin_tile();
	}
	
	public void sflt_set_new_program(WebDriver driver, String program_name) throws Exception
	{
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		set_new_program(driver, program_name);
	}
	
	public void sflt_set_product_details(WebDriver driver, String product_count, String product_name, String product_qty)
			throws Exception {
		
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		set_product_details(driver, product_count, product_name, product_qty);
	}
	
	public void sflt_set_program_campaign(String product_count, String campaign_name) throws Exception {
			
			WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
			driver.switchTo().frame(sflt_inner_frame);
			set_program_campaign(product_count, campaign_name);
		}
	
	public void sflt_set_campaign_member_status(String product_count, String campaign_member_status) throws Exception
	{	
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		set_campaign_member_status(product_count, campaign_member_status);
	}
		
	public void sflt_add_user_in_program(String product_count, String user_name) throws Exception {
		
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		add_user_in_program(product_count, user_name);	
	}
	
	public void sflt_add_program_product() throws Exception {
		
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		add_program_product();
	}
	
	public void sflt_activate_program() throws Exception {
		
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		activate_program();
	}

	public void set_new_program(WebDriver driver, String program_name) throws Exception {
		wait_min();
		switchToFrame(driver);
		clickElement(driver, new_program_button);
		System.out.println("clicked on NEW program button");
		enterText(driver, program_name_textbox, program_name);
		System.out.println("Entered the Program Name");
		clickElement(driver, program_creation_ok_button);
		System.out.println("clicked to ok program button");
		clickElement(driver, add_program_button);
		System.out.println("clicked on Add product button inside program");
		driver.switchTo().defaultContent();
	}
	
	public void set_assignment_type(String product_count, String assignment_type) throws Exception
	{
		System.out.println("I am within set_assignment_type method");
		switchToFrame(driver);
		driver.findElement(By.xpath(assignment_type_field.replace("$$product_count$$", product_count))).isDisplayed();
		driver.findElement(By.xpath(assignment_type_field.replace("$$product_count$$", product_count))).click();
		wait_min();
		driver.findElement(By.xpath("(//label[contains(text(),'Assignment Type')]/..//select//option[contains(.,'"+assignment_type+"')])['"+product_count+"']")).click();
		//wait_min();
		driver.switchTo().defaultContent();
		System.out.println("I am done with assignment type settings");
	}
	
	public void add_user_by_role(String role_name) throws Exception
	{
		System.out.println("I am within add_user_by_role method");
		switchToFrame(driver);
		findElement(driver, role_name_search_bar).sendKeys(role_name);
		wait_min();
		findElement(driver, add_role_button).click();
		wait_min();
		driver.switchTo().defaultContent();
		System.out.println("taking exit from add_user_by_role method");
	}

	
	public String get_product_quanity(String product_count, String product_name) throws Exception
	{
		wait_min();
		switchToFrame(driver);
		
		//adding product by name during program creation
		driver.findElement(By.xpath(product_edit_button.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on product edit button");
		driver.findElement(By.xpath(product_name_search_bar1.replace("$$product_count$$", product_count))).sendKeys(product_name);
		
		//findElement(driver, product_name_search_bar).sendKeys(product_name);
		wait_min();
		driver.findElement(By.xpath("//a[contains(@title,'"+product_name+"')]")).click();
		System.out.println("selected product successfully");
		wait_min();	
		
		driver.findElement(By.xpath(refresh_button.replace("$$product_count$$", product_count))).click();
		wait_min();
		
		String avl_budget = driver.findElement(By.xpath(available_budget)).getText();
		System.out.println("availble budget qty is: " +avl_budget);
		String final_avl_bgt1 = avl_budget.replace("$", "");
		String final_avl_bgt2 = final_avl_bgt1.replace("/", "");
		String final_avl_bgt = final_avl_bgt2.replace(" ", "");
		System.out.println("final available budget is: " +final_avl_bgt);
		int int_avl_budget = Integer.parseInt(final_avl_bgt);
		int over_budget = int_avl_budget + 1;
		String string_over_budget = Integer.toString(over_budget);
		driver.switchTo().defaultContent();
		return string_over_budget;	
	}
	
	public void add_product_n_qty(String product_count, String product_qty) throws Exception
	{
		switchToFrame(driver);
		//adding product quantity during program creation
		driver.findElement(By.xpath(budget_qty.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on budget qty label successfully");
		driver.findElement(By.xpath(product_qty_input.replace("$$product_count$$", product_count))).clear();
		driver.findElement(By.xpath(refresh_button.replace("$$product_count$$", product_count))).click();
		driver.findElement(By.xpath(budget_qty.replace("$$product_count$$", product_count))).click();
		driver.findElement(By.xpath(product_qty_input.replace("$$product_count$$", product_count))).sendKeys(product_qty);
		System.out.println("entered product qty successfully");
		//wait_min();
		
		//refreshing the program creation section during program creation
		driver.findElement(By.xpath(refresh_button.replace("$$product_count$$", product_count))).click();
		wait_min();
		driver.switchTo().defaultContent();
	}
	
	
	public String get_user_increased_budget(String user_budget)
	{
		int user_budget1 = Integer.parseInt(user_budget)+1;
		String increased_user_budget = Integer.toString(user_budget1);
		System.out.println("value of increased user budget is: " +increased_user_budget);
		return increased_user_budget;
	}
	
	public void set_user_budget(String user_budget) throws Exception
	{
		wait_min();
		switchToFrame(driver);
		Scroll_ByVisibleElement(driver, add_user_b);
		waittillvisibility(driver, admin_user_budget_quantity);	
		findElement(driver, admin_user_budget_quantity).click();
		wait_min();
		findElement(driver, admin_user_budget_quantity_text).clear();
		System.out.println("cleared the text box");
		//wait_min();
		findElement(driver, admin_user_budget_quantity).click();
		//wait_min();
		findElement(driver, admin_user_budget_quantity_text).sendKeys(user_budget);
		//wait_min();
		System.out.println("entereing the new qty");
		findElement(driver, refresh_b).click();
		System.out.println("entered the passed amount successfully");
		driver.switchTo().defaultContent();
	}
	
	public void assert_errors_program_page() throws Exception
	{
		switchToFrame(driver);
		Scroll_ByVisibleElement(driver, error_prg_budget_exceed);
		assertTrue(isElementVisible(driver, error_prg_budget_exceed));
		assertTrue(isElementVisible(driver, error_user_budget_exceed));	
		System.out.println("assert is true for program error of budget quantity");
		driver.switchTo().defaultContent();
	}
	
	public void set_new_program_lightng(WebDriver driver, String program_name) throws Exception {
		wait_min();
		WebElement iframe_lightng = driver.findElement(By.xpath("//div[contains(@class, 'oneAlohaPage')]//iframe"));
		driver.switchTo().frame(iframe_lightng);
		switchToFrame(driver);
		clickElement(driver, new_program_button);
		System.out.println("clicked on NEW program button");
		enterText(driver, program_name_textbox, program_name);
		System.out.println("Entered the Program Name");
		clickElement(driver, program_creation_ok_button);
		System.out.println("clicked to ok program button");
		clickElement(driver, add_program_button);
		System.out.println("clicked on Add product button inside program");
		driver.switchTo().defaultContent();
	}

	public void set_product_details(WebDriver driver, String product_count, String product_name, String product_qty)
			throws Exception {
		wait_min();
		switchToFrame(driver);
		driver.findElement(By.xpath(product_edit_button.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on product edit button");
		driver.findElement(By.xpath(product_name_search_bar1.replace("$$product_count$$", product_count))).sendKeys(product_name);
		wait_min();
		By admin_add_product_name = By.xpath("//a[contains(@title,'" + product_name + "')]");
		clickElement(driver, admin_add_product_name);
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

	public void set_product_details_lightng(WebDriver driver, String product_count, String product_name,
			String product_qty) throws Exception {
		wait_min();
		WebElement iframe_lightng = driver.findElement(By.xpath("//div[contains(@class, 'oneAlohaPage')]//iframe"));
		driver.switchTo().frame(iframe_lightng);
		switchToFrame(driver);
		driver.findElement(By.xpath(product_edit_button.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on product edit button");
		driver.findElement(By.xpath(product_name_search_bar1.replace("$$product_count$$", product_count)))
				.sendKeys(product_name);
		wait_min();
		By admin_add_product_name = By.xpath("//a[contains(@title,'" + product_name + "')]");
		clickElement(driver, admin_add_product_name);
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

	public void set_program_campaign(String product_count, String campaign_name) throws Exception {
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

	public void set_program_campaign_lightng(String product_count, String campaign_name) throws Exception {
		WebElement iframe_lightng = driver.findElement(By.xpath("//div[contains(@class, 'oneAlohaPage')]//iframe"));
		driver.switchTo().frame(iframe_lightng);
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

	public void set_campaign_member_status(String product_count, String campaign_member_status) throws Exception {
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

	public void set_campaign_member_status_lightng(String product_count, String campaign_member_status) throws Exception {
		WebElement iframe_lightng = driver.findElement(By.xpath("//div[contains(@class, 'oneAlohaPage')]//iframe"));
		driver.switchTo().frame(iframe_lightng);
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


	public void add_user_in_program(String product_count, String user_name) throws Exception {
		switchToFrame(driver);
		// clicking on add users button during program creation
		Scroll_ByVisibleElement(driver, add_user_btn);
		driver.findElement(By.xpath(add_user_button_prg.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on add users button successfully");
		enterText(driver, search_bar_on_users_page, user_name);
		boolean user_displayed = driver
				.findElement(By.xpath("//td[contains(@title, '" + user_name + "')]/..//input[@type = 'checkbox']"))
				.isDisplayed();
		System.out.println("User displayed successfully: " + user_displayed);
		wait_min();
		clickElement(driver, select_all_checkbox_add_user);
		System.out.println("clicked on select all checkbox successfully");
		clickElement(driver, add_user_button_on_users_page);
		wait_min();

		//boolean confirmation_msg = driver.findElement(By.xpath("//button[contains(.,'Yes') or contains(.,'Ok') ]")).isDisplayed();
		boolean confirmatino_msg = isElementVisible(driver, add_users_confirm_button_ok);
		System.out.println("confirmation message popup appears: " +confirmatino_msg);
		clickElement(driver, add_users_confirm_button_ok);
		System.out.println("cliked on confirmation popup successfully");
		wait_min();
		driver.switchTo().defaultContent();
	}

	public void add_user_in_program_lightng(String product_count, String user_name) throws Exception {
		WebElement iframe_lightng = driver.findElement(By.xpath("//div[contains(@class, 'oneAlohaPage')]//iframe"));
		driver.switchTo().frame(iframe_lightng);
		switchToFrame(driver);
		// clicking on add users button during program creation
		driver.findElement(By.xpath(add_user_button_prg.replace("$$product_count$$", product_count))).click();
		System.out.println("clicked on add users button successfully");
		enterText(driver, search_bar_on_users_page, user_name);
		boolean user_displayed = driver
				.findElement(By.xpath("//td[contains(@title, '" + user_name + "')]/..//input[@type = 'checkbox']"))
				.isDisplayed();
		System.out.println("User displayed successfully: " + user_displayed);
		wait_min();
		clickElement(driver, select_all_checkbox_add_user);
		System.out.println("clicked on select all checkbox successfully");
		clickElement(driver, add_user_button_on_users_page);
		wait_min();

		boolean confirmation_msg = driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).isDisplayed();
		System.out.println("confirmation message popup appears: " + confirmation_msg);
		clickElement(driver, add_users_confirm_button_ok);
		System.out.println("cliked on confirmation popup successfully");
		wait_min();
		driver.switchTo().defaultContent();
	}

	public void activate_program() throws Exception {
		switchToFrame(driver);
		boolean prg_activate_toggle = driver.findElement(active_program_toggle).isDisplayed();
		System.out.println("prg_activate_toggle appears: " + prg_activate_toggle);
		wait_min();
		clickElement(driver, active_program_toggle);
		// findElement(driver, active_program_toggle).click();
		System.out.println("clicked on prg_active toggle successfully");
		wait_min();

		boolean confirmation_msg = driver.findElement(add_users_confirm_button_ok).isDisplayed();
		System.out.println("confirmation message popup appears: " +confirmation_msg);
		clickElement(driver, add_users_confirm_button_ok);

		System.out.println("created program successfully");
		wait_min();
		driver.switchTo().defaultContent();
	}

	public void activate_program_lightng() throws Exception {
		WebElement iframe_lightng = driver.findElement(By.xpath("//div[contains(@class, 'oneAlohaPage')]//iframe"));
		driver.switchTo().frame(iframe_lightng);
		switchToFrame(driver);
		boolean prg_activate_toggle = driver.findElement(active_program_toggle).isDisplayed();
		System.out.println("prg_activate_toggle appears: " + prg_activate_toggle);
		wait_min();
		clickElement(driver, active_program_toggle);
		// findElement(driver, active_program_toggle).click();
		System.out.println("clicked on prg_active toggle successfully");
		wait_min();

		boolean confirmation_msg = driver.findElement(add_users_confirm_button_ok).isDisplayed();
		System.out.println("confirmation message popup appears: " + confirmation_msg);
		clickElement(driver, add_users_confirm_button_ok);

		System.out.println("created program successfully");
		wait_min();
		driver.switchTo().defaultContent();
	}

	public void add_program_product() throws Exception {
		switchToFrame(driver);
		clickElement(driver, add_program_product_button);
		driver.switchTo().defaultContent();
	}

	//// ***************************Rani******************************//////

	public void click_program_admin_tile(WebDriver driver) throws Exception {
		waitForPageToLoad1(driver);
		switchToFrame(driver);
		clickElement(driver, admin_program_admin_tile);
		driver.switchTo().defaultContent();

	}

	public void click_on_product_admin_tile(WebDriver driver) throws Exception {
		System.out.println("user available on product admin tile");
		waitForPageToLoad1(driver);
		switchToFrame(driver);
		System.out.println("user entering within frame");
		clickElement(driver, admin_product_admin_tile);
		driver.switchTo().defaultContent();

	}

	public void click_on_product_search_bar_on_Pro_Administration(WebDriver driver, String product_name)
			throws Exception {
		waitForPageToLoad1(driver);
		switchToFrame(driver);
		waitForPageToLoad();
		clickElement(driver, admin_product_search_bar);
		enterText(driver, admin_product_search_bar, product_name);
		wait_max();
		driver.switchTo().defaultContent();
	}

	public void click_product_detail_section(WebDriver driver, String product_name) throws Exception {
		switchToFrame(driver);
		wait_min();
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
		wait_min();
		findElement(driver, admin_product_active_toggle).click();
		wait_min();
		findElement(driver, active_program_toggle).click();
		findElement(driver, admin_product_save_button).click();
		
		driver.switchTo().defaultContent();

	}

	/*
	 * public void click_new_program_button(WebDriver driver) throws Exception {
	 * waitForPageToLoad1(driver); switchToFrame(driver); findElement(driver,
	 * admin_new_program_button).click(); boolean cancel_button =
	 * findElement(driver, admin_program_cancel_button).isDisplayed();
	 * System.out.println("cancel button visible on page:" + cancel_button);
	 * driver.switchTo().defaultContent();
	 * 
	 * }
	 */
	public void set_program_name(WebDriver driver, String program_name) throws Exception {
		switchToFrame(driver);
		findElement(driver, admin_new_program_button).click();
		wait_min();
		driver.findElement(By.cssSelector("input[placeholder='New Program Name']")).sendKeys(program_name);
		clickElement(driver, program_creation_ok_button);
		// findElement(driver, program_creation_ok_button).click();
		clickElement(driver, add_program_button);
		// findElement(driver, add_program_button).click();
		driver.switchTo().defaultContent();

	}

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

	}

	public void compare_value() {
		if (product_value.equals(quantity)) {

			System.out.println("Unallocated budget quantity is same");
		} else
			System.out.println("Product value not found");

	}

	public void click_on_program_from_search_result(WebDriver driver, String program_name) throws Exception {
		switchToFrame(driver);
		clickElement(driver,By.xpath("(//td[contains(text(),'" + program_name + "')])[1]"));
		//driver.findElement(By.xpath("//td[contains(.,'" + program_name + "')])[1]")).click();
		driver.switchTo().defaultContent();

	}

	public void inactivate_program(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, admin_inactive_program_toggle);
		clickElement(driver, add_users_confirm_button_ok);
		driver.switchTo().defaultContent();
		// TODO Auto-generated method stub

	}

	public void verify_program_on_admin_page(WebDriver driver, String program_name) throws Exception {
		switchToFrame(driver);
		findElement(driver, search_bar_on_users_page).click();
		enterText(driver, search_bar_on_users_page, program_name);
		assertTrue(isElementVisible(driver, By.xpath("(//td[contains(text(),'" + program_name + "')])[1]")));
		driver.switchTo().defaultContent();
	}

	public boolean verify_content_on_Page(WebDriver driver, String content_xpath) throws Exception {
		switchToFrame(driver);
		wait_min();
		boolean content_visible = driver.findElement(By.xpath(content_xpath)).isDisplayed();
		wait_max();
		System.out.println("Required Element found on page :" + content_visible);
		driver.switchTo().defaultContent();
		return content_visible;

	}

	public boolean verify_xpath_on_page(WebDriver driver, String path_value) throws Exception {

		boolean content_visible = driver.findElement(By.xpath(path_value)).isDisplayed();
		wait_max();
		System.out.println("Required Element found on page :" + content_visible);

		return content_visible;

	}

	public void deactive_product(WebDriver driver) throws Exception {
		switchToFrame(driver);
		findElement(driver, admin_product_deactive_toggle).click();
		findElement(driver, admin_product_save_button).click();
		driver.switchTo().defaultContent();

	}

	public void active_product(WebDriver driver) throws Exception {
		switchToFrame(driver);
		findElement(driver, admin_product_active_toggle).click();
		findElement(driver, admin_product_save_button).click();
		driver.switchTo().defaultContent();

	}
}
