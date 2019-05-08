package com.pfl.automation.utils;

import org.openqa.selenium.By;

public class Constants {
	
	public static final boolean GRID_RUN= false;
	
	public static long PAGE_LOAD_Timeout = 50;
	public static long IMPLICIT_WAIT = 50;
	
	public static String IsLightingEnabled = "False";
	
	public static By sflt_lightning_icon = By.cssSelector("a.switch-to-lightning");
	public static By sflt_app_launcher = By.xpath ("//div[contains(@class, 'slds-icon-waffle')]/..");

	
	public static final String REPORTS_PATH = null;
	public static final String ExecutionResultFile = "TestExecutionResult.txt";
	public static final String logFile = "testlog.log";
	public static final String logHTMLFile = "application.html.txt";
	public static final String TestDataFile = "TestData.xml";
	public static final String PropertyFileName = "info.properties";
	public static final String lg4jPropFileName = "log4j.properties";
	
	//Project Folder Path
	public static final String LogFileLocation = "\\logs\\";
	public static final String ExecutionFolder = "\\src\\test\\resources\\executionresults\\";
	public static final String screenshotFolder = "\\screenshots\\";
	public static final String testDataFolder = "\\src\\test\\resources\\testdata\\";
	public static final String configFolder = "\\src\\test\\resources\\config\\";
	
	//Drivers
	public static final String chromeDriverPath = "\\src\\test\\resources\\drivers\\chromedriver.exe";
	public static final String firefoxDriverPath = "\\src\\test\\resources\\drivers\\geckodriver.exe";
	public static final String ieDriverPath = "\\src\\test\\resources\\drivers\\IEDriverServer.exe";
	public static final String edgeDriverPath = "\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe";
	
	public static String username = "mohit.gulati@metacubeautomation.com";
	public static String password = "admin123#";
	
	public static String sfauser= "amit@metacubeautomation.com";
	public static String sfapass = "admin1234";
	
	public static String sfsuser="deepak@metacubeautomation.com";
	public static String sfspass="admin123";
	
	public static String sfnuer= "nishant.jain@metacubeautomation.com";
	public static String sfnpass = "Test@123";
	
	public static String sfruser= "rani.dixit@metacubeautomation.com";
	public static String sfrpass= "admin123";
	
	public static String emailid= "pflqatesting@gmail.com";
	public static String emailpassword = "PFL$12345";
	public static String setRecipients = "nishant.jain2601@gmail.com";
	
	public static String ParentFrameid = "canvas-outer-_:SwagIQ_Canvas_Staging:j_id0:canvasApp:canvasapp";
	public static String ChildFrameId = "canvas-inner-_:SwagIQ_Canvas_Staging:j_id0:canvasApp:canvasapp";
	public static String sflt_frame =  "//div[contains(@class, 'oneAlohaPage')]//iframe";
	
	public static String pfl_contact_view = "PFL Auto Contact";
	public static String tab_contacts = "Contacts";
	public static String con_bd_auto_contact_first_name = "PFL";
	public static String con_bd_auto_contact_last_name = "Auto_Contact";
	public static String canvas_outerframe = "//div[@id ='canvas']//iframe";
	public static String canvas_innerframe = "//div[@id ='canvasapp']//iframe";
	public static String canvas_object = "//div[contains(text(),'User Administration')]";
	public static String tab_swagiq_tools = "SwagIQ Tools";	
	public static String un_license_user = "user_4, Automation";
	
	public static String first_name = "PFL";
	public static String lasr_name = "Auto_Contact";
	
	public static String product_name = "PFL_Auto_Product5";
	public static String product_count ="1";
	public static String tab_swag_iq_tool = "SwagIQ Tools";
	public static String product_name_two = "PFL_Auto_Product4";

	
	public static String validation_message = "element found successfully";
	
	public static String tstMsg = "Searched element found";
	public static String errorMsgTxt = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	
	public static String con_other_address_line1 = "input-AddressLine1";
	public static String con_other_address_line2 = "input-AddressLine2";
	public static String con_other_city_field = "input-City";
	public static String con_other_state_field = "input-State";
	public static String con_other_postal_code = "input-PostalCode";
	public static String con_other_postal_country = "input-Country";
	public static String con_other_phone_number = "input-Phone";
	public static String con_other_company_name = "input-Company";
	
	public static String con_other_address_line1_value =  "Flat No 305 J Sons Felicia Cross Layout Singarr";
	public static String con_other_address_line2_value =  "Flat No 305 J Sons Felicia Cross Layout Singarr";
	public static String con_other_city_field_value =  "Flat No 305 J Sons Felicia Cross Layout Singarr";
	public static String con_other_state_field_value =  "Flat No 305 J Sons Felicia Cross Layout Singarr";
	public static String con_other_postal_code_value =  "101010101010";
	public static String con_other_postal_country_value =  "INDIAINDIAINDIAINDIAINDIA";
	public static String con_other_phone_number_value =  "01412525250141252525";
	public static String con_con_other_company_name_value =  "MetacubeMetacubeMetacubeMetacubeMetacube";
	
	public static String con_error_other_name_address1 =  "The shipping label has a limit of 35 characters for Address Line 1.";
	public static String con_error_other_name_address2 = "The shipping label has a limit of 34 characters for Address Line 2.";
	public static String con_error_other_name_city =  "The shipping label has a limit of 35 characters for City.";
	public static String con_error_other_name_state =  "The shipping label has a limit of 30 characters for State.";
	public static String con_error_other_name_country =  "The shipping label has a limit of 20 characters for Country.";
	public static String con_error_other_name_phone_name =   "The shipping label has a limit of 16 characters for Phone.";
	public static String con_error_other_name_company_name =  "The shipping label has a limit of 35 characters for Company.";
	public static String con_error_other_name_postal_code =  "The shipping label has a limit of 10 characters for Postal Code.";
	
	public static String con_other_address_line1_valid_value = "100 PFL Way";
	public static String con_other_address_line2_valid_value = "PFL Office";
	public static String con_other_city_field_valid_value  = "Livingston";
	public static String con_other_state_field_valid_value= "Montana";
	public static String con_other_postal_code_valid_value  = "90006";
	public static String con_other_postal_country_valid_value  = "USA";
	public static String con_other_phone_number_valid_value =   "9342323333";
	public static String con_con_other_company_name_valid_value =  "PFL";

	public static String username1 = "test-user@metacubeautomation.com";
	public static String password1 = "admin123#";	
	
	//TestRail Configuration
	public static String TEST_RUN_ID                 = "2";
	public static String TEST_CASE_ID                = "6";
	public static String TESTRAIL_USERNAME          = "pflqatesting@gmail.com";
	public static String TESTRAIL_PASSWORD          = "Alwar_301001";
	public static String RAILS_ENGINE_URL           = "https://pflautomation.testrail.io/";
	public static final int TEST_CASE_PASSED_STATUS = 1;
	public static final int TEST_CASE_FAILED_STATUS = 5;
		
	public static String admin_program_page_product_xpath_after_selection ="//div/p[contains(.,'PFL_Auto_Product4')]";
	public static String admin_program_page_product_unavailable_text = "//text()[contains(.,'No Results Found')]/ancestor::div[1]";
	public static String con_send_swag_select_address = "//span[contains(text(), 'Contact Address')]/ancestor::div[1]";
	public static String con_error_city_is_required = "//div/span[contains(.,'City is required.')]";
	public static String con_error_state_is_required = "//div/span[contains(.,'State is required.')]";
	public static String con_error_phone_is_required = "//div/span[contains(.,'Phone is required.')]";
	
	//Grid Implementation
	public static String hub = "http://localhost:4444/wd/hub";
	public static String node1 = "http://172.16.25.25:5566/wd/hub";
	
	
	
}
