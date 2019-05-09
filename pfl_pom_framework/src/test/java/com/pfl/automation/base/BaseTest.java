package com.pfl.automation.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;

//https://sites.google.com/a/chromium.org/chromedriver/capabilities

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Case;
import com.codepine.api.testrail.model.CaseField;
import com.codepine.api.testrail.model.Project;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;
import com.codepine.api.testrail.model.Section;
import com.codepine.api.testrail.model.Suite;
import com.pfl.automation.org62.pages.AdminPage;
import com.pfl.automation.org62.pages.ContactPage;
import com.pfl.automation.org62.pages.HomePage;
import com.pfl.automation.org62.pages.LicensePage;
import com.pfl.automation.org62.pages.LoginPage;
import com.pfl.automation.org62.pages.ProductAdministrationPage;
import com.pfl.automation.org62.pages.ProgramAdministrationPage;
import com.pfl.automation.org62.pages.SalesforcePage;
import com.pfl.automation.org62.pages.SwagIQPage;
import com.pfl.automation.org62.pages.UserAdministrationPage;
import com.pfl.automation.utils.Constants;
import com.pfl.automation.utils.Log;
import com.pfl.automation.utils.mail.APIClient;
import com.pfl.automation.utils.mail.APIException;

public class BaseTest {

	public WebDriver driver;
	public static Properties prop;
	public static String propxml;
	public static String search_name;
	public static String url, email, phone, folder, licensename = null;

	public static String tstMsg = null;
	public static String first_n_value = null;
	public static String last_n_value = "sharma";
	public static String mailing_address_street = null;
	public static String mailing_address_zipcode = null;
	public static String mailing_country_value = null;
	public static String phone_no = null;
	public static String state = null;
	public static String city = null;
	public static String admin_bd_auto_program_1 = null;
	public static String admin_bd_auto_product_1 =null;
	
	public SwagIQPage swagiq;
	public LoginPage loginPage;
	public HomePage homePage;
	public ProgramAdministrationPage programAdminPage;
	public UserAdministrationPage userAdminPage;
	public ProductAdministrationPage productAdministrationPage;
	public SalesforcePage salsesforcePage;
	public LicensePage licensepage;
	public ContactPage contactpage;
	public AdminPage adminpage;
	
	//****************************TestNG Annotations For all Test Cases****************************
	@BeforeTest
	//@Parameters(value={"browser"})
	public void setUp() throws Exception {
		callBasicConfigFiles();
		//initBrowser();
		openBrowser();
		
		//testngBrowserlaunch(browserName);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		swagiq = new SwagIQPage(driver);
		programAdminPage = new ProgramAdministrationPage(driver);
		userAdminPage = new UserAdministrationPage(driver);
		productAdministrationPage = new ProductAdministrationPage(driver);
		salsesforcePage = new SalesforcePage(driver);
		adminpage = new AdminPage(driver);
		contactpage = new ContactPage(driver);
		licensepage = new LicensePage(driver);
	}
	
	@BeforeMethod
	public void LogIn(ITestResult result) throws Exception {
		//System.out.println("Executing TestCase Name :" + result.getMethod().getMethodName());
	}
	
	@AfterMethod
	public void Logout(ITestResult result) throws Exception {
		//Call Program to Capture screenshot in selenium for failed test cases
		taketestCaseScreenshot(driver, result.getMethod().getMethodName());
		if(result.getStatus() == ITestResult.FAILURE)
	    {
		   homePage.logout(driver);
		   System.out.println("Issue in Script explicitly logg off");
	       driver.close();
	    }
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {		
		closebrowser();
	}
	
	//****************************Initilize Config Files****************************	
	
	// Initilize the log file
	public void log4j_config() {
		// DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator
				.configure(System.getProperty("user.dir") + Constants.configFolder + Constants.lg4jPropFileName);
	}

	// init the prop file
	public void readConFigFile() {
		Log.info("Load Property File");
		// test.log(LogStatus.INFO, "Open Browser Successfully");
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + Constants.configFolder + Constants.PropertyFileName);
				prop.load(fs);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				Log.error(e.toString());
			}
		}
		Log.info("Property File Initilized");
	}

	public void navigate(String urlKey) {
		driver.get(prop.getProperty("url"));
	}
	
	public void killChromeInstances () {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		} catch (IOException e) {
			System.out.println("Failed to kill all the chrome Instances");
			e.printStackTrace();
		}
	}
	
	// init the testdata - xml file
	public void readxmlDataFile() {
		Log.info("Load Test data  - XML File");
		File inputFile = new File(System.getProperty("user.dir") + Constants.testDataFolder + Constants.TestDataFile);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputFile);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// search_name = document.selectSingleNode("//target/value").getText();
		System.out.println(search_name);
		Log.info("XML File Initilized");
	}

	public void ReadXML(String name) {
		try {
			// Get xml file
			File file = new File(System.getProperty("user.dir") + Constants.testDataFolder + Constants.TestDataFile);

			// Prepare XML
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document document = db.parse(file);

			url = document.getElementsByTagName("url").item(0).getTextContent();
			email = document.getElementsByTagName("email").item(0).getTextContent();
			phone = document.getElementsByTagName("phone").item(0).getTextContent();
			folder = document.getElementsByTagName("folder").item(0).getTextContent();

			tstMsg = document.getElementsByTagName("tstMsg").item(0).getTextContent();
			first_n_value = document.getElementsByTagName("first_n_value").item(0).getTextContent();
			last_n_value = document.getElementsByTagName("last_n_value").item(0).getTextContent();
			mailing_address_street = document.getElementsByTagName("mailing_address_street").item(0).getTextContent();

			mailing_address_zipcode = document.getElementsByTagName("mailing_address_zipcode").item(0).getTextContent();
			mailing_country_value = document.getElementsByTagName("mailing_country_value").item(0).getTextContent();
			phone_no = document.getElementsByTagName("phone_no").item(0).getTextContent();
			state = document.getElementsByTagName("state").item(0).getTextContent();
			city = document.getElementsByTagName("city").item(0).getTextContent();
			admin_bd_auto_program_1 = document.getElementsByTagName("admin_bd_auto_program_1").item(0).getTextContent();
			admin_bd_auto_product_1 = document.getElementsByTagName("admin_bd_auto_product_1").item(0).getTextContent();
			
			licensename = document.getElementsByTagName("licensename").item(0).getTextContent();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Write Execution Status to text file - TestExecutionResult.txt
	public void writeResults_File(WebDriver driver, String testcasename, String Status) throws IOException {
		// Delete File if Exists First
		DeleteExecutionFile();
		File filedata = new File(
				System.getProperty("user.dir") + Constants.ExecutionFolder + Constants.ExecutionResultFile);

		// Not Equal condition is modified
		if (filedata.exists() && filedata.isFile()) {
			FileWriter writecsv = new FileWriter(filedata, false);
			// String data = testcasename;
			writecsv.append("PFl Automation test Script Execution Status\n\n");

			writecsv.append("Smoke Suite Execution - " + get_date().toString() + "\n");
			writecsv.append(testcasename);
			writecsv.append(',');
			writecsv.append(Status + "\n");
			writecsv.close();
		}
	}

	// Write data in the notepad file
	public void txt_write(WebDriver driver, String testcasename, String Status) throws IOException {
		// Delete File if Exists First
		DeleteExecutionFile();
		FileWriter fr = new FileWriter(
				System.getProperty("user.dir") + Constants.ExecutionFolder + Constants.ExecutionResultFile);

		BufferedWriter br = new BufferedWriter(fr);

		br.write("PFl Automation test Script Execution Status");
		br.newLine();
		br.write("Smoke Suite Execution");
		br.newLine();
		br.write(testcasename + "," + Status);

		br.close();
	}

	// Delete a executionresults - TestExecutionResult.txt file
	public static void DeleteExecutionFile() {
		// get current project path
		String filePath = System.getProperty("user.dir") + Constants.ExecutionFolder;

		// create a new file
		File file = new File(filePath + "\\" + Constants.ExecutionResultFile);
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File is created");
			} else {
				// delete a file
				System.out.println("File is deleted");
				file.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Delete all Log File before execution
	public static void DeleteLogFile() {
		// get current project path
		String logFilePath = System.getProperty("user.dir") + Constants.LogFileLocation;
		String resultFilePath = System.getProperty("user.dir") + Constants.ExecutionFolder;

		// create a new file
		File logFile = new File(logFilePath + Constants.logFile);
		File logHTMLFile = new File(logFilePath + Constants.logHTMLFile);
		File resultsFile = new File(resultFilePath + Constants.ExecutionResultFile);
		try {
			if (!logFile.exists() || !logHTMLFile.exists() || !logHTMLFile.exists()) {
				resultsFile.createNewFile();
				System.out.println("Log and Result Files are deleted");
			} else {
				// delete a file
				System.out.println("Log and Result Files are deleted");
				logFile.delete();
				logHTMLFile.delete();
				resultsFile.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Call basic configuration
	public void callBasicConfigFiles() throws FileNotFoundException, IOException, DocumentException {
		readConFigFile();
		ReadXML(null);
		DeleteLogFile();
		log4j_config();
	}
	
	/*public void initBrowser() throws FileNotFoundException, IOException, DocumentException {
		if (!Constants.GRID_RUN) {
			//Local Machine
			openBrowserNormal();
		} else {
			//Grid Machines
			openBrowserGrid();
		}
	}*/
	
	public void openBrowserGrid() throws FileNotFoundException, IOException, DocumentException {
		String browser = prop.getProperty("browser");
		DesiredCapabilities cap = null;
		
		if (browser.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setJavascriptEnabled(true);
			cap.setPlatform(Platform.WINDOWS);
		} else if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--no-sandbox");
		    options.addArguments("--dns-prefetch-disable");
		    options.addArguments("--disable-device-discovery-notifications");
		    options.addArguments("--disable-infobars");
		    options.addArguments("start-maximized");
		    options.addArguments("--enable-precache");
		    options.setCapability("--applicationCacheEnabled", "true");
		    options.addArguments("--disable-notifications");
		    options.addArguments("--disable-extensions");
		    options.addArguments("--disable-geolocation");
		    options.addArguments("--ignore-certificate-errors");
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-infobars");
		    options.addArguments("--no-default-browser-check");
		    options.addArguments("--safebrowsing-disable-auto-update");
		    options.setProxy(null);
		    options.addArguments("--disable-default-apps");
		    options.addArguments("--disable-popup-blocking");
		    options.addArguments("--enable-experimental-canvas-features");
			
			cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
		} else if (browser.equals("IE")) {
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("IE");
			cap.setJavascriptEnabled(true);
			cap.setPlatform(Platform.WINDOWS);
		}
		try {
			driver = new RemoteWebDriver(new URL(Constants.hub), cap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		openURL();
		Log.info("URL load Successfully");
		System.out.println("Open Browser and Load the URL");
	}

	public WebDriver openBrowser() throws FileNotFoundException, IOException, DocumentException {
		Log.info("Open Browser Successfully");
		Reporter.log("Open Browser Successfully");

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Constants.chromeDriverPath);
			
			ChromeOptions chromeOptions = new ChromeOptions();
			
			chromeOptions.addArguments("start-maximized");
			//chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			chromeOptions.addArguments("--enable-precache");
			chromeOptions.setCapability("--applicationCacheEnabled", "true");
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--disable-geolocation");
			chromeOptions.addArguments("--ignore-certificate-errors");
			//chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-infobars");
	        chromeOptions.addArguments("--no-default-browser-check");
	        chromeOptions.addArguments("--safebrowsing-disable-auto-update");
			chromeOptions.setProxy(null);
	       // chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
	        //chromeOptions.addArguments("--enable-fast-unload");
	        //chromeOptions.addArguments("--enable-scroll-prediction");
	       
	        chromeOptions.addArguments("--disable-default-apps");
	        chromeOptions.addArguments("--disable-popup-blocking");
	        //chromeOptions.addArguments("--enable-precise-memory-info");
	        //chromeOptions.addArguments("--js-flags=--expose-gc");
	        //chromeOptions.addArguments("--enable-simple-cache-backend");
	        //chromeOptions.addArguments("--ignore-gpu-blacklist");
	          chromeOptions.addArguments("--enable-experimental-canvas-features");
	        //chromeOptions.addArguments("--enable-smooth-scrolling");
			//chromeOptions.addArguments("--enable-strict-powerful-feature-restrictions");
			//chromeOptions.addArguments("--max_old_space_size=4096");
			//chromeOptions.addArguments("--incognito");
	        //chromeOptions.addArguments("--profile-directory=Default");
			
			driver = new ChromeDriver(chromeOptions);
			Log.info("Chrome browser initilized Successfully");
		} else if (browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + Constants.firefoxDriverPath);

			/*
			 * ProfilesIni profile = new ProfilesIni(); FirefoxProfile myprofile =
			 * profile.getProfile("default");
			 * myprofile.setAcceptUntrustedCertificates(true);
			 * myprofile.setAssumeUntrustedCertificateIssuer(true);
			 */

			//driver = new FirefoxDriver();
			//Log.info("Firefox browser initilized Successfully");
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + Constants.ieDriverPath);
			driver = new InternetExplorerDriver();
			Log.info("IE browser initilized Successfully");
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
			Log.info("Edge browser initilized Successfully");
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + Constants.edgeDriverPath);
			driver = new InternetExplorerDriver();
			Log.info("IE browser initilized Successfully");
		} else if (browserName.equals("chromeheadless")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--disable-popup-blocking");
			chromeOptions.addArguments("--window-size=1440,900");
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.addArguments("--test-type");

			driver = new ChromeDriver(chromeOptions);
			Log.info("Chrome Headless Browser initilized Successfully");
//		} else if (browserName.equals("firefoxheadless")) {
//			FirefoxBinary firefoxBinary = new FirefoxBinary();
//			firefoxBinary.addCommandLineOptions("--headless");
//			System.setProperty("webdriver.gecko.driver", prop.getProperty("ffdriver_exe"));
//			FirefoxOptions firefoxOptions = new FirefoxOptions();
//
//			firefoxOptions.addArguments("--headless");
//			firefoxOptions.addArguments("--headless");
//			firefoxOptions.addArguments("--no-sandbox");
//			firefoxOptions.addArguments("--disable-gpu");
//			firefoxOptions.addArguments("--disable-popup-blocking");
//			firefoxOptions.addArguments("--window-size=1440,900");
//			firefoxOptions.addArguments("--disable-infobars");
//			firefoxOptions.addArguments("--disable-notifications");
//			firefoxOptions.addArguments("--disable-extensions");
//			firefoxOptions.addArguments("--disable-popup-blocking");
//			firefoxOptions.addArguments("--ignore-certificate-errors");
//			firefoxOptions.addArguments("--test-type");
//
//			firefoxOptions.setBinary(firefoxBinary);
//			driver = new FirefoxDriver(firefoxOptions);
//			Log.info("Firefox Headless Browser initilized Successfully");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		openURL();
		Log.info("URL load Successfully");
		System.out.println("Open Browser and Load the URL");
		
		return driver;
	}

	public void openURL() {
		driver.get(prop.getProperty("url"));
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login | Salesforce";
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("User load login Page Successfully");
		} else {
			System.out.println("User not load login Page Successfully");
		}
		// getting current url
		System.out.println(driver.getCurrentUrl());
	}

	public void testngBrowserlaunch(String browserName) {
		readConFigFile();
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver_exe"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", prop.getProperty("ffdriver_exe"));
			//driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	public void closebrowser() {
		driver.close();
		driver.quit();
		Log.info("Close Browser Successfully");
	}

	public String get_date() {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);

		// Print the Date
		System.out.println(date1);
		return date1;
	}

//		public long get_timestamp() {
//			System.out.println("we are inside get_timestamp method");
//			Date date = new Date();
//			long time = date.getTime();
//			System.out.println("Time in Milliseconds: " + time);
//			return time;
//		}

	public Timestamp getTimeStampRandomNumber() {
		// 2019-04-18 00:18:45.346
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		return timestamp;
	}

	// Return Current date
	private String currentDate() {
		return currentDate();
	}

	public void enter_within_iframe() {
		WebElement iframe_outer = driver.findElement(By.xpath(Constants.canvas_outerframe));
		driver.switchTo().frame(iframe_outer);
		System.out.println("I am within outer iframe");
		driver.switchTo().frame(driver.findElement(By.xpath(Constants.canvas_innerframe)));
		System.out.println("I am inside the inner iframe");
	}

	// Program to Capture screenshot in selenium for failed test cases
	public static void taketestCaseScreenshot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

	// Verify Current page title compare to Expected Title
	public void verifyPageTitle(WebDriver driver, String Excepected, String Actual) throws Exception {
		// Get the current page title
		Actual = driver.getTitle();
		// Print the title to console
		System.out.println(Excepected + "  " + Actual);
		Assert.assertEquals(Excepected, Actual);
	}

	// Get the Current page title
	public void getPageTitle(WebDriver driver, String actualTitle) throws Exception {
		// Get the current page title
		actualTitle = driver.getTitle();
		// Print the title to console
		System.out.println("Title is : " + actualTitle);
	}

	// *****************************************Total counts of object on
	// page*************************************

	// *****************************************Broken
	// Link*******************************************

	public static void getTotalLinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getAttribute("href"));
		}
	}

	// Verify Broken Links of a Web Page
	public static void verifyURLStatus(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}

	// *****************Verify any Browser Instance Open, If open close
	// it*************************************

	public static boolean isProcessRunning(String serviceName) {
		Process p;
		try {
			String TASKLIST = null;
			p = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(serviceName)) {
					return true;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public static void killBrowsers() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
	}

	// *********************************TestRail*************************************

	// Create a Test Run
	public void createTestRun(int suite_id, int milestone_id) throws MalformedURLException, IOException, APIException {

		APIClient client = new APIClient(Constants.RAILS_ENGINE_URL);
		client.setUser(Constants.TESTRAIL_PASSWORD);
		client.setPassword(Constants.TESTRAIL_PASSWORD);

		Map<String, Object> data = new HashMap<String, Object>();

		// TimeStamp as random unique numberNumber Ex: Format <Date Time>
		Timestamp Date = getTimeStampRandomNumber();
		// Create Test Run with Time Stamp as unique value Ex:- TestRun_2019-04-18
		// 00:36:14.681
		data.put("name", "TestRun_" + Date);

		// Milestones id
		// data.put("milestone_id","1");
		data.put("milestone_id", milestone_id);

		// data.put("case_ids", new int[]{17,86});
		//
		/*
		 * List cases1 = new ArrayList(); cases1.add(new Integer(11)); cases1.add(new
		 * Integer(12)); data.put("case_ids", cases1);
		 */

		// data.put("suite_id", "4");
		data.put("suite_id", suite_id);
		// Include all the test cases in a Run
		data.put("inculde_all", "true");
		client.sendPost("add_run/3", data);
	}

	public void getProjectSuiteCaseName(int projectID, int suiteID, int testCaseID)
			throws MalformedURLException, IOException, APIException {

		APIClient client = new APIClient(Constants.RAILS_ENGINE_URL);
		client.setUser(Constants.TESTRAIL_PASSWORD);
		client.setPassword(Constants.TESTRAIL_PASSWORD);

		// get_project/3
		// get_suite/4
		// get_case/11

		JSONObject projects = (JSONObject) client.sendGet("get_project/" + projectID); // PFL_ORG62
		JSONObject suites = (JSONObject) client.sendGet("get_suite/" + suiteID); // Functional Tests
		JSONObject cases = (JSONObject) client.sendGet("get_case/" + testCaseID); // com.pfl.automation.testcases.TS01.TS1_Verify_administration_tiles

		System.out.println(projects.get("name"));
		System.out.println(suites.get("name"));
		System.out.println(cases.get("title"));
	}

	// Test rail test cases status updation
	public static void addResultForTestCase(String testRunId, String testCaseId, int status, String error)
			throws IOException, APIException {

		testRunId = Constants.TEST_RUN_ID;
		testCaseId = Constants.TEST_CASE_ID;

		APIClient client = new APIClient(Constants.RAILS_ENGINE_URL);
		client.setUser(Constants.TESTRAIL_USERNAME);
		client.setPassword(Constants.TESTRAIL_PASSWORD);

		JSONObject c = (JSONObject) client.sendGet("get_case/5");
		System.out.println(c.get("title"));

		Map data = new HashMap();
		data.put("status_id", status);
		// data.put("status_id", new Integer(1));
		data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
		client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
	}

	public void setup_Project_TestRail(String projectName, String suiteName, String sectionName, String testcaseName,
			String runName) {
		TestRail testRail = TestRail
				.builder("https://pflautomation.testrail.io", "pflqatesting@gmail.com", "Alwar_301001")
				.applicationName("playground").build();

		// create a new project
		Project project = testRail.projects().add(new Project().setName(projectName)).execute();

		// add a new test suite
		Suite suite = testRail.suites().add(project.getId(), new Suite().setName(suiteName)).execute();

		// add a new section
		Section section = testRail.sections()
				.add(project.getId(), new Section().setSuiteId(suite.getId()).setName(sectionName)).execute();

		// add a test case
		List<CaseField> customCaseFields = testRail.caseFields().list().execute();
		Case testCase = testRail.cases().add(section.getId(), new Case().setTitle(testcaseName), customCaseFields)
				.execute();

		// add a new test run
		Run run = testRail.runs().add(project.getId(), new Run().setSuiteId(suite.getId()).setName(runName)).execute();

		// add test result
		List<ResultField> customResultFields = testRail.resultFields().list().execute();
		testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(1), customResultFields)
				.execute();

		// close the run
		testRail.runs().close(run.getId()).execute();

		// complete the project - supports partial updates
		testRail.projects().update(project.setCompleted(true)).execute();
	}

	/// ***** Deepak Sharma *****///
	public static long get_timestamp() {
		System.out.println("we are inside get_timestamp method");
		Date date = new Date();
		long time = date.getTime();
		System.out.println("Time in Milliseconds: " + time);
		return time;
	}

	public static void sendEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("nishant.jain2601@gmail.com", "Alwar_301001"));
		email.setSSLOnConnect(true);
		email.setFrom("pflqatesting@gmail.com");
		email.setSubject("Selenium Test Report");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("nishant.jain2601@gmail.com");
		email.send();

		System.out.println("Email Send Successfully");
	}

	/***************************** Reporting ********************************/

	public void reportFailure(String msg) {
		takeScreenShot();
		Assert.fail(msg);
	}

	public void takeScreenShot() {
		// fileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + Constants.screenshotFolder + screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}