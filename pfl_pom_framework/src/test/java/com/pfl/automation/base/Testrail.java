package com.pfl.automation.base;

//https://github.com/codepine/testrail-api-java-client

import org.testng.annotations.Test;

import com.pfl.automation.base.BaseTest;


public class Testrail extends BaseTest {
	
	@Test
	public void Test() throws Exception {
		sendEmail();
		/*TestRail testRail = TestRail.builder("https://pflautomation.testrail.io", "pflqatesting@gmail.com", "Alwar_301001").applicationName("playground").build();

		// create a new project
		Project project = testRail.projects().add(new Project().setName("Playground Project")).execute();
		
		// add a new test suite
		Suite suite = testRail.suites().add(project.getId(), new Suite().setName("Functional Tests")).execute();
		
		// add a new section
		Section section = testRail.sections().add(project.getId(), new Section().setSuiteId(suite.getId()).setName("Boundary Cases")).execute();
		
		// add a test case
		List<CaseField> customCaseFields = testRail.caseFields().list().execute();
		Case testCase = testRail.cases().add(section.getId(), new Case().setTitle("Be able to play in playground"), customCaseFields).execute();

		// add a new test run
		Run run = testRail.runs().add(project.getId(), new Run().setSuiteId(suite.getId()).setName("Weekly Regression")).execute();

		// add test result
		List<ResultField> customResultFields = testRail.resultFields().list().execute();
		testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(1), customResultFields).execute();

		// close the run
		testRail.runs().close(run.getId()).execute();

		// complete the project - supports partial updates
		testRail.projects().update(project.setCompleted(true)).execute();*/
	}
}