package com.orasi.bluesource.features.manageEmployees;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orasi.bluesource.LoginPage;
import com.orasi.bluesource.commons.TopNavigationBar;
import com.orasi.bluesource.employeesPage.Employee;
import com.orasi.bluesource.employeesPage.EmployeeSummaryPage;
import com.orasi.bluesource.employeesPage.EmployeesPage;
import com.orasi.bluesource.employeesPage.ManageEmployeeModal;
import com.orasi.utils.Constants;
import com.orasi.utils.OrasiDriver;
import com.orasi.utils.Randomness;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.orasi.utils.dataProviders.ExcelDataProvider;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class EmployeeCRUD  extends TestEnvironment {

    private Employee employee = new Employee();
    //private OrasiDriver driver = null;
    
    @DataProvider(name = "dataScenario")
    public Object[][] scenarios() {
	return new ExcelDataProvider(Constants.BLUESOURCE_DATAPROVIDER_PATH + "ManageEmployees.xlsx", "AddEmployee").getTestData();
    }
    
    @BeforeClass(  alwaysRun=true)
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion", "operatingSystem", "environment" })
    public void setup(String runLocation, String browserUnderTest, String browserVersion, String operatingSystem, String environment) {
	setApplicationUnderTest("Bluesource");
	setBrowserUnderTest(browserUnderTest);
	setBrowserVersion(browserVersion);
	setOperatingSystem(operatingSystem);
	setRunLocation(runLocation);
	setTestEnvironment(environment);
	//setThreadDriver(true);
    }

    @AfterClass( alwaysRun=true)
    public void closeSession(ITestContext test) {
	endTest(testName, test);
    }    

    @Features("Manage Employees")
    @Stories("I can create a new Employee")
    @Severity(SeverityLevel.BLOCKER)
    @Title("Manage Employees - Create Employee")
    @Test(dataProvider = "dataScenario", groups = {"regression", "manageEmployees", "employeeCRUD", "qaOnly"  })
    public void testAddEmployee(@Parameter String testScenario, @Parameter String role) {

	testStart("testAddEmployee");
	//driver = getDriver();
	// Login
	LoginPage loginPage = new LoginPage( getDriver());
	TestReporter.assertTrue(loginPage.pageLoaded(),"Verify login page is displayed");
	loginPage.login(role);

	// Verify user is logged in
	TopNavigationBar topNavigationBar = new TopNavigationBar( getDriver());
	TestReporter.assertTrue(topNavigationBar.isLoggedIn(), "Validate the user logged in successfully");

	//Navigate to Employees Page
	topNavigationBar.clickEmployeesLink();
	EmployeesPage employeesPage = new EmployeesPage( getDriver());
	TestReporter.assertTrue(employeesPage.pageLoaded(),"Verify Employees page is displayed");

	// Open New Employee Modal 
	employeesPage.clickAddEmployeeButton();
	ManageEmployeeModal newEmployee = new ManageEmployeeModal( getDriver());	
	TestReporter.assertTrue(newEmployee.pageLoaded(),"Verify New Employee Popup Modal is displayed");
	
	//Enter Employee Info
	newEmployee.addEmployee(employee);
	TestReporter.assertTrue(employeesPage.isSuccessMsgDisplayed(), "Verify Success message appears after creating new employee");
	
	//Validate new Employee created and visible
	employeesPage.pageLoaded();
	employeesPage.enterSearchText(employee.getLastName());
	TestReporter.assertTrue(employeesPage.validateLastnameFoundInTable(employee.getLastName()), "Verify Employee " + employee.getLastName() + " appeared in the Employee Table");
    }    
    
    
    @Features("Manage Employees")
    @Stories("I can see an Employee's General Info after creating Employee")
    @Severity(SeverityLevel.NORMAL)
    @Title("Manage Employees - View Employee Summary")
    @Test(groups = { "regression", "manageEmployees", "employeeCRUD", "qaOnly" },
    	  dependsOnMethods = {"testAddEmployee"})
    public void testViewEmployeeGeneralInfo() {
	EmployeesPage employeesPage = new EmployeesPage( getDriver());
	employeesPage.selectEmployeeName(employee.getLastName());
	
	EmployeeSummaryPage summary = new EmployeeSummaryPage(getDriver());
	TestReporter.assertTrue(summary.pageLoaded(),"Verify Employees Summary page is displayed");
	TestReporter.assertTrue(summary.validateGeneralInfo(employee), "Verify displayed Employee's General Information is correct");
	
    }
    
    
    @Features("Manage Employees")
    @Stories("I can Modify an Employee's General Info and view changes")
    @Severity(SeverityLevel.MINOR)
    @Title("Manage Employees Employeesmployees - Modify Employee Information")
    @Test(groups = {"regression", "manageEmployees", "employeeCRUD", "qaOnly" },
    	  dependsOnMethods = {"testViewEmployeeGeneralInfo"})
    public void testModifyEmployeeGeneralInfo() {
	EmployeeSummaryPage summary = new EmployeeSummaryPage( getDriver());
	summary.clickManageGeneralInfo();
	
	ManageEmployeeModal modifyEmployee = new ManageEmployeeModal( getDriver());
	TestReporter.assertTrue(modifyEmployee.pageLoaded(),"Verify Manage Employee Popup Modal is displayed");
	
	employee.setLastName(Randomness.randomAlphaNumeric(8));
	
	modifyEmployee.modifyEmployee(employee);
	TestReporter.assertTrue(summary.validateGeneralInfo(employee), "Verify Employee's General Information is correct");
    }
    
    
    @Features("Manage Employees")
    @Stories("I can mark an Employee as Inactive")
    @Severity(SeverityLevel.MINOR)
    @Title("Manage Employees - Mark Employee Inactive")
    @Test(groups = {"regression", "manageEmployees", "employeeCRUD" , "qaOnly"},
    	  dependsOnMethods = {"testModifyEmployeeGeneralInfo"})
    public void testDeactivateEmployee() {
	EmployeeSummaryPage summary = new EmployeeSummaryPage( getDriver());
	summary.clickManageGeneralInfo();
	
	ManageEmployeeModal modifyEmployee = new ManageEmployeeModal( getDriver());
	TestReporter.assertTrue(modifyEmployee.pageLoaded(),"Verify Manage Employee Popup Modal is displayed");
	
	employee.setStatus("Inactive");
	modifyEmployee.modifyEmployee(employee);
	TestReporter.assertTrue(summary.validateGeneralInfo(employee), "Verify Employee's General Information is correct");
	
	TopNavigationBar topNavigationBar = new TopNavigationBar( getDriver());
	topNavigationBar.clickEmployeesLink();
	
	EmployeesPage employeesPage = new EmployeesPage( getDriver());
	TestReporter.assertTrue(employeesPage.pageLoaded(),"Verify Employees page is displayed");
	employeesPage.uncheckInactiveCheckbox();
	employeesPage.enterSearchText(employee.getLastName());
	TestReporter.assertTrue(employeesPage.validateNoRowsFound(),"Verify Employees Table does not have Employee as inactive");
	topNavigationBar.clickLogout();
    }
}
