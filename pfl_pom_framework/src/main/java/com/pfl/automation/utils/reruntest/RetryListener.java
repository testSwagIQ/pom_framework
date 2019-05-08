package com.pfl.automation.utils.reruntest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {
	
	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation testannotation, Class testClass, 
			@SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod)	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null)	{
			testannotation.setRetryAnalyzer(DynamicRetryAnalyzer.class);
		}

	}
}
