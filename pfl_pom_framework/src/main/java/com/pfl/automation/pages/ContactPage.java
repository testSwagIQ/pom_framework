package com.pfl.automation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pfl.automation.base.BasePage;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}

	By con_send_marketing_button = By.xpath("//*[contains(@title, 'Send Marketing Materials')]");
	By con_select_send_swag_address = By.xpath("//span[contains(text(), 'Contact Address')]/ancestor::div[1]");
	By con_send_swag_use_this_address = By.xpath("//button[contains(text(), 'this address')]/..//button[1]");
	By con_use_this_address_button = By.xpath("//button[contains(text(), 'this address')]/..//button[1]");
	By con_no_product_available_msg = By.xpath(
			"//label[contains(text(),'You do not have any products available to order. Please contact your SwagIQ Admin.')]");
	By con_pfl_auto_use = By.xpath("//a[contains(text(),'Auto_Contact, PFL')]");
	By con_error_mesage = By.xpath(
			"//label[text()='You do not have any products available to order. Please contact your SwagIQ Admin.']");

	public void opencontact(String first_name, String last_name) throws Exception {

		System.out.println("we are inside opencontact method");
		clickElement(driver, con_pfl_auto_use);
		System.out.println("opened the contact succesfully");
	}

	public void click_on_send_marketing_button() {
		try {
			clickElement(driver, con_send_marketing_button);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void select_contact_address() throws Exception {
		clickElement(driver, con_select_send_swag_address);

	}

	public void use_this_address() {
		findElement(driver, con_use_this_address_button).click();
		try {
			waitForPageToLoad1(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verify_error_message() throws Exception {

		System.out.println("I am within verify error msg method");
		// boolean error_visible = findElement(driver, con_error_mesage).isDisplayed();
		// System.out.println("error visibility: " +error_visible);

		switchToFrame(driver);

		System.out.println("entered in frame successfully");

		waitForPageToLoad1(driver);

		assertTrue(isElementVisible(driver, con_error_mesage));
		System.out.println("Asserted error message successfully");
		driver.switchTo().defaultContent();
		System.out.println("successfully came out from iframe");

	}

}
