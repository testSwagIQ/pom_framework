	package com.pfl.automation.base;
	
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import java.util.NoSuchElementException;
	import java.util.Set;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.TestException;

	import com.pfl.automation.utils.Constants;
	import com.pfl.automation.utils.Log;
	import com.relevantcodes.extentreports.ExtentTest;
	
	
	public class BasePage {
	
		public WebDriver driver;
		public WebElement element;
		public ExtentTest test;
	
		By switchtoLightningExperience = By.xpath("//a[contains(@class,'switch-to-lightning')]");
		By lightining_icon = By.xpath("//img[contains(@alt,'User')]");
		By switchtoSalesforceClassic = By.xpath("//a[contains(@class,'profile-link-label switch-to-aloha uiOutputURL')]");
		By userAdministration_xpath = By.xpath("//div[contains(text(),'User Administration')]");
		By outherframe = By.xpath("//div[@id ='canvas']//iframe");
		By innerframe = By.xpath("//div[@id ='canvasapp']//iframe");
		
		public By sflt_logout_button_image = By.xpath("//span[@class='photoContainer forceSocialPhoto']");
		public By sflt_logout_link_text = By.linkText("Log Out");
		public By switch_to_classic = By.linkText("Switch to Salesforce Classic");
	
		public void HomePageswitchToFrame(WebDriver driver) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@id ='canvas']//iframe")));
			System.out.println("went inside outerframe");
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@id ='canvasapp']//iframe")));
			System.out.println("went inside inner frame");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'User Administration')]")));
			waitForPageToLoad1(driver);
			System.out.println("User Administration loaded in frame");
		}
		
		public void switchToFrame(WebDriver driver) {
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@id ='canvas']//iframe")));
			System.out.println("went inside outerframe");
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@id ='canvasapp']//iframe")));
			System.out.println("went inside inner frame");
		}
	
		public void switchTo_Classic_Lightning() throws Exception {
			boolean value = isElementVisible(driver, switchtoLightningExperience);
			boolean value1 = isElementVisible(driver, switchtoSalesforceClassic);
			if ((value) && (Constants.IsLightingEnabled == "True")) {
				clickElement(driver, switchtoLightningExperience);
				Log.info("UI switched to Litining Experience");
			}
			else if ((value1) && (Constants.IsLightingEnabled == "False")) {
				clickLightiningToClassic(driver);
				Log.info("UI switched to Classic Experience");
			}
		}	
	
		public void clickLightiningToClassic(WebDriver driver) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			clickElement(driver, lightining_icon);
			clickElement(driver, switchtoSalesforceClassic);
			waitForPageToLoad1(driver);
		}
	
		//Selecting Checkbox and using isSelected Method to verify it
		public void clickCheckbox(WebDriver driver, By locator) throws Exception {
			element = findElement(driver, locator);
	
			for (int i=0; i<2; i++) {											
				element.click (); 			
				System.out.println("Checkbox Status is -  "+ element.isSelected());							
			}
		}
	
		//Selecting radio Button and using isSelected Method to verify it
		public void clickRadioButton(WebDriver driver, By locator) throws Exception {
			element = findElement(driver, locator);	
	
			//Click on radio button Element and Sleep for 5 seconds
			element.click (); 	
			Thread.sleep(3000);
	
			//Print the Name of radio Button
			System.out.println(element.getText());
	
			//verify that radio button is display, enabled and selcted or not
			if(element.isDisplayed()||element.isEnabled()||(element.isSelected())) {
				System.out.println("Radio button is selected");
			} else {
				System.out.println("Radio button is NOT selected");
			}
		}
	
	
		public void clickAlert(WebDriver driver, By locator) throws Exception {
			element = findElement(driver, locator);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
	
			Alert alert = driver.switchTo().alert();
			String print = alert.getText();
			System.out.println(print);
			alert.accept();
			Thread.sleep(3000);
	
			element.click();
			Thread.sleep(3000);
			alert.dismiss();
			waitForPageToLoad1(driver);
		}
	
		//Get the coordinates of the object located on the Webpage
		public void getLocation(WebDriver driver, By locator) {
			element = findElement(driver, locator);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
	
			System.out.println(element.getLocation());
		}
	
		//Download file using Wget.exe and save in D: Driver
		public void download(WebDriver driver, By locator, String savedLocation) {
			element = findElement(driver, locator);
			String sourceLocation = element.getAttribute("href");
			String wget_command = "cmd /c C:\\Wget\\wget.exe -P "+savedLocation+" --no-check-certificate " + sourceLocation;
	
			try {
				Process exec = Runtime.getRuntime().exec(wget_command);
				int exitVal = exec.waitFor();
				System.out.println("Exit value: " + exitVal);
			} catch (InterruptedException | IOException e) {
				System.out.println(e.toString());
			}
		}
	
		public void handleWindow(WebDriver driver, By locator) throws Exception {
			element = findElement(driver, locator);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
	
			String handle= driver.getWindowHandle();
			System.out.println(handle);
	
			element.click();
	
			// Store and Print the name of all the windows open	
			Set handles = driver.getWindowHandles();
			System.out.println(handles);
	
			// Pass a window handle to the other window
			for (String handle1 : driver.getWindowHandles()) {
				System.out.println(handle1);
				driver.switchTo().window(handle1);
			}
	
			// Closing Pop Up window
			driver.close();
		}
	
		public void handlePopup(WebDriver driver, String winHandleBefore) throws Exception {
			winHandleBefore = driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}
	
			//Once action is performed, switch back to parent window.
			//driver.switchTo().window(driver.getWindowHandle());
		}
	
		public void selectItem_inListBox(WebDriver driver, By locator) throws Exception {
			element = findElement(driver, locator);
			element.click();
		}
	
	
		public void clickElement(WebDriver driver, By locator) throws Exception {
			element = findElement(driver, locator);
			//Highlight element using javaScript Executer
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
			//scroll until the element is in view
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
			if(element.isDisplayed()||element.isEnabled())
				js.executeScript("arguments[0].click();", element);
			
			waitForPageToLoad1(driver);
		}
	
	
		public void doubleclickElement(WebDriver driver, By locator) throws Exception {
			Actions actions = new Actions(driver);
			element = findElement(driver, locator);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed()||element.isEnabled())
				actions.doubleClick(element).perform();
			waitForPageToLoad1(driver);
		}
	
		public void enterkey(WebDriver driver, By locator) {
			element = findElement(driver, locator);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed())
				element.sendKeys(Keys.ENTER);
		}
	
		public void rightclickElement(WebDriver driver, By locator) {
			element = findElement(driver, locator);
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed()||element.isEnabled())
				actions.contextClick(element).perform();
		}
	
		public void enterText(WebDriver driver, By locator, String text) {
			element = findElement(driver, locator);
			//Highlight element using javaScript Executer
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed())
				element.clear();
				element.sendKeys(text);
		}
	
		public void getText(WebDriver driver, By locator) {
			element = findElement(driver, locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
	
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			String GetText = element.getText();
			System.out.println(GetText);
		}
	
		public void Scroll_ByVisibleElement(WebDriver driver, By locator) {
			element = findElement(driver, locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	
			//This will scroll the page till the element is found		
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
	
		public void Scroll_ByBottomofpage(WebDriver driver, By locator) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	
			//This will scroll the web page till end.		
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
	
		public void ScrollHorizontally(WebDriver driver, By locator) {
			element = findElement(driver, locator); 
			JavascriptExecutor js = (JavascriptExecutor) driver;
	
			//This will scroll the page Horizontally till the element is found		
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
	
		public void upperText(WebDriver driver, WebElement element, String text) {
			text = text.toUpperCase();
			System.out.println(text);
		}
		
		public boolean isElementExist(WebDriver driver, By locator){
			element = findElement(driver, locator);
			try {
				WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
				wait.until(ExpectedConditions.visibilityOf(element));
				return true;
			} catch (Exception e) {
				return false;
			}
	    }
	
		public boolean isElementVisible(WebDriver driver, By locator) {
			element = findElement(driver, locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
	
			try {
				return true;
			} catch (Exception e) {
				System.out.println(" Element not load/found ---- " + element);
				return false;
			}
		}
	
		public WebElement findElement(WebDriver driver, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
	
		public boolean isElementVisible(WebDriver driver, By locator, int timeOut) {
			element = findElement(driver, locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
	
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeOut);
				wait.until(ExpectedConditions.visibilityOf(element));
				//WebDriverWait wait = new WebDriverWait(driver, timeOut);
				//wait.until(ExpectedConditions.visibilityOf(locator));
				return true;
			}
			catch (Exception e)
			{
				return false;
			}
		}
		
		
		public boolean verifyText(String locatorKey,String expectedTextKey){
			String actualText=getElement(locatorKey).getText().trim();
			String expectedText=expectedTextKey;
			if(actualText.equals(expectedText))
				return true;
			else 
				return false;
			
		}
	
		////**** Deepak Sharma ****////
		public boolean isElementVisible(WebDriver driver, WebElement locator, int timeOut)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, timeOut);
				wait.until(ExpectedConditions.visibilityOf(locator));
				return true;
			}
			catch (Exception e)
			{
				return false;
			}
		}
		
		public void waittillvisibility(WebDriver driver, By locator)
		{
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("finally element got visible");
		}
	
	
		public boolean isElementPresent(WebDriver driver, By locator) {
			try {
				driver.findElements(locator);
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}
		}
	
		// finding element and returning it
		public WebElement getElement(String locatorKey){
			WebElement e=null;
			try{
				if(locatorKey.endsWith("_id"))
					e = driver.findElement(By.id(locatorKey));
				else if(locatorKey.endsWith("_name"))
					e = driver.findElement(By.name(locatorKey));
				else if(locatorKey.endsWith("_xpath"))
					e = driver.findElement(By.xpath(locatorKey));
				else{
					Assert.fail("Locator not correct - " + locatorKey);
				}
	
			}catch(Exception ex){
				// fail the test and report the error
				ex.printStackTrace();
				Assert.fail("Failed the test - "+ex.getMessage());
			}
			return e;
		}
	
	
		public boolean isElementPresent(WebDriver driver, String locatorKey){
			List<WebElement> elementList=null;
			if(locatorKey.endsWith("_id"))
				elementList = driver.findElements(By.id(locatorKey));
			else if(locatorKey.endsWith("_name"))
				elementList = driver.findElements(By.name(locatorKey));
			else if(locatorKey.endsWith("_xpath"))
				elementList = driver.findElements(By.xpath(locatorKey));
			else{
				Assert.fail("Locator not correct - " + locatorKey);
			}
	
			if(elementList.size()==0)
				return false;	
			else
				return true;
		}
	
	
		public String getPageTitle() {
			try {
				System.out.print(String.format("The title of the page is: %s\n\n", driver.getTitle()));
				return driver.getTitle();
			} catch (Exception e) {
				throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
			}
		}
	
		public String getCurrentURL() {
			try {
				System.out.print(String.format("The Current URL of the page is: %s\n\n", driver.getCurrentUrl()));
				return driver.getCurrentUrl();
			} catch (Exception e) {
				throw new TestException(String.format("Current URL of the page is: %s", driver.getCurrentUrl()));
			}
		}
	
		public String getPageSource() {
			try {
				System.out.print(String.format("Page Soutrce: %s\n\n", driver.getPageSource()));
				return driver.getPageSource();
			} catch (Exception e) {
				throw new TestException(String.format("Page Soutrce: %s", driver.getPageSource()));
			}
		}
	
		public void pageReferesh(WebDriver driver, By locator) {
			element = findElement(driver, locator);
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			driver.navigate().refresh();
			waitForPageToLoad();
		}
	
		/*****************************Wait********************************/
	
		public void waitForPageToLoad(){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			int i=0;
	
			while(i!=10){
				String state = (String)js.executeScript("return document.readyState;");
				System.out.println(state);
	
				if(state.equals("complete"))
					break;
				else
					wait(2);
	
				i++;
			}
			// check for jquery status
			i=0;
			while(i!=10){
	
				Long d= (Long) js.executeScript("return jQuery.active;");
				System.out.println(d);
				if(d.longValue() == 0 )
					break;
				else
					wait(2);
				i++;	
			}
		}
	
		public void waitForLoad(WebDriver driver) {
		    new WebDriverWait(driver, 100).until((ExpectedCondition<Boolean>) wd ->
		            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		}
		
		public void wait(int timeSec){
			try {
				Thread.sleep(timeSec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		public static String uniquedate(){
			Date d1 = new Date();
			SimpleDateFormat formatting = new SimpleDateFormat("yyMMddhhss");
			String d = formatting.format(d1);
			return d;	
		}
	
		public  boolean waittillinvisibility (WebDriver driver, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}
	
		public void wait_min() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	
		public void wait_max() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	
		public void waitForPageToLoad1(WebDriver driver) throws Exception {
			waitPage(5);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = (String) js.executeScript("return document.readyState");
	
			while (!state.equals("complete")) {
				waitPage(5);
				state = (String) js.executeScript("return document.readyState");
			}
		}
	
		public void waitPage(int timeToWaitInSec){
			try {
				Thread.sleep(timeToWaitInSec * 1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public void WaitForCompleteLoad(WebDriver driver) {
			new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout).until(
			          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		}
	}