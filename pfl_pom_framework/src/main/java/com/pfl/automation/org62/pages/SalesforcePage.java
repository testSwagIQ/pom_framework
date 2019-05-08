package com.pfl.automation.org62.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pfl.automation.base.BasePage;
import com.pfl.automation.utils.Constants;

public class SalesforcePage extends BasePage {
	//WebDriver driver;
	
	public SalesforcePage(WebDriver driver) {
		this.driver = driver;
	}

	BasePage tb = new BasePage();
	
	By send_marketing_button =  By.xpath("//*[contains(@title, 'Send Marketing Materials')]");
	By contact_address_box_selection = By.xpath("//span[contains(text(), 'Contact Address')]/ancestor::div[1]");
	By use_this_address_button =  By.xpath("//button[contains(text(), 'this address')]/..//button[1]");
	public String canvas_outerframe = "//div[@id ='canvas']//iframe";
	public String canvas_innerframe = "//div[@id ='canvasapp']//iframe";	
	
	public String admin_bd_auto_program_1 = "PFL_Auto_Program1";
	By set_product_filter_txtbox = By.xpath("//*[@id='ProductFilter']");
	By user_auto_pfl = By.xpath("//span[contains(text(), 'Auto_Contact')]/ancestor::div[contains(@id, 'FULL_NAME')]/a");
	String xpath1 = "//label[contains(text(), '$$program_name$$')]/ancestor::div[@class = 'box-title']";
	String program_selection_on_send_swag_screen = "//label[contains(text(), '$$program_name$$')]/ancestor::div[@class = 'box-title']";
	
	By account_address_box_selection = By.xpath("//span[contains(text(), 'Account Billing Address')]/ancestor::div[1]");
	By login_box_xpath = By.xpath("//input[@id='username']");	
	By pw_box_xpath = By.xpath("//input[@id='password']");
	By login_button_xpath = By.xpath("//input[@id='Login']");
	By all_tabs = By.xpath("//img[contains(@title, 'All Tabs')]");
	
	By list_view_drop_down = By.xpath("//select[@name='fcf']");
	By go_button = By.xpath("//input[@name='go']");
	By first_program_on_canvas_screen = By.xpath("(//div[@class='box-title'])[1]");
	By searched_element = By.xpath(xpath1.replace("$$program_name$$",admin_bd_auto_program_1));
	By loading_configuration = By.xpath("//p/strong[contains(.,'Loading Configuration Data...')]");
	By swag_iq_order_related_list_section = By.xpath("//h3[contains(text(), 'SwagIQ Order')]/ancestor::div[1]/../..");
	By con_do_not_swag_uncheck = By.xpath ("//td[contains(text(),'Do Not Swag')]/..//img[contains(@title,'Not Checked')]");
	By con_edit_button = By.xpath ("//td[contains(@class,'pbButtonb')]//input[contains(@value,'Edit')]");
	By con_edit_checkbox_donotswag = By.xpath ("//label[contains(text(),'Do Not Swag')]/../following-sibling::td/input[@type='checkbox']");
	By con_save_button = By.xpath ("//td[contains(@class,'pbButtonb')]//input[contains(@value,'Save')]");
	By con_do_not_swag_checkbox = By.xpath ("//td[contains(text(),'Do Not Swag')]/..//img[contains(@title,'Checked')]");	
	By con_do_not_swag_back_button = By.xpath ("//button[text()='Back']");	
	String con_send_swag_not_avbl = "//h2[contains(text(), 'Send Swag not available')]";
	By sflt_app_launcher = By.xpath ("//div[contains(@class, 'slds-icon-waffle')]/..");
	By $sflt_select_app_input = By.xpath ("//input[contains(@placeholder, 'Search apps or items...')]");
	
	public By con_new_button = By.xpath("//input[@type='button'][@name='new']");
	public By con_first_name = By.xpath("//label[contains(text(), 'First Name')]/../following-sibling::td[1]//input");
	public By con_last_name = By.xpath("//label[contains(text(), 'Last Name')]/../following-sibling::td[1]//input");
	public By con_address_mailing_street = By.xpath("//label[contains(text(), 'Mailing Street')]/../following-sibling::td[1]//textarea");
	public By con_address_mailing_zipcode = By.xpath("//label[contains(text(), 'Mailing Zip/Postal Code')]/../following-sibling::td[1]//input");
	public By con_address_mailing_country = By.xpath("//label[contains(text(), 'Mailing Country')]/../following-sibling::td[1]//input");
	public By con_save_buttonn = By.xpath("//input[@type='submit'][@name='save']");
	By other_address_box_selection = By.xpath("//button[contains(text(), 'Other Address')]");
	By use_this_address_on_other_address_page =  By.cssSelector("button[class='slds-button slds-button--brand']");
	By list_view_dropdown_sflt = By.xpath("//a[contains(@title, 'Select List View')]");
	By sflt_swag_iq_order_view_all = By.xpath("//div/span[contains(.,'View All') and span[contains(.,'SwagIQ Order')]]");
	
	
	
	
	public void use_this_address_on_other_address_page()
	{
		findElement(driver, use_this_address_on_other_address_page).click();
	}
	
	public boolean verify_content_on_Page(WebDriver driver, String content_xpath)throws Exception{
		boolean content_visible = driver.findElement(By.xpath(content_xpath)).isDisplayed();
		System.out.println("Required Element found on page :"+ content_visible);
		return content_visible;
	}
	
	
	
	public void fill_other_address(String input_id, String input_value) throws Exception
	{
		driver.findElement(By.xpath("(//input[@id='"+input_id+"'])[1]")).sendKeys(input_value);
		
	}
	
	public void select_other_address() throws Exception
	{
		findElement(driver, other_address_box_selection).click();
	}

	
	public String con_send_swag_not_avbl_message(WebDriver driver)
	{
		WebElement Message= driver.findElement(By.xpath(con_send_swag_not_avbl));
		return Message.getText();
	}

	
	public void click_send_swag_back_pop_up(WebDriver driver)
	{
		findElement(driver, con_do_not_swag_back_button).click();
		}

	
	public void set_do_not_swag_checkbox_as_unchecked(WebDriver driver)
	{
		if (isElementVisible(driver, con_do_not_swag_checkbox)) {
			findElement(driver, con_edit_button).click();
			findElement(driver, con_edit_checkbox_donotswag).click();
			findElement(driver, con_save_button).click();
		}
	}

	
	public void set_do_not_swag_checkbox_as_checked(WebDriver driver)
	{
		if (isElementVisible(driver, con_do_not_swag_uncheck)) {
			findElement(driver, con_edit_button).click();
			findElement(driver, con_edit_checkbox_donotswag).click();
			findElement(driver, con_save_button).click();
		}
	}

	
	public void use_this_address() throws Exception
	{
		clickElement(driver, use_this_address_button);
	}
	
	public void select_contact_address() throws Exception
	{
		clickElement(driver, contact_address_box_selection);
	}

	public void sflt_select_account_address()
	{
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		findElement(driver, account_address_box_selection).click();
		System.out.println("selected account type address to send swag");
		driver.switchTo().defaultContent();
	}
	
	public void click_sendswagbutton()
	{
		System.out.println("we are inside click sendswagbutton method");
		findElement(driver, send_marketing_button).click();
	}
	
	public void opencontact(String first_name, String last_name)
	{
		try {
			System.out.println("we are inside opencontact method");
			driver.findElement(By.xpath("//span[contains(text(), '" + first_name + "')]/ancestor::div[contains(@id, 'FULL_NAME')]/a")).click();
			System.out.println("opened the contact succesfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void open_tab(String tabname) throws Exception {
		
		System.out.println("I am within open_tab method");
		clickElement(driver, all_tabs);
		driver.findElement(By.xpath("//table[@class='detailList tabs']//a[contains(text(),'"+tabname+"')]")).click();
		System.out.println("Tab Clicked successfully");
	}
	
	public void open_tab_lightng(String tabname) throws Exception
	{   
		clickElement(driver, sflt_app_launcher);
		System.out.println("I am within open_tab method");
		enterText(driver, $sflt_select_app_input, tabname);
		By sflt_click_on_tab = By.xpath ("//mark[contains(text(), '"+tabname+"')]");
		clickElement(driver, sflt_click_on_tab);
		System.out.println("Tab Clicked successfully");
		
	}
	
	
	public void selectview(String viewname) throws Exception
	{
		clickElement(driver, list_view_drop_down);
		driver.findElement(By.xpath("//option[contains(text(),'"+viewname+"')]")).click();
		clickElement(driver, go_button);
		System.out.println("selected view list successfully");
	}
	
	public void go_inside_iframe()
	{
		WebElement iframe_outer = driver.findElement(By.xpath(canvas_outerframe));
		driver.switchTo().frame(iframe_outer);
		System.out.println("I am within outer iframe");
		driver.switchTo().frame(driver.findElement(By.xpath(canvas_innerframe)));
		System.out.println("I am inside the inner iframe");
	}
	public void verify_program_on_contact_send_marketing_page(String program_name, String product_name) throws Exception
	{
		String program_title = program_name + " - " + product_name;
		switchToFrame(driver);
		waittillinvisibility(driver, loading_configuration);


		findElement(driver, first_program_on_canvas_screen);
		clickElement(driver, set_product_filter_txtbox);
		System.out.println("clicked on text box successfully");
		enterText(driver, set_product_filter_txtbox, program_title);
		System.out.println("entered the text in box successfully");
		WebElement searched_element = driver.findElement(By.xpath(xpath1.replace("$$program_name$$",program_title)));
		System.out.println("element captured succesfully, searched_element");
		
		Boolean result = isElementVisible(driver, searched_element, 60);
		
				if (result == true)
		{
			System.out.println("element exists:" +result );
		}
			else
		{
			System.out.println("element doesn't exist:" +result);
		}
		driver.switchTo().defaultContent();
		
	}
	
	
	public void click_program_on_send_swag_screen(String program_name)
	{
		driver.findElement(By.xpath(program_selection_on_send_swag_screen.replace("$$program_name$$", program_name))).click();
		System.out.println("clicked on program "+program_name+" name successfully");
	}
	
	public boolean assert_value_n_report_result(boolean expected_value, boolean actual_value, String validation_message)
	{
		if (expected_value==actual_value) {
			System.out.println("comparision passed: true");
			return true;
		}else {
			System.out.println("comparision passed: false");
			//break;
			return false;	
		}
	}

			/***************Deepak Sharma**********************/////////////////
	
	public void sflt_click_program_on_send_swag_screen(String program_name, String product_name) throws Exception
	{
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		click_program_on_send_swag_screen(program_name, product_name);		
	}
	
	public void sflt_verify_program_on_contact_send_marketing_page(String program_name, String product_name) throws Exception
	{
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		verify_program_on_contact_send_marketing_page(program_name, product_name);
	}
	
	public void sflt_use_this_address() throws Exception
	{
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		clickElement(driver, use_this_address_button);
		driver.switchTo().defaultContent();
		
	}
	
	public void sflt_select_contact_address() throws Exception
	{
		WebElement sflt_inner_frame = driver.findElement(By.xpath(Constants.sflt_frame));
		driver.switchTo().frame(sflt_inner_frame);
		clickElement(driver, contact_address_box_selection);
		driver.switchTo().defaultContent();				
	}
	
	public void sflt_open_contact(String first_name, String last_name) throws Exception
	{
		wait_min();
		//waitForPageToLoad1(driver);
		String full_name = first_name + " "+ last_name;
		System.out.println("full name is : " +full_name);
		By contact_link = By.xpath("(//a[contains(@title ,'"+full_name+"')])[1]");
		clickElement(driver, contact_link);
		System.out.println("clicked on contact successfully to delete the item");
	}
	
	public void sflt_delete_order(String product_name, String program_name, String order_status) throws Exception
	{
		String program_title = program_name + " - "+ product_name;
		clickElement(driver, sflt_swag_iq_order_view_all);
		waitForPageToLoad1(driver);
		By order_to_delete = By.xpath("(//*[contains(text(), '"+order_status+"')]/ancestor::tr[1]//a[contains(text(), '"+program_title+"')]/ancestor::tr[1]//span[contains(text(), 'Show More')]/..)[1]");
		clickElement(driver, order_to_delete);
		By delete_option = By.xpath("//a[contains(@title, 'Delete')]");
		By delete_option_on_alert = By.xpath("//span[contains(text(), 'Delete')]");
		By breadcrumb_user = By.xpath("//nav[@aria-label='Breadcrumbs']//span[contains(.,'PFL Auto_Contact')]");
		clickElement(driver, delete_option);
		clickElement(driver, delete_option_on_alert);
		clickElement(driver, breadcrumb_user);
		System.out.println("Order Deleted successfuly");
	}
	
	public void sflt_verify_lightning_page(By sflt_app_launcher, By sflt_lightning_icon) throws Exception
	{
		boolean status = check_element_visibility(sflt_app_launcher);
		System.out.println("current status is lightning mode: " +status);
		if(status==true)
		{
			System.out.println("already on lightning");
			
			
		}
		else
		{
			System.out.println("moving to lightning");
			clickElement(driver, sflt_lightning_icon);
		}
	}
	
	public boolean check_element_visibility(By locator)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			//wait.until(ExpectedConditions.visibilityOf(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch (Exception e)
		{
			System.out.println("element not visible");
			return false;
		}
	}
	
	public void sflt_select_view(String view_name) throws Exception
	{
		clickElement(driver, list_view_dropdown_sflt);
		By viewname = By.xpath("//span[contains(text(), '"+view_name+"')]/..");
		clickElement(driver, viewname);
		System.out.println("clicked on view name successfully");
	}
	
	public void click_program_on_send_swag_screen(String program_name, String product_name) throws Exception
	{
		switchToFrame(driver);
		System.out.println("going to click on product now");
		String program_title = program_name + " - " + product_name;
		System.out.println("program title is: " +program_title);
		driver.findElement(By.xpath("//label[contains(text(), '"+program_title+"')]/ancestor::div[@class = 'box-title']")).click();
		System.out.println("clicked on product successfully");
		driver.switchTo().defaultContent();		
	}
	
	public void select_account_address()
	{
		findElement(driver, account_address_box_selection).click();
		System.out.println("selected account type address to send swag");
	}

	public void delete_order(String product_name, String program_name, String order_status)
	{
		String program_title = program_name + " - "+ product_name;
		Scroll_ByVisibleElement(driver, swag_iq_order_related_list_section);
		driver.findElement(By.xpath("//td[contains(text(), '"+order_status+"')]/ancestor::tr[1]//a[contains(text(), '"+program_title+"')]/ancestor::tr[1]//a[contains(text(), 'Del')]")).click();
		driver.switchTo().alert().accept();
		System.out.println("Order Deleted successfuly");
		
	}
	
	public void verify_inactiveprogram_on_contact_send_marketing_page(WebDriver driver,String program_name) throws Exception {
		switchToFrame(driver);
		clickElement(driver, set_product_filter_txtbox);
		System.out.println("clicked on text box successfully");
		enterText(driver, set_product_filter_txtbox, program_name);
		System.out.println("entered the text in box successfully");
		assertTrue(isElementVisible(driver,By.xpath("//label[text()='No products found.']")));
		System.out.println("No product Found for Program");
		
	}
	
	public void create_new_contact(WebDriver driver, String first_n_value, String last_n_value, String mailing_address_street,
			String mailing_address_zipcode, String mailing_country_value) throws Exception {
		
		clickElement(driver, con_new_button);
		wait_min();
		driver.findElement(con_first_name).sendKeys(first_n_value);
		wait_min();
		driver.findElement(con_last_name).sendKeys(last_n_value);
		wait_min();
		driver.findElement(con_address_mailing_street).sendKeys(mailing_address_street);
		wait_min();
		driver.findElement(con_address_mailing_zipcode).sendKeys(mailing_address_zipcode);
		wait_min();
		driver.findElement(con_address_mailing_country).sendKeys(mailing_country_value);
		wait_min();
		clickElement(driver, con_save_buttonn);
		waitForPageToLoad1(driver);
		
		
		

	}


}








