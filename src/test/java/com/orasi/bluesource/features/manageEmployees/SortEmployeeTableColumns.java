package com.orasi.bluesource.features.manageEmployees;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orasi.bluesource.LoginPage;
import com.orasi.bluesource.commons.TopNavigationBar;
import com.orasi.bluesource.employeesPage.EmployeesPage;
import com.orasi.utils.Constants;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.ExcelDataProvider;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class SortEmployeeTableColumns  extends TestEnvironment {

    private OrasiDriver driver = null;
    @DataProvider(name = "dataScenario")
    public Object[][] scenarios() {
	return new ExcelDataProvider(Constants.BLUESOURCE_DATAPROVIDER_PATH + "ManageEmployees.xlsx", "SortEmployeeTableColumns").getTestData();
    }
    
    @BeforeClass( alwaysRun=true)
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion", "operatingSystem", "environment" })
    public void setup(String runLocation, String browserUnderTest, String browserVersion, String operatingSystem, String environment) {
	setApplicationUnderTest("Bluesource");
	setBrowserUnderTest(browserUnderTest);
	setBrowserVersion(browserVersion);
	setOperatingSystem(operatingSystem);
	setRunLocation(runLocation);
	setTestEnvironment(environment);
	setThreadDriver(true);
    }

    @AfterMethod(alwaysRun=true)
    public void closeSession(ITestContext test) {
	endTest(testName, test);
    }    

    @Features("Manage Employees")
    @Stories("I can sort on a column an Employee on the Employee Page")
    @Title("Manage Employees - Sort Employee Table Columns")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(dataProvider = "dataScenario", groups = { "regression", "manageEmployees", "sortEmployeeTableColumns" })
    public void testSortColumns(@Parameter String testScenario, @Parameter String role, @Parameter String column, @Parameter String order) {
	
	testName = new Object() {
	}.getClass().getEnclosingMethod().getName();

	testStart(testName);
	driver = getDriver();
	// Login
	LoginPage loginPage = new LoginPage(driver);
	TestReporter.assertTrue(loginPage.pageLoaded(),"Verify login page is displayed");
	loginPage.login(role);

	// Verify user is logged in
	TopNavigationBar topNavigationBar = new TopNavigationBar(driver);
	TestReporter.assertTrue(topNavigationBar.isLoggedIn(), "Validate the user logged in successfully");

	//Navigate to Employees Page
	topNavigationBar.clickEmployeesLink();
	EmployeesPage employeesPage = new EmployeesPage(driver);
	TestReporter.assertTrue(employeesPage.pageLoaded(),"Verify Employees page is displayed");
	
	//Search for Employee
	employeesPage.sortColumn(column, order);
	TestReporter.assertTrue(employeesPage.validateSortColumn(column, order), "Validate column " + column + " was found sorted in " + order + " order");

	// logout
	topNavigationBar.clickLogout();
    }
    
}