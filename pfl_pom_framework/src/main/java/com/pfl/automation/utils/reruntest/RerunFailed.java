package com.pfl.automation.utils.reruntest;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RerunFailed {
	
	/*Go to the TestNG test-output folder and see the testng-failed.xml file
	  Create a Test Runner Instance class and call it
	  Execute failed test cases in Selenium webdriver */
	
	public static void main(String[] args) {
		TestNG runner = new TestNG();
		
		List<String> failedTestCases = new ArrayList<String>();
		
		//Location of the Failed List of Test cases if Test NG file
		failedTestCases.add(System.getProperty("user.dir") + "\\test-output\\Default suite\\testng-failed.xml");
		runner.setTestSuites(failedTestCases);
		
		//Execute the failed test cases
		runner.run();
	}

}
