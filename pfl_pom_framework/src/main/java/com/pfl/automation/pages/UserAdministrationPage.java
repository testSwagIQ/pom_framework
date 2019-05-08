package com.pfl.automation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pfl.automation.base.BasePage;
import com.pfl.automation.utils.Log;

public class UserAdministrationPage extends BasePage{
	
	//*************************Declare Locators*********************************
	
	By licenses_link_xpath = By.xpath("//a[text()='Licenses']");
	By administration_link_xpath = By.cssSelector("//a[text()='Administration']");
	By admin_user_search_checkbox  = By.cssSelector("//td[@class='userlist-checkbox-cell col-1']/input");
	By user_admin_fn_column = By.xpath("//th[@title='First Name']/span");
	By user_admin_ln_column  = By.xpath("//th[@title='Last Name']/span");
	By user_admin_title_column  = By.xpath("//th[@title='Title']/span");
	By user_admin_email_column  = By.xpath("//th[@title='Email']/span");
	By user_admin_role_column  = By.xpath("//th[@title='Role']/span");
	By user_admin_profile_column  = By.xpath("//th[@title='Profile']/span");
	By user_admin_cost_center_column  = By.xpath("//th[@title='Cost Center']/span");
	By user_admin_region_column  = By.xpath("//th[@title='Region']/span");
	By user_admin_Country_column  = By.xpath("//th[@title='Country']/span");
	By user_admin_User_Type_column  = By.xpath("//th[@title='User Type']/span");
	By user_admin_Add_user_button  = By.xpath("//text()[contains(.,'Add Users')]/ancestor::a[1]");
	By user_admin_program_product_name  = By.xpath("//button[contains(text(),'Advanced')]"); 
	By user_admin_product_name  = By.xpath("//a[text()='Metacube1']"); 
	By user_admin_edit_user_button  = By.xpath("//text()[contains(.,'Edit Users')]/ancestor::button[1]"); 
	By user_admin_selectall_checkbox  = By.xpath("//input[@type='checkbox'][@id='ckBxAll']");
	By admin_advance_search_button = By.xpath("//button[contains(text(),'Advanced')]");
	By admin_search_email = By.xpath("(//input[@id='advSearch_title'])[2]");
	By admin_search_admin_access_level = By.xpath("//option[contains(text(),'Admin')]");
	By admin_searchbar_on_users_page = By.xpath("//input[@id='inputSearch']");
	By admin_user_detail = By.xpath("//td[contains(@title,'Tech Master')]/..");
	By admin_user_detail1 = By.cssSelector("td[title='Tech Master']");
	By admin_user_remove_button = By.xpath("//button[contains(text(),'Remove')]");
	By admin_add_users_confirm_button_ok = By.xpath("//button[contains(text(),'Ok')]");
	By admin_add_user_button_on_users_admin_page = By.xpath("//a[contains(@title,'Add Users')]");
	By admin_select_checkbox_user = By.xpath("(//input[contains(@type,'checkbox')])[3]");
	By admin_add_user_button_for_adding_user = By.xpath("//button[contains(.,'Add 1 Users')]");

				
		
	//*************************Initilizing the page objects *********************************
    
	public UserAdministrationPage(WebDriver driver) {
		this.driver = driver;
	}
    
    //*************************Declare Function *********************************
    
    public void verifyUserAdministration(WebDriver driver) {
		
		assertTrue(isElementVisible(driver, licenses_link_xpath));
		assertTrue(isElementVisible(driver, administration_link_xpath));
		
		switchToFrame(driver);
		
		assertTrue(isElementVisible(driver, admin_user_search_checkbox));
		assertTrue(isElementVisible(driver, user_admin_fn_column));
		assertTrue(isElementVisible(driver, user_admin_ln_column));
		assertTrue(isElementVisible(driver, user_admin_title_column));
		assertTrue(isElementVisible(driver, user_admin_email_column));
		assertTrue(isElementVisible(driver, user_admin_role_column));
		assertTrue(isElementVisible(driver, user_admin_profile_column));
		assertTrue(isElementVisible(driver, user_admin_cost_center_column));
		assertTrue(isElementVisible(driver, user_admin_region_column));
		assertTrue(isElementVisible(driver, user_admin_Country_column));
		assertTrue(isElementVisible(driver, user_admin_User_Type_column));
		assertTrue(isElementVisible(driver, user_admin_Add_user_button));
		assertTrue(isElementVisible(driver, user_admin_program_product_name));
		assertTrue(isElementVisible(driver, user_admin_product_name));
		assertTrue(isElementVisible(driver, user_admin_edit_user_button));
		assertTrue(isElementVisible(driver, user_admin_selectall_checkbox));
		
		driver.switchTo().defaultContent();
	}
	
	public void Click_AddUsers_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_Add_user_button);
		driver.switchTo().defaultContent();
	}
	
	public void Click_AdvanceSearch_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_program_product_name);
		driver.switchTo().defaultContent();
	}
	
	public void Click_ProductName_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_product_name);
		driver.switchTo().defaultContent();
	}
	
	public void Click_FirstNameColumn_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_fn_column);
		driver.switchTo().defaultContent();
	}
	
	public void Click_LastNameColumn_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_ln_column);
		driver.switchTo().defaultContent();
	}
	
	public void Click_TitleColumn_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_title_column);
		driver.switchTo().defaultContent();
	}
	
	public void Click_EmailColumn_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_email_column);
		driver.switchTo().defaultContent();
	}
	
	public void Click_RoleColumn_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_role_column);
		driver.switchTo().defaultContent();
	}
	
	public void Click_ProfileColumn_UserAdministration(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, user_admin_profile_column);
		driver.switchTo().defaultContent();
	}
	
	public void Search_UserAdministration(WebDriver driver, String text) {
		switchToFrame(driver);
		enterText(driver, admin_user_search_checkbox,"text");
		driver.switchTo().defaultContent();
	}
	
	public void click_on_advanced_search_button(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver,admin_advance_search_button);
		//driver.switchTo().defaultContent();
	}
	
	public void advance_search_using_id_and_value(WebDriver driver,String id,String value) {
		//switchToFrame(driver);
		driver.findElement(By.xpath("//input[@id='"+id+"']")).sendKeys(value);
	}
	
	public void search_email_Advance_Search(WebDriver driver,String email) {
		enterText(driver,admin_search_email,email);
	}
	
	public void search_access_level_Advance_Search(WebDriver driver) throws Exception {
		clickElement(driver, admin_search_admin_access_level);
	}
	
	public void verify_value_using_advance_search(WebDriver driver,String parameter) {
		assertTrue(isElementVisible(driver,By.xpath("//td[contains(@title,'"+parameter+"')]")));
		Log.info("Verify  "+parameter+" Successfully");
	}
	
	public void search_user_on_user_administration(WebDriver driver,String parameter){
		switchToFrame(driver);
		enterText(driver,admin_searchbar_on_users_page,parameter);
		driver.switchTo().defaultContent();
	}
	
	public void open_user_detail_section(WebDriver driver) throws Exception {
		switchToFrame(driver);
		isElementVisible(driver,admin_user_detail1);
		
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", admin_user_detail1);
		//Actions actions = new Actions(driver); 
		//WebElement elementLocator = driver.findElement(By.cssSelector("td[title='Tech Master']")); 
		driver.findElement(admin_user_detail1).click();
		//actions.doubleClick(elementLocator).perform();
		//doubleclickElement(driver, admin_user_detail1);
		System.out.println("Clicked to User detail once");
		wait_min();
		
		//driver.findElement(admin_user_detail1).click();
		System.out.println("Clicked to User detail twice");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(admin_user_remove_button));
		driver.switchTo().defaultContent();
	}
	
	public void remove_user_on_Store(WebDriver driver) throws Exception {
		switchToFrame(driver);
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println("Clicked to remove once");
		executor.executeScript("arguments[0].click();", element);
		wait_min();
		System.out.println("Clicked to remove twice");
		//executor.executeScript("arguments[0].click();", element);
		//driver.findElement(admin_user_remove_button).click();
		//clickElement(driver, admin_user_remove_button);
		driver.switchTo().defaultContent();
	}
	
	public void click_on_ok_user_confirmation(WebDriver driver) throws Exception {
		switchToFrame(driver);
		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		//clickElement(driver, admin_add_users_confirm_button_ok);
		driver.switchTo().defaultContent();
	}
	
	public void verify_unauthorized_message_on_administrator_page_on_classic(WebDriver driver) {
		switchToFrame(driver);
		assertTrue(isElementVisible(driver,By.xpath("//h3[contains(text(),'You are not authorized to view that resource.')]")));
		Log.info("Verify You are not authorized to view that resource. msg Successfully");
		System.out.println("Verify You are not authorized to view that resource. msg Successfully");
		driver.switchTo().defaultContent();
	}
	
	public void click_on_add_users_button_on_users_administration_page(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, admin_add_user_button_on_users_admin_page);
		driver.switchTo().defaultContent();
	}
	
	public void select_user_to_add_in_store(WebDriver driver) throws Exception {
		switchToFrame(driver);
		clickElement(driver, admin_select_checkbox_user);
		driver.switchTo().defaultContent();
	}
	
	public void click_add_user_button_in_store(WebDriver driver)throws Exception {
		switchToFrame(driver);
		clickElement(driver, admin_add_user_button_for_adding_user);
		driver.switchTo().defaultContent();
	}
	
	public void change_user_access_to_standard(WebDriver driver) {
		switchToFrame(driver);
		WebElement element = driver.findElement(By.xpath("//div[@id ='accessLevel']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		wait_min();
		WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'Standard User')]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		driver.switchTo().defaultContent();
	}
	
	public void save_user_on_Store(WebDriver driver) {
		switchToFrame(driver);
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Save') and @ng-disabled = '!adminUserListRowEditCtrl.form.$dirty']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();
	}
	
	public void change_user_access_to_admin(WebDriver driver) {
		switchToFrame(driver);
		WebElement element = driver.findElement(By.xpath("//div[@id ='accessLevel']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//wait_min();
		WebElement element1 = driver.findElement(By.xpath("//a[@href='#'][contains(.,'Admin')]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		wait_min();
		driver.switchTo().defaultContent();
	}
}
	

