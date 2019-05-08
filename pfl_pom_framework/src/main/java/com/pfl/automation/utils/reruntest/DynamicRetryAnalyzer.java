package com.pfl.automation.utils.reruntest;

/*Help Files
https://www.toolsqa.com/selenium-webdriver/retry-failed-tests-testng/
https://www.seleniumeasy.com/testng-tutorials/execute-only-failed-test-cases-using-iretryanalyzer
https://www.youtube.com/watch?v=HYIxSQTbB10
https://www.youtube.com/watch?v=O6NYI529yqI */

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class DynamicRetryAnalyzer implements IRetryAnalyzer {
	
	int Count = 1;
	int maxRetryCount = 2;
	
	/*
	 * (non-Javadoc)
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 * 
	 * This method decides how many times a test needs to be rerun.
	 * TestNg will call this method every time a test fails. So we 
	 * can put some code in here to decide when to rerun the test.
	 * 
	 * Note: This method will return true if a tests needs to be retried
	 * and false it not.
	 *
	 */
	
	public boolean retry(ITestResult result) {
        if (Count < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (Count+1) + " time(s).");
            
            Count++;
            return true;
        }
        return false;
    }
	
	public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
}