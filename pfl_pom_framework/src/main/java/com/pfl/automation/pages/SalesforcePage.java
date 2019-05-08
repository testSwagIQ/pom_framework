package com.pfl.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pfl.automation.base.BasePage;

public class SalesforcePage extends BasePage {
	//WebDriver driver;
	
	public SalesforcePage(WebDriver driver) {
		this.driver = driver;
	}

	BasePage tb = new BasePage();
	
	By send_marketing_button =  By.xpath("//*[contains(@title, 'Send Marketing Materials')]");
	By contact_address_box_selection = By.xpath("//span[contains(text(), 'Contact Address')]/ancestor::div[1]");
	By use_this_address_button =  By.xpath("//button[contains(text(), 'this address')]/..//button[1]");
	String canvas_outerframe = "//div[@id ='canvas']//iframe";
	String canvas_innerframe = "//div[@id ='canvasapp']//iframe";
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

	
	public void use_this_address()
	{
		findElement(driver, use_this_address_button).click();
	}
	
	public void select_contact_address()
	{
		findElement(driver, contact_address_box_selection).click();
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
	
	public void open_tab(String tabname)
	{
		System.out.println("I am within open_tab method");
		findElement(driver, all_tabs).click();
		driver.findElement(By.xpath("//table[@class='detailList tabs']//a[contains(text(),'"+tabname+"')]")).click();
		System.out.println("Tab Clicked successfully");
		
	}
	
	public void selectview(String viewname)
	{
		findElement(driver, list_view_drop_down).click();
		driver.findElement(By.xpath("//option[contains(text(),'"+viewname+"')]")).click();
		findElement(driver, go_button).click();
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
	public void verify_program_on_contact_send_marketing_page(String program_name)
	{
		
		WebElement iframe_outer = driver.findElement(By.xpath(canvas_outerframe));
		driver.switchTo().frame(iframe_outer);
		System.out.println("I am within outer iframe");
		driver.switchTo().frame(driver.findElement(By.xpath(canvas_innerframe)));
		System.out.println("I am inside the inner iframe");
		
		waittillinvisibility(driver, loading_configuration);


		findElement(driver, first_program_on_canvas_screen);
		findElement(driver, set_product_filter_txtbox).click();
		System.out.println("clicked on text box successfully");
		findElement(driver, set_product_filter_txtbox).sendKeys(program_name);
		System.out.println("entered the text in box successfully");
		WebElement searched_element = driver.findElement(By.xpath(xpath1.replace("$$program_name$$",program_name)));
		//driver.findElement(By.xpath(xpath1.replace(arg0, arg1)));
		Boolean result = isElementVisible(driver, searched_element, 30);
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
	
	public void click_program_on_send_swag_screen(String product_name, String program_name)
	{
		System.out.println("going to click on product now");
		String program_title = program_name + " - " + product_name;
		WebElement iframe_outer = driver.findElement(By.xpath(canvas_outerframe));
		driver.switchTo().frame(iframe_outer);
		driver.switchTo().frame(driver.findElement(By.xpath(canvas_innerframe)));
		System.out.println("going to click on product now, after entering in iframe");
		//switchToFrame(driver);
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


}








