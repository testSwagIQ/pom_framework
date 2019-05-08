package com.pfl.automation.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;

public class FindBrokenLinksExample extends BaseTest {
	
		//private WebDriver driver;
		//private int invalidLinksCount;
		String siteName = "http://www.google.com";
		
		@BeforeClass
		public void setUp() throws FileNotFoundException, IOException, DocumentException, InterruptedException {
			//initBrowser();
		}

		@Test
		public void validateInvalidLinks() throws Exception {   
			driver.get(siteName);
			System.out.println(siteName);
			List<WebElement> links=driver.findElements(By.tagName("a"));
			links.addAll(driver.findElements(By.tagName("img")));
			
			System.out.println("Total links amd images are " + links.size());
			
			//Extract active links and images
			List<WebElement> activeLinks=new ArrayList<WebElement>();
			for(int i=0;i<links.size();i++) {
				if (links.get(i).getAttribute("href")!=null) {
					activeLinks.add(links.get(i));
				}
			}
			//Count no of active links and inactive links
			System.out.println("total active links " + activeLinks.size());
			System.out.println("total inactive links " + (links.size() - activeLinks.size()));
			
			for(int j=0;j<activeLinks.size();j++) {
				HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
				connection.setConnectTimeout(5000);
				connection.connect();
		        
		        String response = connection.getResponseMessage();
		        connection.disconnect();
		        System.out.println(activeLinks.get(j).getAttribute("href") + "------>" + response );
		       }    
		}			
			
			/*try {
				invalidLinksCount = 0;
				List<WebElement> anchorTagsList = driver.findElements(By
						.tagName("a"));
				System.out.println("Total no. of links are "
						+ anchorTagsList.size());
				for (WebElement anchorTagElement : anchorTagsList) {
					if (anchorTagElement != null) {
						String url = anchorTagElement.getAttribute("href");
						System.out.println(url);
						if (url != null && !url.contains("javascript")) {
							verifyURLStatus(url);
						} else {
							invalidLinksCount++;
						}
					}
				}
	
				System.out.println("Total no. of invalid links are "
						+ invalidLinksCount);
	
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}*/
		
	
		@AfterClass
		public void tearDown() {
			if (driver != null)
				driver.quit();
		}
}